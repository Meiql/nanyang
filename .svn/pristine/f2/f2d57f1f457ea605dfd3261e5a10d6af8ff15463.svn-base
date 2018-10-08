package org.springrain.erp.tc.service;

import java.util.List;

import org.springrain.erp.tc.entity.TongchouShow;
import org.springrain.frame.util.Page;
import org.springrain.system.service.IBaseSpringrainService;
/**
 * TODO 在此加入类描述
 * @copyright {@link weicms.net}
 * @author springrain<Auto generate>
 * @version  2017-07-03 17:42:41
 * @see org.springrain.erp.tc.service.TongchouShow
 */
public interface ITongchouShowService extends IBaseSpringrainService {
	
	/**
	 * 根据ID查找
	 * @param id
	 * @return
	 * @throws Exception
	 */
	TongchouShow findTongchouShowById(Object id) throws Exception;
	
	List<TongchouShow> findListTongchou(Page page,TongchouShow tongchouShow)throws Exception;

	/**
	 * 根据typekey查找桌面显示信息
	 * @param page
	 * @param tongchouShow
	 * @return
	 * @throws Exception
	 */
	List<TongchouShow> findListByTypekey(TongchouShow tongchouShow)throws Exception;
}
