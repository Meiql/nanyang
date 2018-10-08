package org.springrain.erp.tc.service;

import java.util.List;

import org.springrain.erp.tc.dto.DkdjRecordDto;
import org.springrain.erp.tc.entity.TongchouRecord;
import org.springrain.frame.util.Page;
import org.springrain.system.service.IBaseSpringrainService;
/**
 * TODO 在此加入类描述
 * @copyright {@link weicms.net}
 * @author springrain<Auto generate>
 * @version  2017-07-03 17:42:27
 * @see org.springrain.erp.tc.service.TongchouRecord
 */
public interface DkdjRecordService extends IBaseSpringrainService {
	
	/**
	 * 公积金代扣代缴
	 * @param record
	 * @param page
	 * @return
	 * @throws Exception
	 */
	List<DkdjRecordDto> finderGjjDkdjList(TongchouRecord record,Page page)throws Exception;
	
	
}
