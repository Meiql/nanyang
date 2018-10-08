package org.springrain.erp.zc.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springrain.erp.zc.entity.ZichanProperties;
import org.springrain.erp.zc.service.IZichanPropertiesService;
import org.springrain.frame.entity.IBaseEntity;
import org.springrain.frame.util.Finder;
import org.springrain.frame.util.Page;
import org.springrain.system.service.BaseSpringrainServiceImpl;


/**
 * TODO 在此加入类描述
 * @copyright {@link weicms.net}
 * @author springrain<Auto generate>
 * @version  2017-08-14 09:45:18
 * @see org.springrain.erp.zc.service.impl.ZichanProperties
 */
@Service("zichanPropertiesService")
public class ZichanPropertiesServiceImpl extends BaseSpringrainServiceImpl implements IZichanPropertiesService {

   
    @Override
	public String  save(Object entity ) throws Exception{
	      ZichanProperties zichanProperties=(ZichanProperties) entity;
	       return super.save(zichanProperties).toString();
	}

    @Override
	public String  saveorupdate(Object entity ) throws Exception{
	      ZichanProperties zichanProperties=(ZichanProperties) entity;
		 return super.saveorupdate(zichanProperties).toString();
	}
	
	@Override
    public Integer update(IBaseEntity entity ) throws Exception{
	 ZichanProperties zichanProperties=(ZichanProperties) entity;
	return super.update(zichanProperties);
    }
    @Override
	public ZichanProperties findZichanPropertiesById(Object id) throws Exception{
	 return super.findById(id,ZichanProperties.class);
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
	public void deleteZichanPropertiesByZcId(String zcId) throws Exception {
		if(StringUtils.isBlank(zcId)){
			return;
		}
		Finder finder = Finder.getDeleteFinder(ZichanProperties.class);
		finder.append(" where 1 = 1 and zcId = :zcId ").setParam("zcId", zcId);
		super.update(finder);
	}

	@Override
	public void saveZichanProperties(String zcid, String guigeStr)
			throws Exception {
		deleteZichanPropertiesByZcId(zcid);
		if(StringUtils.isBlank(zcid)||StringUtils.isBlank(guigeStr)){
			return ;
		}
		List<ZichanProperties> datas = new ArrayList<ZichanProperties>();
		String[] guigeArr = guigeStr.replaceAll("，", ",").split(",");
		if(guigeArr != null && guigeArr.length > 0){
			for(String guige : guigeArr){
				String[] guiges = guige.replaceAll("：", ":").split(":");
				if(guiges != null && guiges.length == 2){
					ZichanProperties dto = new ZichanProperties();
					dto.setId(null);
					dto.setZcId(zcid);
					dto.setProName(guiges[0]);
					dto.setProValue(guiges[1]);
					datas.add(dto);
				}
			}
		}
		if(CollectionUtils.isNotEmpty(datas)){
			super.save(datas);
		}
		
	}

}
