package org.springrain.erp.zc.service;

import java.util.List;

import org.springrain.erp.zc.entity.Zichan;
import org.springrain.erp.zc.entity.ZichanRecord;
import org.springrain.frame.util.Page;
import org.springrain.system.service.IBaseSpringrainService;
/**
 * TODO 在此加入类描述
 * @copyright {@link weicms.net}
 * @author springrain<Auto generate>
 * @version  2017-08-14 09:44:45
 * @see org.springrain.erp.zc.service.Zichan
 */
public interface IZichanService extends IBaseSpringrainService {
	
	/**
	 * 根据ID查找
	 * @param id
	 * @return
	 * @throws Exception
	 */
	Zichan findZichanById(Object id) throws Exception;
	
	/**
	 * 资产领用
	 * 
	 * @param zc
	 * @param re
	 * @param ling
	 * @throws Exception
	 */
	void saveLingyong(Zichan zc, ZichanRecord re) throws Exception;

	/**
	 * 资产归还
	 * 
	 * @param zc
	 * @param re
	 * @throws Exception
	 */
	void saveGuihuan(Zichan zc, ZichanRecord re) throws Exception;
	/**
	 * 保存报损
	 * @param zc
	 * @param re
	 * @throws Exception
	 */
	void saveBaosun(Zichan zc,ZichanRecord re)throws Exception;
	/**
	 * 保存出售
	 * @param zc
	 * @param re
	 * @throws Exception
	 */
	void saveChushou(Zichan zc,ZichanRecord re)throws Exception;
	/**
	 * 查询非指定ID的资产编号是否合法
	 * @param zcCode
	 * @param zcId
	 * @return
	 * @throws Exception
	 */
	boolean findZcCodeLegal(String zcCode,String zcId)throws Exception;
	
	void saveZichanList(List<Zichan> zichanList) throws Exception;
	
	List<Zichan> findZichanByQuery(Zichan query,Page page) throws Exception;
	
	Zichan findZichanByZccode(String zccode) throws Exception;
}
