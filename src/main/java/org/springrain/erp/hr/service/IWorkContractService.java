package org.springrain.erp.hr.service;

import java.util.List;

import org.springrain.erp.hr.entity.WorkContract;
import org.springrain.frame.util.Page;
import org.springrain.system.service.IBaseSpringrainService;
/**
 * TODO 在此加入类描述
 * @copyright {@link weicms.net}
 * @author springrain<Auto generate>
 * @version  2017-07-03 17:48:09
 * @see org.springrain.erp.hr.service.WorkContract
 */
public interface IWorkContractService extends IBaseSpringrainService {
	
	/**
	 * 根据ID查找
	 * @param id
	 * @return
	 * @throws Exception
	 */
	WorkContract findWorkContractById(Object id) throws Exception;
	
	List<WorkContract> findWorkContractByQuery(WorkContract query,Page page) throws Exception;

	List<WorkContract> findWorkContractByUserId(String userId) throws Exception;
	
	void updateUserLizheWorkContract(String userId)throws Exception;
	/**
	 * 查询即将过期的有效的劳动合同
	 * @return
	 * @throws Exception
	 */
	List<WorkContract> findJiJiangShixiaoWorkContract()throws Exception;
	/**
	 * 将过期的劳动合同状态设置为失效
	 * @throws Exception
	 */
	void updateWorkContractShixiao()throws Exception;
}
