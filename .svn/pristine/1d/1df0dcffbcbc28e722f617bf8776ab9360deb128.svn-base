package org.springrain.erp.zc.service;

import java.util.List;

import org.springrain.erp.zc.entity.ZichanLingDetail;
import org.springrain.system.service.IBaseSpringrainService;
/**
 * TODO 在此加入类描述
 * @copyright {@link weicms.net}
 * @author springrain<Auto generate>
 * @version  2017-08-14 09:44:57
 * @see org.springrain.erp.zc.service.ZichanLingDetail
 */
public interface IZichanLingDetailService extends IBaseSpringrainService {
	
	/**
	 * 根据ID查找
	 * @param id
	 * @return
	 * @throws Exception
	 */
	ZichanLingDetail findZichanLingDetailById(Object id) throws Exception;
	
	/**
	 * 查询资产的现领用记录(领用数量大于0)
	 * @param zcId
	 * @return
	 * @throws Exception
	 */
	List<ZichanLingDetail> findZichanLing(String zcId)throws Exception;
	/**
	 * 查询某个人的现领用记录（只有1条）
	 * @param linguser
	 * @return
	 * @throws Exception
	 */
	ZichanLingDetail findUserLing(String linguserid,String zcId)throws Exception;
	/**
	 * 模糊查询领用人
	 * @param uname
	 * @return
	 * @throws Exception
	 */
	List<String> findLikeLingUser(String uname)throws Exception;
	
}
