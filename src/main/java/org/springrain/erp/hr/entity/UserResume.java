package org.springrain.erp.hr.entity;

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
 * @version  2017-08-04 09:20:14
 * @see org.springrain.erp.hr.entity.UserResume
 */
@Table(name="t_user_resume")
public class UserResume  extends BaseEntity {
	
	private static final long serialVersionUID = 1L;

	//alias
	/*
	public static final String TABLE_ALIAS = "员工履历表";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_USERID = "员工Id";
	public static final String ALIAS_TYPE = "类别";
	public static final String ALIAS_CREATEPERSON = "创建人";
	public static final String ALIAS_CREATEDATE = "创建时间";
	public static final String ALIAS_OLDORG = "原部门";
	public static final String ALIAS_NEWORG = "新部门";
	public static final String ALIAS_OLDGRADE = "原级别";
	public static final String ALIAS_NEWGRADE = "新级别";
	public static final String ALIAS_OLDGANGWEI = "原岗位";
	public static final String ALIAS_NEWGANGWEI = "新岗位";
	public static final String ALIAS_OLDJIBENPAY = "原基本工资";
	public static final String ALIAS_NEWJIBENPAY = "新基本工资";
	public static final String ALIAS_OLDKAOHEPAY = "原考核工资";
	public static final String ALIAS_NEWKAOHEPAY = "新考核工资";
	public static final String ALIAS_OLDGANGWEIPAY = "原岗位工资";
	public static final String ALIAS_NEWGANGWEIPAY = "新岗位工资";
    */
	//date formats
	//public static final String FORMAT_CREATEDATE = DateUtils.DATETIME_FORMAT;
	
	//columns START
	/**
	 * id
	 */
	private java.lang.String id;
	/**
	 * 员工Id
	 */
	private java.lang.String userId;
	/**
	 * 类别
	 */
	private java.lang.Integer type;
	/**
	 * 创建人
	 */
	private java.lang.String createPerson;
	/**
	 * 创建时间
	 */
	private java.util.Date createDate;
	/**
	 * 原部门
	 */
	private java.lang.String oldOrg;
	/**
	 * 新部门
	 */
	private java.lang.String newOrg;
	/**
	 * 原级别
	 */
	private java.lang.String oldGrade;
	/**
	 * 新级别
	 */
	private java.lang.String newGrade;
	/**
	 * 原岗位
	 */
	private java.lang.String oldGangwei;
	/**
	 * 新岗位
	 */
	private java.lang.String newGangwei;
	/**
	 * 原基本工资
	 */
	private java.math.BigDecimal oldJibenpay;
	/**
	 * 新基本工资
	 */
	private java.math.BigDecimal newJibenpay;
	/**
	 * 原考核工资
	 */
	private java.math.BigDecimal oldKaohepay;
	/**
	 * 新考核工资
	 */
	private java.math.BigDecimal newKaohepay;
	/**
	 * 原岗位工资
	 */
	private java.math.BigDecimal oldGangweipay;
	/**
	 * 新岗位工资
	 */
	private java.math.BigDecimal newGangweipay;
	//columns END 数据库字段结束
	private String userName;
	private String createPersonName;
	private String oldOrgName;
	private String newOrgName;
	private String oldGradeName;
	private String newGradeName;
	private String oldGangweiName;
	private String newGangweiName;
	private String sdate;
	private String edate;
	//concstructor

	public UserResume(){
	}

	public UserResume(
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
     @WhereSQL(sql="id=:UserResume_id")
	public java.lang.String getId() {
		return this.id;
	}
		/**
		 * 员工Id
		 */
	public void setUserId(java.lang.String value) {
		    if(StringUtils.isNotBlank(value)){
			 value=value.trim();
			}
		this.userId = value;
	}
	
	
	
	/**
	 * 员工Id
	 */
     @WhereSQL(sql="userId=:UserResume_userId")
	public java.lang.String getUserId() {
		return this.userId;
	}
		/**
		 * 类别
		 */
	public void setType(java.lang.Integer value) {
		this.type = value;
	}
	
	
	
	/**
	 * 类别
	 */
     @WhereSQL(sql="type=:UserResume_type")
	public java.lang.Integer getType() {
		return this.type;
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
     @WhereSQL(sql="createPerson=:UserResume_createPerson")
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
     @WhereSQL(sql="createDate=:UserResume_createDate")
	public java.util.Date getCreateDate() {
		return this.createDate;
	}
		/**
		 * 原部门
		 */
	public void setOldOrg(java.lang.String value) {
		    if(StringUtils.isNotBlank(value)){
			 value=value.trim();
			}
		this.oldOrg = value;
	}
	
	
	
	/**
	 * 原部门
	 */
     @WhereSQL(sql="oldOrg=:UserResume_oldOrg")
	public java.lang.String getOldOrg() {
		return this.oldOrg;
	}
		/**
		 * 新部门
		 */
	public void setNewOrg(java.lang.String value) {
		    if(StringUtils.isNotBlank(value)){
			 value=value.trim();
			}
		this.newOrg = value;
	}
	
	
	
	/**
	 * 新部门
	 */
     @WhereSQL(sql="newOrg=:UserResume_newOrg")
	public java.lang.String getNewOrg() {
		return this.newOrg;
	}
		/**
		 * 原级别
		 */
	public void setOldGrade(java.lang.String value) {
		    if(StringUtils.isNotBlank(value)){
			 value=value.trim();
			}
		this.oldGrade = value;
	}
	
	
	
	/**
	 * 原级别
	 */
     @WhereSQL(sql="oldGrade=:UserResume_oldGrade")
	public java.lang.String getOldGrade() {
		return this.oldGrade;
	}
		/**
		 * 新级别
		 */
	public void setNewGrade(java.lang.String value) {
		    if(StringUtils.isNotBlank(value)){
			 value=value.trim();
			}
		this.newGrade = value;
	}
	
	
	
	/**
	 * 新级别
	 */
     @WhereSQL(sql="newGrade=:UserResume_newGrade")
	public java.lang.String getNewGrade() {
		return this.newGrade;
	}
		/**
		 * 原岗位
		 */
	public void setOldGangwei(java.lang.String value) {
		    if(StringUtils.isNotBlank(value)){
			 value=value.trim();
			}
		this.oldGangwei = value;
	}
	
	
	
	/**
	 * 原岗位
	 */
     @WhereSQL(sql="oldGangwei=:UserResume_oldGangwei")
	public java.lang.String getOldGangwei() {
		return this.oldGangwei;
	}
		/**
		 * 新岗位
		 */
	public void setNewGangwei(java.lang.String value) {
		    if(StringUtils.isNotBlank(value)){
			 value=value.trim();
			}
		this.newGangwei = value;
	}
	
	
	
	/**
	 * 新岗位
	 */
     @WhereSQL(sql="newGangwei=:UserResume_newGangwei")
	public java.lang.String getNewGangwei() {
		return this.newGangwei;
	}
		/**
		 * 原基本工资
		 */
	public void setOldJibenpay(java.math.BigDecimal value) {
		this.oldJibenpay = value;
	}
	
	
	
	/**
	 * 原基本工资
	 */
     @WhereSQL(sql="oldJibenpay=:UserResume_oldJibenpay")
	public java.math.BigDecimal getOldJibenpay() {
		return this.oldJibenpay;
	}
		/**
		 * 新基本工资
		 */
	public void setNewJibenpay(java.math.BigDecimal value) {
		this.newJibenpay = value;
	}
	
	
	
	/**
	 * 新基本工资
	 */
     @WhereSQL(sql="newJibenpay=:UserResume_newJibenpay")
	public java.math.BigDecimal getNewJibenpay() {
		return this.newJibenpay;
	}
		/**
		 * 原考核工资
		 */
	public void setOldKaohepay(java.math.BigDecimal value) {
		this.oldKaohepay = value;
	}
	
	
	
	/**
	 * 原考核工资
	 */
     @WhereSQL(sql="oldKaohepay=:UserResume_oldKaohepay")
	public java.math.BigDecimal getOldKaohepay() {
		return this.oldKaohepay;
	}
		/**
		 * 新考核工资
		 */
	public void setNewKaohepay(java.math.BigDecimal value) {
		this.newKaohepay = value;
	}
	
	
	
	/**
	 * 新考核工资
	 */
     @WhereSQL(sql="newKaohepay=:UserResume_newKaohepay")
	public java.math.BigDecimal getNewKaohepay() {
		return this.newKaohepay;
	}
		/**
		 * 原岗位工资
		 */
	public void setOldGangweipay(java.math.BigDecimal value) {
		this.oldGangweipay = value;
	}
	
	
	
	/**
	 * 原岗位工资
	 */
     @WhereSQL(sql="oldGangweipay=:UserResume_oldGangweipay")
	public java.math.BigDecimal getOldGangweipay() {
		return this.oldGangweipay;
	}
		/**
		 * 新岗位工资
		 */
	public void setNewGangweipay(java.math.BigDecimal value) {
		this.newGangweipay = value;
	}
	
	
	
	/**
	 * 新岗位工资
	 */
     @WhereSQL(sql="newGangweipay=:UserResume_newGangweipay")
	public java.math.BigDecimal getNewGangweipay() {
		return this.newGangweipay;
	}
	@Override
	public String toString() {
		return new StringBuilder()
			.append("id[").append(getId()).append("],")
			.append("员工Id[").append(getUserId()).append("],")
			.append("类别[").append(getType()).append("],")
			.append("创建人[").append(getCreatePerson()).append("],")
			.append("创建时间[").append(getCreateDate()).append("],")
			.append("原部门[").append(getOldOrg()).append("],")
			.append("新部门[").append(getNewOrg()).append("],")
			.append("原级别[").append(getOldGrade()).append("],")
			.append("新级别[").append(getNewGrade()).append("],")
			.append("原岗位[").append(getOldGangwei()).append("],")
			.append("新岗位[").append(getNewGangwei()).append("],")
			.append("原基本工资[").append(getOldJibenpay()).append("],")
			.append("新基本工资[").append(getNewJibenpay()).append("],")
			.append("原考核工资[").append(getOldKaohepay()).append("],")
			.append("新考核工资[").append(getNewKaohepay()).append("],")
			.append("原岗位工资[").append(getOldGangweipay()).append("],")
			.append("新岗位工资[").append(getNewGangweipay()).append("],")
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
		if(obj instanceof UserResume == false){
			return false;
		}
			
		if(this == obj){
			return true;
		}
		
		UserResume other = (UserResume)obj;
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
	public String getCreatePersonName() {
		return createPersonName;
	}

	public void setCreatePersonName(String createPersonName) {
		this.createPersonName = createPersonName;
	}
	@Transient
	public String getOldOrgName() {
		return oldOrgName;
	}

	public void setOldOrgName(String oldOrgName) {
		this.oldOrgName = oldOrgName;
	}
	@Transient
	public String getNewOrgName() {
		return newOrgName;
	}

	public void setNewOrgName(String newOrgName) {
		this.newOrgName = newOrgName;
	}
	@Transient
	public String getOldGradeName() {
		return oldGradeName;
	}

	public void setOldGradeName(String oldGradeName) {
		this.oldGradeName = oldGradeName;
	}
	@Transient
	public String getNewGradeName() {
		return newGradeName;
	}

	public void setNewGradeName(String newGradeName) {
		this.newGradeName = newGradeName;
	}
	@Transient
	public String getOldGangweiName() {
		return oldGangweiName;
	}

	public void setOldGangweiName(String oldGangweiName) {
		this.oldGangweiName = oldGangweiName;
	}
	@Transient
	public String getNewGangweiName() {
		return newGangweiName;
	}

	public void setNewGangweiName(String newGangweiName) {
		this.newGangweiName = newGangweiName;
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
	
	
}

	
