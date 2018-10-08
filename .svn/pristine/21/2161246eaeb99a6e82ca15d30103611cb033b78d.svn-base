package org.springrain.erp.gz.entity;

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
 * @version  2017-07-21 09:20:19
 * @see org.springrain.erp.gz.entity.StopPay
 */
@Table(name="z_stop_pay")
public class StopPay  extends BaseEntity {
	
	private static final long serialVersionUID = 1L;

	//alias
	/*
	public static final String TABLE_ALIAS = "停发工资管理表";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_USERID = "员工ID";
	public static final String ALIAS_STATE = "状态（1：停止，0，撤销）";
	public static final String ALIAS_CREATEPERSON = "创建人";
	public static final String ALIAS_CREATEDATE = "创建时间";
	public static final String ALIAS_CANCELPERSON = "撤销人";
	public static final String ALIAS_CANCELDATE = "撤销时间";
	public static final String ALIAS_REMARK = "备注";
    */
	//date formats
	//public static final String FORMAT_CREATEDATE = DateUtils.DATETIME_FORMAT;
	//public static final String FORMAT_CANCELDATE = DateUtils.DATETIME_FORMAT;
	
	//columns START
	/**
	 * id
	 */
	private java.lang.String id;
	/**
	 * 员工ID
	 */
	private java.lang.String userId;
	/**
	 * 状态（1：停止，0，撤销）
	 */
	private java.lang.Integer state;
	/**
	 * 创建人
	 */
	private java.lang.String createPerson;
	/**
	 * 创建时间
	 */
	private java.util.Date createDate;
	/**
	 * 撤销人
	 */
	private java.lang.String cancelPerson;
	/**
	 * 撤销时间
	 */
	private java.util.Date cancelDate;
	/**
	 * 备注
	 */
	private java.lang.String remark;
	//columns END 数据库字段结束
	private String userName;
	private String orgName;
	private String orgId;
	private String sdate;
	private String edate;
	private String stateStr;
	private String createPersonName;
	private String cancelPersonName;
	//concstructor

	public StopPay(){
	}

	public StopPay(
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
     @WhereSQL(sql="id=:StopPay_id")
	public java.lang.String getId() {
		return this.id;
	}
		/**
		 * 员工ID
		 */
	public void setUserId(java.lang.String value) {
		    if(StringUtils.isNotBlank(value)){
			 value=value.trim();
			}
		this.userId = value;
	}
	
	
	
	/**
	 * 员工ID
	 */
     @WhereSQL(sql="userId=:StopPay_userId")
	public java.lang.String getUserId() {
		return this.userId;
	}
		/**
		 * 状态（1：停止，0，撤销）
		 */
	public void setState(java.lang.Integer value) {
		this.state = value;
	}
	
	
	
	/**
	 * 状态（1：停止，0，撤销）
	 */
     @WhereSQL(sql="state=:StopPay_state")
	public java.lang.Integer getState() {
		return this.state;
	}
		/**
		 * 创建人
		 */
	public void setCreatePerson(java.lang.String value) {
		    if(StringUtils.isNotBlank(value)){
			 value=value.trim();
			}
		this.createPerson = value;
	}
	
	
	
	/**
	 * 创建人
	 */
     @WhereSQL(sql="createPerson=:StopPay_createPerson")
	public java.lang.String getCreatePerson() {
		return this.createPerson;
	}
		/*
	public String getcreateDateString() {
		return DateUtils.convertDate2String(FORMAT_CREATEDATE, getcreateDate());
	}
	public void setcreateDateString(String value) throws ParseException{
		setcreateDate(DateUtils.convertString2Date(FORMAT_CREATEDATE,value));
	}*/
	
		/**
		 * 创建时间
		 */
	public void setCreateDate(java.util.Date value) {
		this.createDate = value;
	}
	
	
	
	/**
	 * 创建时间
	 */
     @WhereSQL(sql="createDate=:StopPay_createDate")
	public java.util.Date getCreateDate() {
		return this.createDate;
	}
		/**
		 * 撤销人
		 */
	public void setCancelPerson(java.lang.String value) {
		    if(StringUtils.isNotBlank(value)){
			 value=value.trim();
			}
		this.cancelPerson = value;
	}
	
	
	
	/**
	 * 撤销人
	 */
     @WhereSQL(sql="cancelPerson=:StopPay_cancelPerson")
	public java.lang.String getCancelPerson() {
		return this.cancelPerson;
	}
		/*
	public String getcancelDateString() {
		return DateUtils.convertDate2String(FORMAT_CANCELDATE, getcancelDate());
	}
	public void setcancelDateString(String value) throws ParseException{
		setcancelDate(DateUtils.convertString2Date(FORMAT_CANCELDATE,value));
	}*/
	
		/**
		 * 撤销时间
		 */
	public void setCancelDate(java.util.Date value) {
		this.cancelDate = value;
	}
	
	
	
	/**
	 * 撤销时间
	 */
     @WhereSQL(sql="cancelDate=:StopPay_cancelDate")
	public java.util.Date getCancelDate() {
		return this.cancelDate;
	}
		/**
		 * 备注
		 */
	public void setRemark(java.lang.String value) {
		    if(StringUtils.isNotBlank(value)){
			 value=value.trim();
			}
		this.remark = value;
	}
	
	
	
	/**
	 * 备注
	 */
     @WhereSQL(sql="remark=:StopPay_remark")
	public java.lang.String getRemark() {
		return this.remark;
	}
	@Override
	public String toString() {
		return new StringBuilder()
			.append("id[").append(getId()).append("],")
			.append("员工ID[").append(getUserId()).append("],")
			.append("状态（1：停止，0，撤销）[").append(getState()).append("],")
			.append("创建人[").append(getCreatePerson()).append("],")
			.append("创建时间[").append(getCreateDate()).append("],")
			.append("撤销人[").append(getCancelPerson()).append("],")
			.append("撤销时间[").append(getCancelDate()).append("],")
			.append("备注[").append(getRemark()).append("],")
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
		if(obj instanceof StopPay == false){
			return false;
		}
			
		if(this == obj){
			return true;
		}
		
		StopPay other = (StopPay)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
	@Transient
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Transient
	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	@Transient
	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}
	@Transient
	public String getSdate() {
		return sdate;
	}

	public void setSdate(String sdate) {
		this.sdate = sdate;
	}
	@Transient
	public String getEdate() {
		return edate;
	}

	public void setEdate(String edate) {
		this.edate = edate;
	}
	@Transient
	public String getStateStr() {
		return stateStr;
	}

	public void setStateStr(String stateStr) {
		this.stateStr = stateStr;
	}
	@Transient
	public String getCreatePersonName() {
		return createPersonName;
	}

	public void setCreatePersonName(String createPersonName) {
		this.createPersonName = createPersonName;
	}
	@Transient
	public String getCancelPersonName() {
		return cancelPersonName;
	}

	public void setCancelPersonName(String cancelPersonName) {
		this.cancelPersonName = cancelPersonName;
	}
	
}

	
