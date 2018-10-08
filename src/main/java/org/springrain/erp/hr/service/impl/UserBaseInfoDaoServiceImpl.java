package org.springrain.erp.hr.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springrain.erp.hr.dao.UserBaseInfoDao;
import org.springrain.erp.hr.entity.UserCertificate;
import org.springrain.erp.hr.entity.UserEducational;
import org.springrain.erp.hr.entity.UserInfo;
import org.springrain.erp.hr.entity.UserResume;
import org.springrain.erp.hr.entity.WorkContract;
import org.springrain.erp.hr.service.IUserBaseInfoDaoService;
import org.springrain.erp.hr.service.IUserCertificateService;
import org.springrain.erp.hr.service.IUserEducationalService;
import org.springrain.erp.hr.service.IUserInfoService;
import org.springrain.erp.hr.service.IUserResumeService;
import org.springrain.erp.hr.service.IWorkContractService;
import org.springrain.erp.tc.entity.TongchouInfo;
import org.springrain.erp.tc.service.ITongchouInfoService;
import org.springrain.frame.util.Finder;
import org.springrain.frame.util.Page;
import org.springrain.system.entity.DicData;
import org.springrain.system.entity.Org;
import org.springrain.system.entity.User;
import org.springrain.system.service.BaseSpringrainServiceImpl;
import org.springrain.system.service.IDicDataService;
import org.springrain.system.service.IOrgService;
import org.springrain.system.service.IUserOrgService;

@Service("userBaseInfoDaoService")
public class UserBaseInfoDaoServiceImpl extends BaseSpringrainServiceImpl
		implements IUserBaseInfoDaoService {
	@Resource
	IUserInfoService userInfoService;
	@Resource
	IDicDataService dicDataService;
	@Resource
	IUserOrgService userOrgService;
	@Resource
	IUserResumeService userResumeService;
	@Resource
	IUserEducationalService userEducationalService;
	@Resource
	IUserCertificateService userCertificateService;
	@Resource
	IWorkContractService workContractService;
	@Resource
	ITongchouInfoService tongchouInfoService;
	@Resource
	IOrgService orgService;

	@SuppressWarnings("unchecked")
	@Override
	public <T> List<T> findListDataByFinder(Finder finder, Page page,
			Class<T> clazz, Object o) throws Exception {

		 return ((List<T>) findUserBaseInfoDaoByQuery((UserInfo) o, page));
	}

	@Override
	public <T> File findDataExportExcel(Finder finder, String ftlurl,
			Page page, Class<T> clazz, Object o) throws Exception {
		return super.findDataExportExcel(finder, ftlurl, page, clazz, o);
	}

	@Override
	public List<UserBaseInfoDao> findUserBaseInfoDaoByQuery(UserInfo query,
			Page page) throws Exception {
		List<UserInfo> infos = userInfoService.findUserInfoByQuery(query, page);
		List<UserBaseInfoDao> datas = new ArrayList<UserBaseInfoDao>();
		Map<String,DicData> dataMaps = dicDataService.getAlldicData(null);
		try {
			
		
		if(CollectionUtils.isNotEmpty(infos)){
			for(UserInfo info : infos){
				UserBaseInfoDao dao = new UserBaseInfoDao();
				dao.setName(info.getUserName());
				List<Org> centers = userOrgService.findCenterByUserId(info.getUserId());
				if(CollectionUtils.isNotEmpty(centers)){
					int i = 0;
					StringBuilder sb = new StringBuilder();
					for(Org o : centers){
						if(i == 0){
							sb.append(o.getName());
						}else{
							sb.append(",").append(o.getName());
						}
						i++;
					}
					dao.setCenterName(sb.toString());
				}
				dao.setOrgName(info.getOrgName());
				dao.setWorkno(info.getWorkno());
				dao.setGangweiName(info.getGangweiName());
				dao.setEntryDate(info.getEntryDate());
				dao.setStartDate(info.getStartDate());
				dao.setOurAge(info.getOurAge());
				dao.setFirstDate(info.getFirstTime());
				dao.setWorkingYears(info.getWorkingYears());
				dao.setSex(info.getSex());
				dao.setBirthDay(info.getBirthday());
				dao.setAge(info.getAge());
				dao.setJiguan(info.getJiguan());
				if(StringUtils.isNotBlank(info.getMinzu())){
					DicData data = dataMaps.get(info.getMinzu());
					if(data != null)
					dao.setMinzuName(data.getName());
				}
				dao.setMarryState(info.getMarryState());
				if(StringUtils.isNotBlank(info.getPoliticsStatus())){
					DicData data = dataMaps.get(info.getPoliticsStatus());
					if(data != null)
					dao.setPoliticsStatus(data.getName());
				}
				dao.setIdCardNo(info.getIdCard());
				dao.setHujidizhi(info.getHujidizhi());
				dao.setAddress(info.getAddress());
				dao.setFireName(info.getFireName());
				dao.setFirePhone(info.getFirePhone());
				dao.setGuanxi(info.getGuanxi());
				dao.setEmail(info.getEmail());
				dao.setPhone(info.getMobile1());
				dao.setXingqu(info.getXingqu());
				
				List<UserResume> resumes =  userResumeService.findUserResumeByUserId(info.getUserId());
				if(CollectionUtils.isNotEmpty(resumes)){
					for(UserResume ur : resumes){
						User createPerson = super.findById(ur.getCreatePerson(), User.class);
						ur.setCreatePersonName(createPerson.getName());
						if(StringUtils.isNotBlank(ur.getOldOrg())){
							List<Org> orgList = orgService.findOrgByOrgIds(ur.getOldOrg());
							if(CollectionUtils.isNotEmpty(orgList)){
								StringBuilder sb = new StringBuilder();
								for(Org o : orgList){
									sb.append(o.getName()).append(",");
								}
								ur.setOldOrgName(sb.toString());
							}
						}
						if(StringUtils.isNotBlank(ur.getNewOrg())){
							List<Org> orgList = orgService.findOrgByOrgIds(ur.getNewOrg());
							if(CollectionUtils.isNotEmpty(orgList)){
								StringBuilder sb = new StringBuilder();
								for(Org o : orgList){
									sb.append(o.getName()).append(",");
								}
								ur.setNewOrgName(sb.toString());
							}
						}
						if(StringUtils.isNotBlank(ur.getOldGangwei())){
							DicData data = dataMaps.get(ur.getOldGangwei());
							if(data != null)
							ur.setOldGangweiName(data.getName());
						}
						if(StringUtils.isNotBlank(ur.getNewGangwei())){
							DicData data = dataMaps.get(ur.getNewGangwei());
							if(data != null)
							ur.setNewGangweiName(data.getName());
						}
						if(StringUtils.isNotBlank(ur.getOldGrade())){
							DicData data = dataMaps.get(ur.getOldGrade());
							if(data != null)
							ur.setOldGradeName(data.getName());
						}
						if(StringUtils.isNotBlank(ur.getNewGrade())){
							DicData data = dataMaps.get(ur.getNewGrade());
							if(data != null)
							ur.setNewGradeName(data.getName());
						}
						
					}
				}
				dao.setResumes(resumes);
				
				List<UserEducational> educationals = userEducationalService.findByUserId(info.getUserId());
				if(CollectionUtils.isNotEmpty(educationals)){
					for(UserEducational educational:educationals){
						if(StringUtils.isNotBlank(educational.getXueli())){
							DicData data = dataMaps.get(educational.getXueli());
							if(data != null)
							educational.setXueliName(data.getName());
						}
						if(StringUtils.isNotBlank(educational.getZhaoshengfangshi())){
							DicData data = dataMaps.get(educational.getZhaoshengfangshi());
							if(data != null)
							educational.setZhaoshengfangshiName(data.getName());
						}
						if(StringUtils.isNotBlank(educational.getXuewei())){
							DicData data = dataMaps.get(educational.getXuewei());
							if(data != null)
							educational.setXueweiName(data.getName());
						}
					}
					dao.setEducationals(educationals);
				}
				
				List<UserCertificate> certificates = userCertificateService.findByUserId(info.getUserId());
				dao.setCertificates(certificates);
				
				List<WorkContract> workContracts = workContractService.findWorkContractByUserId(info.getUserId());
				if(CollectionUtils.isNotEmpty(workContracts)){
					for(WorkContract e:workContracts){
						if(StringUtils.isNotBlank(e.getWorkType())){
							DicData workType = dataMaps.get(e.getWorkType());
							if(workType != null)
							e.setWorkTypeName(workType.getName());
						}
					}
					dao.setLaodongguanxi(workContracts.get(0).getWorkTypeName());
				}
				dao.setWorkContracts(workContracts);
				
				List<TongchouInfo> tongchouInfos = tongchouInfoService.finderInfoByUserId(info.getUserId());
				if(CollectionUtils.isNotEmpty(tongchouInfos)){
					for(TongchouInfo tongchouInfo : tongchouInfos){
						if(StringUtils.isNotBlank(tongchouInfo.getInsuranceType())){
							DicData data = dataMaps.get(tongchouInfo.getInsuranceType());
							if(data != null)
							tongchouInfo.setInsuranceTypeName(data.getName());
						}
					}
					dao.setTongchouInfos(tongchouInfos);
				}
				datas.add(dao);
			}
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return datas;
	}
	
	
}
