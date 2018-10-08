package org.springrain.erp.gz.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springrain.erp.gz.entity.Salary;
import org.springrain.frame.util.Page;
import org.springrain.system.entity.DicData;
import org.springrain.system.service.IBaseSpringrainService;
/**
 * TODO 在此加入类描述
 * @copyright {@link weicms.net}
 * @author springrain<Auto generate>
 * @version  2017-07-03 17:28:38
 * @see org.springrain.erp.gz.service.Salary
 */
public interface ISalaryService extends IBaseSpringrainService {
	
	/**
	 * 根据ID查找
	 * @param id
	 * @return
	 * @throws Exception
	 */
	Salary findSalaryById(Object id) throws Exception;
	/**
	 * 将用户表的工资信息写入到工资表
	 * @param month
	 * @throws Exception
	 */
	void saveGenUserInfo(Date month,List<String> listuserid)throws Exception;
	/**
	 * 发放工资 按归属月份  只对已生成状态发放
	 * @param em
	 * @param Indate
	 * @throws Exception
	 */
//	void updateSalaryState(Date indate,Date sendDate)throws Exception;
	/**
	 * 发放工资 按勾选项  只对已生成状态发放
	 * @param em
	 * @param listId
	 * @throws Exception
	 */
//	void updateSalaryState(String[] salaryIds,Date sendDate)throws Exception;
	/**
	 * 工资发放
	 * @param salaryIds
	 * @param sendDate
	 * @param inDate
	 * @throws Exception
	 */
	void updateSalarySend(List<String> salaryIds,Date sendDate,Date inDate)throws Exception;
    /**
	 * 查询工资状态字典
	 * @return
	 * @throws Exception
	 */
	List<DicData> findSalaryState()throws Exception;
	/**
	 * 正常生成人员工资（已生成备份）
	 * @param listSalaryId
	 * @throws Exception
	 */
	void saveGenSalary(List<String> listSalaryId,Date indate)throws Exception;

	/**
	 * 生成指定月份员工工资（未生成备）
	 * @param listUserId
	 * @throws Exception
	 */
	void saveGenLeaveSalary(List<String> listuserid,Date indate)throws Exception;


	/**
	 * 查询本月离职人员工资
	 * @param qb
	 * @param page
	 * @return
	 * @throws Exception
	 */
	List<Salary> findLeaveUserSalary(Salary qb,Page page) throws Exception;
	/**
	 * 清除工资信息（不清除人员备份信息，条件是工资未发放）
	 * @param listSalaryId
	 * @param inDate
	 * @throws Exception
	 */
	void deleteSalary(List<String> listSalaryId,Date inDate)throws Exception;
	/**
	 * 清除工资信息 含备份（条件是工资未发放）
	 * @param listSalaryId
	 * @param inDate
	 * @throws Exception
	 */
	void deleteSalaryIncludeBak(List<String> listSalaryId,Date inDate)throws Exception;
	/**
	 * 查询员工基本工资信息
	 * @param salary
	 * @param page
	 * @return
	 * @throws Exception
	 */
	List<Salary> findUserBasicSalary(Salary salary , Page page) throws Exception;
	
	/**
	 * 查找工资信息 
	 * @param userId
	 * @param indate
	 * @return
	 * @throws Exception
	 */
	Salary finderSalaryInfo(String userId,Date indate)throws Exception;
	
	/**
	 * 根据状态和日期查找工资Id
	 * @param state
	 * @param inDate
	 * @return
	 * @throws Exception
	 */
	List<String> findSalaryIdsByStateAndInDate(Integer state,Date inDate) throws Exception;
	
	/**
	 * 离职-上月 员工生成工资（已生成备份 ）
	 * @param listSalaryId
	 * @throws Exception
	 */
	void saveGenSalaryForLizhi(String userId,Date indate)throws Exception;
	
	/**
	 * 离职--本月 员工生成工资（未生成备份）
	 * @param listUserId
	 * @throws Exception
	 */
	void saveGenSalaryforLizhinow(String userid,Date indate)throws Exception;

	/**
	 * 取消生成工资
	 * @param salaryIds
	 * @param inDate
	 * @throws Exception
	 */
	void updateCancelGenSalary(List<String> salaryIds, Date inDate) throws Exception;
	/**
	 * 取消发放工资
	 * @param salaryIds
	 * @param inDate
	 * @throws Exception
	 */
	void updateCancelSendSalary(List<String> salaryIds, Date inDate) throws Exception;
	/**
	 * 查询一个人在某月的日工资  为空的时候返回0
	 * @param userId
	 * @param month
	 * @return
	 * @throws Exception
	 */
	BigDecimal findUserDayPay(String userId,Date month)throws Exception;
}
