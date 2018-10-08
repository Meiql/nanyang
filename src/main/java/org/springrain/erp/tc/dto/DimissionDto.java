package org.springrain.erp.tc.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.util.CollectionUtils;
import org.springrain.erp.gz.entity.Salaryinfo;
import org.springrain.erp.tc.entity.TongchouRecord;
import org.springrain.erp.tc.entity.TongchouShow;
import org.springrain.erp.tc.entity.TongchouZengjian;

public class DimissionDto {
	private String username;//用户名
	private String userId;//用户编号
	private String jobNumber;//用户工号
	private String cardId;//身份证号
	private String allUnitName;//所有部门
	private String inCompany;//公司名称
	private Date stopProtectMonth;//停保月份
	private List<TongchouRecord> tcrecordList;//保险信息
	private List<TongchouZengjian> zjList;//统筹增减项
	private List<TongchouShow> showList = new ArrayList<TongchouShow>();//页面用于显示一行里所有统筹显示信息
	private List<Salaryinfo> salarInfoyList;
	private String salaryId;
	private String dutyTypeName;//岗位类型名称
	private BigDecimal jibenpay;
	private BigDecimal kaohepay;
	private BigDecimal gangweipay;
	private String payDay;//日工资
	private Date month ;//月份
	
	public String getAllUnitName() {
		return allUnitName;
	}
	public void setAllUnitName(String allUnitName) {
		this.allUnitName = allUnitName;
	}
	public List<TongchouShow> getShowList() {
		if(CollectionUtils.isEmpty(showList))
			return null;
		return showList;
	}
	public void setShowList(List<TongchouShow> showList) {
		this.showList = showList;
	}
	
	public String getDutyTypeName() {
		return dutyTypeName;
	}
	public void setDutyTypeName(String dutyTypeName) {
		this.dutyTypeName = dutyTypeName;
	}
	
	public String getSalaryId() {
		return salaryId;
	}
	public void setSalaryId(String salaryId) {
		this.salaryId = salaryId;
	}
	public Date getMonth() {
		return month;
	}
	public void setMonth(Date month) {
		this.month = month;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public List<Salaryinfo> getSalarInfoyList() {
		return salarInfoyList;
	}
	public void setSalarInfoyList(List<Salaryinfo> salarInfoyList) {
		this.salarInfoyList = salarInfoyList;
	}
	public String getUserId() {
		return userId;
	}
	
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public BigDecimal getJibenpay() {
		return jibenpay;
	}
	public void setJibenpay(BigDecimal jibenpay) {
		this.jibenpay = jibenpay;
	}
	public BigDecimal getKaohepay() {
		return kaohepay;
	}
	public void setKaohepay(BigDecimal kaohepay) {
		this.kaohepay = kaohepay;
	}
	public BigDecimal getGangweipay() {
		return gangweipay;
	}
	public void setGangweipay(BigDecimal gangweipay) {
		this.gangweipay = gangweipay;
	}
	public String getJobNumber() {
		return jobNumber;
	}
	public void setJobNumber(String jobNumber) {
		this.jobNumber = jobNumber;
	}
	public String getCardId() {
		return cardId;
	}
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}
	public String getInCompany() {
		return inCompany;
	}
	public void setInCompany(String inCompany) {
		this.inCompany = inCompany;
	}
	public Date getStopProtectMonth() {
		return stopProtectMonth;
	}
	public void setStopProtectMonth(Date stopProtectMonth) {
		this.stopProtectMonth = stopProtectMonth;
	}
	public List<TongchouZengjian> getZjList() {
		return zjList;
	}
	public void setZjList(List<TongchouZengjian> zjList) {
		this.zjList = zjList;
	}
	public List<TongchouRecord> getTcrecordList() {
		return tcrecordList;
	}
	public void setTcrecordList(List<TongchouRecord> tcrecordList) {
		this.tcrecordList = tcrecordList;
	}
	public String getPayDay() {
		return payDay;
	}
	public void setPayDay(String payDay) {
		this.payDay = payDay;
	}
	
}
