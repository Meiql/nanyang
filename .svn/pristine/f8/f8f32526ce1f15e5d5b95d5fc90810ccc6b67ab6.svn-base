package org.springrain.erp.quratz;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springrain.erp.constants.DicdataTypeEnum;
import org.springrain.erp.gz.util.MailMessageData;
import org.springrain.erp.hr.entity.WorkContract;
import org.springrain.erp.hr.service.IWorkContractService;
import org.springrain.frame.util.GlobalStatic;
import org.springrain.frame.util.ReturnDatas;
import org.springrain.frame.util.SpringUtils;
import org.springrain.system.entity.DicData;
import org.springrain.system.service.IDicDataService;

public class SendMailQuartz extends QuartzJobBean {
	public   Logger logger = LoggerFactory.getLogger(getClass());
	private IWorkContractService workContractService=(IWorkContractService) SpringUtils.getBean("workContractService");
	private IDicDataService dicDataService=(IDicDataService) SpringUtils.getBean("dicDataService");
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	protected void executeInternal(JobExecutionContext arg0)
			throws JobExecutionException {
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
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		
	}
	
	
}
