package org.springrain.erp.zc.service.impl;

import java.io.File;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springrain.erp.zc.entity.ZichanLingDetail;
import org.springrain.erp.zc.service.IZichanLingDetailService;
import org.springrain.frame.entity.IBaseEntity;
import org.springrain.frame.util.Finder;
import org.springrain.frame.util.Page;
import org.springrain.system.entity.User;
import org.springrain.system.service.BaseSpringrainServiceImpl;


/**
 * TODO 在此加入类描述
 * @copyright {@link weicms.net}
 * @author springrain<Auto generate>
 * @version  2017-08-14 09:44:57
 * @see org.springrain.erp.zc.service.impl.ZichanLingDetail
 */
@Service("zichanLingDetailService")
public class ZichanLingDetailServiceImpl extends BaseSpringrainServiceImpl implements IZichanLingDetailService {

   
    @Override
	public String  save(Object entity ) throws Exception{
	      ZichanLingDetail zichanLingDetail=(ZichanLingDetail) entity;
	       return super.save(zichanLingDetail).toString();
	}

    @Override
	public String  saveorupdate(Object entity ) throws Exception{
	      ZichanLingDetail zichanLingDetail=(ZichanLingDetail) entity;
		 return super.saveorupdate(zichanLingDetail).toString();
	}
	
	@Override
    public Integer update(IBaseEntity entity ) throws Exception{
	 ZichanLingDetail zichanLingDetail=(ZichanLingDetail) entity;
	return super.update(zichanLingDetail);
    }
    @Override
	public ZichanLingDetail findZichanLingDetailById(Object id) throws Exception{
	 return super.findById(id,ZichanLingDetail.class);
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
	public List<ZichanLingDetail> findZichanLing(String zcId) throws Exception {
		if(StringUtils.isBlank(zcId)){
			return null;
		}
		Finder finder = Finder.getSelectFinder(ZichanLingDetail.class);
		finder.append(" where 1 = 1 and active=0 and zcid=:zcid  and lingnum>0 ").setParam("zcid", zcId);
		return super.queryForList(finder,ZichanLingDetail.class);
	}

	@Override
	public ZichanLingDetail findUserLing(String linguserid, String zcId)
			throws Exception {
		if(StringUtils.isBlank(linguserid)){
			return null;
		}
		Finder finder = Finder.getSelectFinder(ZichanLingDetail.class);
		finder.append(" where 1 = 1 ");
		finder.append(" and active=0 and linguserid=:linguserid and zcid=:zcid and lingnum>0 ")
		.setParam("linguserid", linguserid).setParam("zcid", zcId);
		return queryForObject(finder, ZichanLingDetail.class);
	}

	@Override
	public List<String> findLikeLingUser(String uname) throws Exception {
		if(StringUtils.isBlank(uname)){
			return null;
		}
		Finder finder = Finder.getSelectFinder(ZichanLingDetail.class,"linguser");
		finder.append(" where 1 = 1 ");
    	finder.append(" and active=0 and lingnum>0 and linguserid in ( ");
    	finder.append(" select id from ").append(Finder.getTableName(User.class)).append(" where 1=1  ");
    	finder.append("  AND (name like :linguser or account like :linguser) "); 
    	finder.append(" ) group by linguser order by linguser LIMIT 10 ");   
		finder.setParam("linguser", uname+"%");
		return queryForList(finder, String.class);
	}

	
}
