package org.springrain.erp.hr.service;

import java.util.List;

import org.springrain.erp.hr.entity.UserEducational;
import org.springrain.system.service.IBaseSpringrainService;
/**
 * TODO 在此加入类描述
 * @copyright {@link weicms.net}
 * @author springrain<Auto generate>
 * @version  2017-07-25 13:38:29
 * @see org.springrain.erp.hr.service.UserEducational
 */
/**
 * TODO 在此加入类描述
 * @copyright {@link weicms.net}
 * @author springrain<Auto generate>
 * @version  2017-07-25 13:38:29
 * @see org.springrain.erp.hr.service.UserEducational
 */
public interface IUserEducationalService extends IBaseSpringrainService {
	
	/**
	 * 根据ID查找
	 * @param id
	 * @return
	 * @throws Exception
	 */
	UserEducational findUserEducationalById(Object id) throws Exception;
	
	void deleteNotInIdsAndUserId(String userId, List<String> educationalIds) throws Exception;

	List<UserEducational> findByUserId(String userId) throws Exception;
	
	void saveOrUpdate(List<UserEducational> list) throws Exception;
}
