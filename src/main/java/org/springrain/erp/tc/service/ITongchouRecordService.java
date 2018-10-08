package org.springrain.erp.tc.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springrain.erp.tc.dto.DkdjRecordDto;
import org.springrain.erp.tc.dto.TongchouInfoDto;
import org.springrain.erp.tc.entity.TongchouRecord;
import org.springrain.frame.util.Page;
import org.springrain.frame.util.ReturnDatas;
import org.springrain.system.service.IBaseSpringrainService;
/**
 * TODO 在此加入类描述
 * @copyright {@link weicms.net}
 * @author springrain<Auto generate>
 * @version  2017-07-03 17:42:27
 * @see org.springrain.erp.tc.service.TongchouRecord
 */
public interface ITongchouRecordService extends IBaseSpringrainService {
	
	/**
	 * 根据ID查找
	 * @param id
	 * @return
	 * @throws Exception
	 */
	TongchouRecord findTongchouRecordById(Object id) throws Exception;
	
	
	void saveTcRecord(String month)throws Exception;
	/**
	 * 查询统筹记录数据
	 * @param tongchouRecord
	 * @param page
	 * @return
	 * @throws Exception
	 */
	List<TongchouInfoDto> finderInfoForList(TongchouRecord tongchouRecord,Page page)throws Exception;
	
	/**
	 * 查询接口工资生成时使用
	 * @param userId
	 * @param month格式 2017-06-01
	 * @return
	 * @throws Exception
	 */
	List<TongchouRecord> finderRecordForList(String userId,Date month)throws Exception;
	
	/**
	 * 查询统筹记录个人缴纳总和
	 * @param userId
	 * @param month
	 * @return
	 * @throws Exception
	 */
	BigDecimal findRecordToal(String userId,Date month)throws Exception;
	/**
	 * 员工离职使用
	 * @param userId
	 * @param salayId
	 * @param month
	 * @return
	 * @throws Exception
	 */
	ReturnDatas saveTongchouRecord(String userId,String salayId,Date month)throws Exception;
	/**
	 * 统筹代扣代缴
	 * @param record
	 * @param page
	 * @return
	 * @throws Exception
	 */
	List<DkdjRecordDto> finderTcDkdjList(TongchouRecord record,Page page)throws Exception;
	
	
}