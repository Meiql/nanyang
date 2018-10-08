package  org.springrain.erp.hr.web;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springrain.erp.constants.ErpStateEnum;
import org.springrain.erp.constants.ErpStateEnum.userImportEnum;
import org.springrain.erp.hr.entity.UserCertificate;
import org.springrain.erp.hr.entity.UserEducational;
import org.springrain.erp.hr.entity.UserInfo;
import org.springrain.erp.hr.service.IOaOrgService;
import org.springrain.erp.hr.service.IOaUserOrgService;
import org.springrain.erp.hr.service.IOaUserService;
import org.springrain.erp.hr.service.IUserCertificateService;
import org.springrain.erp.hr.service.IUserEducationalService;
import org.springrain.erp.hr.service.IUserInfoService;
import org.springrain.erp.hr.service.impl.UserCertificateImportService;
import org.springrain.erp.hr.service.impl.UserEducationImportService;
import org.springrain.erp.hr.service.impl.UserInfoImportService;
import org.springrain.erp.hr.service.impl.UserSalaryImportService;
import org.springrain.frame.common.SessionUser;
import org.springrain.frame.controller.BaseController;
import org.springrain.frame.util.GlobalStatic;
import org.springrain.frame.util.Page;
import org.springrain.frame.util.ReturnDatas;
import org.springrain.frame.util.property.MessageUtils;
import org.springrain.system.entity.User;
import org.springrain.system.service.IDicDataService;
import org.springrain.system.service.IUserService;


/**
 * TODO 在此加入类描述
 * @copyright {@link weicms.net}
 * @author springrain<Auto generate>
 * @version  2017-07-03 17:47:25
 * @see org.springrain.erp.hr.web.UserInfo
 */
@Controller
@RequestMapping(value="/userinfo")
public class UserInfoController  extends BaseController {
	@Resource
	private IUserInfoService userInfoService;
	@Resource
	private IDicDataService dicDataService;
	@Resource
	private IUserEducationalService userEducationalService;
	@Resource
	private IUserCertificateService userCertificateService;
	@Resource
	IOaUserService oaUserService;
	@Resource
	IOaUserOrgService oaUserOrgService;
	@Resource
	IOaOrgService oaOrgService;
	@Resource
	private UserSalaryImportService userSalaryImportService;
	@Resource
	private UserEducationImportService userEducationImportService;
	@Resource
	private UserCertificateImportService  userCertificateImportService;
	@Resource
	private UserInfoImportService userInfoImportService;
	@Resource
	private IUserService userService;
	private String listurl="/erp/hr/userinfo/userinfoList";
	
	
	   
	/**
	 * 列表数据,调用listjson方法,保证和app端数据统一
	 * 
	 * @param request
	 * @param model
	 * @param userInfo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list")
	public String list(HttpServletRequest request, Model model,UserInfo userInfo) 
			throws Exception {
		ReturnDatas returnObject = listjson(request, model, userInfo);
		User user = new User();
		user.setUserType(ErpStateEnum.userTypeEnum.员工.getValue());
		List<User> userList = userService.finderUserForList(user,null);
		model.addAttribute("userList", userList);
		model.addAttribute(GlobalStatic.returnDatas, returnObject);
		return listurl;
	}
	
	/**
	 * json数据,为APP提供数据
	 * 
	 * @param request
	 * @param model
	 * @param userInfo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list/json")
	@ResponseBody   
	public  ReturnDatas listjson(HttpServletRequest request, Model model,UserInfo userInfo) throws Exception{
		ReturnDatas returnObject = ReturnDatas.getSuccessReturnDatas();
		// ==构造分页请求
		Page page = newPage(request);
		// ==执行分页查询
		//List<UserInfo> datas=userInfoService.findListDataByFinder(null,page,UserInfo.class,userInfo);
		List<UserInfo> datas=userInfoService.findUserInfoByQuery(userInfo, page);
		
		returnObject.setQueryBean(userInfo);
		returnObject.setPage(page);
		returnObject.setData(datas);
		return returnObject;
	}
	
	@RequestMapping("/list/export")
	public void listexport(HttpServletRequest request,HttpServletResponse response, Model model,UserInfo userInfo) throws Exception{
		// ==构造分页请求
		Page page = newPage(request);
	
		File file = userInfoService.findDataExportExcel(null,listurl, page,UserInfo.class,userInfo);
		String fileName="userInfo"+GlobalStatic.excelext;
		downFile(response, file, fileName,true);
		return;
	}
	/**
	 * 下载模板
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @throws Exception
	 */
	@RequestMapping("/import/{oper}/pre")
	public void downloadUsermoban(@PathVariable String oper,HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		String userId = SessionUser.getUserId();
		if (StringUtils.isBlank(userId)) {
			return;
		}
		String path = "";
		String name = "";
		if(userImportEnum.教育经历.getValue().equals(oper)){
			 path = "/WEB-INF/tmpl/yuangongjiaoyujingli.xls";
			 name = "员工教育经历信息";
		}
		if(userImportEnum.证书.getValue().equals(oper)){
			 path = "/WEB-INF/tmpl/yuangongzhengshu.xls";
			 name = "员工证书信息";
		}
		if(userImportEnum.基本信息.getValue().equals(oper)){
			path = "/WEB-INF/tmpl/userbaseinfo.xls";
			name = "员工基本信息";
			
		}
		String filePath = request.getSession().getServletContext().getRealPath("/");
		File file = new File(filePath + path);
		super.downFile(response, file, ""+name+".xls", false);
	}

	/**
	 * 导入统筹信息
	 * @param uploadfile
	 * @param request
	 * @param model
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("static-access")
	@RequestMapping("/import/{oper}")
	public @ResponseBody ReturnDatas userupload(@PathVariable String oper,@RequestParam("uploadfile") MultipartFile uploadfile,
			HttpServletRequest request, Model model, HttpServletResponse response) throws Exception {
		ReturnDatas rd = ReturnDatas.getSuccessReturnDatas();
		String msg ="";
		if(userImportEnum.教育经历.getValue().equals(oper)){
			msg = userEducationImportService.importExcel(uploadfile, userEducationImportService.titles, request);
		}
		if(userImportEnum.证书.getValue().equals(oper)){
			msg = userCertificateImportService.importExcel(uploadfile, userCertificateImportService.titles, request);
		}
		if(userImportEnum.基本信息.getValue().equals(oper)){
			msg = userInfoImportService.importExcel(uploadfile, userInfoImportService.titles, request);
		}
		if (StringUtils.isNotBlank(msg)) {
			rd.setStatus(ReturnDatas.ERROR);
			rd.setMessage(msg);
			return rd;
		} else {
			rd.setMessage("导入成功!");
		}
		return rd;
	}
		/**
	 * 查看操作,调用APP端lookjson方法
	 */
	@RequestMapping(value = "/look")
	public String look(Model model,HttpServletRequest request,HttpServletResponse response)  throws Exception {
		ReturnDatas returnObject = lookjson(model, request, response);
		model.addAttribute(GlobalStatic.returnDatas, returnObject);
		return "/erp/hr/userinfo/userinfoLook";
	}

	
	/**
	 * 查看的Json格式数据,为APP端提供数据
	 */
	@RequestMapping(value = "/look/json")
	@ResponseBody      
	public ReturnDatas lookjson(Model model,HttpServletRequest request,HttpServletResponse response) throws Exception {
		ReturnDatas returnObject = ReturnDatas.getSuccessReturnDatas();
		java.lang.String userId=request.getParameter("userId");
		if(StringUtils.isNotBlank(userId)){
			UserInfo userInfo = userInfoService.findUserInfoByUserId(userId);
			if(userInfo != null ){
				List<UserEducational> ueList = userEducationalService.findByUserId(userId);
				userInfo.setEducational(ueList);
				List<UserCertificate> ceList = userCertificateService.findByUserId(userId);
				userInfo.setCertificate(ceList);
			}
//			UserInfo userInfo = userInfoService.findUserInfoById(id);
		   returnObject.setData(userInfo);
		}else{
		returnObject.setStatus(ReturnDatas.ERROR);
		}
		return returnObject;
		
	}
	
	
	/**
	 * 新增/修改 操作吗,返回json格式数据
	 * 
	 */
	@RequestMapping("/update")
	@ResponseBody      
	public ReturnDatas saveorupdate(Model model,UserInfo userInfo,HttpServletRequest request,HttpServletResponse response) throws Exception{
		if(StringUtils.isNotBlank(userInfo.getFlag())){
			if(CollectionUtils.isEmpty(userInfo.getEducational())){
				return new ReturnDatas(ReturnDatas.ERROR,"请填写员工教育经历");
			}
		}
		ReturnDatas returnObject = userInfoService.saveOrUpdate(userInfo);
		return returnObject;
	
	}
	
	/**
	 * 进入修改页面,APP端可以调用 lookjson 获取json格式数据
	 */
	@RequestMapping(value = "/update/pre")
	public String updatepre(Model model,HttpServletRequest request,HttpServletResponse response)  throws Exception{
		ReturnDatas returnObject = lookjson(model, request, response);
		model.addAttribute(GlobalStatic.returnDatas, returnObject);
		return "/erp/hr/userinfo/userinfoCru";
	}
	
	/**
	 * 删除操作
	 */
	@RequestMapping(value="/delete")
	@ResponseBody      
	public  ReturnDatas delete(HttpServletRequest request) throws Exception {

			// 执行删除
		try {
		java.lang.String id=request.getParameter("id");
		if(StringUtils.isNotBlank(id)){
				userInfoService.deleteById(id,UserInfo.class);
				return new ReturnDatas(ReturnDatas.SUCCESS,MessageUtils.DELETE_SUCCESS);
			} else {
				return new ReturnDatas(ReturnDatas.WARNING,MessageUtils.DELETE_WARNING);
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return new ReturnDatas(ReturnDatas.WARNING, MessageUtils.DELETE_WARNING);
	}
	
	/**
	 * 删除多条记录
	 * 
	 */
	@RequestMapping("/delete/more")
	@ResponseBody      
	public ReturnDatas deleteMore(HttpServletRequest request, Model model) {
		String records = request.getParameter("records");
		if(StringUtils.isBlank(records)){
			 return new ReturnDatas(ReturnDatas.ERROR,MessageUtils.DELETE_ALL_FAIL);
		}
		String[] rs = records.split(",");
		if (rs == null || rs.length < 1) {
			return new ReturnDatas(ReturnDatas.ERROR,MessageUtils.DELETE_NULL_FAIL);
		}
		try {
			List<String> ids = Arrays.asList(rs);
			userInfoService.deleteByIds(ids,UserInfo.class);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return new ReturnDatas(ReturnDatas.ERROR,MessageUtils.DELETE_ALL_FAIL);
		}
		return new ReturnDatas(ReturnDatas.SUCCESS,MessageUtils.DELETE_ALL_SUCCESS);
		
	}

	
	@RequestMapping("/userbank/list")
	public String userbankList(HttpServletRequest request, Model model,UserInfo userInfo) 
			throws Exception {
		ReturnDatas returnObject = listjson(request, model, userInfo);
		User user = new User();
		user.setUserType(ErpStateEnum.userTypeEnum.员工.getValue());
		List<User> userList = userService.finderUserForList(user,null);
		model.addAttribute("userList", userList);
		model.addAttribute(GlobalStatic.returnDatas, returnObject);
		return "/erp/hr/userinfo/userBankList";
	}
	
	@RequestMapping(value = "/bank/update/pre")
	public String bankUpdatepre(Model model,HttpServletRequest request,HttpServletResponse response)  throws Exception{
		ReturnDatas returnObject = lookjson(model, request, response);
		model.addAttribute(GlobalStatic.returnDatas, returnObject);
		return "/erp/hr/userinfo/userBankCru";
	}
	@RequestMapping("/userbank/list/export")
	public void userbanklistexport(HttpServletRequest request,HttpServletResponse response, Model model,UserInfo userInfo) throws Exception{
		// ==构造分页请求
		Page page = newPage(request);
	
		File file = userInfoService.findDataExportExcel(null,"/erp/hr/userinfo/userBankList", page,UserInfo.class,userInfo);
		String fileName="userBank"+GlobalStatic.excelext;
		downFile(response, file, fileName,true);
		return;
	}
	@RequestMapping("/usersalary/list")
	public String usersalaryList(HttpServletRequest request, Model model,UserInfo userInfo) 
			throws Exception {
		ReturnDatas returnObject = listjson(request, model, userInfo);
		User user = new User();
		user.setUserType(ErpStateEnum.userTypeEnum.员工.getValue());
		List<User> userList = userService.finderUserForList(user,null);
		model.addAttribute("userList", userList);
		model.addAttribute(GlobalStatic.returnDatas, returnObject);
		return "/erp/hr/userinfo/userSalaryList";
	}
	
	@RequestMapping(value = "/salary/update/pre")
	public String usersalaryUpdatepre(Model model,HttpServletRequest request,HttpServletResponse response)  throws Exception{
		ReturnDatas returnObject = lookjson(model, request, response);
		model.addAttribute(GlobalStatic.returnDatas, returnObject);
		return "/erp/hr/userinfo/userSalaryCru";
	}
	@RequestMapping("/usersalary/list/export")
	public void usersalarylistexport(HttpServletRequest request,HttpServletResponse response, Model model,UserInfo userInfo) throws Exception{
		// ==构造分页请求
		Page page = newPage(request);
	
		File file = userInfoService.findDataExportExcel(null,"/erp/hr/userinfo/userSalaryList", page,UserInfo.class,userInfo);
		String fileName="usersalary"+GlobalStatic.excelext;
		downFile(response, file, fileName,true);
		return;
	}
	/**
	 * 下载模板
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @throws Exception
	 */
	@RequestMapping("/usersalary/import/pre")
	public void downloadmoban(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		String userId = SessionUser.getUserId();
		if (StringUtils.isBlank(userId)) {
			return;
		}
		String path = "/WEB-INF/tmpl/yuangongsalary.xls";
		String filePath = request.getSession().getServletContext().getRealPath("/");
		File file = new File(filePath + path);
		super.downFile(response, file, "员工工资信息.xls", false);
	}

	/**
	 * 导入统筹信息
	 * @param uploadfile
	 * @param request
	 * @param model
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("static-access")
	@RequestMapping(value = "/usersalary/import")
	public @ResponseBody ReturnDatas upload(@RequestParam("uploadfile") MultipartFile uploadfile,
			HttpServletRequest request, Model model, HttpServletResponse response) throws Exception {
		ReturnDatas rd = ReturnDatas.getSuccessReturnDatas();
		String msg = userSalaryImportService.importExcel(uploadfile, userSalaryImportService.titles, request);
		if (StringUtils.isNotBlank(msg)) {
			rd.setStatus(ReturnDatas.ERROR);
			rd.setMessage(msg);
			return rd;
		} else {
			rd.setMessage("导入成功!");
		}
		return rd;
	}
	/**
	 * 同步数据
	 * @param model
	 * @param request
	 * @param user
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/syndata")
	public @ResponseBody ReturnDatas syndata(Model model,HttpServletRequest request,User user)throws Exception{
		ReturnDatas returnDatas = ReturnDatas.getSuccessReturnDatas();
		try {
			oaUserService.saveOaMsg();
			userInfoService.savesyndata();
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			returnDatas.setStatus(ReturnDatas.ERROR);
			returnDatas.setMessage("同步失败");
			return returnDatas;
		}
		return returnDatas;
		
	}
}
