package org.springrain.erp.gz.service.impl;

import java.math.BigDecimal;
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
import org.springrain.erp.constants.ErpStateEnum;
import org.springrain.erp.gz.entity.Salaryinfo;
import org.springrain.erp.gz.service.ISalaryService;
import org.springrain.erp.gz.service.ISalaryinfoService;
import org.springrain.erp.gz.util.BaseImport;
import org.springrain.erp.gz.util.MathUtils;
import org.springrain.frame.common.SessionUser;
import org.springrain.frame.util.DateUtils;
import org.springrain.system.entity.DicData;
import org.springrain.system.entity.User;
import org.springrain.system.service.IDicDataService;
import org.springrain.system.service.IUserService;

@Service("salaryinfoImportService")
public class SalaryinfoImportService extends BaseImport {
	@Resource
	private ISalaryinfoService salaryinfoService;
	@Resource
	private IUserService userService;
	@Resource
	private IDicDataService dicDataService;
	@Resource
	private ISalaryService salaryService;

	public static String[] titles = { "归属月份", "员工", "增减类型","天数", "金额", "备注" };
	List<String> listTitle = Arrays.asList(titles);
	private static final String entityKey = "key";

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	protected String checkData() throws Exception {
		Salaryinfo dto = new Salaryinfo();
		// 归属月份
		int index = 0;
		String indexvalue = rowCells.get(index).trim();
		if (StringUtils.isBlank(indexvalue)) {
			return getCellPosition(index) + listTitle.get(index) + "不能为空";
		}
		Date inDate = DateUtils.convertString2Date(indexvalue + "-01");
		dto.setInDate(inDate);
		// 员工
		index += 1;
		indexvalue = rowCells.get(index).trim();
		if (StringUtils.isBlank(indexvalue)) {
			return getCellPosition(index) + listTitle.get(index) + "不能为空";
		}
		String name2 = indexvalue.replaceAll(" ", "");
		List<User> list = userService.finderUserByUserName(indexvalue,name2);
		if(CollectionUtils.isEmpty(list)){
			return "系统中不存在"+dto.getUserName()+"用户";
		}
		dto.setUserAccount(list.get(0).getAccount());
		dto.setUserId(list.get(0).getId());
		dto.setUserName(list.get(0).getName());
		//增减类型
		index += 1;
		indexvalue = rowCells.get(index).trim();
		if (StringUtils.isBlank(indexvalue)) {
			return getCellPosition(index) + listTitle.get(index) + "不能为空";
		}
		dto.setSalaryType(indexvalue);
		
		//查询字典表对应的id  如果不存在说明增减类型不对
		//dto.setSalaryTypeId(salaryTypeId);
		DicData qb=new DicData();
		qb.setName(indexvalue);
		qb.setActive(Integer.parseInt(ErpStateEnum.stateEnum.是.getValue()));
		List<DicData> ls= dicDataService.findListDicData("gzzjxlx", null, qb);
		if(CollectionUtils.isEmpty(ls)) {
			return getCellPosition(index) + indexvalue + "系统中不存在";
		}
		DicData da= ls.get(0);
		if(da!=null) {
			dto.setSalaryTypeId(da.getId());
		}
		//天数
		index += 1;
		indexvalue = rowCells.get(index).trim();
		if (StringUtils.isBlank(indexvalue)) {
			return getCellPosition(index) + listTitle.get(index) + "不能为空";
		}
		dto.setNumberDay(new BigDecimal(indexvalue));
		
		
		//金额
		index += 1;
		indexvalue = rowCells.get(index).trim();
		if (StringUtils.isBlank(indexvalue)) {
			return getCellPosition(index) + listTitle.get(index) + "不能为空";
		}
		if(new BigDecimal(indexvalue).signum()<0){
			return getCellPosition(index) + listTitle.get(index) + "不能为负数";
		}
		if("请假".equals(dto.getSalaryType())||"加班".equals(dto.getSalaryType())){
				BigDecimal rigongzi = salaryService.findUserDayPay(list.get(0).getId(), inDate);
				String amount = MathUtils.mulScale(rigongzi.toString(), dto.getNumberDay().toString());
				dto.setAmount(new BigDecimal(amount));
		}else{
			//判断金额
			dto.setAmount(new BigDecimal(indexvalue));
		}
		
		//备注
		index += 1;
		indexvalue = rowCells.get(index).trim();
		if (StringUtils.isBlank(indexvalue)) {
			return getCellPosition(index) + listTitle.get(index) + "不能为空";
		}
		dto.setRemarker(indexvalue);
		
		dto.setActive("1");
		dto.setCreateUser(SessionUser.getUserName());
		dto.setCreateTime(new Date());
		
		Map m = new HashMap();
		m.put(entityKey, dto);
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
		List<Salaryinfo> list = new ArrayList<Salaryinfo>();
		for (Map m : listEntities) {
			if (m.get(entityKey) != null) {
				Salaryinfo u = (Salaryinfo) m.get(entityKey);
				list.add(u);
			}
		}
		salaryinfoService.save(list);

		return true;

	}

	@Override
	protected void initOtherParam() {
		// 初始化参数

	}

}
