	package org.springrain.erp.tc.service.impl;

import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springrain.erp.constants.TcshowEnum.tcShowPropetryEnum;
import org.springrain.erp.gz.util.MathUtils;
import org.springrain.erp.tc.dto.TongchouInfoDto;
import org.springrain.erp.tc.entity.GzdkdjRecord;
import org.springrain.erp.tc.entity.GztcCeRecord;
import org.springrain.erp.tc.entity.TcjnRecord;
import org.springrain.erp.tc.entity.TongchouShow;
import org.springrain.erp.tc.service.ITongchouCerecordService;
import org.springrain.frame.common.SessionUser;
import org.springrain.frame.entity.IBaseEntity;
import org.springrain.frame.util.DateUtils;
import org.springrain.frame.util.Finder;
import org.springrain.frame.util.Page;
import org.springrain.frame.util.ReturnDatas;
import org.springrain.system.entity.DicData;
import org.springrain.system.entity.Org;
import org.springrain.system.service.BaseSpringrainServiceImpl;
import org.springrain.system.service.IDicDataService;


/**
 * TODO 在此加入类描述
 * @copyright {@link weicms.net}
 * @author springrain<Auto generate>
 * @version  2017-08-11 10:29:49
 * @see org.springrain.erp.gz.service.impl.GztcCeRecord
 */
@Service("tongchouCerepordService")
public class TongchouCerecordServiceImpl extends BaseSpringrainServiceImpl implements ITongchouCerecordService {
	@Resource
	private IDicDataService dicDataService;
   
    @Override
	public String  save(Object entity ) throws Exception{
    	GztcCeRecord gztcCeRecord=(GztcCeRecord) entity;
	       return super.save(gztcCeRecord).toString();
	}

    @Override
	public String  saveorupdate(Object entity ) throws Exception{
    	GztcCeRecord gztcCeRecord=(GztcCeRecord) entity;
		 return super.saveorupdate(gztcCeRecord).toString();
	}
	
	@Override
    public Integer update(IBaseEntity entity ) throws Exception{
	 GztcCeRecord GztcCeRecord=(GztcCeRecord) entity;
	return super.update(GztcCeRecord);
    }
    @Override
	public GztcCeRecord findTongchouCerepordById(Object id) throws Exception{
	 return super.findById(id,GztcCeRecord.class);
	}
	
/**
 * 列表查询,每个service都会重载,要把sql语句封装到service中,Finder只是最后的方案
 * @param finder
 * @param page
 * @param clazz
 * @param o
 * @return
 * @throws Exception
 */
        @SuppressWarnings("unchecked")
		@Override
    public <T> List<T> findListDataByFinder(Finder finder, Page page, Class<T> clazz,
			Object o) throws Exception{
//			 return super.findListDataByFinder(finder,page,clazz,o);
			 return (List<T>) finderCeRecordList((GztcCeRecord) o, page);
			}
	/**
	 * 根据查询列表的宏,导出Excel
	 * @param finder 为空则只查询 clazz表
	 * @param ftlurl 类表的模版宏
	 * @param page 分页对象
	 * @param clazz 要查询的对象
	 * @param o  querybean
	 * @return
	 * @throws Exception
	 */
		@Override
	public <T> File findDataExportExcel(Finder finder,String ftlurl, Page page,
			Class<T> clazz, Object o)
			throws Exception {
			 return super.findDataExportExcel(finder,ftlurl,page,clazz,o);
		}

	@Override
	public ReturnDatas saveCeRecord(String month) throws Exception {
		ReturnDatas returnDatas = ReturnDatas.getSuccessReturnDatas();
		if(StringUtils.isEmpty(month)){
			returnDatas.setStatus(ReturnDatas.ERROR);
			returnDatas.setMessage("请选择月份");
			return returnDatas;
		}
		//根据月份查询统筹记录表
		Date date = DateUtils.convertString2Date(DateUtils.DATE_FORMAT, month+"-01");
		List<GztcCeRecord> listCe = new ArrayList<GztcCeRecord>();
		//查询出工资代扣代缴本月记录
		Finder fgz = new Finder();
		fgz.append("select * from "+Finder.getTableName(GzdkdjRecord.class)+" where `month` =:month");
		fgz.setParam("month", date);
		List<GzdkdjRecord> listGz = super.queryForList(fgz, GzdkdjRecord.class);
		if(CollectionUtils.isEmpty(listGz)){
			returnDatas.setStatus(ReturnDatas.ERROR);
			returnDatas.setMessage("请生成该月份:工资代扣代缴报表");
			return returnDatas;
		}
		for(GzdkdjRecord gzdkdjRecord:listGz){
			GztcCeRecord cerepord = assembleMsg(gzdkdjRecord);
			listCe.add(cerepord);
		}
		//存储gzdkdj数据 先清空本当月数据在进行存储
		Finder fde = Finder.getDeleteFinder(GztcCeRecord.class);
		fde.append(" where month=:month").setParam("month", date);
		super.update(fde);
		super.save(listCe);
		return returnDatas;
	}

	private GztcCeRecord assembleMsg(GzdkdjRecord gzdkdjRecord)throws Exception{
		
		Finder finder = new Finder();
		finder.append("select * from "+Finder.getTableName(TcjnRecord.class)+" where userId=:userId and  month=:month and insuranceType=:insuranceType");
		finder.setParam("userId",gzdkdjRecord.getUserId() )
			  .setParam("insuranceType", gzdkdjRecord.getInsuranceType()).setParam("month", gzdkdjRecord.getMonth());
		List<TcjnRecord> listTc = super.queryForList(finder, TcjnRecord.class);
		BigDecimal insuranceCompanyDk = gzdkdjRecord.getInsuranceCompany();//代扣代缴公司部分
		BigDecimal insurancePersonalDk = gzdkdjRecord.getInsurancePersonal();//代扣代缴个人部分
		BigDecimal insuranceCompanyJn = BigDecimal.ZERO;//缴纳公司部分
		BigDecimal insurancePersonalJn = BigDecimal.ZERO;//缴纳个人部分
		if(CollectionUtils.isNotEmpty(listTc)){
			for(TcjnRecord record:listTc){
				insuranceCompanyJn = new BigDecimal(MathUtils.addScale(insuranceCompanyJn.toString(), record.getInsuranceCompany().toString()));
				insurancePersonalJn = new BigDecimal(MathUtils.addScale(insurancePersonalJn.toString(), record.getInsurancePersonal().toString()));
			}
		}
		BigDecimal insuranceCompanyCe =new BigDecimal(MathUtils.subScale(insuranceCompanyDk.toString(), insuranceCompanyJn.toString()));//公司部分差额
		BigDecimal insurancePersonalCe =new BigDecimal(MathUtils.subScale(insurancePersonalDk.toString(), insurancePersonalJn.toString()));//个人部分差额
		GztcCeRecord cerepord = new GztcCeRecord();
		cerepord.setCompany(gzdkdjRecord.getCompany());
		cerepord.setUserId(gzdkdjRecord.getUserId());
		cerepord.setUserName(gzdkdjRecord.getUserName());
		cerepord.setCompanyCe(insuranceCompanyCe);
		cerepord.setCompanyDK(insuranceCompanyDk);
		cerepord.setCompanyJn(insuranceCompanyJn);
		cerepord.setCreateTime(new Date());
		cerepord.setMonth(gzdkdjRecord.getMonth());
		cerepord.setCreateUser(SessionUser.getUserId());
		cerepord.setDepartment(gzdkdjRecord.getDepartment());
		cerepord.setInsurancePersonalCe(insurancePersonalCe);
		cerepord.setInsurancePersonalDk(insurancePersonalDk);
		cerepord.setInsurancePersonalJn(insurancePersonalJn);
		cerepord.setInsuranceType(gzdkdjRecord.getInsuranceType());
		if(StringUtils.isNotBlank(gzdkdjRecord.getInsuranceorgongjijinAccount())){
			cerepord.setInsuranceorgongjijinAccount(gzdkdjRecord.getInsuranceorgongjijinAccount());
		}
		if(StringUtils.isNotBlank(gzdkdjRecord.getInsurgongjijinType())){
			cerepord.setInsurgongjijinType(gzdkdjRecord.getInsurgongjijinType());
		}
		cerepord.setTcjiaonadi(gzdkdjRecord.getTcjnd());
		return cerepord;
	}

	@Override
	public List<TongchouInfoDto> finderCeRecordList(
			GztcCeRecord GztcCeRecord, Page page) throws Exception {


		List<GztcCeRecord> list = new ArrayList<GztcCeRecord>();
		//首先查找用userId 主要是分页数据显示正确。
		Finder f = new Finder();
		f.append(" select DISTINCT userId from "+Finder.getTableName(GztcCeRecord.class)+" where  1=1 ");
		if(StringUtils.isNotEmpty(GztcCeRecord.getCompany())){
			f.append(" and company=:company");
		}
		if(GztcCeRecord.getMonth()!=null){
			f.append(" and month=:month");
		}
		if(StringUtils.isNotEmpty(GztcCeRecord.getUserName())){
			f.append(" and userName =:userName");
		}
		f.setParam("company", GztcCeRecord.getCompany());
		f.setParam("userName", GztcCeRecord.getUserName());
		f.setParam("month", DateUtils.formatDate("yyyy-MM-01", GztcCeRecord.getMonth()));
		List<String> listUserIdStr = super.queryForList(f, String.class, page);
		if(CollectionUtils.isEmpty(listUserIdStr)){
			return null;
		}
		//根据查询的userid查找统筹信息 
		Finder finder = new  Finder();
		finder.append(" select * from "+Finder.getTableName(GztcCeRecord.class)+" where 1=1 ");
		finder.append(" and userId in(:userId)");
		if(StringUtils.isNotEmpty(GztcCeRecord.getCompany())){
			finder.append(" and company=:company");
		}
		if(GztcCeRecord.getMonth()!=null){
			finder.append(" and month=:month");
		}
		if(StringUtils.isNotEmpty(GztcCeRecord.getUserName())){
			finder.append(" and userName =:userName");
		}
		finder.setParam("month", DateUtils.formatDate("yyyy-MM-01", GztcCeRecord.getMonth()));
		finder.setParam("company", GztcCeRecord.getCompany());
		finder.setParam("userId", listUserIdStr);
		finder.setParam("userName", GztcCeRecord.getUserName());
		list=super.queryForList(finder, GztcCeRecord.class);
		
		return convertShowInfo(GztcCeRecord.getListShow(), list);
	
	
	}

	@Override
	public List<TongchouInfoDto> convertShowInfo(List<TongchouShow> showTitles,
			List<GztcCeRecord> statinfos) throws Exception {

		List<TongchouInfoDto> list = new ArrayList<TongchouInfoDto>();
		if(CollectionUtils.isEmpty(showTitles)||CollectionUtils.isEmpty(statinfos)){
			return list;
		}
		Map<String, TongchouInfoDto> map = new LinkedHashMap<String, TongchouInfoDto>();
		for(GztcCeRecord info : statinfos){
			String userId = info.getUserId();
			TongchouInfoDto dto = map.get(userId);
			if(dto==null){
				dto = new TongchouInfoDto();
				dto.setShowList(beanValuesCopy(showTitles));//显示的信息
				dto.setUserId(info.getUserId());
				dto.setUsername(info.getUserName());
				DicData dicData2 = dicDataService.findDicDataById(info.getCompany());
				dto.setMonth(info.getMonth());
				if(StringUtils.isNotBlank(info.getDepartment())){
					Org org = super.findById(info.getDepartment(), Org.class);
					if(org!=null){
						dto.setUnitName(org.getName());
					}
				}
				if(dicData2!=null){
					dto.setInCompany(dicData2.getName());
				}
				map.put(userId, dto);
				list.add(dto);
			}
			//统筹信息设置
			List<TongchouShow> tempShows = dto.getShowList();
			for(TongchouShow temp : tempShows){
				if(!temp.getDicttypeId().equals(info.getInsuranceType())){
					continue;	
				}
				String property = temp.getProperty();
				if(tcShowPropetryEnum.代扣代缴公司部分.getValue().equals(property))
					temp.setPropertyValue(info.getCompanyDK().toString());
				else if(tcShowPropetryEnum.代扣代缴个人部分.getValue().equals(property))
					temp.setPropertyValue(info.getInsurancePersonalDk().toString());
				else if(tcShowPropetryEnum.社保缴纳公司部分.getValue().equals(property))
					temp.setPropertyValue(info.getCompanyJn().toString());
				else if(tcShowPropetryEnum.社保缴纳个人部分.getValue().equals(property)){
					temp.setPropertyValue(info.getInsurancePersonalJn().toString());
				}else if(tcShowPropetryEnum.公司部分差额.getValue().equals(property)){
					temp.setPropertyValue(info.getCompanyCe().toString());
				}else if(tcShowPropetryEnum.个人部分差额.getValue().equals(property)){
					temp.setPropertyValue(info.getInsurancePersonalCe().toString());
				}
			}
			
		}
		
		return list;
	
	};
	private List<TongchouShow> beanValuesCopy(List<TongchouShow> showTitles){
		List<TongchouShow> list = new ArrayList<TongchouShow>();
		for(TongchouShow show : showTitles){
			TongchouShow temp = new TongchouShow();
			temp.setDeskShowName(show.getDeskShowName());
			temp.setDicttypeId(show.getDicttypeId());
			temp.setShowOrhidden(show.getShowOrhidden());
			String property = show.getProperty();
			temp.setProperty(property);
			list.add(temp);
		}
		return list;
	}
}
