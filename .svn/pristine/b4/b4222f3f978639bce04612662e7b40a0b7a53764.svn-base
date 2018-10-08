package org.springrain.erp.hr.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springrain.erp.gz.util.BaseImport;
import org.springrain.erp.hr.entity.UserInfo;
import org.springrain.erp.hr.service.IUserInfoService;
import org.springrain.system.entity.User;
import org.springrain.system.service.IUserService;

@Service("userSalaryImportService")
public class UserSalaryImportService extends BaseImport {
	@Resource
	private IUserService userService;
	@Resource
	private IUserInfoService userInfoService;
	public static String[] titles = { "姓名", "基本工资","考核工资","岗位工资", "话费补助" };
	List<String> listTitle = Arrays.asList(titles);
	private static final String entityKey = "key";

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	protected String checkData() throws Exception {
		// 姓名
		int index = 0;
		String indexvalue = rowCells.get(index).trim();
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
		UserInfo userInfo = userInfoService.findUserInfoByUserId(user.getId());
		if(userInfo==null){
			return "请补充用户"+indexvalue+"基本信息";
		}
		//基本工资
		index += 1;
		indexvalue = rowCells.get(index).trim();
		if (StringUtils.isBlank(indexvalue)) {
			return getCellPosition(index) + listTitle.get(index) + "不能为空";
		}
		if(new BigDecimal(indexvalue).signum()<0){
			return getCellPosition(index) +"【"+ listTitle.get(index) + "】不能为负数";
		}
		userInfo.setJibenpay(new BigDecimal(indexvalue));
		//考核工资
		index += 1;
		indexvalue = rowCells.get(index).trim();
		if (StringUtils.isBlank(indexvalue)) {
			return getCellPosition(index) + listTitle.get(index) + "不能为空";
		}
		if(new BigDecimal(indexvalue).signum()<0){
			return getCellPosition(index) +"【"+ listTitle.get(index) + "】不能为负数";
		}
		userInfo.setKaohepay(new BigDecimal(indexvalue));
		//岗位工资
		index += 1;
		indexvalue = rowCells.get(index).trim();
		if (StringUtils.isBlank(indexvalue)) {
			return getCellPosition(index) + listTitle.get(index) + "不能为空";
		}
		if(new BigDecimal(indexvalue).signum()<0){
			return getCellPosition(index) +"【"+ listTitle.get(index) + "】不能为负数";
		}
		userInfo.setGangweipay(new BigDecimal(indexvalue));
		//话费补助
		index += 1;
		indexvalue = rowCells.get(index).trim();
		if (StringUtils.isBlank(indexvalue)) {
			return getCellPosition(index) + listTitle.get(index) + "不能为空";
		}
		if(new BigDecimal(indexvalue).signum()<0){
			return getCellPosition(index) +"【"+ listTitle.get(index) + "】不能为负数";
		}
		userInfo.setMobilePay(new BigDecimal(indexvalue));
		Map m = new HashMap();
		m.put(entityKey, userInfo);
		if (listEntities == null)
			listEntities = new ArrayList<Map>();
		listEntities.add(m);
		return null;
	}

	@Override
	protected String extraCheck() throws Exception {
		// 额外校验
		return null;
	}

	@SuppressWarnings("rawtypes")
	@Override
	protected boolean saveData() throws Exception {
		List<UserInfo> list = new ArrayList<UserInfo>();
		for (Map m : listEntities) {
			if (m.get(entityKey) != null) {
				UserInfo u = (UserInfo) m.get(entityKey);
				list.add(u);
			}
		}
		userInfoService.update(list);
		return true;

	}

	@Override
	protected void initOtherParam() {
		// 初始化参数

	}

}
