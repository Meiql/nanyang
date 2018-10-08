package org.springrain.erp.tc.service;

import java.util.List;

import org.springrain.erp.tc.dto.TongchouInfoDto;
import org.springrain.erp.tc.entity.TcjnRecord;
import org.springrain.erp.tc.entity.TongchouShow;
import org.springrain.frame.util.Page;
import org.springrain.frame.util.ReturnDatas;
import org.springrain.system.service.IBaseSpringrainService;
/**
 * TODO 在此加入类描述
 * @copyright {@link weicms.net}
 * @author springrain<Auto generate>
 * @version  2017-08-10 08:55:37
 * @see org.springrain.erp.gz.service.TcjnRecord
 */
public interface ITcjnRecordService extends IBaseSpringrainService {
	
	/**
	 * 根据ID查找
	 * @param id
	 * @return
	 * @throws Exception
	 */
	TcjnRecord findTcjnRecordById(Object id) throws Exception;
	
	
	/**
	 * 生成工社保缴纳明细
	 * @param month
	 * @throws Exception
	 */
	ReturnDatas saveTcjnInfo(String month)throws Exception;
	
	/**
	 * 查询
	 * @param info
	 * @param page
	 * @return
	 * @throws Exception
	 */
	List<TongchouInfoDto> finderListTcjnInfo(TcjnRecord tcjnRecord,Page page)throws Exception;
	/**
	 * 组装数据 行转列
	 * @param showTitles
	 * @param statinfos
	 * @return
	 * @throws Exception
	 */
	List<TongchouInfoDto> convertShowInfo(List<TongchouShow> showTitles, List<TcjnRecord> statinfos)throws Exception ;
}
