package org.springrain.cms.service.impl;

import java.io.File;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springrain.cms.entity.CmsSite;
import org.springrain.cms.entity.CmsTemplate;
import org.springrain.cms.entity.CmsTheme;
import org.springrain.cms.service.ICmsTemplateService;
import org.springrain.frame.entity.IBaseEntity;
import org.springrain.frame.util.Finder;
import org.springrain.frame.util.Page;
import org.springrain.system.service.BaseSpringrainServiceImpl;


/**
 * TODO 在此加入类描述
 * @copyright {@link weicms.net}
 * @author springrain<Auto generate>
 * @version  2016-11-10 11:55:22
 * @see org.springrain.cms.entity.demo.service.impl.CmsTemplate
 */
@Service("cmsTemplateService")
public class CmsTemplateServiceImpl extends BaseSpringrainServiceImpl implements ICmsTemplateService {

   
    @Override
	public String  save(Object entity ) throws Exception{
	      CmsTemplate cmsTemplate=(CmsTemplate) entity;
	       return super.save(cmsTemplate).toString();
	}

    @Override
	public String  saveorupdate(Object entity ) throws Exception{
	      CmsTemplate cmsTemplate=(CmsTemplate) entity;
		 return super.saveorupdate(cmsTemplate).toString();
	}
	
	@Override
    public Integer update(IBaseEntity entity ) throws Exception{
	 CmsTemplate cmsTemplate=(CmsTemplate) entity;
	return super.update(cmsTemplate);
    }
    @Override
	public CmsTemplate findCmsTemplateById(String id) throws Exception{
	 return super.findById(id,CmsTemplate.class);
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
        	finder=Finder.getSelectFinder(CmsTemplate.class," tpl.*,t.name themeName ").append(" tpl, ").append(Finder.getTableName(CmsTheme.class))
        			.append(" t ").append(" where tpl.themeId=t.id ");
        	
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
	public CmsTemplate findCmsTemplateByThemeIdAndModelType(String themeId, Integer modelType, Integer themeType)
			throws Exception {
		Finder finder=Finder.getSelectFinder(CmsTemplate.class).append(" where themeId=:themeId and modelType=:modelType and themeType=:themeType ");
		finder.setParam("themeId", themeId).setParam("modelType", modelType).setParam("themeType", themeType);
		CmsTemplate data = queryForObject(finder, CmsTemplate.class);
		return data;
	}

	@Override
	public List<CmsTemplate> findTplsByThemeIdAndThemeType(String themeId, Integer themeType) throws Exception {
		Finder finder;
		if(themeType!=null){
			finder=Finder.getSelectFinder(CmsTemplate.class).append(" where themeId=:themeId  and themeType=:themeType ");
			finder.setParam("themeId", themeId).setParam("themeType", themeType);
		}else{
			finder=Finder.getSelectFinder(CmsTemplate.class).append(" where themeId=:themeId");
			finder.setParam("themeId", themeId);
		}
		return queryForList(finder, CmsTemplate.class);
	}

	@Override
	public List<CmsTemplate> findTplsBySiteIdAndThemeType(String siteId, Integer themeType) throws Exception {
		CmsSite cmsSite = findById(siteId, CmsSite.class);
		return this.findTplsByThemeIdAndThemeType(cmsSite.getThemeId(), themeType);
	}

}