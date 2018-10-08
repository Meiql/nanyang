package org.springrain.erp.hr.service.impl;

import java.io.File;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springrain.erp.hr.entity.UserInfo;
import org.springrain.erp.hr.entity.UserInfoBak;
import org.springrain.erp.hr.service.IUserInfoBakService;
import org.springrain.frame.entity.IBaseEntity;
import org.springrain.frame.util.Finder;
import org.springrain.frame.util.Page;
import org.springrain.system.entity.User;
import org.springrain.system.service.BaseSpringrainServiceImpl;

/**
 * TODO 在此加入类描述
 * 
 * @copyright {@link weicms.net}
 * @author springrain<Auto generate>
 * @version 2017-07-03 17:47:33
 * @see org.springrain.erp.hr.service.impl.UserInfoBak
 */
@Service("userInfoBakService")
public class UserInfoBakServiceImpl extends BaseSpringrainServiceImpl implements IUserInfoBakService {

	@Override
	public String saveUserInfoBak(Date month) throws Exception {
		Finder finder = new Finder(
				" select ui.*,u.name,u.account,u.sex,u.userType,u.active from " + Finder.getTableName(UserInfo.class)
						+ " as ui," + Finder.getTableName(User.class) + " as u where ui.userId=u.id  ");
		List<UserInfoBak> listbak = super.queryForList(finder, UserInfoBak.class);

		if (CollectionUtils.isNotEmpty(listbak)) {
			// 保存之前先删除当月备份
			deleteUserInfoBak(month);
			for (UserInfoBak u : listbak) {
				u.setMonth(month);
				u.setId(null);
			}
			super.save(listbak);
		}

		return null;
	}

	@Override
	public String deleteUserInfoBak(Date month) throws Exception {
		if (month == null) {
			return "month is null";
		}
		Finder finder = new Finder(" delete from " + Finder.getTableName(UserInfoBak.class));
		finder.append(" where month=:month").setParam("month", month);
		super.update(finder);
		return null;
	}

	@Override
	public String save(Object entity) throws Exception {
		UserInfoBak userInfoBak = (UserInfoBak) entity;
		return super.save(userInfoBak).toString();
	}

	@Override
	public String saveorupdate(Object entity) throws Exception {
		UserInfoBak userInfoBak = (UserInfoBak) entity;
		return super.saveorupdate(userInfoBak).toString();
	}

	@Override
	public Integer update(IBaseEntity entity) throws Exception {
		UserInfoBak userInfoBak = (UserInfoBak) entity;
		return super.update(userInfoBak);
	}

	@Override
	public UserInfoBak findUserInfoBakById(Object id) throws Exception {
		return super.findById(id, UserInfoBak.class);
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
	public <T> List<T> findListDataByFinder(Finder finder, Page page, Class<T> clazz, Object o) throws Exception {
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
	public <T> File findDataExportExcel(Finder finder, String ftlurl, Page page, Class<T> clazz, Object o)
			throws Exception {
		return super.findDataExportExcel(finder, ftlurl, page, clazz, o);
	}

	@Override
	public UserInfoBak findUserMonthBak(Date month, String userId) throws Exception {
		if(month==null||StringUtils.isBlank(userId)) {
			return null;
		}
		Finder finder = Finder.getSelectFinder(UserInfoBak.class);
		finder.append(" where userId=:userId and month=:month ").setParam("userId", userId).setParam("month", month);
		return super.queryForObject(finder,UserInfoBak.class);
	}

}
