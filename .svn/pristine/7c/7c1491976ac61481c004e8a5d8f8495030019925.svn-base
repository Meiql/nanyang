package org.springrain.erp.gz.service.impl;

import java.io.File;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springrain.erp.constants.ErpStateEnum;
import org.springrain.erp.gz.entity.Salaryinfo;
import org.springrain.erp.gz.service.ISalaryinfoService;
import org.springrain.frame.entity.IBaseEntity;
import org.springrain.frame.util.DateUtils;
import org.springrain.frame.util.Finder;
import org.springrain.frame.util.Page;
import org.springrain.system.entity.DicData;
import org.springrain.system.service.BaseSpringrainServiceImpl;
import org.springrain.system.service.IDicDataService;
import org.springrain.system.service.IUserOrgService;

/**
 * TODO 在此加入类描述
 * 
 * @copyright {@link weicms.net}
 * @author springrain<Auto generate>
 * @version 2017-07-03 17:28:49
 * @see org.springrain.erp.gz.service.impl.Salaryinfo
 */
@Service("salaryinfoService")
public class SalaryinfoServiceImpl extends BaseSpringrainServiceImpl implements
		ISalaryinfoService {
	@Resource
	private IDicDataService dicDataService;
	@Resource
	private IUserOrgService userOrgService;

	@Override
	public List<Salaryinfo> findListSalaryinfo(String salaryId)
			throws Exception {
		Finder finder = new Finder(
				" SELECT info.*,dic.name as salaryTypeName from "
						+ Finder.getTableName(Salaryinfo.class)
						+ " as info,"
						+ Finder.getTableName(DicData.class)
						+ " as dic where dic.id=info.salaryTypeId and info.salaryId=:salaryId ");
		finder.setParam("salaryId", salaryId);
		return super.queryForList(finder, Salaryinfo.class);
	}

	@Override
	public List<Salaryinfo> findListSalaryinfo(String userId, Date inDate)
			throws Exception {
		if (StringUtils.isBlank(userId) || inDate == null) {
			return null;
		}
		Finder finder = new Finder(
				"select userId,inDate,sum(amount) as amount,salaryTypeId from "
						+ Finder.getTableName(Salaryinfo.class)
						+ " where userId=:userId and inDate=:inDate group by userId,salaryTypeId,inDate order by userId ");
		finder.setParam("userId", userId).setParam("inDate", inDate);
		return super.queryForList(finder, Salaryinfo.class);
	}

	@Override
	public String save(Object entity) throws Exception {
		Salaryinfo salaryinfo = (Salaryinfo) entity;
		return (String) super.save(salaryinfo);
	}

	@Override
	public String saveorupdate(Object entity) throws Exception {
		Salaryinfo salaryinfo = (Salaryinfo) entity;
		return super.saveorupdate(salaryinfo).toString();
	}

	@Override
	public Integer update(IBaseEntity entity) throws Exception {
		Salaryinfo salaryinfo = (Salaryinfo) entity;
		return super.update(salaryinfo);
	}

	@Override
	public Salaryinfo findSalaryinfoById(Object id) throws Exception {
		return super.findById(id, Salaryinfo.class);
	}

	/**
	 * 列表查询,每个service都会重载,要把sql语句封装到service中,Finder只是最后的方案
	 * 
	 * @param finder
	 * @param page
	 * @param clazz
	 * @param o
	 * @return
	 * @throws Exception
	 */
	@Override
	public <T> List<T> findListDataByFinder(Finder finder, Page page,
			Class<T> clazz, Object o) throws Exception {
		page.setOrder("createTime");
		page.setSort("desc");
		return super.findListDataByFinder(finder, page, clazz, o);
	}

	/**
	 * 根据查询列表的宏,导出Excel
	 * 
	 * @param finder
	 *            为空则只查询 clazz表
	 * @param ftlurl
	 *            类表的模版宏
	 * @param page
	 *            分页对象
	 * @param clazz
	 *            要查询的对象
	 * @param o
	 *            querybean
	 * @return
	 * @throws Exception
	 */
	@Override
	public <T> File findDataExportExcel(Finder finder, String ftlurl,
			Page page, Class<T> clazz, Object o) throws Exception {
		return super.findDataExportExcel(finder, ftlurl, page, clazz, o);
	}

	@Override
	public List<Salaryinfo> findSalaryinfoForList(String userId,Date inDate)
			throws Exception {
		if(StringUtils.isBlank(userId)){
			return null;
		}
		Finder f = new Finder();
		f.append("select * from "+Finder.getTableName(Salaryinfo.class)+" where 1=1 and active=:active").setParam("active", ErpStateEnum.gzZjxActiveEnum.否.getValue());
		if(StringUtils.isNotBlank(userId)){
			f.append(" and userId =:userId");
		}
		
		if(inDate!=null){
			f.append(" and inDate=:inDate");
		}
		f.setParam("userId", userId);
		f.append(" order by inDate desc  ");
		f.setParam("inDate", inDate);
		
		List<Salaryinfo> salaryList = queryForList(f, Salaryinfo.class);
		//重新组装数据，离职查询时使用
		Map<String, DicData> dicmap = dicDataService.getAlldicData(null);
		if(CollectionUtils.isEmpty(salaryList)){
			return  salaryList;
		}
		
		for(Salaryinfo salaryinfo:salaryList){
			salaryinfo.setMonthStr(DateUtils.convertDate2String(DateUtils.DATE_FORMAT, salaryinfo.getInDate()));
			if(StringUtils.isNotBlank(salaryinfo.getSalaryTypeId())&&dicmap.get(salaryinfo.getSalaryTypeId())!=null){
				salaryinfo.setSalaryType(dicmap.get(salaryinfo.getSalaryTypeId()).getName());
			}
			if(StringUtils.isBlank(salaryinfo.getRemarker())){
				salaryinfo.setRemarker("");
			}
			if(salaryinfo.getNumberDay()==null){
				salaryinfo.setNumberDay(BigDecimal.ZERO);
			}
		}
		return  salaryList;
	}

	@Override
	public List<Salaryinfo> saveSalryForList(List<Salaryinfo> list,
			String userId, Date month) throws Exception {
		if(CollectionUtils.isEmpty(list)&&StringUtils.isEmpty(userId)&&month==null){
			return null;
		}
		//保存添加的增减项数据
		super.save(list);
		//查询 userid month;
		Map<String, DicData> dicmap = dicDataService.getAlldicData(null);
		List<Salaryinfo> salaryList = findSalaryinfoForList(userId,month);
		if(CollectionUtils.isEmpty(salaryList)){
			return null;
		}
		for(Salaryinfo salaryinfo:salaryList){
			salaryinfo.setMonthStr(DateUtils.convertDate2String(DateUtils.DATE_FORMAT, salaryinfo.getInDate()));
			if(StringUtils.isNotBlank(salaryinfo.getSalaryTypeId())&&dicmap.get(salaryinfo.getSalaryTypeId())!=null){
				salaryinfo.setSalaryType(dicmap.get(salaryinfo.getSalaryTypeId()).getName());
			}
			if(StringUtils.isBlank(salaryinfo.getRemarker())){
				salaryinfo.setRemarker("");
			}
			if(salaryinfo.getNumberDay()==null){
				salaryinfo.setNumberDay(BigDecimal.ZERO);
			}
		}
			return salaryList;
	}

}
