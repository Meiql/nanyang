package org.springrain.erp.gz.web;

import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springrain.erp.constants.DicdataTypeEnum;
import org.springrain.erp.constants.ErpStateEnum;
import org.springrain.erp.gz.dto.UserSalaryDto;
import org.springrain.erp.gz.entity.Salary;
import org.springrain.erp.gz.entity.Salaryinfo;
import org.springrain.erp.gz.service.ISalaryService;
import org.springrain.erp.gz.service.ISalaryinfoService;
import org.springrain.erp.gz.util.GlobalStaticVar;
import org.springrain.erp.gz.util.GlobalStaticVar.SalaryStateEnum;
import org.springrain.erp.tc.entity.TongchouRecord;
import org.springrain.erp.tc.entity.TongchouZengjian;
import org.springrain.erp.tc.service.ITongchouRecordService;
import org.springrain.erp.tc.service.ITongchouZengjianService;
import org.springrain.frame.common.SessionUser;
import org.springrain.frame.controller.BaseController;
import org.springrain.frame.util.DateUtils;
import org.springrain.frame.util.GlobalStatic;
import org.springrain.frame.util.Page;
import org.springrain.frame.util.ReturnDatas;
import org.springrain.system.entity.DicData;
import org.springrain.system.entity.Org;
import org.springrain.system.service.IDicDataService;
import org.springrain.system.service.IOrgService;

import freemarker.template.Template;

@Controller
@RequestMapping(value="/user/salary")
public class UserSalaryController extends BaseController {
	@Resource
	private IDicDataService dicDataService;
	@Resource
	private ISalaryService salaryService;
	@Resource
	private ISalaryinfoService salaryinfoService;
	@Resource
	private ITongchouRecordService tongchouRecordService;
	@Resource
	private ITongchouZengjianService tongchouZengjianService;
	@Resource
	private IOrgService orgService;
	@Resource
	public FreeMarkerConfigurer freeMarkerConfigurer;

	@RequestMapping("/configure")
	public String configureUpdatePre(Model model,HttpServletRequest request,HttpServletResponse response)  throws Exception{
		ReturnDatas returnObject = lookConfigureJson(model, request, response);
		model.addAttribute(GlobalStatic.returnDatas, returnObject);
		return "/erp/gz/userSalary/configureCru";
	}
	
	@RequestMapping("/look/configure/json")
	public @ResponseBody ReturnDatas lookConfigureJson(Model model,HttpServletRequest request,HttpServletResponse response)  throws Exception{
		ReturnDatas returnObject = ReturnDatas.getSuccessReturnDatas();
		Map<String,DicData> map = dicDataService.findGongziConfigure();
		returnObject.setMap(map);
		return returnObject;
	}
	
	@RequestMapping("/configure/update")
	public @ResponseBody ReturnDatas configureUpdate(Model model,HttpServletRequest request,HttpServletResponse response)  throws Exception{
		ReturnDatas returnObject = ReturnDatas.getSuccessReturnDatas();
		String userNames = request.getParameter("userNames");
		String userPayDate = request.getParameter("userPayDate");
		Map<String,DicData> map = dicDataService.findGongziConfigure();
		DicData chakanData = map.get("chakanData");
		DicData bushengchengData = map.get("bushengchengData");
		if(chakanData == null){
			chakanData = new DicData();
			chakanData.setId(null);
			chakanData.setName(DicdataTypeEnum.员工工资查询时间.getName());
			chakanData.setTypekey(DicdataTypeEnum.员工工资查询时间.getValue());
			chakanData.setActive(Integer.parseInt(ErpStateEnum.stateEnum.是.getValue()));
		}
		if(bushengchengData == null){
			bushengchengData = new DicData();
			bushengchengData.setId(null);
			bushengchengData.setName(DicdataTypeEnum.不生成工资员工.getName());
			bushengchengData.setTypekey(DicdataTypeEnum.不生成工资员工.getValue());
			bushengchengData.setActive(Integer.parseInt(ErpStateEnum.stateEnum.是.getValue()));
		}
		chakanData.setCode(userPayDate);
		bushengchengData.setRemark(userNames);
		dicDataService.saveorupdate(chakanData);
		dicDataService.saveorupdate(bushengchengData);
		return returnObject;
	}
	
	@RequestMapping("/list/{oper}")
	public String list(@PathVariable String oper,Model model,HttpServletRequest request,HttpServletResponse response,Salary salary)  throws Exception{
//		String userId = request.getParameter("userId");
		Page page = newPage(request);
		ReturnDatas returnObject = listjson(oper, model, request, response, salary,page);
		model.addAttribute(GlobalStatic.returnDatas, returnObject);
		List<Org> orgList = orgService.findAllBumen();
		model.addAttribute("orgList", orgList);
		return "/erp/gz/userSalary/userSalaryList"+oper;
	}
	
	@RequestMapping("/list/{oper}/json")
	public @ResponseBody ReturnDatas listjson(@PathVariable String oper,Model model,HttpServletRequest request,HttpServletResponse response,Salary salary,Page page)  throws Exception{
		String inDateStr = request.getParameter("inDateStr");
		if(StringUtils.isBlank(inDateStr)){
			inDateStr = DateUtils.convertDate2String("yyyy-MM-01",new Date());
		}else{
			inDateStr = inDateStr+"-01";
		}
		salary.setInDate(DateUtils.convertString2Date(DateUtils.DATE_FORMAT, inDateStr));
		if(ErpStateEnum.operSalaryEnum.个人工资查询.getValue().equals(oper)){
			salary.setUserId(SessionUser.getUserId());
		}
		ReturnDatas returnObject = ReturnDatas.getSuccessReturnDatas();
		//获取工资基本项
		List<Salary> salaryList = salaryService.findUserBasicSalary(salary, page);
		List<UserSalaryDto> dtoList = new ArrayList<UserSalaryDto>();
		List<Set<String>> titleList = new ArrayList<Set<String>>();
		Set<String> salaryTitleSet = new HashSet<String>();
		Set<String> tongchouRecordTitleSet = new HashSet<String>();
		Set<String> tongchouZengjianTitleSet = new HashSet<String>();
		if(CollectionUtils.isNotEmpty(salaryList)){
			for(Salary s : salaryList){
				UserSalaryDto dto = getUserSalaryDtoBySalary(s);
				//获取工资增减项
				List<Salaryinfo> salaryinfoList = salaryinfoService.findListSalaryinfo(s.getUserId(), s.getInDate());
				if(CollectionUtils.isNotEmpty(salaryinfoList)){
					Map<String,BigDecimal> salaryinfoMap = new HashMap<String, BigDecimal>();
					for(Salaryinfo info : salaryinfoList){
						DicData data = dicDataService.findDicDataById(info.getSalaryTypeId());
						if(data != null){
							salaryinfoMap.put(data.getName(), info.getAmount());
							salaryTitleSet.add(data.getName());
						}
					}
					
					dto.setSalaryinfoMap(salaryinfoMap);
				}
				//获取统筹记录
				List<TongchouRecord> tongchouRecordList = tongchouRecordService.finderRecordForList(s.getUserId(), s.getInDate());
				if(CollectionUtils.isNotEmpty(tongchouRecordList)){
					Map<String,BigDecimal> tongchouRecordMap = new HashMap<String, BigDecimal>();
					for(TongchouRecord record : tongchouRecordList){
						DicData data = dicDataService.findDicDataById(record.getInsuranceType());
						if(data != null){
							tongchouRecordMap.put(data.getName(), record.getInsurancePersonal());
							tongchouRecordTitleSet.add(data.getName());
						}
					}
					
					dto.setTongchouRecordMap(tongchouRecordMap);
				}
				//获取统筹增减项
				List<TongchouZengjian> tongchouZengjianList = tongchouZengjianService.finderTczjxForFenzuList(s.getUserId(), s.getInDate());
				if(CollectionUtils.isNotEmpty(tongchouZengjianList)){
					Map<String,BigDecimal> tongchouZengjianMap = new HashMap<String, BigDecimal>();
					for(TongchouZengjian tczj : tongchouZengjianList){
						DicData insurance = dicDataService.findDicDataById(tczj.getInsuranceType());
						DicData feiyong = dicDataService.findDicDataById(tczj.getFeiyongtype());
						if(insurance != null && feiyong!=null){
							tongchouZengjianMap.put(insurance.getName()+"-"+feiyong.getName(), tczj.getInsurancePersonal());
							tongchouZengjianTitleSet.add(insurance.getName()+"-"+feiyong.getName());
						}
					}
					
					dto.setTongchouZengjianMap(tongchouZengjianMap);
				}
				dtoList.add(dto);
			}
		}
		titleList.add(salaryTitleSet);
		titleList.add(tongchouRecordTitleSet);
		titleList.add(tongchouZengjianTitleSet);
		returnObject.setData(dtoList);
		returnObject.setPage(page);
		returnObject.setQueryBean(salary);
		model.addAttribute("titleList", titleList);
		return returnObject;
	}
	
	private UserSalaryDto getUserSalaryDtoBySalary(Salary salary) throws Exception{
		UserSalaryDto dto = new UserSalaryDto();
		dto.setSalaryId(salary.getId());
		dto.setUserName(salary.getUserName());
		dto.setInDate(salary.getInDate());
		dto.setJibenpay(salary.getJibenpay());
		dto.setKaohepay(salary.getKaohepay());
		dto.setGangweipay(salary.getGangweipay());
		dto.setTongchoupay(salary.getTongchoupay());
		dto.setGongziPlusPay(salary.getGongziPlusPay());
		dto.setRipay(salary.getRipay());
		dto.setGeshui(salary.getGeshui());
		dto.setMobilePay(salary.getMobilePay());
		dto.setYingfupay(salary.getYingfupay());
		dto.setShifupay(salary.getShifupay());
		dto.setOndutydays(salary.getOndutydays());
		if(StringUtils.isNotBlank(salary.getCompanyId())){
			DicData company = dicDataService.findDicDataById(salary.getCompanyId());
			if(company != null){
				dto.setCompanyName(company.getName());
			}
		}
		if(StringUtils.isNotBlank(salary.getUnitId())){
			List<Org> orgList = orgService.findOrgByOrgIds(salary.getUnitId());
			if(CollectionUtils.isNotEmpty(orgList)){
				StringBuilder sb = new StringBuilder();
				int f = 0 ;
				for(Org o : orgList){
					if(f == 0){
						sb.append(o.getName());
					}else{
						sb.append(",").append(o.getName());
					}
					f++;
				}
				dto.setUnitName(sb.toString());
			}
		}
		if(salary.getState() != null){
			dto.setPayStateStr(SalaryStateEnum.getName(salary.getState()));
		}
		return dto;
	}
	
	@RequestMapping("/gen/gongzi")
	@ResponseBody
	public ReturnDatas generateGongziUpdate(Model model,HttpServletRequest request,HttpServletResponse response)  throws Exception{
		ReturnDatas returnObject = ReturnDatas.getSuccessReturnDatas();
		String salaryIds = request.getParameter("salaryIds");
		//String inDateStr = request.getParameter("inDate");
		if(StringUtils.isBlank(salaryIds)){
			return new ReturnDatas(ReturnDatas.ERROR,"请选择要生成工资的员工");
		}
//		if(StringUtils.isBlank(inDateStr)){
//			return new ReturnDatas(ReturnDatas.ERROR,"请选择要生成的月份");
//		}
		Date indate = DateUtils.getBoferBeginDate(Calendar.getInstance());
		List<String> salaryIdList = new ArrayList<String>();
		if("all".equals(salaryIds)){
			salaryIdList = salaryService.findSalaryIdsByStateAndInDate(GlobalStaticVar.SalaryStateEnum.未生成.getValue(), indate);
		}else{
			salaryIdList = Arrays.asList(salaryIds.split(","));
		}
		salaryService.saveGenSalary(salaryIdList, indate);
		return returnObject;
	}
	@RequestMapping("/send/gongzi")
	@ResponseBody
	public ReturnDatas sendGongziUpdate(Model model,HttpServletRequest request,HttpServletResponse response)  throws Exception{
		ReturnDatas returnObject = ReturnDatas.getSuccessReturnDatas();
		String salaryIds = request.getParameter("salaryIds");
//		String inDateStr = request.getParameter("inDate");
		if(StringUtils.isBlank(salaryIds)){
			return new ReturnDatas(ReturnDatas.ERROR,"请选择要发放工资的员工");
		}
//		if(StringUtils.isBlank(inDateStr)){
//			return new ReturnDatas(ReturnDatas.ERROR,"请选择要发放的月份");
//		}
		Date indate = DateUtils.getBoferBeginDate(Calendar.getInstance());
		List<String> salaryIdList = new ArrayList<String>();
		if("all".equals(salaryIds)){
			salaryIdList = salaryService.findSalaryIdsByStateAndInDate(GlobalStaticVar.SalaryStateEnum.已生成.getValue(), indate);
		}else{
			salaryIdList = Arrays.asList(salaryIds.split(","));
		}
		salaryService.updateSalarySend(salaryIdList, new Date(), indate);
		return returnObject;
	}
	
	@RequestMapping("/send/gongzi/per")
	public String senGongziPer(Model model,HttpServletRequest request,HttpServletResponse response,Salary salary)  throws Exception{
		Page page = newPage(request);
		ReturnDatas returnObject = senGongziListJson(model, request, response, salary,page);
		model.addAttribute(GlobalStatic.returnDatas, returnObject);
		List<Org> orgList = orgService.findAllBumen();
		model.addAttribute("orgList", orgList);
		return "/erp/gz/userSalary/userSalaryListsend";
	}
	@RequestMapping("/send/gongzi/json")
	public @ResponseBody ReturnDatas senGongziListJson(Model model,HttpServletRequest request,HttpServletResponse response,Salary salary,Page page)  throws Exception{
		ReturnDatas returnObject = ReturnDatas.getSuccessReturnDatas();
		String inDateStr = request.getParameter("inDateStr");
		if(StringUtils.isBlank(inDateStr)){
			inDateStr = DateUtils.convertDate2String("yyyy-MM-01",new Date());
		}else{
			inDateStr = inDateStr+"-01";
		}
		salary.setInDate(DateUtils.convertString2Date(DateUtils.DATE_FORMAT, inDateStr));
		salary.setOper(ErpStateEnum.operSalaryEnum.工资发放.getValue());
		
		//获取工资基本项
		List<Salary> salaryList = salaryService.findUserBasicSalary(salary, page);
		if(CollectionUtils.isNotEmpty(salaryList)){
			for(Salary s : salaryList){
				if(StringUtils.isNotBlank(s.getCompanyId())){
					DicData company = dicDataService.findDicDataById(s.getCompanyId());
					if(company != null){
						s.setCompanyName(company.getName());
					}
				}
				if(StringUtils.isNotBlank(s.getUnitId())){
					List<Org> orgList = orgService.findOrgByOrgIds(s.getUnitId());
					if(CollectionUtils.isNotEmpty(orgList)){
						StringBuilder sb = new StringBuilder();
						int f = 0 ;
						for(Org o : orgList){
							if(f == 0){
								sb.append(o.getName());
							}else{
								sb.append(",").append(o.getName());
							}
							f++;
						}
						s.setUnitName(sb.toString());
					}
				}
				if(s.getState() != null){
					s.setPayStateStr(SalaryStateEnum.getName(s.getState()));
				}
			}
		}
		
		returnObject.setData(salaryList);
		returnObject.setPage(page);
		returnObject.setQueryBean(salary);
		
		return returnObject;
	}
	@RequestMapping("/cancel/gen/gongzi")
	@ResponseBody
	public ReturnDatas cancelGenGongziUpdate(Model model,HttpServletRequest request,HttpServletResponse response)  throws Exception{
		ReturnDatas returnObject = ReturnDatas.getSuccessReturnDatas();
		String salaryIds = request.getParameter("salaryIds");
		String inDateStr = request.getParameter("inDate");
		if(StringUtils.isBlank(salaryIds)){
			return new ReturnDatas(ReturnDatas.ERROR,"请选择要取消生成工资的员工");
		}
		if(StringUtils.isBlank(inDateStr)){
			return new ReturnDatas(ReturnDatas.ERROR,"请选择要取消生成的月份");
		}
		Date indate = DateUtils.convertString2Date("yyyy-MM-01", inDateStr);
		List<String> salaryIdList = new ArrayList<String>();
		if("all".equals(salaryIds)){
			salaryIdList = salaryService.findSalaryIdsByStateAndInDate(GlobalStaticVar.SalaryStateEnum.已生成.getValue(), indate);
		}else{
			salaryIdList = Arrays.asList(salaryIds.split(","));
		}
		salaryService.updateCancelGenSalary(salaryIdList, indate);
		return returnObject;
	}
	@RequestMapping("/cancel/send/gongzi")
	@ResponseBody
	public ReturnDatas cancelSendGongziUpdate(Model model,HttpServletRequest request,HttpServletResponse response)  throws Exception{
		ReturnDatas returnObject = ReturnDatas.getSuccessReturnDatas();
		String salaryIds = request.getParameter("salaryIds");
		String inDateStr = request.getParameter("inDate");
		if(StringUtils.isBlank(salaryIds)){
			return new ReturnDatas(ReturnDatas.ERROR,"请选择要取消发放工资的员工");
		}
		if(StringUtils.isBlank(inDateStr)){
			return new ReturnDatas(ReturnDatas.ERROR,"请选择要取消发放的月份");
		}
		Date indate = DateUtils.convertString2Date("yyyy-MM-01", inDateStr);
		List<String> salaryIdList = new ArrayList<String>();
		if("all".equals(salaryIds)){
			salaryIdList = salaryService.findSalaryIdsByStateAndInDate(GlobalStaticVar.SalaryStateEnum.已发放.getValue(), indate);
		}else{
			salaryIdList = Arrays.asList(salaryIds.split(","));
		}
		salaryService.updateCancelSendSalary(salaryIdList, indate);
		return returnObject;
	}
	
	@RequestMapping("/list/export/{oper}")
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void listexport(@PathVariable String oper,HttpServletRequest request,HttpServletResponse response, Model model,Salary salary) throws Exception{
		Page page =newPage(request);
		page.setPageSize(GlobalStatic.excelPageSize);
		page.setPageIndex(1);
		
		Map map = new HashMap();
		
		ReturnDatas returnObject = new ReturnDatas();
		if(ErpStateEnum.operSalaryEnum.工资发放.getValue().equals(oper)){
			returnObject = senGongziListJson(model, request, response, salary,page);
		}else{
			returnObject =  listjson(oper, model, request, response, salary,page);
			List<String> titleList = (List<String>) model.asMap().get("titleList");
			map.put("titleList", titleList);
		}
		map.put(GlobalStatic.exportexcel, true);
		map.put(GlobalStatic.returnDatas, returnObject);
		Template template = freeMarkerConfigurer.getConfiguration()
				.getTemplate("/erp/gz/userSalary/userSalaryList"+oper+ GlobalStatic.suffix);
		String fileName=oper+"salary"+GlobalStatic.excelext;
		File file = createExceFile(template, map);
		downFile(response, file, fileName,true);
		return;
	}
	
}
