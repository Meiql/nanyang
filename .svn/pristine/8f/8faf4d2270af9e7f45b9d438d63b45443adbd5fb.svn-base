package org.springrain.erp.quratz;

import java.util.Date;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springrain.erp.gz.service.ISalaryService;
import org.springrain.erp.hr.service.IUserInfoBakService;
import org.springrain.erp.tc.service.ITongchouRecordService;
import org.springrain.frame.util.DateUtils;
import org.springrain.frame.util.SpringUtils;

public class ErpTcUserAndSlaryQuartz extends QuartzJobBean {
	public   Logger logger = LoggerFactory.getLogger(getClass());
	private IUserInfoBakService userInfoBakService=(IUserInfoBakService) SpringUtils.getBean("userInfoBakService");
	private ITongchouRecordService tongchouRecordService=(ITongchouRecordService) SpringUtils.getBean("tongchouRecordService");
	private ISalaryService salaryService=(ISalaryService) SpringUtils.getBean("salaryService");
	@Override
	protected void executeInternal(JobExecutionContext arg0)
			throws JobExecutionException {
		System.out.println("22222222222");
		try {
			Date thisMonthFirstDay = DateUtils.getMonthFirstDay(new Date());
			Date lastMonthFirstDay = DateUtils.plusMonth(thisMonthFirstDay, -1);
			
			userInfoBakService.saveUserInfoBak(lastMonthFirstDay);
			
			salaryService.saveGenUserInfo(lastMonthFirstDay, null);

			tongchouRecordService.saveTcRecord(DateUtils.convertDate2String("yyyy-MM",lastMonthFirstDay));
		
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		
	}
	
	
}
