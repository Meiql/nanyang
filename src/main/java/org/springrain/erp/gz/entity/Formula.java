package org.springrain.erp.gz.entity;

import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springrain.frame.annotation.WhereSQL;
import org.springrain.frame.entity.BaseEntity;
/**
 * 公式表
 * @copyright {@link weicms.net}
 * @author springrain<Auto generate>
 * @version  2017-07-03 17:29:07
 * @see org.springrain.erp.gz.entity.Formula
 */
@Table(name="z_formula")
public class Formula  extends BaseEntity {
	
	private static final long serialVersionUID = 1L;

	//alias
	/*
	public static final String TABLE_ALIAS = "公式";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_NAME = "名称";
	public static final String ALIAS_CHINESENAME = "表达式的中文名称";
	public static final String ALIAS_EXPRESSION = "表达式";
	public static final String ALIAS_CHINESEEXPRESSION = "表达式的中文显示";
	public static final String ALIAS_SYSEXPRESSION = "是否是系统变量,0是 1否";
	public static final String ALIAS_PROJECTNAME = "项目名称,用于区分不同项目的公式";
	public static final String ALIAS_INEFFECTIVEDATE = "起效日期";
	public static final String ALIAS_ACTIVE = "是否可用";
    */
	//date formats
	//public static final String FORMAT_INEFFECTIVEDATE = DateUtils.DATETIME_FORMAT;
	
	//columns START
	/**
	 * id
	 */
	private java.lang.String id;
	/**
	 * 名称
	 */
	private java.lang.String name;
	/**
	 * 表达式的中文名称
	 */
	private java.lang.String chineseName;
	/**
	 * 表达式
	 */
	private java.lang.String expression;
	/**
	 * 表达式的中文显示
	 */
	private java.lang.String chineseExpression;
	/**
	 * 是否是系统变量,0是 1否
	 */
	private java.lang.Integer sysExpression;
	/**
	 * 项目名称,用于区分不同项目的公式
	 */
	private java.lang.String projectName;
	/**
	 * 起效日期
	 */
	private java.util.Date inEffectiveDate;
	/**
	 * 是否可用
	 */
	private java.lang.Integer active;
	/**
	 * 公式组合
	 */
	private String expressionCode;
	//columns END 数据库字段结束
	
	//concstructor

	public Formula(){
	}

	public Formula(
		java.lang.String id
	){
		this.id = id;
	}

	public String getExpressionCode() {
		return expressionCode;
	}

	public void setExpressionCode(String expressionCode) {
		this.expressionCode = expressionCode;
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
     @WhereSQL(sql="id=:Formula_id")
	public java.lang.String getId() {
		return this.id;
	}
		/**
		 * 名称
		 */
	public void setName(java.lang.String value) {
		    if(StringUtils.isNotBlank(value)){
			 value=value.trim();
			}
		this.name = value;
	}
	
	
	
	/**
	 * 名称
	 */
     @WhereSQL(sql="name=:Formula_name")
	public java.lang.String getName() {
		return this.name;
	}
		/**
		 * 表达式的中文名称
		 */
	public void setChineseName(java.lang.String value) {
		    if(StringUtils.isNotBlank(value)){
			 value=value.trim();
			}
		this.chineseName = value;
	}
	
	
	
	/**
	 * 表达式的中文名称
	 */
     @WhereSQL(sql="chineseName=:Formula_chineseName")
	public java.lang.String getChineseName() {
		return this.chineseName;
	}
		/**
		 * 表达式
		 */
	public void setExpression(java.lang.String value) {
		    if(StringUtils.isNotBlank(value)){
			 value=value.trim();
			}
		this.expression = value;
	}
	
	
	
	/**
	 * 表达式
	 */
     @WhereSQL(sql="expression=:Formula_expression")
	public java.lang.String getExpression() {
		return this.expression;
	}
		/**
		 * 表达式的中文显示
		 */
	public void setChineseExpression(java.lang.String value) {
		    if(StringUtils.isNotBlank(value)){
			 value=value.trim();
			}
		this.chineseExpression = value;
	}
	
	
	
	/**
	 * 表达式的中文显示
	 */
     @WhereSQL(sql="chineseExpression=:Formula_chineseExpression")
	public java.lang.String getChineseExpression() {
		return this.chineseExpression;
	}
		/**
		 * 是否是系统变量,0是 1否
		 */
	public void setSysExpression(java.lang.Integer value) {
		this.sysExpression = value;
	}
	
	
	
	/**
	 * 是否是系统变量,0是 1否
	 */
     @WhereSQL(sql="sysExpression=:Formula_sysExpression")
	public java.lang.Integer getSysExpression() {
		return this.sysExpression;
	}
		/**
		 * 项目名称,用于区分不同项目的公式
		 */
	public void setProjectName(java.lang.String value) {
		    if(StringUtils.isNotBlank(value)){
			 value=value.trim();
			}
		this.projectName = value;
	}
	
	
	
	/**
	 * 项目名称,用于区分不同项目的公式
	 */
     @WhereSQL(sql="projectName=:Formula_projectName")
	public java.lang.String getProjectName() {
		return this.projectName;
	}
		/*
	public String getinEffectiveDateString() {
		return DateUtils.convertDate2String(FORMAT_INEFFECTIVEDATE, getinEffectiveDate());
	}
	public void setinEffectiveDateString(String value) throws ParseException{
		setinEffectiveDate(DateUtils.convertString2Date(FORMAT_INEFFECTIVEDATE,value));
	}*/
	
		/**
		 * 起效日期
		 */
	public void setInEffectiveDate(java.util.Date value) {
		this.inEffectiveDate = value;
	}
	
	
	
	/**
	 * 起效日期
	 */
     @WhereSQL(sql="inEffectiveDate=:Formula_inEffectiveDate")
	public java.util.Date getInEffectiveDate() {
		return this.inEffectiveDate;
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
     @WhereSQL(sql="active=:Formula_active")
	public java.lang.Integer getActive() {
		return this.active;
	}
	@Override
	public String toString() {
		return new StringBuilder()
			.append("id[").append(getId()).append("],")
			.append("名称[").append(getName()).append("],")
			.append("表达式的中文名称[").append(getChineseName()).append("],")
			.append("表达式[").append(getExpression()).append("],")
			.append("表达式的中文显示[").append(getChineseExpression()).append("],")
			.append("是否是系统变量,0是 1否[").append(getSysExpression()).append("],")
			.append("项目名称,用于区分不同项目的公式[").append(getProjectName()).append("],")
			.append("起效日期[").append(getInEffectiveDate()).append("],")
			.append("是否可用[").append(getActive()).append("],")
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
		if(obj instanceof Formula == false){
			return false;
		}
			
		if(this == obj){
			return true;
		}
		
		Formula other = (Formula)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

	
