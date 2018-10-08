package  org.springrain.erp.zc.web;

import java.io.File;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springrain.erp.zc.entity.Zichan;
import org.springrain.erp.zc.entity.ZichanLingDetail;
import org.springrain.erp.zc.entity.ZichanRecord;
import org.springrain.erp.zc.service.IZichanLingDetailService;
import org.springrain.erp.zc.service.IZichanRecordService;
import org.springrain.erp.zc.service.IZichanService;
import org.springrain.erp.zc.service.impl.ZichanImportService;
import org.springrain.frame.common.SessionUser;
import org.springrain.frame.controller.BaseController;
import org.springrain.frame.util.GlobalStatic;
import org.springrain.frame.util.Page;
import org.springrain.frame.util.ReturnDatas;
import org.springrain.frame.util.property.MessageUtils;
import org.springrain.system.entity.DicData;
import org.springrain.system.entity.Org;
import org.springrain.system.entity.User;
import org.springrain.system.service.IDicDataService;
import org.springrain.system.service.IOrgService;
import org.springrain.system.service.IUserService;


/**
 * TODO 在此加入类描述
 * @copyright {@link weicms.net}
 * @author springrain<Auto generate>
 * @version  2017-08-14 09:44:45
 * @see org.springrain.erp.zc.web.Zichan
 */
@Controller
@RequestMapping(value="/zichan")
public class ZichanController  extends BaseController {
	@Resource
	private IZichanService zichanService;
	@Resource
	private IZichanRecordService zichanRecordService;
	@Resource
	private IZichanLingDetailService zichanLingDetailService;
	@Resource
	private ZichanImportService zichanImportService;
	@Resource
	private IDicDataService dicDataService;
	@Resource
	private IOrgService orgService;
	@Resource
	private IUserService userService;
	
	private String listurl="/erp/zc/zichan/zichanList";
	
	
	   
	/**
	 * 列表数据,调用listjson方法,保证和app端数据统一
	 * 
	 * @param request
	 * @param model
	 * @param zichan
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list")
	public String list(HttpServletRequest request, Model model,Zichan zichan) 
			throws Exception {
		ReturnDatas returnObject = listjson(request, model, zichan);
		model.addAttribute(GlobalStatic.returnDatas, returnObject);
		return listurl;
	}
	
	/**
	 * json数据,为APP提供数据
	 * 
	 * @param request
	 * @param model
	 * @param zichan
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list/json")
	@ResponseBody   
	public  ReturnDatas listjson(HttpServletRequest request, Model model,Zichan zichan) throws Exception{
		ReturnDatas returnObject = ReturnDatas.getSuccessReturnDatas();
		// ==构造分页请求
		Page page = newPage(request);
		// ==执行分页查询
		List<Zichan> datas=zichanService.findZichanByQuery(zichan,page);
			returnObject.setQueryBean(zichan);
		returnObject.setPage(page);
		returnObject.setData(datas);
		return returnObject;
	}
	
	@RequestMapping("/list/export")
	public void listexport(HttpServletRequest request,HttpServletResponse response, Model model,Zichan zichan) throws Exception{
		// ==构造分页请求
		Page page = newPage(request);
	
		File file = zichanService.findDataExportExcel(null,listurl, page,Zichan.class,zichan);
		String fileName="zichan"+GlobalStatic.excelext;
		downFile(response, file, fileName,true);
		return;
	}
	
		/**
	 * 查看操作,调用APP端lookjson方法
	 */
	@RequestMapping(value = "/look")
	public String look(Model model,HttpServletRequest request,HttpServletResponse response)  throws Exception {
		ReturnDatas returnObject = lookjson(model, request, response);
		model.addAttribute(GlobalStatic.returnDatas, returnObject);
		return "/erp/zc/zichan/zichanLook";
	}

	
	/**
	 * 查看的Json格式数据,为APP端提供数据
	 */
	@RequestMapping(value = "/look/json")
	@ResponseBody      
	public ReturnDatas lookjson(Model model,HttpServletRequest request,HttpServletResponse response) throws Exception {
		ReturnDatas returnObject = ReturnDatas.getSuccessReturnDatas();
		java.lang.String id=request.getParameter("id");
		if(StringUtils.isNotBlank(id)){
		  Zichan zichan = zichanService.findZichanById(id);
		   returnObject.setData(zichan);
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
	public ReturnDatas saveorupdate(Model model,Zichan zichan,HttpServletRequest request,HttpServletResponse response) throws Exception{
		ReturnDatas returnObject = ReturnDatas.getSuccessReturnDatas();
		returnObject.setMessage(MessageUtils.UPDATE_SUCCESS);
		try {
		
			java.lang.String id =zichan.getId();
			if(StringUtils.isBlank(id)){
			  zichan.setId(null);
			}
			if(StringUtils.isNotBlank(zichan.getGuige())){
				zichan.setGuige(zichan.getGuige().replaceAll("：", ":").replaceAll("，", ","));
			}
			zichan.setCreatetime(new Date());
			zichan.setCreateuser(SessionUser.getUserId());
			zichanService.saveorupdate(zichan);
			
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			returnObject.setStatus(ReturnDatas.ERROR);
			returnObject.setMessage(MessageUtils.UPDATE_ERROR);
		}
		return returnObject;
	
	}
	
	/**
	 * 进入修改页面,APP端可以调用 lookjson 获取json格式数据
	 */
	@RequestMapping(value = "/update/pre")
	public String updatepre(Model model,HttpServletRequest request,HttpServletResponse response)  throws Exception{
		ReturnDatas returnObject = lookjson(model, request, response);
		model.addAttribute(GlobalStatic.returnDatas, returnObject);
		return "/erp/zc/zichan/zichanCru";
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
				zichanService.deleteById(id,Zichan.class);
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
			zichanService.deleteByIds(ids,Zichan.class);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return new ReturnDatas(ReturnDatas.ERROR,MessageUtils.DELETE_ALL_FAIL);
		}
		return new ReturnDatas(ReturnDatas.SUCCESS,MessageUtils.DELETE_ALL_SUCCESS);
		
		
	}
	
	/**
	 * 管理页面
	 */
	@RequestMapping(value = "/manage")
	public String manage(Model model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		java.lang.String zcid = request.getParameter("id");
		ReturnDatas returnObject = ReturnDatas.getSuccessReturnDatas();
		String msg = request.getParameter(message);
		Zichan zichan = zichanService.findZichanById(zcid);
		if (zichan != null) {
			DicData data = dicDataService.findDicDataById(zichan.getZctype());
			if(data != null){
				zichan.setZctypeName(data.getName());
			}
			DicData leibie = dicDataService.findDicDataById(zichan.getZcleibie());
			if(leibie != null){
				zichan.setZcleibieName(leibie.getName());
			}
			List<ZichanRecord> listrecord = zichanRecordService
					.findZichanRecord(zcid);
			List<ZichanLingDetail> listling = zichanLingDetailService
					.findZichanLing(zcid);
			returnObject.setData(zichan);
			model.addAttribute(GlobalStatic.returnDatas, returnObject);
//			model.addAttribute("zichan", zichan);
			model.addAttribute("listrecord", listrecord);
			model.addAttribute("listling", listling);
			model.addAttribute(message, msg);
		}
		return "/erp/zc/zichan/zichanManage";
	}

	/**
	 * 领用
	 */
	@RequestMapping(value = "/lingyong")
	@ResponseBody
	public ReturnDatas lingyong(Model model, ZichanRecord record,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ReturnDatas returnDatas = ReturnDatas.getSuccessReturnDatas();
		java.lang.String zcid = request.getParameter("zcid");
		Zichan zichan = zichanService.findZichanById(zcid);
		if (record != null && StringUtils.isNotBlank(record.getReunitid())) {
			List<Org> orgList = orgService.findOrgByOrgIds(record.getReunitid());
			if(CollectionUtils.isNotEmpty(orgList)){
				StringBuilder sb = new StringBuilder();
				for(Org o : orgList){
					sb.append(o.getName()).append(",");
				}
				record.setReunit(sb.toString());
			}
		}
		if (zcid != null) {
			zichanService.saveLingyong(zichan, record);
		}
		returnDatas.setMessage("领用成功！");
		return returnDatas;
	}
	
	@RequestMapping(value = "/lingyong/pre")
	public String lingyongPre(Model model, ZichanRecord record,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String zcid = request.getParameter("zcid");
		Zichan zichan = zichanService.findZichanById(zcid);
		model.addAttribute("zichan", zichan);
		return "/erp/zc/zichan/zichanLingyongCru";
	}

	/**
	 * 归还
	 */
	@RequestMapping(value = "/guihuan")
	@ResponseBody
	public ReturnDatas guihuan(Model model, ZichanRecord record,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ReturnDatas returnDatas = ReturnDatas.getSuccessReturnDatas();
		java.lang.String zcid = request.getParameter("zcid");
		if (record != null && StringUtils.isNotBlank(record.getReunitid())) {
			List<Org> orgList = orgService.findOrgByOrgIds(record.getReunitid());
			if(CollectionUtils.isNotEmpty(orgList)){
				StringBuilder sb = new StringBuilder();
				for(Org o : orgList){
					sb.append(o.getName()).append(",");
				}
				record.setReunit(sb.toString());
			}
		}
		Zichan zichan = zichanService.findZichanById(zcid);
		if (zcid != null) {
			zichanService.saveGuihuan(zichan, record);
		}
		returnDatas.setMessage("归还成功！");
		return returnDatas;
	}
	@RequestMapping(value = "/guihuan/pre")
	public String guihuanPre(Model model, ZichanRecord record,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String zcid = request.getParameter("zcid");
		Zichan zichan = zichanService.findZichanById(zcid);
		model.addAttribute("zichan", zichan);
		List<User> lingUserList = userService.findUserByZichanId(zcid);
		model.addAttribute("lingUserList", lingUserList);
		
		return "/erp/zc/zichan/zichanGuihuanCru";
	}

	/**
	 * 报损
	 */
	@RequestMapping(value = "/baosun")
	@ResponseBody
	public ReturnDatas baosun(Model model, ZichanRecord record,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ReturnDatas returnDatas = ReturnDatas.getSuccessReturnDatas();
		java.lang.String zcid = request.getParameter("zcid");
		Zichan zichan = zichanService.findZichanById(zcid);
		if (zcid != null) {
			zichanService.saveBaosun(zichan, record);
		}
		returnDatas.setMessage("报损成功！");
		return returnDatas;
	}

	@RequestMapping(value = "/baosun/pre")
	public String baosunPre(Model model, ZichanRecord record,
			HttpServletRequest request, HttpServletResponse response)
					throws Exception {
		String zcid = request.getParameter("zcid");
		Zichan zichan = zichanService.findZichanById(zcid);
		model.addAttribute("zichan", zichan);
		return "/erp/zc/zichan/zichanBaosunCru";
	}

	
	/**
	 * 出售
	 */
	@RequestMapping(value = "/chushou")
	@ResponseBody
	public ReturnDatas chushou(Model model, ZichanRecord record,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ReturnDatas returnDatas = ReturnDatas.getSuccessReturnDatas();
		java.lang.String zcid = request.getParameter("zcid");
		Zichan zichan = zichanService.findZichanById(zcid);
		if (zcid != null) {
			zichanService.saveChushou(zichan, record);
		}
		returnDatas.setMessage("出售成功！");
		return returnDatas;
	}
	
	@RequestMapping(value = "/chushou/pre")
	public String chushouPre(Model model, ZichanRecord record,
			HttpServletRequest request, HttpServletResponse response)
					throws Exception {
		String zcid = request.getParameter("zcid");
		Zichan zichan = zichanService.findZichanById(zcid);
		model.addAttribute("zichan", zichan);
		return "/erp/zc/zichan/zichanChushouCru";
	}
	
	/**
	 * 下载模板
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @throws Exception
	 */
	@RequestMapping("/ajax/downMoban")
	public void downloadmoban(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		String userId = SessionUser.getUserId();
		if (StringUtils.isBlank(userId)) {
			return;
		}
		String path = "/WEB-INF/tmpl/zichanImport.xls";
		String filePath = request.getSession().getServletContext().getRealPath("/");
		File file = new File(filePath + path);
		super.downFile(response, file, "资产导入模板.xls", false);
	}

	/**
	 * 导入资产
	 * 
	 * @param uploadfile
	 * @param request
	 * @param model
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/import")
	public @ResponseBody ReturnDatas upload(@RequestParam("uploadfile") MultipartFile uploadfile,
			HttpServletRequest request, Model model, HttpServletResponse response) throws Exception {
		ReturnDatas rd = ReturnDatas.getSuccessReturnDatas();
		String msg = zichanImportService.importExcel(uploadfile, ZichanImportService.titles, request);
		if (StringUtils.isNotBlank(msg)) {
			rd.setStatus(ReturnDatas.ERROR);
			rd.setMessage(msg);
			return rd;
		} else {
			rd.setMessage("导入成功!");
		}
		return rd;
	}
	
	@RequestMapping("/ajax/ajaxFindLing")
	public @ResponseBody
	ReturnDatas ajaxFindLing(HttpServletRequest request, Model model)
			throws Exception {
		ReturnDatas returnObject = ReturnDatas.getSuccessReturnDatas();
		String linguserid = request.getParameter("linguserid");
		String zcid = request.getParameter("zcid");
		ZichanLingDetail ling = zichanLingDetailService.findUserLing(linguserid,
				zcid);
		returnObject.setData(ling);
		return returnObject;
	}

}
