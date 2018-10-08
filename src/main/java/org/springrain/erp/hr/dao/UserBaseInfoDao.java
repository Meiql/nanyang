package org.springrain.erp.hr.dao;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springrain.erp.hr.entity.UserCertificate;
import org.springrain.erp.hr.entity.UserEducational;
import org.springrain.erp.hr.entity.UserResume;
import org.springrain.erp.hr.entity.WorkContract;
import org.springrain.erp.tc.entity.TongchouInfo;

public class UserBaseInfoDao implements Serializable {
	
	private static final long serialVersionUID = 1L;
	/**
	 * 姓名
	 */
	private String name;
	/**
	 * 归属中心
	 */
	private String centerName;
	/**
	 * 部门
	 */
	private String orgName;
	/**
	 * 劳动关系
	 */
	private String laodongguanxi;
	/**
	 * 工号
	 */
	private String workno;
	/**
	 * 岗位
	 */
	private String gangweiName;
	/**
	 * 入职时间
	 */
	private Date entryDate;
	/**
	 * 转正时间
	 */
	private Date startDate;
	/**
	 * 司龄
	 */
	private Integer ourAge;
	/**
	 * 首次工作时间
	 */
	private Date firstDate;
	/**
	 * 工龄
	 */
	private Integer workingYears;
	/**
	 * 性别
	 */
	private String sex;
	/**
	 * 生日
	 */
	private Date birthDay;
	/**
	 * 年龄
	 */
	private Integer age;
	/**
	 * 籍贯
	 */
	private String jiguan;
	/**
	 * 民族
	 */
	private String minzuName;
	/**
	 * 婚姻状态
	 */
	private String marryState;
	/**
	 * 政治面貌
	 */
	private String politicsStatus;
	/**
	 * 身份证号
	 */
	private String idCardNo;
	/**
	 * 户籍地址
	 */
	private String hujidizhi;
	/**
	 * 详细住址
	 */
	private String address;
	/**
	 * 紧急联系人
	 */
	private String fireName;
	/**
	 * 紧急联系电话
	 */
	private String firePhone;
	/**
	 * 紧急联系人关系
	 */
	private String guanxi;
	/**
	 * 邮箱
	 */
	private String email;
	/**
	 * 电话
	 */
	private String phone;
	/**
	 * 教育经历
	 */
	private List<UserEducational> educationals;
	/**
	 * 证书
	 */
	private List<UserCertificate> certificates;
	/**
	 * 劳动关系
	 */
	private List<WorkContract> workContracts;
	/**
	 * 履历
	 */
	private List<UserResume> resumes;
	/**
	 * 统筹信息
	 */
	private List<TongchouInfo> tongchouInfos;
	/**
	 * 兴趣爱好
	 */
	private String xingqu;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCenterName() {
		return centerName;
	}

	public void setCenterName(String centerName) {
		this.centerName = centerName;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getLaodongguanxi() {
		return laodongguanxi;
	}

	public void setLaodongguanxi(String laodongguanxi) {
		this.laodongguanxi = laodongguanxi;
	}

	public String getWorkno() {
		return workno;
	}

	public void setWorkno(String workno) {
		this.workno = workno;
	}

	public String getGangweiName() {
		return gangweiName;
	}

	public void setGangweiName(String gangweiName) {
		this.gangweiName = gangweiName;
	}

	public Date getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Integer getOurAge() {
		return ourAge;
	}

	public void setOurAge(Integer ourAge) {
		this.ourAge = ourAge;
	}

	public Date getFirstDate() {
		return firstDate;
	}

	public void setFirstDate(Date firstDate) {
		this.firstDate = firstDate;
	}

	public Integer getWorkingYears() {
		return workingYears;
	}

	public void setWorkingYears(Integer workingYears) {
		this.workingYears = workingYears;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getJiguan() {
		return jiguan;
	}

	public void setJiguan(String jiguan) {
		this.jiguan = jiguan;
	}

	public String getMinzuName() {
		return minzuName;
	}

	public void setMinzuName(String minzuName) {
		this.minzuName = minzuName;
	}

	public String getMarryState() {
		return marryState;
	}

	public void setMarryState(String marryState) {
		this.marryState = marryState;
	}

	public String getPoliticsStatus() {
		return politicsStatus;
	}

	public void setPoliticsStatus(String politicsStatus) {
		this.politicsStatus = politicsStatus;
	}

	public String getIdCardNo() {
		return idCardNo;
	}

	public void setIdCardNo(String idCardNo) {
		this.idCardNo = idCardNo;
	}

	public String getHujidizhi() {
		return hujidizhi;
	}

	public void setHujidizhi(String hujidizhi) {
		this.hujidizhi = hujidizhi;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getFireName() {
		return fireName;
	}

	public void setFireName(String fireName) {
		this.fireName = fireName;
	}

	public String getFirePhone() {
		return firePhone;
	}

	public void setFirePhone(String firePhone) {
		this.firePhone = firePhone;
	}

	public String getGuanxi() {
		return guanxi;
	}

	public void setGuanxi(String guanxi) {
		this.guanxi = guanxi;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<UserEducational> getEducationals() {
		return educationals;
	}

	public void setEducationals(List<UserEducational> educationals) {
		this.educationals = educationals;
	}

	public List<UserCertificate> getCertificates() {
		return certificates;
	}

	public void setCertificates(List<UserCertificate> certificates) {
		this.certificates = certificates;
	}

	public List<WorkContract> getWorkContracts() {
		return workContracts;
	}

	public void setWorkContracts(List<WorkContract> workContracts) {
		this.workContracts = workContracts;
	}

	public List<UserResume> getResumes() {
		return resumes;
	}

	public void setResumes(List<UserResume> resumes) {
		this.resumes = resumes;
	}

	public List<TongchouInfo> getTongchouInfos() {
		return tongchouInfos;
	}

	public void setTongchouInfos(List<TongchouInfo> tongchouInfos) {
		this.tongchouInfos = tongchouInfos;
	}

	public String getXingqu() {
		return xingqu;
	}

	public void setXingqu(String xingqu) {
		this.xingqu = xingqu;
	}
	
	
}
