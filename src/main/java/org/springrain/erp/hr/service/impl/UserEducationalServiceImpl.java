package org.springrain.erp.hr.service.impl;

import java.io.File;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springrain.erp.hr.entity.UserEducational;
import org.springrain.erp.hr.service.IUserEducationalService;
import org.springrain.frame.entity.IBaseEntity;
import org.springrain.frame.util.Finder;
import org.springrain.frame.util.Page;
import org.springrain.system.service.BaseSpringrainServiceImpl;


/**
 * TODO 在此加入类描述
 * @copyright {@link weicms.net}
 * @author springrain<Auto generate>
 * @version  2017-07-25 13:38:29
 * @see org.springrain.erp.hr.service.impl.UserEducational
 */
@Service("userEducationalService")
public class UserEducationalServiceImpl extends BaseSpringrainServiceImpl implements IUserEducationalService {

   
    @Override
	public String  save(Object entity ) throws Exception{
	      UserEducational userEducational=(UserEducational) entity;
	       return super.save(userEducational).toString();
	}

    @Override
	public String  saveorupdate(Object entity ) throws Exception{
	      UserEducational userEducational=(UserEducational) entity;
		 return super.saveorupdate(userEducational).toString();
	}
	
	@Override
    public Integer update(IBaseEntity entity ) throws Exception{
	 UserEducational userEducational=(UserEducational) entity;
	return super.update(userEducational);
    }
    @Override
	public UserEducational findUserEducationalById(Object id) throws Exception{
	 return super.findById(id,UserEducational.class);
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
	public void deleteNotInIdsAndUserId(String userId,
			List<String> educationalIds) throws Exception {
		if(StringUtils.isBlank(userId)){
			return ;
		}
		Finder finder = Finder.getDeleteFinder(UserEducational.class);
		finder.append(" where 1 = 1 and userId = :userId ");
		finder.setParam("userId", userId);
		if(CollectionUtils.isNotEmpty(educationalIds)){
			finder.append(" and id not in (:ids) ").setParam("ids", educationalIds);
		}
		super.update(finder);
		
	}

	@Override
	public List<UserEducational> findByUserId(String userId) throws Exception {
		if(StringUtils.isBlank(userId)){
			return null;
		}
		Finder finder = Finder.getSelectFinder(UserEducational.class);
		finder.append(" where 1 = 1 and userId = :userId ").setParam("userId", userId);
		finder.append(" order by sort ");
		return super.queryForList(finder, UserEducational.class);
	}

	@Override
	public void saveOrUpdate(List<UserEducational> list) throws Exception {
		if(CollectionUtils.isEmpty(list)){
			return;
		}
		//判断是否存在
		for(UserEducational educational:list){
			List<UserEducational> listCunzai = findByUserId(educational.getUserId());
			if(CollectionUtils.isNotEmpty(listCunzai)){
				for(UserEducational educational2:listCunzai){
					super.deleteById(educational2.getId(), UserEducational.class);
				}
			}
		}
		super.save(list);
	}

	
}
