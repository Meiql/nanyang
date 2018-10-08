package org.springrain.erp.hr.entity;

import java.util.Date;

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
 * @version  2017-07-03 17:48:09
 * @see org.springrain.erp.hr.entity.WorkContract
 */
@Table(name="z_work_contract")
public class WorkContract  extends BaseEntity {
	
	private static final long serialVersionUID = 1L;

	//alias
	/*
	public static final String TABLE_ALIAS = "WorkContract";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_USERID = "userId";
	public static final String ALIAS_COMPANY = "归属公司";
	public static final String ALIAS_ORGID = "部门";
	public static final String ALIAS_STARTDATE = "签订开始日期";
	public static final String ALIAS_ENDDATE = "签订结束日期";
	public static final String ALIAS_CONTRACTTYPE = "合同类型";
	public static final String ALIAS_WORKTYPE = "用工方式";
	public static final String ALIAS_BAK = "备注";
	public static final String ALIAS_STATE = "是否有效";
    */
	//date formats
	//public static final String FORMAT_STARTDATE = DateUtils.DATETIME_FORMAT;
	//public static final String FORMAT_ENDDATE = DateUtils.DATETIME_FORMAT;
	
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
	 * 归属公司
	 */
	private java.lang.String company;
	/**
	 * 部门
	 */
	private java.lang.String orgId;
	/**
	 * 签订开始日期
	 */
	private java.util.Date startDate;
	/**
	 * 签订结束日期
	 */
	private java.util.Date endDate;
	/**
	 * 合同类型
	 */
	private java.lang.String contractType;
	/**
	 * 用工方式
	 */
	private java.lang.String workType;
	/**
	 * 备注
	 */
	private java.lang.String bak;
	/**
	 * 是否有效
	 */
	private java.lang.String state;
	
	
	private String editPerson;
	private Date editDate;
	/**
	 * 录入期限
	 */
	private Integer term;
	/**
	 * 签订次数
	 */
	private Integer times;
	/**
	 * 合同编号
	 */
	private String contractNo;
	//columns END 数据库字段结束
	private String userName;
	private String contractTypeName;
	private String workTypeName;
	private int viewModify;//合同是否失效
	private String companyName;
	private String orgName;
	private String userAccount;
	//concstructor

	public WorkContract(){
	}

	public WorkContract(
		java.lang.String id
	){
		this.id = id;
	}
	@Transient
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Transient
	public String getContractTypeName() {
		return contractTypeName;
	}

	public void setContractTypeName(String contractTypeName) {
		this.contractTypeName = contractTypeName;
	}
	@Transient
	public String getWorkTypeName() {
		return workTypeName;
	}

	public void setWorkTypeName(String workTypeName) {
		this.workTypeName = workTypeName;
	}
	@Transient
	public int getViewModify() {
		return viewModify;
	}

	public void setViewModify(int viewModify) {
		this.viewModify = viewModify;
	}
	@Transient
	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	@Transient
	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	@Transient
	public String getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
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
     @WhereSQL(sql="id=:WorkContract_id")
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
     @WhereSQL(sql="userId=:WorkContract_userId")
	public java.lang.String getUserId() {
		return this.userId;
	}
		/**
		 * 归属公司
		 */
	public void setCompany(java.lang.String value) {
		    if(StringUtils.isNotBlank(value)){
			 value=value.trim();
			}
		this.company = value;
	}
	
	
	
	/**
	 * 归属公司
	 */
     @WhereSQL(sql="company=:WorkContract_company")
	public java.lang.String getCompany() {
		return this.company;
	}
		/**
		 * 部门
		 */
	public void setOrgId(java.lang.String value) {
		    if(StringUtils.isNotBlank(value)){
			 value=value.trim();
			}
		this.orgId = value;
	}
	
	
	
	/**
	 * 部门
	 */
     @WhereSQL(sql="orgId=:WorkContract_orgId")
	public java.lang.String getOrgId() {
		return this.orgId;
	}
		/*
	public String getstartDateString() {
		return DateUtils.convertDate2String(FORMAT_STARTDATE, getstartDate());
	}
	public void setstartDateString(String value) throws ParseException{
		setstartDate(DateUtils.convertString2Date(FORMAT_STARTDATE,value));
	}*/
	
		/**
		 * 签订开始日期
		 */
	public void setStartDate(java.util.Date value) {
		this.startDate = value;
	}
	
	
	
	/**
	 * 签订开始日期
	 */
     @WhereSQL(sql="startDate=:WorkContract_startDate")
	public java.util.Date getStartDate() {
		return this.startDate;
	}
		/*
	public String getendDateString() {
		return DateUtils.convertDate2String(FORMAT_ENDDATE, getendDate());
	}
	public void setendDateString(String value) throws ParseException{
		setendDate(DateUtils.convertString2Date(FORMAT_ENDDATE,value));
	}*/
	
		/**
		 * 签订结束日期
		 */
	public void setEndDate(java.util.Date value) {
		this.endDate = value;
	}
	
	
	
	/**
	 * 签订结束日期
	 */
     @WhereSQL(sql="endDate=:WorkContract_endDate")
	public java.util.Date getEndDate() {
		return this.endDate;
	}
		/**
		 * 合同类型
		 */
	public void setContractType(java.lang.String value) {
		    if(StringUtils.isNotBlank(value)){
			 value=value.trim();
			}
		this.contractType = value;
	}
	
	
	
	/**
	 * 合同类型
	 */
     @WhereSQL(sql="contractType=:WorkContract_contractType")
	public java.lang.String getContractType() {
		return this.contractType;
	}
		/**
		 * 用工方式
		 */
	public void setWorkType(java.lang.String value) {
		    if(StringUtils.isNotBlank(value)){
			 value=value.trim();
			}
		this.workType = value;
	}
	
	
	
	/**
	 * 用工方式
	 */
     @WhereSQL(sql="workType=:WorkContract_workType")
	public java.lang.String getWorkType() {
		return this.workType;
	}
		/**
		 * 备注
		 */
	public void setBak(java.lang.String value) {
		    if(StringUtils.isNotBlank(value)){
			 value=value.trim();
			}
		this.bak = value;
	}
	
	
	
	/**
	 * 备注
	 */
     @WhereSQL(sql="bak=:WorkContract_bak")
	public java.lang.String getBak() {
		return this.bak;
	}
		/**
		 * 是否有效
		 */
	public void setState(java.lang.String value) {
		    if(StringUtils.isNotBlank(value)){
			 value=value.trim();
			}
		this.state = value;
	}
	
	
	
	/**
	 * 是否有效
	 */
     @WhereSQL(sql="state=:WorkContract_state")
	public java.lang.String getState() {
		return this.state;
	}
     
     
	public String getEditPerson() {
		return editPerson;
	}

	public void setEditPerson(String editPerson) {
		this.editPerson = editPerson;
	}

	public Date getEditDate() {
		return editDate;
	}

	public void setEditDate(Date editDate) {
		this.editDate = editDate;
	}
	@WhereSQL(sql="term=:WorkContract_term")
	public Integer getTerm() {
		return term;
	}

	public void setTerm(Integer term) {
		this.term = term;
	}
	@WhereSQL(sql="times=:WorkContract_times")
	public Integer getTimes() {
		return times;
	}

	public void setTimes(Integer times) {
		this.times = times;
	}
	@WhereSQL(sql="contractNo=:WorkContract_contractNo")
	public String getContractNo() {
		return contractNo;
	}

	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}

	@Override
	public String toString() {
		return new StringBuilder()
			.append("id[").append(getId()).append("],")
			.append("userId[").append(getUserId()).append("],")
			.append("归属公司[").append(getCompany()).append("],")
			.append("部门[").append(getOrgId()).append("],")
			.append("签订开始日期[").append(getStartDate()).append("],")
			.append("签订结束日期[").append(getEndDate()).append("],")
			.append("合同类型[").append(getContractType()).append("],")
			.append("用工方式[").append(getWorkType()).append("],")
			.append("备注[").append(getBak()).append("],")
			.append("是否有效[").append(getState()).append("],")
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
		if(obj instanceof WorkContract == false){
			return false;
		}
			
		if(this == obj){
			return true;
		}
		
		WorkContract other = (WorkContract)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

	
