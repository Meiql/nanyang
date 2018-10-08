package org.springrain.erp.gz.entity;

import java.util.Calendar;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springrain.frame.annotation.NotLog;
import org.springrain.frame.annotation.TableSuffix;
import org.springrain.frame.annotation.WhereSQL;
import org.springrain.frame.entity.BaseEntity;
import org.springrain.frame.util.GlobalStatic;
/**
 * 公式数据表 分表 每年一张
 * @copyright {@link weicms.net}
 * @author springrain<Auto generate>
 * @version  2017-07-03 17:32:15
 * @see org.springrain.erp.gz.entity.FormulaData
 */
@Table(name="z_formula_data")
@TableSuffix(name="ext")
@NotLog
public class FormulaData  extends BaseEntity {
	
	private static final long serialVersionUID = 1L;

	//alias
	/*
	public static final String TABLE_ALIAS = "业务公式数据";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_BUSINESSID = "业务ID";
	public static final String ALIAS_FORMULAID = "公式ID";
	public static final String ALIAS_PROJECTNAME = "项目ID";
	public static final String ALIAS_AMOUNT = "金额";
    */
	//date formats
	
	//columns START
	/**
	 * id
	 */
	private java.lang.String id;
	/**
	 * 业务ID
	 */
	private java.lang.String businessId;
	/**
	 * 公式ID
	 */
	private java.lang.String formulaId;
	/**
	 * 项目ID
	 */
	private java.lang.String projectName;
	/**
	 * 金额
	 */
	private java.math.BigDecimal amount;
	//columns END 数据库字段结束
	
	
	private String ext;
	
	//concstructor

	public FormulaData(){
	}

	public FormulaData(
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
     @WhereSQL(sql="id=:FormulaData_id")
	public java.lang.String getId() {
		return this.id;
	}
		/**
		 * 业务ID
		 */
	public void setBusinessId(java.lang.String value) {
		    if(StringUtils.isNotBlank(value)){
			 value=value.trim();
			}
		this.businessId = value;
	}
	
	
	
	/**
	 * 业务ID
	 */
     @WhereSQL(sql="businessId=:FormulaData_businessId")
	public java.lang.String getBusinessId() {
		return this.businessId;
	}
		/**
		 * 公式ID
		 */
	public void setFormulaId(java.lang.String value) {
		    if(StringUtils.isNotBlank(value)){
			 value=value.trim();
			}
		this.formulaId = value;
	}
	
	
	
	/**
	 * 公式ID
	 */
     @WhereSQL(sql="formulaId=:FormulaData_formulaId")
	public java.lang.String getFormulaId() {
		return this.formulaId;
	}
		/**
		 * 项目ID
		 */
	public void setProjectName(java.lang.String value) {
		    if(StringUtils.isNotBlank(value)){
			 value=value.trim();
			}
		this.projectName = value;
	}
	
	
	
	/**
	 * 项目ID
	 */
     @WhereSQL(sql="projectName=:FormulaData_projectName")
	public java.lang.String getProjectName() {
		return this.projectName;
	}
		/**
		 * 金额
		 */
	public void setAmount(java.math.BigDecimal value) {
		this.amount = value;
	}
	
	
	
	/**
	 * 金额
	 */
     @WhereSQL(sql="amount=:FormulaData_amount")
	public java.math.BigDecimal getAmount() {
		return this.amount;
	}
	@Override
	public String toString() {
		return new StringBuilder()
			.append("id[").append(getId()).append("],")
			.append("业务ID[").append(getBusinessId()).append("],")
			.append("公式ID[").append(getFormulaId()).append("],")
			.append("项目ID[").append(getProjectName()).append("],")
			.append("金额[").append(getAmount()).append("],")
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
		if(obj instanceof FormulaData == false){
			return false;
		}
			
		if(this == obj){
			return true;
		}
		
		FormulaData other = (FormulaData)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
	
	@Transient
	public String getExt() {
		if(StringUtils.isBlank(ext)){
			int year= Calendar.getInstance().get(Calendar.YEAR);
			this.ext= GlobalStatic.tableSuffix + year;
		}
			return ext;
	}

	public void setExt(String ext) {
		this.ext = ext;
	}
}

	
