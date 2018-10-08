package org.springrain.erp.hr.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springrain.erp.hr.entity.OaOrg;
import org.springrain.erp.hr.service.IOaOrgService;
import org.springrain.frame.entity.IBaseEntity;
import org.springrain.frame.util.Finder;
import org.springrain.frame.util.Page;
import org.springrain.system.entity.Org;
import org.springrain.system.service.BaseSpringrainServiceImpl;
import org.springrain.system.service.IOrgService;


/**
 * TODO 在此加入类描述
 * @copyright {@link weicms.net}
 * @author springrain<Auto generate>
 * @version  2017-07-31 10:02:48
 * @see org.springrain.erp.gz.service.impl.OaOrg
 */
@Service("oaOrgService")
public class OaOrgServiceImpl extends BaseSpringrainServiceImpl implements IOaOrgService {

	@Resource
	private IOrgService orgService;	
   
    @Override
	public String  save(Object entity ) throws Exception{
	      OaOrg oaOrg=(OaOrg) entity;
	       return super.save(oaOrg).toString();
	}

    @Override
	public String  saveorupdate(Object entity ) throws Exception{
	      OaOrg oaOrg=(OaOrg) entity;
		 return super.saveorupdate(oaOrg).toString();
	}
	
	@Override
    public Integer update(IBaseEntity entity ) throws Exception{
	 OaOrg oaOrg=(OaOrg) entity;
	return super.update(oaOrg);
    }
    @Override
	public OaOrg findOaOrgById(Object id) throws Exception{
	 return super.findById(id,OaOrg.class);
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
	public void updateSynOaOrg() throws Exception {
		List<OaOrg> oaOrgList = findTreeOaOrg();
		if(CollectionUtils.isNotEmpty(oaOrgList)){
			Set<String> oaOrgIds = new HashSet<String>();
			for(OaOrg oaOrg : oaOrgList){
				updateOaOrg2Org(oaOrg,oaOrgIds);
			}
			if(CollectionUtils.isNotEmpty(oaOrgIds)){
				orgService.updateOrgNotInOaOrg(oaOrgIds);
			}
		}
		
	}

	private void updateOaOrg2Org(OaOrg oaOrg,Set<String> oaOrgIds) throws Exception{
		if(oaOrg == null){
			return ;
		}
		Org org = orgService.findOrgByOaOrgId(oaOrg.getId());
		if(org == null){
			org = new Org();
			org.setId(null);
			org.setOaorgId(oaOrg.getId());
		}
		
		if(StringUtils.isNotBlank(oaOrg.getPid()) && (!"-1".equals(oaOrg.getPid()))){
			Org pOrg = orgService.findOrgByOaOrgId(oaOrg.getPid());
			org.setPid(pOrg.getId());
		}
		
		org.setName(oaOrg.getName());
		org.setOrgType(1);
		org.setSortno(oaOrg.getSortno());
		org.setLeaf(oaOrg.getLeaf());
		org.setDescription(oaOrg.getDescription());
		org.setActive(1);
		
		if(StringUtils.isNotBlank(org.getId())){
			orgService.updateOrg(org);
		}else{
			orgService.saveOrg(org);
		}
		oaOrgIds.add(oaOrg.getId());
		Iterator<OaOrg> it = oaOrg.getLeafOrg().iterator();
		while (it.hasNext()) {
			OaOrg childOaOrg = it.next();
			updateOaOrg2Org(childOaOrg,oaOrgIds);
		}
		
	}
	
	@Override
	public List<OaOrg> findTreeOaOrg() throws Exception {
		Finder finder=Finder.getSelectFinder(OaOrg.class).append(" WHERE state=:state ");
		finder.setParam("state", "是");
		
		List<OaOrg> list=super.queryForList(finder, OaOrg.class);
		if(CollectionUtils.isEmpty(list)){
			return null;
		}
		List<OaOrg> wrapList=new ArrayList<OaOrg>();
		diguiwrapList(list, wrapList, "-1");
		
		return wrapList;
		
	}
	
	private List<OaOrg> diguiwrapList(List<OaOrg> from, List<OaOrg> tolist,
			String parentId) {
		if (CollectionUtils.isEmpty(from)) {
			return null;
		}

		for (int i = 0; i < from.size(); i++) {
			OaOrg m = from.get(i);
			if (m == null ) {
				// from.remove(i);
				// i=i-1;
				continue;
			}

			String pid = m.getPid();
			if ((pid == null) && (parentId != null)) {
				continue;
			}

			if ((parentId == m.getPid()) || (m.getPid().equals(parentId))) {
				List<OaOrg> leaf = new ArrayList<OaOrg>();
				m.setLeafOrg(leaf);
				tolist.add(m);
				// from.remove(i);
				// i=i-1;
				diguiwrapList(from, leaf, m.getId());
				if (CollectionUtils.isEmpty(leaf)) {
					continue;
				}

			}

		}

		return tolist;

	}

}
