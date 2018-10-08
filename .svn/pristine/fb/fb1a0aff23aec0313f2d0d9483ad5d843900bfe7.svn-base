package org.springrain.erp.gz.web;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springrain.erp.constants.DicdataTypeEnum;
import org.springrain.erp.gz.service.ISalaryService;
import org.springrain.erp.gz.util.MailMessageData;
import org.springrain.erp.hr.entity.WorkContract;
import org.springrain.erp.hr.service.IOaUserService;
import org.springrain.erp.hr.service.IUserInfoBakService;
import org.springrain.erp.hr.service.IUserInfoService;
import org.springrain.erp.hr.service.IWorkContractService;
import org.springrain.erp.tc.service.ITongchouRecordService;
import org.springrain.frame.controller.BaseController;
import org.springrain.frame.util.DateUtils;
import org.springrain.frame.util.GlobalStatic;
import org.springrain.frame.util.ReturnDatas;
import org.springrain.system.entity.DicData;
import org.springrain.system.service.IDicDataService;

/**
 * 定时任务
 * 
 * @author wulei
 *
 */
@Controller
@RequestMapping(value = "/taskjob")
public class TaskJobController extends BaseController {
	@Resource
	private IDicDataService dicDataService;
	@Resource
	private IUserInfoBakService userInfoBakService;
	@Resource
	private ITongchouRecordService tongchouRecordService;
	@Resource
	private ISalaryService salaryService;
	@Resource
	private IWorkContractService workContractService;
	@Resource
	IOaUserService oaUserService;
	@Resource
	private IUserInfoService userInfoService;
	/**
	 * 生成上月人员备份信息
	 * 
	 * @param model
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/genUserInfoBak")
	public void genUserBak(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			Date thisMonthFirstDay = DateUtils.getMonthFirstDay(new Date());
			Date lastMonthFirstDay = DateUtils.plusMonth(thisMonthFirstDay, -1);
			userInfoBakService.saveUserInfoBak(lastMonthFirstDay);
			salaryService.saveGenUserInfo(lastMonthFirstDay, null);
			response.getWriter().write("success");
			
		} catch (Exception e) {
			 logger.error(e.getMessage(), e);
		}
		
	}
	
	/**
	 * 生成上月统筹备份信息
	 * @param model
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/genTcBak")
	public void gentcBak(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {	
			Date thisMonthFirstDay = DateUtils.getMonthFirstDay(new Date());
			Date lastMonthFirstDay = DateUtils.plusMonth(thisMonthFirstDay, -1);
			tongchouRecordService.saveTcRecord(DateUtils.convertDate2String("yyyy-MM",lastMonthFirstDay));
			response.getWriter().write("success");
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
			}

		
	}
	
	/**
	 * 发送合同过期email
	 * @param model
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping("/sendEmail")
	public void sendEmail(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			
			workContractService.updateWorkContractShixiao();
			List<WorkContract> datas = workContractService.findJiJiangShixiaoWorkContract();
			if(CollectionUtils.isNotEmpty(datas)){
				ReturnDatas returnDatas = ReturnDatas.getSuccessReturnDatas();
				returnDatas.setData(datas);
				Map map = new HashMap();
				map.put(GlobalStatic.returnDatas, returnDatas);
				MailMessageData data = new MailMessageData();
				data.setTemplateData(map);
				data.setTemplateName("hetongguoqi");
				data.setSubject("合同到期通知");
				List<DicData> dicDatas = dicDataService.findListDicData(DicdataTypeEnum.接收邮箱.getValue(), null, null);
				if(CollectionUtils.isEmpty(dicDatas)){
					return ;
				}
				DicData sendData = dicDatas.get(0);
				data.setTo(sendData.getRemark().split(","));
				data.send();
				response.getWriter().write("success");
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		
	}
	/**
	 * 同步人员，部门信息
	 * @param model
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/synData")
	public void synData(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			oaUserService.saveOaMsg();
			userInfoService.savesyndata();
			response.getWriter().write("success");
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}
}