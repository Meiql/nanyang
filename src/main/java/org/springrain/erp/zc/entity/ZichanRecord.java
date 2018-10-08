package org.springrain.erp.zc.entity;

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
 * @version  2017-08-14 09:45:09
 * @see org.springrain.erp.zc.entity.ZichanRecord
 */
@Table(name="z_zichan_record")
public class ZichanRecord  extends BaseEntity {
	
	private static final long serialVersionUID = 1L;

	//alias
	/*
	public static final String TABLE_ALIAS = "资产领用记录表";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_ZCID = "zcid";
	public static final String ALIAS_LINGID = "lingid";
	public static final String ALIAS_RETYPE = "发生类型";
	public static final String ALIAS_REUSER = "发生人";
	public static final String ALIAS_REUSERID = "发生人id";
	public static final String ALIAS_REUNIT = "发生部门";
	public static final String ALIAS_REUNITID = "发生部门id";
	public static final String ALIAS_REDATE = "发生日期";
	public static final String ALIAS_RENUM = "变动数量";
	public static final String ALIAS_REMONEY = "变动金额";
	public static final String ALIAS_REMARK = "备注";
	public static final String ALIAS_CREATEUSER = "创建人";
	public static final String ALIAS_CREATETIME = "创建日期";
	public static final String ALIAS_ACTIVE = "active";
	public static final String ALIAS_BAK1 = "审核人";
	public static final String ALIAS_BAK2 = "bak2";
	public static final String ALIAS_BAK3 = "bak3";
    */
	//date formats
	//public static final String FORMAT_REDATE = DateUtils.DATETIME_FORMAT;
	//public static final String FORMAT_CREATETIME = DateUtils.DATETIME_FORMAT;
	
	//columns START
	/**
	 * id
	 */
	private java.lang.String id;
	/**
	 * zcid
	 */
	private java.lang.String zcid;
	/**
	 * lingid
	 */
	private java.lang.String lingid;
	/**
	 * 发生类型
	 */
	private java.lang.String retype;
	/**
	 * 发生人
	 */
	private java.lang.String reuser;
	/**
	 * 发生人id
	 */
	private java.lang.String reuserid;
	/**
	 * 发生部门
	 */
	private java.lang.String reunit;
	/**
	 * 发生部门id
	 */
	private java.lang.String reunitid;
	/**
	 * 发生日期
	 */
	private java.util.Date redate;
	/**
	 * 变动数量
	 */
	private java.lang.Integer renum;
	/**
	 * 变动金额
	 */
	private java.math.BigDecimal remoney;
	/**
	 * 备注
	 */
	private java.lang.String remark;
	/**
	 * 创建人
	 */
	private java.lang.String createuser;
	/**
	 * 创建日期
	 */
	private java.util.Date createtime;
	/**
	 * active
	 */
	private java.lang.Integer active;
	/**
	 * 审核人
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
	//columns END 数据库字段结束
	private String isAdmin;
	private String zcname;
	private String zccode;
	private String sdate;
	private String edate;
	
	
	//concstructor

	public ZichanRecord(){
	}

	public ZichanRecord(
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
     @WhereSQL(sql="id=:ZichanRecord_id")
	public java.lang.String getId() {
		return this.id;
	}
		/**
		 * zcid
		 */
	public void setZcid(java.lang.String value) {
		    if(StringUtils.isNotBlank(value)){
			 value=value.trim();
			}
		this.zcid = value;
	}
	
	
	
	/**
	 * zcid
	 */
     @WhereSQL(sql="zcid=:ZichanRecord_zcid")
	public java.lang.String getZcid() {
		return this.zcid;
	}
		/**
		 * lingid
		 */
	public void setLingid(java.lang.String value) {
		    if(StringUtils.isNotBlank(value)){
			 value=value.trim();
			}
		this.lingid = value;
	}
	
	
	
	/**
	 * lingid
	 */
     @WhereSQL(sql="lingid=:ZichanRecord_lingid")
	public java.lang.String getLingid() {
		return this.lingid;
	}
		/**
		 * 发生类型
		 */
	public void setRetype(java.lang.String value) {
		    if(StringUtils.isNotBlank(value)){
			 value=value.trim();
			}
		this.retype = value;
	}
	
	
	
	/**
	 * 发生类型
	 */
     @WhereSQL(sql="retype=:ZichanRecord_retype")
	public java.lang.String getRetype() {
		return this.retype;
	}
		/**
		 * 发生人
		 */
	public void setReuser(java.lang.String value) {
		    if(StringUtils.isNotBlank(value)){
			 value=value.trim();
			}
		this.reuser = value;
	}
	
	
	
	/**
	 * 发生人
	 */
     @WhereSQL(sql="reuser=:ZichanRecord_reuser")
	public java.lang.String getReuser() {
		return this.reuser;
	}
		/**
		 * 发生人id
		 */
	public void setReuserid(java.lang.String value) {
		    if(StringUtils.isNotBlank(value)){
			 value=value.trim();
			}
		this.reuserid = value;
	}
	
	
	
	/**
	 * 发生人id
	 */
     @WhereSQL(sql="reuserid=:ZichanRecord_reuserid")
	public java.lang.String getReuserid() {
		return this.reuserid;
	}
		/**
		 * 发生部门
		 */
	public void setReunit(java.lang.String value) {
		    if(StringUtils.isNotBlank(value)){
			 value=value.trim();
			}
		this.reunit = value;
	}
	
	
	
	/**
	 * 发生部门
	 */
     @WhereSQL(sql="reunit=:ZichanRecord_reunit")
	public java.lang.String getReunit() {
		return this.reunit;
	}
		/**
		 * 发生部门id
		 */
	public void setReunitid(java.lang.String value) {
		    if(StringUtils.isNotBlank(value)){
			 value=value.trim();
			}
		this.reunitid = value;
	}
	
	
	
	/**
	 * 发生部门id
	 */
     @WhereSQL(sql="reunitid=:ZichanRecord_reunitid")
	public java.lang.String getReunitid() {
		return this.reunitid;
	}
		/*
	public String getredateString() {
		return DateUtils.convertDate2String(FORMAT_REDATE, getredate());
	}
	public void setredateString(String value) throws ParseException{
		setredate(DateUtils.convertString2Date(FORMAT_REDATE,value));
	}*/
	
		/**
		 * 发生日期
		 */
	public void setRedate(java.util.Date value) {
		this.redate = value;
	}
	
	
	
	/**
	 * 发生日期
	 */
     @WhereSQL(sql="redate=:ZichanRecord_redate")
	public java.util.Date getRedate() {
		return this.redate;
	}
		/**
		 * 变动数量
		 */
	public void setRenum(java.lang.Integer value) {
		this.renum = value;
	}
	
	
	
	/**
	 * 变动数量
	 */
     @WhereSQL(sql="renum=:ZichanRecord_renum")
	public java.lang.Integer getRenum() {
		return this.renum;
	}
		/**
		 * 变动金额
		 */
	public void setRemoney(java.math.BigDecimal value) {
		this.remoney = value;
	}
	
	
	
	/**
	 * 变动金额
	 */
     @WhereSQL(sql="remoney=:ZichanRecord_remoney")
	public java.math.BigDecimal getRemoney() {
		return this.remoney;
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
     @WhereSQL(sql="remark=:ZichanRecord_remark")
	public java.lang.String getRemark() {
		return this.remark;
	}
		/**
		 * 创建人
		 */
	public void setCreateuser(java.lang.String value) {
		    if(StringUtils.isNotBlank(value)){
			 value=value.trim();
			}
		this.createuser = value;
	}
	
	
	
	/**
	 * 创建人
	 */
     @WhereSQL(sql="createuser=:ZichanRecord_createuser")
	public java.lang.String getCreateuser() {
		return this.createuser;
	}
		/*
	public String getcreatetimeString() {
		return DateUtils.convertDate2String(FORMAT_CREATETIME, getcreatetime());
	}
	public void setcreatetimeString(String value) throws ParseException{
		setcreatetime(DateUtils.convertString2Date(FORMAT_CREATETIME,value));
	}*/
	
		/**
		 * 创建日期
		 */
	public void setCreatetime(java.util.Date value) {
		this.createtime = value;
	}
	
	
	
	/**
	 * 创建日期
	 */
     @WhereSQL(sql="createtime=:ZichanRecord_createtime")
	public java.util.Date getCreatetime() {
		return this.createtime;
	}
		/**
		 * active
		 */
	public void setActive(java.lang.Integer value) {
		this.active = value;
	}
	
	
	
	/**
	 * active
	 */
     @WhereSQL(sql="active=:ZichanRecord_active")
	public java.lang.Integer getActive() {
		return this.active;
	}
		/**
		 * 审核人
		 */
	public void setBak1(java.lang.String value) {
		    if(StringUtils.isNotBlank(value)){
			 value=value.trim();
			}
		this.bak1 = value;
	}
	
	
	
	/**
	 * 审核人
	 */
     @WhereSQL(sql="bak1=:ZichanRecord_bak1")
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
     @WhereSQL(sql="bak2=:ZichanRecord_bak2")
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
     @WhereSQL(sql="bak3=:ZichanRecord_bak3")
	public java.lang.String getBak3() {
		return this.bak3;
	}
	@Override
	public String toString() {
		return new StringBuilder()
			.append("id[").append(getId()).append("],")
			.append("zcid[").append(getZcid()).append("],")
			.append("lingid[").append(getLingid()).append("],")
			.append("发生类型[").append(getRetype()).append("],")
			.append("发生人[").append(getReuser()).append("],")
			.append("发生人id[").append(getReuserid()).append("],")
			.append("发生部门[").append(getReunit()).append("],")
			.append("发生部门id[").append(getReunitid()).append("],")
			.append("发生日期[").append(getRedate()).append("],")
			.append("变动数量[").append(getRenum()).append("],")
			.append("变动金额[").append(getRemoney()).append("],")
			.append("备注[").append(getRemark()).append("],")
			.append("创建人[").append(getCreateuser()).append("],")
			.append("创建日期[").append(getCreatetime()).append("],")
			.append("active[").append(getActive()).append("],")
			.append("审核人[").append(getBak1()).append("],")
			.append("bak2[").append(getBak2()).append("],")
			.append("bak3[").append(getBak3()).append("],")
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
		if(obj instanceof ZichanRecord == false){
			return false;
		}
			
		if(this == obj){
			return true;
		}
		
		ZichanRecord other = (ZichanRecord)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
	@Transient
	public String getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(String isAdmin) {
		this.isAdmin = isAdmin;
	}
	@Transient
	public String getZcname() {
		return zcname;
	}

	public void setZcname(String zcname) {
		this.zcname = zcname;
	}
	@Transient
	public String getZccode() {
		return zccode;
	}

	public void setZccode(String zccode) {
		this.zccode = zccode;
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

	
