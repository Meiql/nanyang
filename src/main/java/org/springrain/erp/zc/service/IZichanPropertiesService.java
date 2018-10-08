package org.springrain.erp.zc.service;

import org.springrain.erp.zc.entity.ZichanProperties;
import org.springrain.system.service.IBaseSpringrainService;
/**
 * TODO 在此加入类描述
 * @copyright {@link weicms.net}
 * @author springrain<Auto generate>
 * @version  2017-08-14 09:45:18
 * @see org.springrain.erp.zc.service.ZichanProperties
 */
public interface IZichanPropertiesService extends IBaseSpringrainService {
	
	/**
	 * 根据ID查找
	 * @param id
	 * @return
	 * @throws Exception
	 */
	ZichanProperties findZichanPropertiesById(Object id) throws Exception;
	
	void deleteZichanPropertiesByZcId(String zcid) throws Exception;
	
	void saveZichanProperties(String zcid,String guige) throws Exception;
	
}
