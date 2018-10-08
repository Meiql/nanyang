package org.springrain.erp.gz.service.impl;

import java.io.File;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springrain.erp.gz.entity.StopPay;
import org.springrain.erp.gz.service.IStopPayService;
import org.springrain.frame.entity.IBaseEntity;
import org.springrain.frame.util.Finder;
import org.springrain.frame.util.Page;
import org.springrain.system.entity.User;
import org.springrain.system.entity.UserOrg;
import org.springrain.system.service.BaseSpringrainServiceImpl;


/**
 * TODO 在此加入类描述
 * @copyright {@link weicms.net}
 * @author springrain<Auto generate>
 * @version  2017-07-21 09:20:19
 * @see org.springrain.erp.gz.service.impl.StopPay
 */
@Service("stopPayService")
public class StopPayServiceImpl extends BaseSpringrainServiceImpl implements IStopPayService {

   
    @Override
	public String  save(Object entity ) throws Exception{
	      StopPay stopPay=(StopPay) entity;
	       return super.save(stopPay).toString();
	}

    @Override
	public String  saveorupdate(Object entity ) throws Exception{
	      StopPay stopPay=(StopPay) entity;
		 return super.saveorupdate(stopPay).toString();
	}
	
	@Override
    public Integer update(IBaseEntity entity ) throws Exception{
	 StopPay stopPay=(StopPay) entity;
	return super.update(stopPay);
    }
    @Override
	public StopPay findStopPayById(Object id) throws Exception{
	 return super.findById(id,StopPay.class);
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
        @Override
    public <T> List<T> findListDataByFinder(Finder finder, Page page, Class<T> clazz,
			Object o) throws Exception{
			 return super.findListDataByFinder(finder,page,clazz,o);
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
	public List<StopPay> findStopPayByQuery(StopPay query, Page page)
			throws Exception {
		Finder finder = Finder.getSelectFinder(StopPay.class,"s.*,u.name as userName");
		finder.append(" as s left join ").append(Finder.getTableName(User.class)).append(" as u on s.userId = u.id ");
		finder.append(" where 1 = 1 ");
		if(StringUtils.isNotBlank(query.getUserName())){
			finder.append(" and u.name like :uname ").setParam("uname", "%"+query.getUserName()+"%");
		}
		if(StringUtils.isNotBlank(query.getSdate())){
			finder.append(" and s.createDate >= :sdate ").setParam("sdate", query.getSdate());
		}
		if(StringUtils.isNotBlank(query.getEdate())){
			finder.append(" and s.createDate <= :edate ").setParam("edate", query.getEdate());
		}
		if(StringUtils.isNotBlank(query.getOrgId())){
			finder.append(" and u.id in (select userId from ").append(Finder.getTableName(UserOrg.class)).append(" where orgId = :orgId)").setParam("orgId", query.getOrgId());
		}
		if(query.getState() != null ){
			finder.append(" and s.state = :state ").setParam("state", query.getState());
		}
		return super.queryForList(finder, StopPay.class, page);
	}

}
