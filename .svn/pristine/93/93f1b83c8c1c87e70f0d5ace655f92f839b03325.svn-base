package org.springrain.erp.tc.entity;

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
 * @version  2017-07-03 17:42:41
 * @see org.springrain.erp.tc.entity.TongchouShow
 */
@Table(name="z_tongchou_show")
public class TongchouShow  extends BaseEntity {
	
	private static final long serialVersionUID = 1L;

	//alias
	/*
	public static final String TABLE_ALIAS = "TongchouShow";
	public static final String ALIAS_ID = "字典id";
	public static final String ALIAS_DICTTYPEID = "dicttypeId";
	public static final String ALIAS_PROPERTY = "属性";
	public static final String ALIAS_PROPERTYVALUE = "属性值";
	public static final String ALIAS_DESKSHOWNAME = "桌面显示值";
	public static final String ALIAS_SHOWORHIDDEN = "是否隐藏";
	public static final String ALIAS_ACTIVE = " 0 否 1 是";
	public static final String ALIAS_TYPE = "区分基础信息和月度数据";
	public static final String ALIAS_REPORTTYPE = "主要记录缴纳类型";
	public static final String ALIAS_BAK1 = "bak1";
	public static final String ALIAS_BAK2 = "bak2";
	public static final String ALIAS_BAK3 = "bak3";
	public static final String ALIAS_BAK4 = "bak4";
    */
	//date formats
	
	//columns START
	/**
	 * 字典id
	 */
	private java.lang.String id;
	/**
	 * dicttypeId
	 */
	private java.lang.String dicttypeId;
	/**
	 * 属性
	 */
	private java.lang.String property;
	/**
	 * 属性值
	 */
	private java.lang.String propertyValue;
	/**
	 * 桌面显示值
	 */
	private java.lang.String deskShowName;
	/**
	 * 是否隐藏
	 */
	private java.lang.String showOrhidden;
	/**
	 *  0 否 1 是
	 */
	private java.lang.String active;
	/**
	 * 区分基础信息和月度数据
	 */
	private java.lang.String type;
	/**
	 * 主要记录缴纳类型
	 */
	private java.lang.String reportType;
	/**
	 * 主要创建人
	 */
	private String createUser;
	/**
	 * 主要创建时间
	 */
	private Date createTime;
	/**
	 * 排序号
	 */
	private Integer sortno;
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
	private String dicdataName;
	//concstructor

	public TongchouShow(){
	}

	public TongchouShow(
		java.lang.String id
	){
		this.id = id;
	}

	//get and set
		/**
		 * 字典id
		 */
	public void setId(java.lang.String value) {
		    if(StringUtils.isNotBlank(value)){
			 value=value.trim();
			}
		this.id = value;
	}
	
	
	@Transient
	public String getDicdataName() {
			return dicdataName;
		}

	public void setDicdataName(String dicdataName) {
		this.dicdataName = dicdataName;
	}

	
	
	public Integer getSortno() {
		return sortno;
	}

	public void setSortno(Integer sortno) {
		this.sortno = sortno;
	}

	/**
	 * 字典id
	 */
	@Id
     @WhereSQL(sql="id=:TongchouShow_id")
	public java.lang.String getId() {
		return this.id;
	}
		/**
		 * dicttypeId
		 */
	public void setDicttypeId(java.lang.String value) {
		    if(StringUtils.isNotBlank(value)){
			 value=value.trim();
			}
		this.dicttypeId = value;
	}
	
	
	
	public String getCreateUser() {
			return createUser;
		}

		public void setCreateUser(String createUser) {
			this.createUser = createUser;
		}

		public Date getCreateTime() {
			return createTime;
		}

		public void setCreateTime(Date createTime) {
			this.createTime = createTime;
		}

	/**
	 * dicttypeId
	 */
     @WhereSQL(sql="dicttypeId=:TongchouShow_dicttypeId")
	public java.lang.String getDicttypeId() {
		return this.dicttypeId;
	}
		/**
		 * 属性
		 */
	public void setProperty(java.lang.String value) {
		    if(StringUtils.isNotBlank(value)){
			 value=value.trim();
			}
		this.property = value;
	}
	
	
	
	/**
	 * 属性
	 */
     @WhereSQL(sql="property=:TongchouShow_property")
	public java.lang.String getProperty() {
		return this.property;
	}
		/**
		 * 属性值
		 */
	public void setPropertyValue(java.lang.String value) {
		    if(StringUtils.isNotBlank(value)){
			 value=value.trim();
			}
		this.propertyValue = value;
	}
	
	
	
	/**
	 * 属性值
	 */
     @WhereSQL(sql="propertyValue=:TongchouShow_propertyValue")
	public java.lang.String getPropertyValue() {
		return this.propertyValue;
	}
		/**
		 * 桌面显示值
		 */
	public void setDeskShowName(java.lang.String value) {
		    if(StringUtils.isNotBlank(value)){
			 value=value.trim();
			}
		this.deskShowName = value;
	}
	
	
	
	/**
	 * 桌面显示值
	 */
     @WhereSQL(sql="deskShowName=:TongchouShow_deskShowName")
	public java.lang.String getDeskShowName() {
		return this.deskShowName;
	}
		/**
		 * 是否隐藏
		 */
	public void setShowOrhidden(java.lang.String value) {
		    if(StringUtils.isNotBlank(value)){
			 value=value.trim();
			}
		this.showOrhidden = value;
	}
	
	
	
	/**
	 * 是否隐藏
	 */
     @WhereSQL(sql="showOrhidden=:TongchouShow_showOrhidden")
	public java.lang.String getShowOrhidden() {
		return this.showOrhidden;
	}
		/**
		 *  0 否 1 是
		 */
	public void setActive(java.lang.String value) {
		    if(StringUtils.isNotBlank(value)){
			 value=value.trim();
			}
		this.active = value;
	}
	
	
	
	/**
	 *  0 否 1 是
	 */
     @WhereSQL(sql="active=:TongchouShow_active")
	public java.lang.String getActive() {
		return this.active;
	}
		/**
		 * 区分基础信息和月度数据
		 */
	public void setType(java.lang.String value) {
		    if(StringUtils.isNotBlank(value)){
			 value=value.trim();
			}
		this.type = value;
	}
	
	
	
	/**
	 * 区分基础信息和月度数据
	 */
     @WhereSQL(sql="type=:TongchouShow_type")
	public java.lang.String getType() {
		return this.type;
	}
		/**
		 * 主要记录缴纳类型
		 */
	public void setReportType(java.lang.String value) {
		    if(StringUtils.isNotBlank(value)){
			 value=value.trim();
			}
		this.reportType = value;
	}
	
	
	
	/**
	 * 主要记录缴纳类型
	 */
     @WhereSQL(sql="reportType=:TongchouShow_reportType")
	public java.lang.String getReportType() {
		return this.reportType;
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
     @WhereSQL(sql="bak1=:TongchouShow_bak1")
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
     @WhereSQL(sql="bak2=:TongchouShow_bak2")
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
     @WhereSQL(sql="bak3=:TongchouShow_bak3")
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
     @WhereSQL(sql="bak4=:TongchouShow_bak4")
	public java.lang.String getBak4() {
		return this.bak4;
	}
	@Override
	public String toString() {
		return new StringBuilder()
			.append("字典id[").append(getId()).append("],")
			.append("dicttypeId[").append(getDicttypeId()).append("],")
			.append("属性[").append(getProperty()).append("],")
			.append("属性值[").append(getPropertyValue()).append("],")
			.append("桌面显示值[").append(getDeskShowName()).append("],")
			.append("是否隐藏[").append(getShowOrhidden()).append("],")
			.append(" 0 否 1 是[").append(getActive()).append("],")
			.append("区分基础信息和月度数据[").append(getType()).append("],")
			.append("主要记录缴纳类型[").append(getReportType()).append("],")
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
		if(obj instanceof TongchouShow == false){
			return false;
		}
			
		if(this == obj){
			return true;
		}
		
		TongchouShow other = (TongchouShow)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

	
