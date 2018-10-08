package org.springrain.erp.hr.service.impl;

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
import org.springrain.erp.constants.DicdataTypeEnum;
import org.springrain.erp.constants.ErpStateEnum;
import org.springrain.erp.gz.util.BaseImport;
import org.springrain.erp.hr.entity.UserEducational;
import org.springrain.erp.hr.service.IUserEducationalService;
import org.springrain.erp.hr.service.IUserInfoService;
import org.springrain.frame.util.DateUtils;
import org.springrain.system.entity.DicData;
import org.springrain.system.entity.User;
import org.springrain.system.service.IDicDataService;
import org.springrain.system.service.IUserService;

@Service("userEducationImportService")
public class UserEducationImportService extends BaseImport {
	@Resource
	private IUserService userService;
	@Resource
	private IUserInfoService userInfoService;
	@Resource
	private IDicDataService dicDataService;	
	@Resource
	private IUserEducationalService userEducationalService;
	public static String[] titles = { "姓名", "开始时间","结束时间","学校名称", "学历", "招生方式", "专业", "学位" };
	List<String> listTitle = Arrays.asList(titles);
	private static final String entityKey = "key";
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	protected String checkData() throws Exception {
		UserEducational dto = new UserEducational();
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
		dto.setUserId(list.get(0).getId());
		//开始时间
		index += 1;
		indexvalue = rowCells.get(index).trim();
		if (StringUtils.isBlank(indexvalue)) {
			return getCellPosition(index) + listTitle.get(index) + "不能为空";
		}
		Date inDate = DateUtils.convertString2Date(indexvalue);
		dto.setStartDate(inDate);
		//结束时间
		index += 1;
		indexvalue = rowCells.get(index).trim();
		if (StringUtils.isBlank(indexvalue)) {
			return getCellPosition(index) + listTitle.get(index) + "不能为空";
		}
		Date endDate = DateUtils.convertString2Date(indexvalue);
		dto.setEndDate(endDate);
		//学校名称
		index += 1;
		indexvalue = rowCells.get(index).trim();
		if (StringUtils.isBlank(indexvalue)) {
			return getCellPosition(index) + listTitle.get(index) + "不能为空";
		}
		dto.setXuexiao(indexvalue);
		//学历
		index += 1;
		indexvalue = rowCells.get(index).trim();
		if (StringUtils.isBlank(indexvalue)) {
			return getCellPosition(index) + listTitle.get(index) + "不能为空";
		}
		DicData qbxl=new DicData();
		qbxl.setName(indexvalue);
		qbxl.setActive(Integer.parseInt(ErpStateEnum.stateEnum.是.getValue()));
		List<DicData> lsxl= dicDataService.findListDicData(DicdataTypeEnum.学历类型.getValue(), null, qbxl);
		if(CollectionUtils.isEmpty(lsxl)){
			return getCellPosition(index)+ "学历【"+ indexvalue + "】系统中不存在";
		};
		DicData da= lsxl.get(0);
		if(da!=null) {
			dto.setXueli(da.getId());
		}
		//招生方式
		index += 1;
		indexvalue = rowCells.get(index).trim();
		if (StringUtils.isBlank(indexvalue)) {
			return getCellPosition(index) + listTitle.get(index) + "不能为空";
		}
		DicData qbzs=new DicData();
		qbzs.setName(indexvalue);
		qbzs.setActive(Integer.parseInt(ErpStateEnum.stateEnum.是.getValue()));
		List<DicData> lszh= dicDataService.findListDicData(DicdataTypeEnum.招生方式.getValue(), null, qbzs);
		if(CollectionUtils.isEmpty(lszh)){
			return getCellPosition(index)+ "招生方式【"+ indexvalue + "】系统中不存在";
		};
		DicData dazs= lszh.get(0);
		if(da!=null) {
			dto.setZhaoshengfangshi(dazs.getId());
		}
		//专业
		index += 1;
		indexvalue = rowCells.get(index).trim();
		if (StringUtils.isBlank(indexvalue)) {
			return getCellPosition(index) + listTitle.get(index) + "不能为空";
		}
		dto.setZhuanye(indexvalue);
		//学位
		index += 1;
		indexvalue = rowCells.get(index).trim();
		if (StringUtils.isBlank(indexvalue)) {
			return getCellPosition(index) + listTitle.get(index) + "不能为空";
		}
		DicData qbxw=new DicData();
		qbxw.setName(indexvalue);
		qbxw.setActive(Integer.parseInt(ErpStateEnum.stateEnum.是.getValue()));
		List<DicData> lsxw= dicDataService.findListDicData(DicdataTypeEnum.学位.getValue(), null, qbxw);
		if(CollectionUtils.isEmpty(lsxw)){
			return getCellPosition(index)+ "学位【"+ indexvalue + "】系统中不存在";
		};
		DicData daxw= lsxw.get(0);
		if(daxw!=null) {
			dto.setXuewei(daxw.getId());
		}	
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
		List<UserEducational> list = new ArrayList<UserEducational>();
		for (Map m : listEntities) {
			if (m.get(entityKey) != null) {
				UserEducational u = (UserEducational) m.get(entityKey);
				list.add(u);
			}
		}
		userEducationalService.saveOrUpdate(list);
		return true;

	}

	@Override
	protected void initOtherParam() {
		// 初始化参数

	}

}
