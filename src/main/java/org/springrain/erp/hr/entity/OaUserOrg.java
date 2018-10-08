package org.springrain.erp.hr.entity;

import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import org.springrain.frame.annotation.WhereSQL;
import org.springrain.frame.entity.BaseEntity;
/**
 * TODO 在此加入类描述
 * @copyright {@link weicms.net}
 * @author springrain<Auto generate>
 * @version  2017-07-31 10:02:21
 * @see org.springrain.erp.gz.entity.OaUserOrg
 */
@Table(name="z_oa_user_org")
public class OaUserOrg  extends BaseEntity {
	
	private static final long serialVersionUID = 1L;

	//alias
	/*
	public static final String TABLE_ALIAS = "用户部门中间表";
	public static final String ALIAS_ID = "编号";
	public static final String ALIAS_USERID = "用户编号";
	public static final String ALIAS_ORGID = "机构编号";
	public static final String ALIAS_ACTIVE = "是否可用";
	public static final String ALIAS_DELUID = "删除人Id";
	public static final String ALIAS_DELTIME = "删除时间";
	public static final String ALIAS_MANAGER = "是否是主管(0：否，1：是)";
    */
	//date formats
	
	//columns START
	/**
	 * 编号
	 */
	private java.lang.String id;
	/**
	 * 用户编号
	 */
	private java.lang.String userId;
	/**
	 * 机构编号
	 */
	private java.lang.String orgId;
	/**
	 * 是否可用
	 */
	private java.lang.Integer active;
	/**
	 * 删除人Id
	 */
	private java.lang.String delUid;
	/**
	 * 删除时间
	 */
	private java.lang.Long delTime;
	/**
	 * 是否是主管(0：否，1：是)
	 */
	private java.lang.Integer manager;
	//columns END 数据库字段结束
	
	//concstructor

	public OaUserOrg(){
	}

	public OaUserOrg(
		java.lang.String id
	){
		this.id = id;
	}

	//get and set
		/**
		 * 编号
		 */
	public void setId(java.lang.String value) {
		    if(StringUtils.isNotBlank(value)){
			 value=value.trim();
			}
		this.id = value;
	}
	
	
	
	/**
	 * 编号
	 */
	@Id
     @WhereSQL(sql="id=:OaUserOrg_id")
	public java.lang.String getId() {
		return this.id;
	}
		/**
		 * 用户编号
		 */
	public void setUserId(java.lang.String value) {
		    if(StringUtils.isNotBlank(value)){
			 value=value.trim();
			}
		this.userId = value;
	}
	
	
	
	/**
	 * 用户编号
	 */
     @WhereSQL(sql="userId=:OaUserOrg_userId")
	public java.lang.String getUserId() {
		return this.userId;
	}
		/**
		 * 机构编号
		 */
	public void setOrgId(java.lang.String value) {
		    if(StringUtils.isNotBlank(value)){
			 value=value.trim();
			}
		this.orgId = value;
	}
	
	
	
	/**
	 * 机构编号
	 */
     @WhereSQL(sql="orgId=:OaUserOrg_orgId")
	public java.lang.String getOrgId() {
		return this.orgId;
	}
		/**
		 * 是否可用
		 */
	public void setActive(java.lang.Integer value) {
		this.active = value;
	}
	
	
	
	/**
	 * 是否可用
	 */
     @WhereSQL(sql="active=:OaUserOrg_active")
	public java.lang.Integer getActive() {
		return this.active;
	}
		/**
		 * 删除人Id
		 */
	public void setDelUid(java.lang.String value) {
		    if(StringUtils.isNotBlank(value)){
			 value=value.trim();
			}
		this.delUid = value;
	}
	
	
	
	/**
	 * 删除人Id
	 */
     @WhereSQL(sql="delUid=:OaUserOrg_delUid")
	public java.lang.String getDelUid() {
		return this.delUid;
	}
		/**
		 * 删除时间
		 */
	public void setDelTime(java.lang.Long value) {
		this.delTime = value;
	}
	
	
	
	/**
	 * 删除时间
	 */
     @WhereSQL(sql="delTime=:OaUserOrg_delTime")
	public java.lang.Long getDelTime() {
		return this.delTime;
	}
		/**
		 * 是否是主管(0：否，1：是)
		 */
	public void setManager(java.lang.Integer value) {
		this.manager = value;
	}
	
	
	
	/**
	 * 是否是主管(0：否，1：是)
	 */
     @WhereSQL(sql="manager=:OaUserOrg_manager")
	public java.lang.Integer getManager() {
		return this.manager;
	}
	@Override
	public String toString() {
		return new StringBuilder()
			.append("编号[").append(getId()).append("],")
			.append("用户编号[").append(getUserId()).append("],")
			.append("机构编号[").append(getOrgId()).append("],")
			.append("是否可用[").append(getActive()).append("],")
			.append("删除人Id[").append(getDelUid()).append("],")
			.append("删除时间[").append(getDelTime()).append("],")
			.append("是否是主管(0：否，1：是)[").append(getManager()).append("],")
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
		if(obj instanceof OaUserOrg == false){
			return false;
		}
			
		if(this == obj){
			return true;
		}
		
		OaUserOrg other = (OaUserOrg)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

	
