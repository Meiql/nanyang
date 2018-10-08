package org.springrain.erp.tc.service;

import java.util.List;

import org.springrain.erp.tc.dto.TongchouInfoDto;
import org.springrain.erp.tc.entity.GzdkdjRecord;
import org.springrain.erp.tc.entity.TongchouShow;
import org.springrain.frame.util.Page;
import org.springrain.frame.util.ReturnDatas;
import org.springrain.system.service.IBaseSpringrainService;
/**
 * TODO 在此加入类描述
 * @copyright {@link weicms.net}
 * @author springrain<Auto generate>
 * @version  2017-08-10 08:55:55
 * @see org.springrain.erp.gz.service.GzdkdjRecord
 */
public interface IGzdkdjRecordService extends IBaseSpringrainService {
	
	/**
	 * 根据ID查找
	 * @param id
	 * @return
	 * @throws Exception
	 */
	GzdkdjRecord findGzdkdjRecordById(Object id) throws Exception;
	/**
	 * 生成工资代扣代缴
	 * @param month
	 * @throws Exception
	 */
	ReturnDatas saveGzdkdjInfo(String month)throws Exception;
	
	/**
	 * 查询
	 * @param info
	 * @param page
	 * @return
	 * @throws Exception
	 */
	List<TongchouInfoDto> finderListInfo(GzdkdjRecord gzdkdjRecord,Page page)throws Exception;
	/**
	 * 组装数据 行转列
	 * @param showTitles
	 * @param statinfos
	 * @return
	 * @throws Exception
	 */
	List<TongchouInfoDto> convertShowInfo(List<TongchouShow> showTitles, List<GzdkdjRecord> statinfos)throws Exception ;
	
}
