package org.springrain.erp.tc.entity;

import java.util.List;

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
 * @version  2017-08-10 08:55:55
 * @see org.springrain.erp.gz.entity.GzdkdjRecord
 */
@Table(name="z_gzdkdj_record")
public class GzdkdjRecord  extends BaseEntity {
	
	private static final long serialVersionUID = 1L;

	//alias
	/*
	public static final String TABLE_ALIAS = "工资代扣代缴表";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_USERID = "userId";
	public static final String ALIAS_COMPANY = "公司编号";
	public static final String ALIAS_TCJND = "统筹缴纳地";
	public static final String ALIAS_DEPARTMENT = "部门";
	public static final String ALIAS_STOPPROTECTMONTH = "停保月份";
	public static final String ALIAS_INSURANCEORGONGJIJINACCOUNT = "保险公积金账号";
	public static final String ALIAS_INSURGONGJIJINTYPE = "类型 1 保险账号 0 公积金账号";
	public static final String ALIAS_INSURANCEPAYMENTDATE = "缴费开始时间";
	public static final String ALIAS_EFFICIENTDATE = "缴费结束时间";
	public static final String ALIAS_RADICES = "基数";
	public static final String ALIAS_INSURANCECOMPANY = "公司缴纳部分";
	public static final String ALIAS_INSURANCEPERSONAL = "个人缴纳部分";
	public static final String ALIAS_INSURANCETYPE = "统筹类型 ";
	public static final String ALIAS_REMARK = "remark";
	public static final String ALIAS_CREATOR = "创建人";
	public static final String ALIAS_CREATETIME = "创建时间";
	public static final String ALIAS_USERNAME = "用户名";
	public static final String ALIAS_MONTH = "所属月份";
    */
	//date formats
	//public static final String FORMAT_STOPPROTECTMONTH = DateUtils.DATETIME_FORMAT;
	//public static final String FORMAT_INSURANCEPAYMENTDATE = DateUtils.DATETIME_FORMAT;
	//public static final String FORMAT_EFFICIENTDATE = DateUtils.DATETIME_FORMAT;
	//public static final String FORMAT_CREATETIME = DateUtils.DATETIME_FORMAT;
	//public static final String FORMAT_MONTH = DateUtils.DATETIME_FORMAT;
	
	//columns START
	/**
	 * id
	 */
	private java.lang.String id;
	/**
	 * userId
	 */
	private java.lang.String userId;
	/**
	 * 公司编号
	 */
	private java.lang.String company;
	/**
	 * 统筹缴纳地
	 */
	private java.lang.String tcjnd;
	/**
	 * 部门
	 */
	private java.lang.String department;
	/**
	 * 停保月份
	 */
	private java.util.Date stopProtectMonth;
	/**
	 * 保险公积金账号
	 */
	private java.lang.String insuranceorgongjijinAccount;
	/**
	 * 类型 1 保险账号 0 公积金账号
	 */
	private java.lang.String insurgongjijinType;
	/**
	 * 基数
	 */
	private java.math.BigDecimal radices;
	/**
	 * 公司缴纳部分
	 */
	private java.math.BigDecimal insuranceCompany;
	/**
	 * 个人缴纳部分
	 */
	private java.math.BigDecimal insurancePersonal;
	/**
	 * 统筹类型 
	 */
	private java.lang.String insuranceType;
	/**
	 * remark
	 */
	private java.lang.String remark;
	/**
	 * 创建人
	 */
	private java.lang.String creator;
	/**
	 * 创建时间
	 */
	private java.util.Date createTime;
	/**
	 * 用户名
	 */
	private java.lang.String userName;
	/**
	 * 所属月份
	 */
	private java.util.Date month;
	//columns END 数据库字段结束
	private  List<TongchouShow> listShow;
	//concstructor

	public GzdkdjRecord(){
	}

	public GzdkdjRecord(
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
     @WhereSQL(sql="id=:GzdkdjRecord_id")
	public java.lang.String getId() {
		return this.id;
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
     @WhereSQL(sql="userId=:GzdkdjRecord_userId")
	public java.lang.String getUserId() {
		return this.userId;
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
     @WhereSQL(sql="company=:GzdkdjRecord_company")
	public java.lang.String getCompany() {
		return this.company;
	}
		/**
		 * 统筹缴纳地
		 */
	public void setTcjnd(java.lang.String value) {
		    if(StringUtils.isNotBlank(value)){
			 value=value.trim();
			}
		this.tcjnd = value;
	}
	
	
	
	/**
	 * 统筹缴纳地
	 */
     @WhereSQL(sql="tcjnd=:GzdkdjRecord_tcjnd")
	public java.lang.String getTcjnd() {
		return this.tcjnd;
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
     @WhereSQL(sql="department=:GzdkdjRecord_department")
	public java.lang.String getDepartment() {
		return this.department;
	}
		/*
	public String getstopProtectMonthString() {
		return DateUtils.convertDate2String(FORMAT_STOPPROTECTMONTH, getstopProtectMonth());
	}
	public void setstopProtectMonthString(String value) throws ParseException{
		setstopProtectMonth(DateUtils.convertString2Date(FORMAT_STOPPROTECTMONTH,value));
	}*/
	
		/**
		 * 停保月份
		 */
	public void setStopProtectMonth(java.util.Date value) {
		this.stopProtectMonth = value;
	}
	
	
	
	/**
	 * 停保月份
	 */
     @WhereSQL(sql="stopProtectMonth=:GzdkdjRecord_stopProtectMonth")
	public java.util.Date getStopProtectMonth() {
		return this.stopProtectMonth;
	}
		/**
		 * 保险公积金账号
		 */
	public void setInsuranceorgongjijinAccount(java.lang.String value) {
		    if(StringUtils.isNotBlank(value)){
			 value=value.trim();
			}
		this.insuranceorgongjijinAccount = value;
	}
	
	
	
	/**
	 * 保险公积金账号
	 */
     @WhereSQL(sql="insuranceorgongjijinAccount=:GzdkdjRecord_insuranceorgongjijinAccount")
	public java.lang.String getInsuranceorgongjijinAccount() {
		return this.insuranceorgongjijinAccount;
	}
		/**
		 * 类型 1 保险账号 0 公积金账号
		 */
	public void setInsurgongjijinType(java.lang.String value) {
		    if(StringUtils.isNotBlank(value)){
			 value=value.trim();
			}
		this.insurgongjijinType = value;
	}
	
	
	
	/**
	 * 类型 1 保险账号 0 公积金账号
	 */
     @WhereSQL(sql="insurgongjijinType=:GzdkdjRecord_insurgongjijinType")
	public java.lang.String getInsurgongjijinType() {
		return this.insurgongjijinType;
	}
		/*
	public String getinsurancePaymentDateString() {
		return DateUtils.convertDate2String(FORMAT_INSURANCEPAYMENTDATE, getinsurancePaymentDate());
	}
	public void setinsurancePaymentDateString(String value) throws ParseException{
		setinsurancePaymentDate(DateUtils.convertString2Date(FORMAT_INSURANCEPAYMENTDATE,value));
	}*/
	
		/*
	public String getefficientDateString() {
		return DateUtils.convertDate2String(FORMAT_EFFICIENTDATE, getefficientDate());
	}
	public void setefficientDateString(String value) throws ParseException{
		setefficientDate(DateUtils.convertString2Date(FORMAT_EFFICIENTDATE,value));
	}*/
	
		/**
		 * 基数
		 */
	public void setRadices(java.math.BigDecimal value) {
		this.radices = value;
	}
	
	
	
	/**
	 * 基数
	 */
     @WhereSQL(sql="radices=:GzdkdjRecord_radices")
	public java.math.BigDecimal getRadices() {
		return this.radices;
	}
		/**
		 * 公司缴纳部分
		 */
	public void setInsuranceCompany(java.math.BigDecimal value) {
		this.insuranceCompany = value;
	}
	
	
	
	/**
	 * 公司缴纳部分
	 */
     @WhereSQL(sql="insuranceCompany=:GzdkdjRecord_insuranceCompany")
	public java.math.BigDecimal getInsuranceCompany() {
		return this.insuranceCompany;
	}
		/**
		 * 个人缴纳部分
		 */
	public void setInsurancePersonal(java.math.BigDecimal value) {
		this.insurancePersonal = value;
	}
	
	
	
	/**
	 * 个人缴纳部分
	 */
     @WhereSQL(sql="insurancePersonal=:GzdkdjRecord_insurancePersonal")
	public java.math.BigDecimal getInsurancePersonal() {
		return this.insurancePersonal;
	}
		/**
		 * 统筹类型 
		 */
	public void setInsuranceType(java.lang.String value) {
		    if(StringUtils.isNotBlank(value)){
			 value=value.trim();
			}
		this.insuranceType = value;
	}
	
	
	
	/**
	 * 统筹类型 
	 */
     @WhereSQL(sql="insuranceType=:GzdkdjRecord_insuranceType")
	public java.lang.String getInsuranceType() {
		return this.insuranceType;
	}
		/**
		 * remark
		 */
	public void setRemark(java.lang.String value) {
		    if(StringUtils.isNotBlank(value)){
			 value=value.trim();
			}
		this.remark = value;
	}
	
	
	
	/**
	 * remark
	 */
     @WhereSQL(sql="remark=:GzdkdjRecord_remark")
	public java.lang.String getRemark() {
		return this.remark;
	}
		/**
		 * 创建人
		 */
	public void setCreator(java.lang.String value) {
		    if(StringUtils.isNotBlank(value)){
			 value=value.trim();
			}
		this.creator = value;
	}
	
	
	
	/**
	 * 创建人
	 */
     @WhereSQL(sql="creator=:GzdkdjRecord_creator")
	public java.lang.String getCreator() {
		return this.creator;
	}
		/*
	public String getcreateTimeString() {
		return DateUtils.convertDate2String(FORMAT_CREATETIME, getcreateTime());
	}
	public void setcreateTimeString(String value) throws ParseException{
		setcreateTime(DateUtils.convertString2Date(FORMAT_CREATETIME,value));
	}*/
	
		/**
		 * 创建时间
		 */
	public void setCreateTime(java.util.Date value) {
		this.createTime = value;
	}
	
	
	
	/**
	 * 创建时间
	 */
     @WhereSQL(sql="createTime=:GzdkdjRecord_createTime")
	public java.util.Date getCreateTime() {
		return this.createTime;
	}
		/**
		 * 用户名
		 */
	public void setUserName(java.lang.String value) {
		    if(StringUtils.isNotBlank(value)){
			 value=value.trim();
			}
		this.userName = value;
	}
	
	
	
	/**
	 * 用户名
	 */
     @WhereSQL(sql="userName=:GzdkdjRecord_userName")
	public java.lang.String getUserName() {
		return this.userName;
	}
		/*
	public String getmonthString() {
		return DateUtils.convertDate2String(FORMAT_MONTH, getmonth());
	}
	public void setmonthString(String value) throws ParseException{
		setmonth(DateUtils.convertString2Date(FORMAT_MONTH,value));
	}*/
	
		/**
		 * 所属月份
		 */
	public void setMonth(java.util.Date value) {
		this.month = value;
	}
	
	
	
	/**
	 * 所属月份
	 */
     @WhereSQL(sql="month=:GzdkdjRecord_month")
	public java.util.Date getMonth() {
		return this.month;
	}
     @Transient
	public List<TongchouShow> getListShow() {
		return listShow;
	}

	public void setListShow(List<TongchouShow> listShow) {
		this.listShow = listShow;
	}

	@Override
	public String toString() {
		return new StringBuilder()
			.append("id[").append(getId()).append("],")
			.append("userId[").append(getUserId()).append("],")
			.append("公司编号[").append(getCompany()).append("],")
			.append("统筹缴纳地[").append(getTcjnd()).append("],")
			.append("部门[").append(getDepartment()).append("],")
			.append("停保月份[").append(getStopProtectMonth()).append("],")
			.append("保险公积金账号[").append(getInsuranceorgongjijinAccount()).append("],")
			.append("类型 1 保险账号 0 公积金账号[").append(getInsurgongjijinType()).append("],")
			.append("基数[").append(getRadices()).append("],")
			.append("公司缴纳部分[").append(getInsuranceCompany()).append("],")
			.append("个人缴纳部分[").append(getInsurancePersonal()).append("],")
			.append("统筹类型 [").append(getInsuranceType()).append("],")
			.append("remark[").append(getRemark()).append("],")
			.append("创建人[").append(getCreator()).append("],")
			.append("创建时间[").append(getCreateTime()).append("],")
			.append("用户名[").append(getUserName()).append("],")
			.append("所属月份[").append(getMonth()).append("],")
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
		if(obj instanceof GzdkdjRecord == false){
			return false;
		}
			
		if(this == obj){
			return true;
		}
		
		GzdkdjRecord other = (GzdkdjRecord)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

	
