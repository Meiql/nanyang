package org.springrain.erp.tc.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springrain.erp.constants.ErpStateEnum;
import org.springrain.erp.constants.ErpStateEnum.tcKKzeSourceEnum;
import org.springrain.erp.tc.entity.TongchouKkze;
import org.springrain.erp.tc.entity.TongchouRecord;
import org.springrain.erp.tc.entity.TongchouZengjian;
import org.springrain.erp.tc.service.ITongchouKkzeService;
import org.springrain.frame.common.SessionUser;
import org.springrain.frame.entity.IBaseEntity;
import org.springrain.frame.util.DateUtils;
import org.springrain.frame.util.Finder;
import org.springrain.frame.util.Page;
import org.springrain.frame.util.ReturnDatas;
import org.springrain.system.entity.DicData;
import org.springrain.system.service.BaseSpringrainServiceImpl;
import org.springrain.system.service.IDicDataService;


/**
 * TODO 在此加入类描述
 * @copyright {@link weicms.net}
 * @author springrain<Auto generate>
 * @version  2017-08-11 13:59:35
 * @see org.springrain.erp.gz.service.impl.TongchouKkze
 */
@Service("tongchouKkzeService")
public class TongchouKkzeServiceImpl extends BaseSpringrainServiceImpl implements ITongchouKkzeService {
	@Resource
	private IDicDataService dicDataService;
   
    @Override
	public String  save(Object entity ) throws Exception{
	      TongchouKkze tongchouKkze=(TongchouKkze) entity;
	       return super.save(tongchouKkze).toString();
	}

    @Override
	public String  saveorupdate(Object entity ) throws Exception{
	      TongchouKkze tongchouKkze=(TongchouKkze) entity;
		 return super.saveorupdate(tongchouKkze).toString();
	}
	
	@Override
    public Integer update(IBaseEntity entity ) throws Exception{
	 TongchouKkze tongchouKkze=(TongchouKkze) entity;
	return super.update(tongchouKkze);
    }
    @Override
	public TongchouKkze findTongchouKkzeById(Object id) throws Exception{
	 return super.findById(id,TongchouKkze.class);
	}
	
/**
 * 列表查询,每个service都会重载,要把sql语句封装到service中,Finder只是最后的方案
 * @param finder
 * @param page
 * @param clazz
 * @param o
 * @return
 * @throws Exception
 */
        @SuppressWarnings("unchecked")
		@Override
    public <T> List<T> findListDataByFinder(Finder finder, Page page, Class<T> clazz,
			Object o) throws Exception{
//			 return super.findListDataByFinder(finder,page,clazz,o);
			 return (List<T>) finderTongchouKkzeList((TongchouKkze) o, page);
			}
	/**
	 * 根据查询列表的宏,导出Excel
	 * @param finder 为空则只查询 clazz表
	 * @param ftlurl 类表的模版宏
	 * @param page 分页对象
	 * @param clazz 要查询的对象
	 * @param o  querybean
	 * @return
	 * @throws Exception
	 */
		@Override
	public <T> File findDataExportExcel(Finder finder,String ftlurl, Page page,
			Class<T> clazz, Object o)
			throws Exception {
			 return super.findDataExportExcel(finder,ftlurl,page,clazz,o);
		}

	@Override
	public ReturnDatas saveTcZemInfo(String month) throws Exception {
		ReturnDatas returnDatas = ReturnDatas.getSuccessReturnDatas();
		if(StringUtils.isEmpty(month)){
			returnDatas.setStatus(ReturnDatas.ERROR);
			returnDatas.setMessage("请选择月份");
			return returnDatas;
		}
		//根据月份查询统筹记录表
		Date date = DateUtils.convertString2Date(DateUtils.DATE_FORMAT, month+"-01");
		List<TongchouKkze> listze = new ArrayList<TongchouKkze>();
		//查询出本月统筹记录
		Finder ftc = new Finder();
		ftc.append("select * from "+Finder.getTableName(TongchouRecord.class)+" where salayid is null and state=:state and `month` =:month");
		ftc.setParam("month", date).setParam("state", ErpStateEnum.tcstateEnum.是.getValue());
		List<TongchouRecord> listTc = super.queryForList(ftc, TongchouRecord.class);
		if(CollectionUtils.isEmpty(listTc)){
			returnDatas.setStatus(ReturnDatas.ERROR);
			returnDatas.setMessage("请生成该月份：统筹月度标准报表");
			return returnDatas;
		}
		if(CollectionUtils.isNotEmpty(listTc)){
			for(TongchouRecord record:listTc){
				TongchouKkze kkze = new TongchouKkze();
				kkze.setCompany(record.getCompany());
				kkze.setCreateTime(new Date());
				kkze.setCreateUser(SessionUser.getUserId());
				kkze.setInsuranceCompany(record.getInsuranceCompany());
				kkze.setInsurancePersonal(record.getInsurancePersonal());
				kkze.setInsuranceType(record.getInsuranceType());
				kkze.setMonth(record.getMonth());
				kkze.setUserName(record.getUserName());
				kkze.setUserId(record.getUserId());
				kkze.setTcjiaonadi(record.getTcjiaonadi());
				kkze.setSourceType(tcKKzeSourceEnum.统筹记录.getValue());
				listze.add(kkze);
			}
		}
		//查询出本月统筹记录
		Finder fzj = new Finder();
		fzj.append("select * from "+Finder.getTableName(TongchouZengjian.class)+" where salayid is null and `month` =:month and active=:active" );
		fzj.setParam("month", date).setParam("active", ErpStateEnum.stateEnum.是.getValue());
		List<TongchouZengjian> listZJ = super.queryForList(fzj, TongchouZengjian.class);
		if(CollectionUtils.isNotEmpty(listZJ)){
			for(TongchouZengjian zengjian:listZJ){
				TongchouKkze kkze = new TongchouKkze();
				kkze.setCompany(zengjian.getCompany());
				kkze.setCreateTime(new Date());
				kkze.setCreateUser(SessionUser.getUserId());
				kkze.setInsuranceCompany(zengjian.getInsuranceCompany());
				kkze.setInsurancePersonal(zengjian.getInsurancePersonal());
				kkze.setInsuranceType(zengjian.getInsuranceType());
				kkze.setMonth(zengjian.getMonth());
				kkze.setUserName(zengjian.getUserName());
				kkze.setUserId(zengjian.getUserId());
				kkze.setTcjiaonadi(zengjian.getTcjnd());
				kkze.setSourceType(tcKKzeSourceEnum.增减项.getValue());
				listze.add(kkze);
			}
		}
		
		//存储gzdkdj数据 先清空本当月数据在进行存储
		Finder fde = Finder.getDeleteFinder(TongchouKkze.class);
		fde.append(" where month=:month").setParam("month", date);
		super.update(fde);
		super.save(listze);
	return returnDatas;
	}

	@Override
	public List<TongchouKkze> finderTongchouKkzeList(
			TongchouKkze tongchouKkze, Page page) throws Exception {
		
		Finder f = new Finder();
		f.append(" select `month` ,company,insuranceType, SUM(insuranceCompany) insuranceCompany,SUM(insurancePersonal) insurancePersonal");
		f.append(" from "+Finder.getTableName(TongchouKkze.class)+" where 1=1 ");
		if(tongchouKkze.getMonth()!=null){
			f.append(" and month=:month");	
			f.setParam("month", tongchouKkze.getMonth());
		}
		if(StringUtils.isNotEmpty(tongchouKkze.getUserName())){
			f.append(" and userName =:userName");
		}
		if(StringUtils.isNotEmpty(tongchouKkze.getCompany())){
			f.append(" and company=:company");
		}
		f.append(" GROUP BY company ,insuranceType");
		f.setParam("company", tongchouKkze.getCompany());
//		f.setParam("userName", tongchouKkze.getUserName());
		List<TongchouKkze> list =  super.queryForList(f, TongchouKkze.class, page);
		Map<String, DicData> dicmap = dicDataService.getAlldicData(null);
		if(CollectionUtils.isNotEmpty(list)){
			for(TongchouKkze kkze:list){
				if(StringUtils.isNotEmpty(kkze.getCompany())&&dicmap.get(kkze.getCompany())!=null){
					kkze.setCompanyName(dicmap.get(kkze.getCompany()).getName());
				}
				if(StringUtils.isNotEmpty(kkze.getInsuranceType())&&dicmap.get(kkze.getInsuranceType())!=null){
					kkze.setInsuranceName(dicmap.get(kkze.getInsuranceType()).getName());
				}
			}
		}
		return list;
	}


}
