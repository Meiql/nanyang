package org.springrain.erp.tc.service;

import java.util.List;

import org.springrain.erp.tc.dto.TongchouInfoDto;
import org.springrain.erp.tc.entity.TongchouInfo;
import org.springrain.frame.util.Page;
import org.springrain.system.service.IBaseSpringrainService;
/**
 * TODO 在此加入类描述
 * @copyright {@link weicms.net}
 * @author springrain<Auto generate>
 * @version  2017-07-03 17:40:07
 * @see org.springrain.erp.tc.service.TongchouInfo
 */
public interface ITongchouInfoService extends IBaseSpringrainService {
	
	/**
	 * 根据ID查找
	 * @param id
	 * @return
	 * @throws Exception
	 */
	TongchouInfo findTongchouInfoById(Object id) throws Exception;
	
	/**
	 * 批量更新统筹信息;
	 * @param list
	 * @throws Exception
	 */
	void saveOrupdateListInfo(List<TongchouInfo> list,String userId)throws Exception;
	/**
	 * userid查找统筹信息
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	
	List<TongchouInfo> finderInfoByUserId(String userId)throws Exception;
	
	/**
	 * 组合数据
	 * @param info
	 * @param page
	 * @return
	 * @throws Exception
	 */
	List<TongchouInfoDto> finderListInfo(TongchouInfo info,Page page)throws Exception;

	
	boolean delete(String userId)throws Exception;
	/**
	 * 用户停保
	 * @param info
	 * @throws Exception
	 */
	void saveOrUpdateTcTingbao(TongchouInfo info,String state)throws Exception;
	
	/**
	 * 验证统筹导入信息存在
	 * @param key
	 * @return
	 * @throws Exception
	 */
	TongchouInfo validateMsg(String userName,String tcType)throws Exception;
	/**
	 * 导入保存更新
	 * @param list
	 * @throws Exception
	 */
	void saveOrUpdate(List<TongchouInfo> list) throws Exception;
}
