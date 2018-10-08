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
import org.springrain.erp.constants.DicdataTypeEnum;
import org.springrain.erp.constants.ErpStateEnum;
import org.springrain.erp.constants.TcCodeTypeEnum;
import org.springrain.erp.constants.TcshowEnum.tcShowPropetryEnum;
import org.springrain.erp.gz.util.MathUtils;
import org.springrain.erp.hr.entity.UserInfo;
import org.springrain.erp.hr.service.IUserInfoService;
import org.springrain.erp.tc.dto.TongchouInfoDto;
import org.springrain.erp.tc.entity.GzdkdjRecord;
import org.springrain.erp.tc.entity.TongchouRecord;
import org.springrain.erp.tc.entity.TongchouShow;
import org.springrain.erp.tc.entity.TongchouZengjian;
import org.springrain.erp.tc.service.IGzdkdjRecordService;
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
import org.springrain.system.service.IUserOrgService;


/**
 * TODO 在此加入类描述
 * @copyright {@link weicms.net}
 * @author springrain<Auto generate>
 * @version  2017-08-10 08:55:55
 * @see org.springrain.erp.gz.service.impl.GzdkdjRecord
 */
@Service("gzdkdjRecordService")
public class GzdkdjRecordServiceImpl extends BaseSpringrainServiceImpl implements IGzdkdjRecordService {
	@Resource
	private IDicDataService dicDataService;
	@Resource
	private IUserInfoService userInfoService;
	@Resource
	private IUserOrgService userOrgService;
    @Override
	public String  save(Object entity ) throws Exception{
	      GzdkdjRecord gzdkdjRecord=(GzdkdjRecord) entity;
	       return super.save(gzdkdjRecord).toString();
	}

    @Override
	public String  saveorupdate(Object entity ) throws Exception{
	      GzdkdjRecord gzdkdjRecord=(GzdkdjRecord) entity;
		 return super.saveorupdate(gzdkdjRecord).toString();
	}
	
	@Override
    public Integer update(IBaseEntity entity ) throws Exception{
	 GzdkdjRecord gzdkdjRecord=(GzdkdjRecord) entity;
	return super.update(gzdkdjRecord);
    }
    @Override
	public GzdkdjRecord findGzdkdjRecordById(Object id) throws Exception{
	 return super.findById(id,GzdkdjRecord.class);
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
        	return (List<T>) finderListInfo((GzdkdjRecord) o, page);
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
	public ReturnDatas saveGzdkdjInfo(String month) throws Exception {
		ReturnDatas returnDatas = ReturnDatas.getSuccessReturnDatas();
		//查询出社保公积金缴纳报表统筹费用类型
		DicData dicData = new DicData();
		dicData.setCode(TcCodeTypeEnum.tcFyTypeEnum.代扣代缴.getValue());
		List<DicData> listDic = dicDataService.findDicDataForList(DicdataTypeEnum.费用类型.getValue(), null, dicData);
		List<String> listStr = new ArrayList<String>();
		if(CollectionUtils.isNotEmpty(listDic)){
			for(DicData data:listDic){
				listStr.add(data.getId());
			}
		}
		if(StringUtils.isEmpty(month)){
			returnDatas.setStatus(ReturnDatas.ERROR);
			returnDatas.setMessage("请选择月份");
			return returnDatas;
		}
		//根据月份查询统筹记录表
		Date date = DateUtils.convertString2Date(DateUtils.DATE_FORMAT, month+"-01");
		Finder ftc = new Finder();
		ftc.append("select * from "+Finder.getTableName(TongchouRecord.class)+" where state=:state and salayid is null")
		   .setParam("state", ErpStateEnum.tcstateEnum.是.getValue());
		ftc.append(" and month=:month").setParam("month", date);
		List<TongchouRecord> listRecord = super.queryForList(ftc, TongchouRecord.class); 
		if(CollectionUtils.isEmpty(listRecord)){
			returnDatas.setStatus(ReturnDatas.ERROR);
			returnDatas.setMessage("请生成该月份：统筹月度标准报表");
			return returnDatas;
		}
		//组数据
		List<GzdkdjRecord> lsgzdkdj = new ArrayList<GzdkdjRecord>(); 
		for(TongchouRecord record:listRecord){
			//*************组数据 通过记录表的统筹类型查询出增减项中的增减项并计算****************************
			GzdkdjRecord gzdkdjRecord = AssembleInfo(record,listStr);
			lsgzdkdj.add(gzdkdjRecord);
		}
		
		//*************查询出增减项存在而记录表的不存在的记录 组装数据****************************
		Finder ftcStr = new Finder();
		ftcStr.append("select insuranceType from "+Finder.getTableName(TongchouRecord.class)+" where state=:state and salayid is null")
			  .append(" and month=:month").setParam("month", date);
		ftcStr.setParam("state", ErpStateEnum.tcstateEnum.是.getValue());
		List<String> listTcTypeStr  = super.queryForList(ftcStr,String.class);
		//查询增减项中和统筹记录中不同的统筹类型
		Finder ftczjx = new Finder();
		ftczjx.append("select * from "+Finder.getTableName(TongchouZengjian.class)+"   where feiyongtype in (:feiyongtype) ");
		ftczjx.append(" and salayid is null and month =:month  and insuranceType not in(:insuranceType) and active=:active");
		ftczjx.setParam("month", date).setParam("insuranceType", listTcTypeStr)
			  .setParam("feiyongtype", listStr).setParam("active", ErpStateEnum.stateEnum.是.getValue());
		
		List<TongchouZengjian> lszj = super.queryForList(ftczjx, TongchouZengjian.class);
		if(CollectionUtils.isNotEmpty(lszj)){
			for(TongchouZengjian tongchouZengjian:lszj){
				BigDecimal insuranceCompany = tongchouZengjian.getInsuranceCompany();
				BigDecimal insurancePersonal = tongchouZengjian.getInsurancePersonal();
				GzdkdjRecord gzdkdjRecord = new GzdkdjRecord();
				gzdkdjRecord.setMonth(tongchouZengjian.getMonth());
				gzdkdjRecord.setUserId(tongchouZengjian.getUserId());
				gzdkdjRecord.setUserName(tongchouZengjian.getUserName());
				gzdkdjRecord.setInsuranceType(tongchouZengjian.getInsuranceType());
				gzdkdjRecord.setInsuranceCompany(insuranceCompany);
				gzdkdjRecord.setInsurancePersonal(insurancePersonal);
				gzdkdjRecord.setCreateTime(new Date());
				gzdkdjRecord.setCreator(SessionUser.getUserId());
				UserInfo userinfo = userInfoService.findUserInfoByUserId(tongchouZengjian.getUserId());
				if(userinfo!=null){
					gzdkdjRecord.setCompany(userinfo.getCompany());
				}
				List<Org> listOrg = userOrgService.findOrgByUserId(tongchouZengjian.getUserId());
				if(CollectionUtils.isNotEmpty(listOrg)){
					gzdkdjRecord.setDepartment(listOrg.get(0).getId());
				}
				lsgzdkdj.add(gzdkdjRecord);
			}
		}
		//存储gzdkdj数据 先清空本当月数据在进行存储
		Finder fde = Finder.getDeleteFinder(GzdkdjRecord.class);
		fde.append(" where month=:month").setParam("month", date);
		super.update(fde);
		super.save(lsgzdkdj);
		returnDatas.setMessage("生成成功");
		return returnDatas;
	}
	
	private  GzdkdjRecord AssembleInfo(TongchouRecord record,List<String> listStr)throws Exception{
		if(record==null){
			return null;
		}
		//查询增减项
		Finder ftczjx = new Finder();
		ftczjx.append("select * from "+Finder.getTableName(TongchouZengjian.class)+"   where feiyongtype in (:feiyongtype) ");
		ftczjx.append("and salayid is null and month =:month and userId=:userId and insuranceType=:insuranceType and active=:active");
		ftczjx.setParam("month", DateUtils.formatDate(DateUtils.DATETIME_FORMAT, record.getMonth())).setParam("insuranceType", record.getInsuranceType())
		  .setParam("userId", record.getUserId()).setParam("feiyongtype", listStr).setParam("active", ErpStateEnum.stateEnum.是.getValue());
		List<TongchouZengjian> list = super.queryForList(ftczjx,TongchouZengjian.class);
		GzdkdjRecord gzdkdjRecord = new GzdkdjRecord();
		BigDecimal companyjn = record.getInsuranceCompany();
		BigDecimal personaljn = record.getInsurancePersonal();
		if(CollectionUtils.isNotEmpty(list)){
			for(TongchouZengjian zengjian :list){
				BigDecimal insuranceCompany = zengjian.getInsuranceCompany();
				BigDecimal insurancePersonal = zengjian.getInsurancePersonal();
				companyjn = new BigDecimal(MathUtils.add(companyjn.toString(), insuranceCompany.toString()));
				personaljn =new BigDecimal(MathUtils.add(personaljn.toString(), insurancePersonal.toString()));
			}
		}
		gzdkdjRecord.setUserId(record.getUserId());
		gzdkdjRecord.setUserName(record.getUserName());
		gzdkdjRecord.setCompany(record.getCompany());
		gzdkdjRecord.setCreateTime(new Date());
		gzdkdjRecord.setCreator(SessionUser.getUserId());
		gzdkdjRecord.setInsuranceCompany(companyjn);
		gzdkdjRecord.setInsuranceorgongjijinAccount(record.getInsuranceorgongjijinAccount());
		gzdkdjRecord.setInsurancePersonal(personaljn);
		gzdkdjRecord.setInsuranceType(record.getInsuranceType());
		gzdkdjRecord.setInsurgongjijinType(record.getInsurgongjijinType());
		gzdkdjRecord.setMonth(record.getMonth());
		gzdkdjRecord.setRadices(record.getRadices());
		gzdkdjRecord.setStopProtectMonth(record.getStopProtectMonth());
		gzdkdjRecord.setTcjnd(record.getTcjiaonadi());
		gzdkdjRecord.setDepartment(record.getDepartment());
		return gzdkdjRecord;
	}

	@Override
	public List<TongchouInfoDto> finderListInfo(GzdkdjRecord gzdkdjRecord,
			Page page) throws Exception {

		List<GzdkdjRecord> list = new ArrayList<GzdkdjRecord>();
		//首先查找用userId 主要是分页数据显示正确。
		Finder f = new Finder();
		f.append(" select DISTINCT userId from "+Finder.getTableName(GzdkdjRecord.class)+" where  1=1 ");
		if(StringUtils.isNotEmpty(gzdkdjRecord.getUserName())){
			f.append(" and userName =:userName");
		}
		if(StringUtils.isNotEmpty(gzdkdjRecord.getCompany())){
			f.append(" and company=:company");
		}
		if(gzdkdjRecord.getMonth()!=null){
			f.append(" and month=:month");
		}
		f.setParam("company", gzdkdjRecord.getCompany());
		f.setParam("userName", gzdkdjRecord.getUserName());
		f.setParam("month", DateUtils.formatDate("yyyy-MM-01", gzdkdjRecord.getMonth()));
		List<String> listUserIdStr = super.queryForList(f, String.class, page);
		if(CollectionUtils.isEmpty(listUserIdStr)){
			return null;
		}
		//根据查询的userid查找统筹信息 
		Finder finder = new  Finder();
		finder.append(" select * from "+Finder.getTableName(GzdkdjRecord.class)+" where 1=1 ");
		if(CollectionUtils.isNotEmpty(listUserIdStr)){
			finder.append(" and userId in(:userId)");
		}
		if(StringUtils.isNotEmpty(gzdkdjRecord.getUserName())){
			finder.append(" and userName =:userName");
		}
		if(StringUtils.isNotEmpty(gzdkdjRecord.getCompany())){
			finder.append(" and company=:company");
		}
		if(gzdkdjRecord.getMonth()!=null){
			finder.append(" and month=:month");
		}
		finder.setParam("month", DateUtils.formatDate("yyyy-MM-01", gzdkdjRecord.getMonth()));
		finder.setParam("company", gzdkdjRecord.getCompany());
		finder.setParam("userName", gzdkdjRecord.getUserName());
		finder.setParam("userId", listUserIdStr);
		list=super.queryForList(finder, GzdkdjRecord.class);
		
		return convertShowInfo(gzdkdjRecord.getListShow(), list);
	
	}
	
	
	/**
	 * 转换为页面显示的信息
	 * */
	@Override
	public  List<TongchouInfoDto> convertShowInfo(
			List<TongchouShow> showTitles, List<GzdkdjRecord> statinfos)
			throws Exception {

		List<TongchouInfoDto> list = new ArrayList<TongchouInfoDto>();
		if(CollectionUtils.isEmpty(showTitles)||CollectionUtils.isEmpty(statinfos)){
			return list;
		}
		Map<String, TongchouInfoDto> map = new LinkedHashMap<String, TongchouInfoDto>();
		for(GzdkdjRecord info : statinfos){
			String userId = info.getUserId();
			TongchouInfoDto dto = map.get(userId);
			if(dto==null){
				dto = new TongchouInfoDto();
				dto.setShowList(beanValuesCopy(showTitles));//显示的信息
				dto.setUsername(info.getUserName());//用户名
				dto.setUserId(info.getUserId());
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
				if(tcShowPropetryEnum.账号.getValue().equals(property))
					temp.setPropertyValue(info.getInsuranceorgongjijinAccount());
				else if(tcShowPropetryEnum.个人缴费.getValue().equals(property))
					temp.setPropertyValue((info.getInsurancePersonal()==null)?BigDecimal.ZERO.toString():info.getInsurancePersonal().toString());
				else if(tcShowPropetryEnum.单位缴费.getValue().equals(property))
					temp.setPropertyValue((info.getInsuranceCompany()==null)?BigDecimal.ZERO.toString():info.getInsuranceCompany().toString());
				else if(tcShowPropetryEnum.缴费基数.getValue().equals(property)){
					temp.setPropertyValue(info.getRadices().toString());
				}
			}
			
		}
		
		return list;
	
	}
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
//		Collections.reverse(list); // 倒序排列 
		return list;
	}
}
