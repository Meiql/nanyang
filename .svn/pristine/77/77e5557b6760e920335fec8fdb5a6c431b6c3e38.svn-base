package org.springrain.erp.hr.web;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springrain.erp.hr.dao.UserBaseInfoDao;
import org.springrain.erp.hr.entity.UserInfo;
import org.springrain.erp.hr.service.IUserBaseInfoDaoService;
import org.springrain.frame.controller.BaseController;
import org.springrain.frame.util.GlobalStatic;
import org.springrain.frame.util.Page;
import org.springrain.frame.util.ReturnDatas;

@Controller
@RequestMapping(value="/userbaseinfo")
public class UserBaseInfoDaoController extends BaseController {
	@Resource
	private IUserBaseInfoDaoService userBaseInfoDaoService;
	
	private String listurl="/erp/hr/userbaseinfo/userbaseinfoList";
	
	@RequestMapping("/list")
	public String list(HttpServletRequest request, Model model,UserInfo userInfo) 
			throws Exception {
		ReturnDatas returnObject = listjson(request, model, userInfo);
		model.addAttribute(GlobalStatic.returnDatas, returnObject);
		return listurl;
	}
	
	@RequestMapping("/list/json")
	@ResponseBody   
	public  ReturnDatas listjson(HttpServletRequest request, Model model,UserInfo userInfo) throws Exception{
		ReturnDatas returnObject = ReturnDatas.getSuccessReturnDatas();
		// ==构造分页请求
		Page page = newPage(request);
		// ==执行分页查询
		List<UserBaseInfoDao> datas = userBaseInfoDaoService.findUserBaseInfoDaoByQuery(userInfo, page);
		returnObject.setQueryBean(userInfo);
		returnObject.setPage(page);
		returnObject.setData(datas);
		return returnObject;
	}
	
	@RequestMapping("/list/export")
	public void listexport(HttpServletRequest request,HttpServletResponse response, Model model,UserInfo userInfo) throws Exception{
		// ==构造分页请求
		Page page = newPage(request);
	
		File file = userBaseInfoDaoService.findDataExportExcel(null,listurl, page,UserInfo.class,userInfo);
		String fileName="userbaseinfo"+GlobalStatic.excelext;
		downFile(response, file, fileName,true);
		return;
	}
	
}
