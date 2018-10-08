package org.springrain.erp.hr.service;

import org.springrain.erp.hr.entity.OaUserOrg;
import org.springrain.system.service.IBaseSpringrainService;
/**
 * TODO 在此加入类描述
 * @copyright {@link weicms.net}
 * @author springrain<Auto generate>
 * @version  2017-07-31 10:02:21
 * @see org.springrain.erp.gz.service.OaUserOrg
 */
public interface IOaUserOrgService extends IBaseSpringrainService {
	
	/**
	 * 根据ID查找
	 * @param id
	 * @return
	 * @throws Exception
	 */
	OaUserOrg findOaUserOrgById(Object id) throws Exception;
	
	void saveOaUserOrg()throws Exception;
	
	
}
