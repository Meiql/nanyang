package org.springrain.erp.zc.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.NumberUtils;
import org.springrain.erp.constants.ErpStateEnum;
import org.springrain.erp.gz.util.BaseImport;
import org.springrain.erp.zc.entity.Zichan;
import org.springrain.erp.zc.entity.ZichanRecord;
import org.springrain.erp.zc.service.IZichanRecordService;
import org.springrain.erp.zc.service.IZichanService;
import org.springrain.frame.util.DateUtils;
import org.springrain.system.entity.Org;
import org.springrain.system.entity.User;
import org.springrain.system.service.IUserOrgService;
import org.springrain.system.service.IUserService;

@Service("zichanLingyongImportService")
public class ZichanLingyongImportService extends BaseImport {

	@Resource
	private IZichanRecordService zichanRecordService;
	@Resource
	private IZichanService zichanService;
	@Resource
	private IUserService userService;
	@Resource
	private IUserOrgService userOrgService;
	
	
	public static String[] titles = { "资产编号", "领用人","领用数量","领用日期"};
	List<String> listTitle = Arrays.asList(titles);
	private static final String entityKey = "key";
	public static Map<String,Zichan> map = new HashMap<String, Zichan>();
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	protected String checkData() throws Exception {
		try {
			ZichanRecord dto = new ZichanRecord();
			//资产编号
			int index = 0;
			String indexvalue = rowCells.get(index).trim();
			if (StringUtils.isBlank(indexvalue)) {
				return getCellPosition(index) + listTitle.get(index) + "不能为空";
			}
			Zichan zichan = map.get(indexvalue);
			if(zichan == null){
				zichan = zichanService.findZichanByZccode(indexvalue);
				
			}
			if(zichan == null){
				return getCellPosition(index) + listTitle.get(index) + indexvalue +"该编号不存在";
			}
			dto.setZcid(zichan.getId());
			//领用人
			index += 1;
			indexvalue = rowCells.get(index).trim();
			if (StringUtils.isBlank(indexvalue)) {
				return getCellPosition(index) + listTitle.get(index) + "不能为空";
			}
			String name2 = indexvalue.replaceAll(" ", "");
			List<User> list = userService.finderUserByUserName(indexvalue,name2);
			if(CollectionUtils.isEmpty(list)){
				return "系统中不存在"+indexvalue+"用户";
			}
			User user = list.get(0);
			dto.setReuser(user.getName());
			dto.setReuserid(user.getId());
			List<Org> orgList = userOrgService.findOrgByUserId(user.getId());
			if(CollectionUtils.isNotEmpty(orgList)){
				StringBuilder orgNames = new StringBuilder();
				StringBuilder orgIds = new StringBuilder();
				for(Org o : orgList){
					orgNames.append(o.getName()).append(",");
					orgIds.append(o.getId()).append(",");
				}
				dto.setReunit(orgNames.toString());
				dto.setReunitid(orgIds.toString());
			}
			//领用数量
			index += 1;
			indexvalue = rowCells.get(index).trim();
			Integer num = 0;
			if (StringUtils.isBlank(indexvalue)) {
				return getCellPosition(index) + listTitle.get(index) + "不能为空";
			}
			try {
				if(indexvalue.indexOf(".") > -1){
					indexvalue = indexvalue.substring(0, indexvalue.indexOf("."));
				}
				num = NumberUtils.parseNumber(indexvalue, Integer.class);
			} catch (Exception e) {
				return getCellPosition(index) + listTitle.get(index) + "只能为整数";
			}
			if(num < 0){
				return getCellPosition(index) + listTitle.get(index) + "不能为负数";
			}
			if(num > zichan.getKucun()){
				return getCellPosition(index) + listTitle.get(index) + "库存不足";
			}
			zichan.setKucun(zichan.getKucun()-num);
			dto.setRenum(num);
			//领用日期
			index += 1;
			indexvalue = rowCells.get(index).trim();
			if(StringUtils.isNotBlank(indexvalue)){
				dto.setRedate(DateUtils.convertString2Date(indexvalue));	
			}else{
				dto.setRedate(new Date());
			}
			dto.setRetype(ErpStateEnum.ZichanOperEnum.领用.getValue());
			
			map.put(zichan.getZccode(), zichan);
			
			Map m = new HashMap();
			m.put(entityKey, dto);
			if (listEntities == null)
				listEntities = new ArrayList<Map>();
			listEntities.add(m);
			
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return "请填写正确的资料";
		}
		return null;
	}

	@Override
	protected String extraCheck() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("rawtypes")
	@Override
	protected boolean saveData() throws Exception {
		List<ZichanRecord> list = new ArrayList<ZichanRecord>();
		for (Map m : listEntities) {
			if (m.get(entityKey) != null) {
				ZichanRecord z = (ZichanRecord) m.get(entityKey);
				list.add(z);
			}
		}
		//
		zichanRecordService.saveZichanRecordList(list);
		map = new HashMap<String, Zichan>();
		return true;
	}

	@Override
	protected void initOtherParam() {
		// TODO Auto-generated method stub

	}

}
