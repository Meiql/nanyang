package org.springrain.erp.hr.service;

import java.util.List;

import org.springrain.erp.hr.entity.UserInfo;
import org.springrain.erp.hr.entity.UserResume;
import org.springrain.frame.util.Page;
import org.springrain.system.service.IBaseSpringrainService;
/**
 * TODO 在此加入类描述
 * @copyright {@link weicms.net}
 * @author springrain<Auto generate>
 * @version  2017-08-04 09:20:14
 * @see org.springrain.erp.hr.service.UserResume
 */
public interface IUserResumeService extends IBaseSpringrainService {
	
	/**
	 * 根据ID查找
	 * @param id
	 * @return
	 * @throws Exception
	 */
	UserResume findUserResumeById(Object id) throws Exception;
	
	void saveUserOrgResume(String[] newOrgIds,String userId) throws Exception;
	
	void saveUserResume(UserInfo oinfo, UserInfo ninfo) throws Exception;
	
	List<UserResume> findUserResumeByQuery(UserResume query,Page page) throws Exception;
	
	List<UserResume> findUserResumeByUserId(String userId) throws Exception;
}
