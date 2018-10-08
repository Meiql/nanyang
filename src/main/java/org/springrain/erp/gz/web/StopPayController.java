package  org.springrain.erp.gz.web;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springrain.erp.constants.ErpStateEnum;
import org.springrain.erp.gz.entity.StopPay;
import org.springrain.erp.gz.service.IStopPayService;
import org.springrain.erp.hr.entity.UserInfo;
import org.springrain.erp.hr.service.IUserInfoService;
import org.springrain.frame.common.SessionUser;
import org.springrain.frame.controller.BaseController;
import org.springrain.frame.util.GlobalStatic;
import org.springrain.frame.util.Page;
import org.springrain.frame.util.ReturnDatas;
import org.springrain.frame.util.property.MessageUtils;
import org.springrain.system.entity.Org;
import org.springrain.system.entity.User;
import org.springrain.system.service.IOrgService;
import org.springrain.system.service.IUserOrgService;
import org.springrain.system.service.IUserService;


/**
 * TODO 在此加入类描述
 * @copyright {@link weicms.net}
 * @author springrain<Auto generate>
 * @version  2017-07-21 09:20:19
 * @see org.springrain.erp.gz.web.StopPay
 */
@Controller
@RequestMapping(value="/stoppay")
public class StopPayController  extends BaseController {
	@Resource
	private IStopPayService stopPayService;
	@Resource
	private IUserOrgService userOrgService;
	@Resource
	private IOrgService orgService;
	@Resource
	private IUserService userService;
	@Resource
	private IUserInfoService userInfoService;
	
	private String listurl="/erp/gz/stoppay/stoppayList";
	
	
	   
	/**
	 * 列表数据,调用listjson方法,保证和app端数据统一
	 * 
	 * @param request
	 * @param model
	 * @param stopPay
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list")
	public String list(HttpServletRequest request, Model model,StopPay stopPay) 
			throws Exception {
		ReturnDatas returnObject = listjson(request, model, stopPay);
		model.addAttribute(GlobalStatic.returnDatas, returnObject);
		List<Org> orgList = orgService.findAllBumen();
		model.addAttribute("orgList", orgList);
		return listurl;
	}
	
	/**
	 * json数据,为APP提供数据
	 * 
	 * @param request
	 * @param model
	 * @param stopPay
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list/json")
	@ResponseBody   
	public  ReturnDatas listjson(HttpServletRequest request, Model model,StopPay stopPay) throws Exception{
		ReturnDatas returnObject = ReturnDatas.getSuccessReturnDatas();
		// ==构造分页请求
		Page page = newPage(request);
		if(stopPay.getState() == null ){
			stopPay.setState(ErpStateEnum.stopPayEnum.停发.getValue());
		}
		// ==执行分页查询
		List<StopPay> datas=stopPayService.findStopPayByQuery(stopPay, page);
		if(CollectionUtils.isNotEmpty(datas)){
			for(StopPay s : datas){
				List<Org> orgList = userOrgService.findOrgByUserId(s.getUserId());
				if(CollectionUtils.isNotEmpty(orgList)){
					int i = 0;
					StringBuilder sb = new StringBuilder();
					for(Org o : orgList){
						if(i == 0){
							sb.append(o.getName());
						}else{
							sb.append(",").append(o.getName());
						}
						i++;
					}
					s.setOrgName(sb.toString());
				}
				if(StringUtils.isNotBlank(s.getCreatePerson())){
					User u = userService.findUserById(s.getCreatePerson());
					s.setCreatePersonName(u.getName());
				}
				if(StringUtils.isNotBlank(s.getCancelPerson())){
					User u = userService.findUserById(s.getCancelPerson());
					s.setCancelPersonName(u.getName());
				}
				if(s.getState() != null ){
					s.setStateStr(ErpStateEnum.stopPayEnum.getName(s.getState()));
				}
			}
		}
		returnObject.setQueryBean(stopPay);
		returnObject.setPage(page);
		returnObject.setData(datas);
		return returnObject;
	}
	
	@RequestMapping("/list/export")
	public void listexport(HttpServletRequest request,HttpServletResponse response, Model model,StopPay stopPay) throws Exception{
		// ==构造分页请求
		Page page = newPage(request);
	
		File file = stopPayService.findDataExportExcel(null,listurl, page,StopPay.class,stopPay);
		String fileName="stopPay"+GlobalStatic.excelext;
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
		return "/erp/gz/stoppay/stoppayLook";
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
		  StopPay stopPay = stopPayService.findStopPayById(id);
		   returnObject.setData(stopPay);
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
	public ReturnDatas saveorupdate(Model model,StopPay stopPay,HttpServletRequest request,HttpServletResponse response) throws Exception{
		ReturnDatas returnObject = ReturnDatas.getSuccessReturnDatas();
		returnObject.setMessage(MessageUtils.UPDATE_SUCCESS);
		try {
		
			java.lang.String id =stopPay.getId();
			if(StringUtils.isBlank(id)){
			  stopPay.setId(null);
			  stopPay.setCreateDate(new Date());
			  stopPay.setState(ErpStateEnum.stopPayEnum.停发.getValue());
			  stopPay.setCreatePerson(SessionUser.getUserId());
			  UserInfo userInfo = userInfoService.findUserInfoByUserId(stopPay.getUserId());
			  if(userInfo == null){
					return new ReturnDatas(ReturnDatas.ERROR,"请先完善该员工基本信息");
				}
			  if(ErpStateEnum.userStopPayEnum.是.getValue().equals(userInfo.getStoppay())){
				  return new ReturnDatas(ReturnDatas.ERROR,"该员工工资已停发请勿重复设置");
			  }
			  userInfo.setStoppay(ErpStateEnum.userStopPayEnum.是.getValue());
			  userInfoService.update(userInfo,true);
			  stopPayService.save(stopPay);
			}else{
				StopPay _stopPay = stopPayService.findStopPayById(id);
				_stopPay.setState(ErpStateEnum.stopPayEnum.撤销.getValue());
				_stopPay.setCancelDate(new Date());
				_stopPay.setCancelPerson(SessionUser.getUserId());
				UserInfo userInfo = userInfoService.findUserInfoByUserId(_stopPay.getUserId());
				if(userInfo == null){
					return new ReturnDatas(ReturnDatas.ERROR,"请先完善该员工基本信息");
				}
				userInfo.setStoppay(ErpStateEnum.userStopPayEnum.否.getValue());
				userInfoService.update(userInfo,true);
				stopPayService.update(_stopPay,true);
			}
		
			
			
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
		return "/erp/gz/stoppay/stoppayCru";
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
				stopPayService.deleteById(id,StopPay.class);
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
			stopPayService.deleteByIds(ids,StopPay.class);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return new ReturnDatas(ReturnDatas.ERROR,MessageUtils.DELETE_ALL_FAIL);
		}
		return new ReturnDatas(ReturnDatas.SUCCESS,MessageUtils.DELETE_ALL_SUCCESS);
		
		
	}

}
