package org.springrain.erp.zc.entity;

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
 * @version  2017-08-14 09:45:18
 * @see org.springrain.erp.zc.entity.ZichanProperties
 */
@Table(name="z_zichan_properties")
public class ZichanProperties  extends BaseEntity {
	
	private static final long serialVersionUID = 1L;

	//alias
	/*
	public static final String TABLE_ALIAS = "资产属性表";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_ZCID = "zcId";
	public static final String ALIAS_PRONAME = "名称";
	public static final String ALIAS_PROVALUE = "值";
	public static final String ALIAS_BAK1 = "bak1";
	public static final String ALIAS_BAK2 = "bak2";
	public static final String ALIAS_BAK3 = "bak3";
    */
	//date formats
	
	//columns START
	/**
	 * id
	 */
	private java.lang.String id;
	/**
	 * zcId
	 */
	private java.lang.String zcId;
	/**
	 * 名称
	 */
	private java.lang.String proName;
	/**
	 * 值
	 */
	private java.lang.String proValue;
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
	//columns END 数据库字段结束
	
	//concstructor

	public ZichanProperties(){
	}

	public ZichanProperties(
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
     @WhereSQL(sql="id=:ZichanProperties_id")
	public java.lang.String getId() {
		return this.id;
	}
		/**
		 * zcId
		 */
	public void setZcId(java.lang.String value) {
		    if(StringUtils.isNotBlank(value)){
			 value=value.trim();
			}
		this.zcId = value;
	}
	
	
	
	/**
	 * zcId
	 */
     @WhereSQL(sql="zcId=:ZichanProperties_zcId")
	public java.lang.String getZcId() {
		return this.zcId;
	}
		/**
		 * 名称
		 */
	public void setProName(java.lang.String value) {
		    if(StringUtils.isNotBlank(value)){
			 value=value.trim();
			}
		this.proName = value;
	}
	
	
	
	/**
	 * 名称
	 */
     @WhereSQL(sql="proName=:ZichanProperties_proName")
	public java.lang.String getProName() {
		return this.proName;
	}
		/**
		 * 值
		 */
	public void setProValue(java.lang.String value) {
		    if(StringUtils.isNotBlank(value)){
			 value=value.trim();
			}
		this.proValue = value;
	}
	
	
	
	/**
	 * 值
	 */
     @WhereSQL(sql="proValue=:ZichanProperties_proValue")
	public java.lang.String getProValue() {
		return this.proValue;
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
     @WhereSQL(sql="bak1=:ZichanProperties_bak1")
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
     @WhereSQL(sql="bak2=:ZichanProperties_bak2")
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
     @WhereSQL(sql="bak3=:ZichanProperties_bak3")
	public java.lang.String getBak3() {
		return this.bak3;
	}
	@Override
	public String toString() {
		return new StringBuilder()
			.append("id[").append(getId()).append("],")
			.append("zcId[").append(getZcId()).append("],")
			.append("名称[").append(getProName()).append("],")
			.append("值[").append(getProValue()).append("],")
			.append("bak1[").append(getBak1()).append("],")
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
		if(obj instanceof ZichanProperties == false){
			return false;
		}
			
		if(this == obj){
			return true;
		}
		
		ZichanProperties other = (ZichanProperties)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

	
