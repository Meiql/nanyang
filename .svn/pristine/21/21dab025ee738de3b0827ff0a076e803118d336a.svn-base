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
 * @version  2017-07-26 09:16:21
 * @see org.springrain.erp.hr.entity.UserCertificate
 */
@Table(name="t_user_certificate")
public class UserCertificate  extends BaseEntity {
	
	private static final long serialVersionUID = 1L;

	//alias
	/*
	public static final String TABLE_ALIAS = "用户证书表";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_USERID = "用户名称";
	public static final String ALIAS_BIANHAO = "编号";
	public static final String ALIAS_NAME = "证书名称";
	public static final String ALIAS_BANZHENGJIGOU = "颁证机构";
	public static final String ALIAS_PASSDATE = "通过日期";
	public static final String ALIAS_YOUXIAOQI = "有效期";
    */
	//date formats
	//public static final String FORMAT_PASSDATE = DateUtils.DATETIME_FORMAT;
	//public static final String FORMAT_YOUXIAOQI = DateUtils.DATETIME_FORMAT;
	
	//columns START
	/**
	 * id
	 */
	private java.lang.String id;
	/**
	 * 用户名称
	 */
	private java.lang.String userId;
	/**
	 * 编号
	 */
	private java.lang.String bianhao;
	/**
	 * 证书名称
	 */
	private java.lang.String name;
	/**
	 * 颁证机构
	 */
	private java.lang.String banzhengjigou;
	/**
	 * 通过日期
	 */
	private java.util.Date passDate;
	/**
	 * 有效期
	 */
	private java.util.Date youxiaoqi;
	//columns END 数据库字段结束
	
	//concstructor

	public UserCertificate(){
	}

	public UserCertificate(
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
     @WhereSQL(sql="id=:UserCertificate_id")
	public java.lang.String getId() {
		return this.id;
	}
		/**
		 * 用户名称
		 */
	public void setUserId(java.lang.String value) {
		    if(StringUtils.isNotBlank(value)){
			 value=value.trim();
			}
		this.userId = value;
	}
	
	
	
	/**
	 * 用户名称
	 */
     @WhereSQL(sql="userId=:UserCertificate_userId")
	public java.lang.String getUserId() {
		return this.userId;
	}
		/**
		 * 编号
		 */
	public void setBianhao(java.lang.String value) {
		    if(StringUtils.isNotBlank(value)){
			 value=value.trim();
			}
		this.bianhao = value;
	}
	
	
	
	/**
	 * 编号
	 */
     @WhereSQL(sql="bianhao=:UserCertificate_bianhao")
	public java.lang.String getBianhao() {
		return this.bianhao;
	}
		/**
		 * 证书名称
		 */
	public void setName(java.lang.String value) {
		    if(StringUtils.isNotBlank(value)){
			 value=value.trim();
			}
		this.name = value;
	}
	
	
	
	/**
	 * 证书名称
	 */
     @WhereSQL(sql="name=:UserCertificate_name")
	public java.lang.String getName() {
		return this.name;
	}
		/**
		 * 颁证机构
		 */
	public void setBanzhengjigou(java.lang.String value) {
		    if(StringUtils.isNotBlank(value)){
			 value=value.trim();
			}
		this.banzhengjigou = value;
	}
	
	
	
	/**
	 * 颁证机构
	 */
     @WhereSQL(sql="banzhengjigou=:UserCertificate_banzhengjigou")
	public java.lang.String getBanzhengjigou() {
		return this.banzhengjigou;
	}
		/*
	public String getpassDateString() {
		return DateUtils.convertDate2String(FORMAT_PASSDATE, getpassDate());
	}
	public void setpassDateString(String value) throws ParseException{
		setpassDate(DateUtils.convertString2Date(FORMAT_PASSDATE,value));
	}*/
	
		/**
		 * 通过日期
		 */
	public void setPassDate(java.util.Date value) {
		this.passDate = value;
	}
	
	
	
	/**
	 * 通过日期
	 */
     @WhereSQL(sql="passDate=:UserCertificate_passDate")
	public java.util.Date getPassDate() {
		return this.passDate;
	}
		/*
	public String getyouxiaoqiString() {
		return DateUtils.convertDate2String(FORMAT_YOUXIAOQI, getyouxiaoqi());
	}
	public void setyouxiaoqiString(String value) throws ParseException{
		setyouxiaoqi(DateUtils.convertString2Date(FORMAT_YOUXIAOQI,value));
	}*/
	
		/**
		 * 有效期
		 */
	public void setYouxiaoqi(java.util.Date value) {
		this.youxiaoqi = value;
	}
	
	
	
	/**
	 * 有效期
	 */
     @WhereSQL(sql="youxiaoqi=:UserCertificate_youxiaoqi")
	public java.util.Date getYouxiaoqi() {
		return this.youxiaoqi;
	}
	@Override
	public String toString() {
		return new StringBuilder()
			.append("id[").append(getId()).append("],")
			.append("用户名称[").append(getUserId()).append("],")
			.append("编号[").append(getBianhao()).append("],")
			.append("证书名称[").append(getName()).append("],")
			.append("颁证机构[").append(getBanzhengjigou()).append("],")
			.append("通过日期[").append(getPassDate()).append("],")
			.append("有效期[").append(getYouxiaoqi()).append("],")
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
		if(obj instanceof UserCertificate == false){
			return false;
		}
			
		if(this == obj){
			return true;
		}
		
		UserCertificate other = (UserCertificate)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

	
