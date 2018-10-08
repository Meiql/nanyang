package org.springrain.erp.zc.service;

import java.util.List;

import org.springrain.erp.zc.entity.ZichanRecord;
import org.springrain.frame.util.Page;
import org.springrain.system.service.IBaseSpringrainService;
/**
 * TODO 在此加入类描述
 * @copyright {@link weicms.net}
 * @author springrain<Auto generate>
 * @version  2017-08-14 09:45:09
 * @see org.springrain.erp.zc.service.ZichanRecord
 */
public interface IZichanRecordService extends IBaseSpringrainService {
	
	/**
	 * 根据ID查找
	 * @param id
	 * @return
	 * @throws Exception
	 */
	ZichanRecord findZichanRecordById(Object id) throws Exception;
	
	/**
	 * 查询资产变更记录
	 * @param zcid
	 * @return
	 * @throws Exception
	 */
	List<ZichanRecord> findZichanRecord(String zcid)throws Exception;
	
	List<ZichanRecord> findZichanRecordByQuery(ZichanRecord query , Page page) throws Exception;
	
	void saveZichanRecordList(List<ZichanRecord> datas) throws Exception;
}
