package org.springrain.erp.zc.service.impl;

import java.io.File;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.util.CollectionUtils;
import org.springframework.stereotype.Service;
import org.springrain.erp.constants.ErpStateEnum;
import org.springrain.erp.gz.util.MathUtils;
import org.springrain.erp.zc.entity.Zichan;
import org.springrain.erp.zc.entity.ZichanLingDetail;
import org.springrain.erp.zc.entity.ZichanRecord;
import org.springrain.erp.zc.service.IZichanLingDetailService;
import org.springrain.erp.zc.service.IZichanRecordService;
import org.springrain.frame.common.SessionUser;
import org.springrain.frame.entity.IBaseEntity;
import org.springrain.frame.util.Finder;
import org.springrain.frame.util.Page;
import org.springrain.system.service.BaseSpringrainServiceImpl;
import org.springrain.system.service.IUserOrgService;

/**
 * TODO 在此加入类描述
 * 
 * @copyright {@link weicms.net}
 * @author springrain<Auto generate>
 * @version 2017-08-14 09:45:09
 * @see org.springrain.erp.zc.service.impl.ZichanRecord
 */
@Service("zichanRecordService")
public class ZichanRecordServiceImpl extends BaseSpringrainServiceImpl
		implements IZichanRecordService {
	@Resource
	private IUserOrgService userOrgService;
	@Resource
	private IZichanLingDetailService zichanLingDetailService;

	@Override
	public String save(Object entity) throws Exception {
		ZichanRecord zichanRecord = (ZichanRecord) entity;
		return super.save(zichanRecord).toString();
	}

	@Override
	public String saveorupdate(Object entity) throws Exception {
		ZichanRecord zichanRecord = (ZichanRecord) entity;
		return super.saveorupdate(zichanRecord).toString();
	}

	@Override
	public Integer update(IBaseEntity entity) throws Exception {
		ZichanRecord zichanRecord = (ZichanRecord) entity;
		return super.update(zichanRecord);
	}

	@Override
	public ZichanRecord findZichanRecordById(Object id) throws Exception {
		return super.findById(id, ZichanRecord.class);
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
	@SuppressWarnings("unchecked")
	@Override
	public <T> List<T> findListDataByFinder(Finder finder, Page page,
			Class<T> clazz, Object o) throws Exception {
		return (List<T>) findZichanRecordByQuery((ZichanRecord) o, page);
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
	public List<ZichanRecord> findZichanRecord(String zcid) throws Exception {
		if (StringUtils.isBlank(zcid))
			return null;
		Finder finder = Finder.getSelectFinder(ZichanRecord.class);
		finder.append(" where 1 = 1 and  active = 0 and zcid = :zcid  order by createtime asc");
		finder.setParam("zcid", zcid);
		return super.queryForList(finder, ZichanRecord.class);
	}

	@Override
	public List<ZichanRecord> findZichanRecordByQuery(ZichanRecord query,
			Page page) throws Exception {
		Finder finder = Finder.getSelectFinder(ZichanRecord.class," zcname,zccode,re.* ");
		finder.append(" as re, ").append(Finder.getTableName(Zichan.class)).append(" as zc ");
		finder.append(" where 1 = 1 and zc.active=0 and re.active=0 and zc.id=re.zcid ");
		if(StringUtils.isNotBlank(query.getRetype())){
			finder.append(" and re.retype = :retype ").setParam("retype", query.getRetype());
		}
		if(StringUtils.isNotBlank(query.getReuser())){
			finder.append(" and re.reuser like :reuser").setParam("reuser", "%"+query.getReuser()+"%");
		}
		if(StringUtils.isNotBlank(query.getZcname())){
			finder.append(" and zc.zcname like :zcname ").setParam("zcname", "%"+query.getZcname()+"%");
		}
		if(StringUtils.isNotBlank(query.getZccode())){
			finder.append(" and zc.zccode like :zccode ").setParam("zccode", "%"+query.getZccode()+"%");
		}
		if(StringUtils.isNotBlank(query.getSdate())){
			finder.append(" and re.redate >= :sdate ").setParam("sdate", query.getSdate());
		}
		if(StringUtils.isNotBlank(query.getEdate())){
			finder.append(" and re.redate <= :edate ").setParam("edate", query.getEdate());
		}
		if(!"super".equals(query.getIsAdmin())){
			Finder uFinder = userOrgService.findUserIdsSQLByManagerUserId(SessionUser.getUserId());
			if (StringUtils.isNotBlank(uFinder.getSql())) {
				// 有权限的时候
				finder.append(" and re.reuserid in (").appendFinder(uFinder).append(")");
			} else {
				// 没有权限的时候
				finder.append(" and re.reuserid = :userId ").setParam("userId", SessionUser.getUserId());
			}
		}
		finder.append(" order by re.createtime desc ");
		return super.queryForList(finder, ZichanRecord.class, page);
	}

	@Override
	public void saveZichanRecordList(List<ZichanRecord> datas) throws Exception {
		if(CollectionUtils.isEmpty(datas)){
			return ;
		}
		for(ZichanRecord re : datas){
			ZichanLingDetail dbling = zichanLingDetailService.findUserLing(re.getReuserid(), re.getZcid());
			String lingid = null;
			ZichanLingDetail ling = new ZichanLingDetail();
			ling.setZcId(re.getZcid());
			ling.setLinguser(re.getReuser());
			ling.setLinguserid(re.getReuserid());
			ling.setLingunit(re.getReunit());
			ling.setLingunitid(re.getReunitid());
			ling.setLingnum(re.getRenum());
			ling.setActive(0);
			if (dbling == null) {
				lingid = super.save(ling).toString();
			} else {
				// 更新领用数量
				lingid = dbling.getId();
				dbling.setLingnum(Integer.parseInt(MathUtils.add(
						String.valueOf(dbling.getLingnum()),
						String.valueOf(ling.getLingnum()))));
				super.update(dbling);
			}

			// 领用记录
			re.setLingid(lingid);
			re.setActive(0);
			re.setCreatetime(new Date());
			re.setCreateuser(SessionUser.getUserId());
			re.setRetype(ErpStateEnum.ZichanOperEnum.领用.getValue());
			super.save(re);

			// 更新资产
			Zichan zc = super.findById(re.getZcid(), Zichan.class);
			zc.setKucun(Integer.parseInt(MathUtils.sub(
					String.valueOf(zc.getKucun()), String.valueOf(re.getRenum()))));
			;
			super.update(zc);
		}
	}

	
}
