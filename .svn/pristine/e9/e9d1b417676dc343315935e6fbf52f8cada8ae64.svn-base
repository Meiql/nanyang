package org.springrain.erp.tc.service;

import java.util.List;

import org.springrain.erp.tc.dto.TongchouInfoDto;
import org.springrain.erp.tc.entity.GztcCeRecord;
import org.springrain.erp.tc.entity.TongchouShow;
import org.springrain.frame.util.Page;
import org.springrain.frame.util.ReturnDatas;
import org.springrain.system.service.IBaseSpringrainService;
/**
 * TODO 在此加入类描述
 * @copyright {@link weicms.net}
 * @author springrain<Auto generate>
 * @version  2017-08-11 10:29:49
 * @see org.springrain.erp.gz.service.TongchouCerepord
 */
public interface ITongchouCerecordService extends IBaseSpringrainService {
	
	/**
	 * 根据ID查找
	 * @param id
	 * @return
	 * @throws Exception
	 */
	GztcCeRecord findTongchouCerepordById(Object id) throws Exception;
	
	/**
	 * 保存差额表
	 * @param month
	 * @throws Exception
	 */
	ReturnDatas saveCeRecord(String month)throws Exception;
	
	/**
	 * 查询
	 * @param info
	 * @param page
	 * @return
	 * @throws Exception
	 */
	List<TongchouInfoDto> finderCeRecordList(GztcCeRecord gztcCeRecord,Page page)throws Exception;
	/**
	 * 组装数据 行转列
	 * @param showTitles
	 * @param statinfos
	 * @return
	 * @throws Exception
	 */
	List<TongchouInfoDto> convertShowInfo(List<TongchouShow> showTitles, List<GztcCeRecord> statinfos)throws Exception ;
}
	