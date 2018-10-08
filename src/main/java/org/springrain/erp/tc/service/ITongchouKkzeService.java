package org.springrain.erp.tc.service;

import java.util.List;

import org.springrain.erp.tc.entity.TongchouKkze;
import org.springrain.frame.util.Page;
import org.springrain.frame.util.ReturnDatas;
import org.springrain.system.service.IBaseSpringrainService;
/**
 * TODO 在此加入类描述
 * @copyright {@link weicms.net}
 * @author springrain<Auto generate>
 * @version  2017-08-11 13:59:35
 * @see org.springrain.erp.gz.service.TongchouKkze
 */
public interface ITongchouKkzeService extends IBaseSpringrainService {
	
	/**
	 * 根据ID查找
	 * @param id
	 * @return
	 * @throws Exception
	 */
	TongchouKkze findTongchouKkzeById(Object id) throws Exception;
	
	/**
	 * 保存统筹扣款总额信息
	 * @param month
	 * @throws Exception
	 */
	ReturnDatas saveTcZemInfo(String month)throws Exception;
	/**
	 * 查询
	 * @param info
	 * @param page
	 * @return
	 * @throws Exception
	 */
	List<TongchouKkze> finderTongchouKkzeList(TongchouKkze tongchouKkze,Page page)throws Exception;
}
