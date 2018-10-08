package org.springrain.erp.tc.entity;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springrain.frame.annotation.WhereSQL;
import org.springrain.frame.entity.BaseEntity;
/**
 * TODO 在此加入类描述
 * @copyright {@link weicms.net}
 * @author springrain<Auto generate>
 * @version  2017-08-11 13:59:35
 * @see org.springrain.erp.gz.entity.TongchouKkze
 */
@Table(name="z_tongchou_kkze")
public class TongchouKkze  extends BaseEntity {
	
	private static final long serialVersionUID = 1L;

	//alias
	/*
	public static final String TABLE_ALIAS = "TongchouKkze";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_COMPANY = "公司编号";
	public static final String ALIAS_USERID = "userId";
	public static final String ALIAS_USERNAME = "userName";
	public static final String ALIAS_TCJIAONADI = "统筹缴纳地";
	public static final String ALIAS_DEPARTMENT = "部门";
	public static final String ALIAS_INSURANCECOMPANY = "公司部分";
	public static final String ALIAS_INSURANCEPERSONAL = "个人部分";
	public static final String ALIAS_COMPANYCE = "companyCe";
	public static final String ALIAS_CREATEUSER = "createUser";
	public static final String ALIAS_CREATETIME = "createTime";
	public static final String ALIAS_INSURANCETYPE = "insuranceType";
	public static final String ALIAS_MONTH = "month";
	public static final String ALIAS_BAK1 = "bak1";
	public static final String ALIAS_BAK2 = "bak2";
	public static final String ALIAS_BAK3 = "bak3";
	public static final String ALIAS_BAK4 = "bak4";
    */
	//date formats
	//public static final String FORMAT_CREATETIME = DateUtils.DATETIME_FORMAT;
	//public static final String FORMAT_MONTH = DateUtils.DATETIME_FORMAT;
	
	//columns START
	/**
	 * id
	 */
	private java.lang.String id;
	/**
	 * 公司编号
	 */
	private java.lang.String company;
	/**
	 * userId
	 */
	private java.lang.String userId;
	/**
	 * userName
	 */
	private java.lang.String userName;
	/**
	 * 统筹缴纳地
	 */
	private java.lang.String tcjiaonadi;
	/**
	 * 部门
	 */
	private java.lang.String department;
	/**
	 * 公司部分
	 */
	private java.math.BigDecimal insuranceCompany;
	/**
	 * 个人部分
	 */
	private java.math.BigDecimal insurancePersonal;
	/**
	 * createUser
	 */
	private java.lang.String createUser;
	/**
	 * createTime
	 */
	private java.util.Date createTime;
	/**
	 * insuranceType
	 */
	private java.lang.String insuranceType;
	/**
	 * month
	 */
	private java.util.Date month;
	/**
	 * 0 统筹记录1 增减项
	 */
	private String sourceType;
	/**
	 * bak1
	 */
	private java.lang.String bak1;
	/**
	 * bak2
	 */
	private java.lang.String bak2;
	/**
	 * bak3
	 */
	private java.lang.String bak3;
	/**
	 * bak4
	 */
	private java.lang.String bak4;
	//columns END 数据库字段结束
	private String companyName;
	private String insuranceName;
	//concstructor

	public TongchouKkze(){
	}

	public TongchouKkze(
		java.lang.String id
	){
		this.id = id;
	}

	//get and set
		/**
		 * id
		 */
	public void setId(java.lang.String value) {
		    if(StringUtils.isNotBlank(value)){
			 value=value.trim();
			}
		this.id = value;
	}
	
	
	
	/**
	 * id
	 */
	@Id
     @WhereSQL(sql="id=:TongchouKkze_id")
	public java.lang.String getId() {
		return this.id;
	}
		/**
		 * 公司编号
		 */
	public void setCompany(java.lang.String value) {
		    if(StringUtils.isNotBlank(value)){
			 value=value.trim();
			}
		this.company = value;
	}
	
	
	
	/**
	 * 公司编号
	 */
     @WhereSQL(sql="company=:TongchouKkze_company")
	public java.lang.String getCompany() {
		return this.company;
	}
		/**
		 * userId
		 */
	public void setUserId(java.lang.String value) {
		    if(StringUtils.isNotBlank(value)){
			 value=value.trim();
			}
		this.userId = value;
	}
	
	
	
	/**
	 * userId
	 */
     @WhereSQL(sql="userId=:TongchouKkze_userId")
	public java.lang.String getUserId() {
		return this.userId;
	}
		/**
		 * userName
		 */
	public void setUserName(java.lang.String value) {
		    if(StringUtils.isNotBlank(value)){
			 value=value.trim();
			}
		this.userName = value;
	}
	
	
	
	/**
	 * userName
	 */
     @WhereSQL(sql="userName=:TongchouKkze_userName")
	public java.lang.String getUserName() {
		return this.userName;
	}
		/**
		 * 统筹缴纳地
		 */
	public void setTcjiaonadi(java.lang.String value) {
		    if(StringUtils.isNotBlank(value)){
			 value=value.trim();
			}
		this.tcjiaonadi = value;
	}
	
	
	
	/**
	 * 统筹缴纳地
	 */
     @WhereSQL(sql="tcjiaonadi=:TongchouKkze_tcjiaonadi")
	public java.lang.String getTcjiaonadi() {
		return this.tcjiaonadi;
	}
		/**
		 * 部门
		 */
	public void setDepartment(java.lang.String value) {
		    if(StringUtils.isNotBlank(value)){
			 value=value.trim();
			}
		this.department = value;
	}
	
	
	
	/**
	 * 部门
	 */
     @WhereSQL(sql="department=:TongchouKkze_department")
	public java.lang.String getDepartment() {
		return this.department;
	}
		/**
		 * 公司部分
		 */
	public void setInsuranceCompany(java.math.BigDecimal value) {
		this.insuranceCompany = value;
	}
	
	
	
	/**
	 * 公司部分
	 */
     @WhereSQL(sql="insuranceCompany=:TongchouKkze_insuranceCompany")
	public java.math.BigDecimal getInsuranceCompany() {
		return this.insuranceCompany;
	}
		/**
		 * 个人部分
		 */
	public void setInsurancePersonal(java.math.BigDecimal value) {
		this.insurancePersonal = value;
	}
	
	
	
	/**
	 * 个人部分
	 */
     @WhereSQL(sql="insurancePersonal=:TongchouKkze_insurancePersonal")
	public java.math.BigDecimal getInsurancePersonal() {
		return this.insurancePersonal;
	}
		/**
		 * createUser
		 */
	public void setCreateUser(java.lang.String value) {
		    if(StringUtils.isNotBlank(value)){
			 value=value.trim();
			}
		this.createUser = value;
	}
	
	
	
	/**
	 * createUser
	 */
     @WhereSQL(sql="createUser=:TongchouKkze_createUser")
	public java.lang.String getCreateUser() {
		return this.createUser;
	}
		/*
	public String getcreateTimeString() {
		return DateUtils.convertDate2String(FORMAT_CREATETIME, getcreateTime());
	}
	public void setcreateTimeString(String value) throws ParseException{
		setcreateTime(DateUtils.convertString2Date(FORMAT_CREATETIME,value));
	}*/
	
		/**
		 * createTime
		 */
	public void setCreateTime(java.util.Date value) {
		this.createTime = value;
	}
	
	
	
	/**
	 * createTime
	 */
     @WhereSQL(sql="createTime=:TongchouKkze_createTime")
	public java.util.Date getCreateTime() {
		return this.createTime;
	}
		/**
		 * insuranceType
		 */
	public void setInsuranceType(java.lang.String value) {
		    if(StringUtils.isNotBlank(value)){
			 value=value.trim();
			}
		this.insuranceType = value;
	}
	
	
	
	/**
	 * insuranceType
	 */
     @WhereSQL(sql="insuranceType=:TongchouKkze_insuranceType")
	public java.lang.String getInsuranceType() {
		return this.insuranceType;
	}
		/*
	public String getmonthString() {
		return DateUtils.convertDate2String(FORMAT_MONTH, getmonth());
	}
	public void setmonthString(String value) throws ParseException{
		setmonth(DateUtils.convertString2Date(FORMAT_MONTH,value));
	}*/
	
		/**
		 * month
		 */
	public void setMonth(java.util.Date value) {
		this.month = value;
	}
	
	
	
	/**
	 * month
	 */
     @WhereSQL(sql="month=:TongchouKkze_month")
	public java.util.Date getMonth() {
		return this.month;
	}
		/**
		 * bak1
		 */
	public void setBak1(java.lang.String value) {
		    if(StringUtils.isNotBlank(value)){
			 value=value.trim();
			}
		this.bak1 = value;
	}
	
	
	
	/**
	 * bak1
	 */
     @WhereSQL(sql="bak1=:TongchouKkze_bak1")
	public java.lang.String getBak1() {
		return this.bak1;
	}
		/**
		 * bak2
		 */
	public void setBak2(java.lang.String value) {
		    if(StringUtils.isNotBlank(value)){
			 value=value.trim();
			}
		this.bak2 = value;
	}
	
	
	
	/**
	 * bak2
	 */
     @WhereSQL(sql="bak2=:TongchouKkze_bak2")
	public java.lang.String getBak2() {
		return this.bak2;
	}
		/**
		 * bak3
		 */
	public void setBak3(java.lang.String value) {
		    if(StringUtils.isNotBlank(value)){
			 value=value.trim();
			}
		this.bak3 = value;
	}
	
	
	
	/**
	 * bak3
	 */
     @WhereSQL(sql="bak3=:TongchouKkze_bak3")
	public java.lang.String getBak3() {
		return this.bak3;
	}
		/**
		 * bak4
		 */
	public void setBak4(java.lang.String value) {
		    if(StringUtils.isNotBlank(value)){
			 value=value.trim();
			}
		this.bak4 = value;
	}
	
	
	
	/**
	 * bak4
	 */
     @WhereSQL(sql="bak4=:TongchouKkze_bak4")
	public java.lang.String getBak4() {
		return this.bak4;
	}
     
	public String getSourceType() {
		return sourceType;
	}

	public void setSourceType(String sourceType) {
		this.sourceType = sourceType;
	}
	@Transient
	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	@Transient
	public String getInsuranceName() {
		return insuranceName;
	}

	public void setInsuranceName(String insuranceName) {
		this.insuranceName = insuranceName;
	}

	@Override
	public String toString() {
		return new StringBuilder()
			.append("id[").append(getId()).append("],")
			.append("公司编号[").append(getCompany()).append("],")
			.append("userId[").append(getUserId()).append("],")
			.append("userName[").append(getUserName()).append("],")
			.append("统筹缴纳地[").append(getTcjiaonadi()).append("],")
			.append("部门[").append(getDepartment()).append("],")
			.append("公司部分[").append(getInsuranceCompany()).append("],")
			.append("个人部分[").append(getInsurancePersonal()).append("],")
			.append("createUser[").append(getCreateUser()).append("],")
			.append("createTime[").append(getCreateTime()).append("],")
			.append("insuranceType[").append(getInsuranceType()).append("],")
			.append("month[").append(getMonth()).append("],")
			.append("bak1[").append(getBak1()).append("],")
			.append("bak2[").append(getBak2()).append("],")
			.append("bak3[").append(getBak3()).append("],")
			.append("bak4[").append(getBak4()).append("],")
			.toString();
	}
	@Override
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.toHashCode();
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof TongchouKkze == false){
			return false;
		}
			
		if(this == obj){
			return true;
		}
		
		TongchouKkze other = (TongchouKkze)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

	
