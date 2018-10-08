package org.springrain.erp.gz.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Hashtable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

/**
 * 全部静态变量类
 * 
 * @author wpl
 * 
 */
public class GlobalStaticVar {
	//字典类型标识
    public static final String dic_zctype="zctype";

	//公式表 工资项目名称
	public static  final String salary_projectName="salary";
    
    //（跟公式表中id匹配）属于内置公式不能修改
    public static final String f_id_shifupay="salary_shifupay";
    public static final String f_id_yingfupay="salary_yingfupay";
    public static final String f_id_taxbase="salary_taxbase";//个税基数
    public static final String f_id_geshui="salary_geshui";//个税
    public static final String f_id_tongchougjj="salary_tongchougjj";//统筹公积金
    public static final String f_id_sarlaryzengjian="salary_zengjian";//工资增减

 
    public static final String f_id_jibenpay="salay_jibenpay";
    public static final String f_id_kaohepay="salay_kaohepay";
    public static final String f_id_gangweipay="salay_gonglingpay";
    public static final String f_id_ondutydays="salary_ondutydays";
    public static final String f_id_monthdays="salary_monthdays";
    public static final String f_id_taxrate="salary_taxrate";
    public static final String f_id_taxshu="salary_taxshu";
    //日工资
    public static final String f_id_salaryDay="salary_day";
    //电话费补助
    public static final String f_id_mobilePay="N000011";


    //(工资查询的几个参数)
    public static final String salary_oper_all="all";//财务工资查询
    public static final String salary_oper_me="me";//员工工资查询
    public static final String salary_oper_send="Send";//生成查询
    public static final String salary_oper_gen="Gen";//发放查询
    public static final String salary_oper_leaveGen="leaveGen";//离职员工工资生成

	//是否停发工资
	public enum StoppayEnum {
		停发("是"), 正常("否");
		String state;

		private StoppayEnum(String state) {
			this.state = state;
		}

		public String getValue() {
			return state;
		}
	}
	//工资状态
	public enum SalaryStateEnum {
		未生成(1), 已生成(2), 已发放(3);
		Integer state;

		private SalaryStateEnum(Integer state) {
			this.state = state;
		}

		public Integer getValue() {
			return state;
		}
		public static String getName(Integer value){
			String name=null;
			if(value==未生成.getValue()){
				name=未生成.toString();
			}else if(value==已生成.getValue()){
				name=已生成.toString();
			}else if(value==已发放.getValue()){
				name=已发放.toString();
			}
			return name;
		}
	}
	//dic-->名称
		public enum dicKeyToName{
			xueli("学历"), placetype("地区类型"), minzu("民族"), bank("银行"), xxlx("学习类型"),worktype("用工方式")
			,contracttype("合同类型");
			String name;

			private dicKeyToName(String name) {
				this.name = name;
			}
			public static String findNameByKey(String key){
				if(key.equals(xueli.toString())){
					return dicKeyToName.xueli.name;
				}
				else if(key.equals(placetype.toString())){
					return dicKeyToName.placetype.name;
				}
				else if(key.equals(minzu.toString())){
					return dicKeyToName.minzu.name;
				}
				else if(key.equals(bank.toString())){
					return dicKeyToName.bank.name;
				}
				else if(key.equals(xxlx.toString())){
					return dicKeyToName.xxlx.name;
				}
				else {
					return "字典管理";
				}
				
			}
			public String getValue() {
				return name;
			}
		}
		/*********************************** 身份证验证开始 ****************************************/
		/**
		 * 身份证号码验证 1、号码的结构 公民身份号码是特征组合码，由十七位数字本体码和一位校验码组成。排列顺序从左至右依次为：六位数字地址码，
		 * 八位数字出生日期码，三位数字顺序码和一位数字校验码。 2、地址码(前六位数）
		 * 表示编码对象常住户口所在县(市、旗、区)的行政区划代码，按GB/T2260的规定执行。 3、出生日期码（第七位至十四位）
		 * 表示编码对象出生的年、月、日，按GB/T7408的规定执行，年、月、日代码之间不用分隔符。 4、顺序码（第十五位至十七位）
		 * 表示在同一地址码所标识的区域范围内，对同年、同月、同日出生的人编定的顺序号， 顺序码的奇数分配给男性，偶数分配给女性。 5、校验码（第十八位数）
		 * （1）十七位数字本体码加权求和公式 S = Sum(Ai * Wi), i = 0, ... , 16 ，先对前17位数字的权求和
		 * Ai:表示第i位置上的身份证号码数字值 Wi:表示第i位置上的加权因子 Wi: 7 9 10 5 8 4 2 1 6 3 7 9 10 5 8 4
		 * 2 （2）计算模 Y = mod(S, 11) （3）通过模得到对应的校验码 Y: 0 1 2 3 4 5 6 7 8 9 10 校验码: 1 0
		 * X 9 8 7 6 5 4 3 2
		 */
		/**
		 * 功能：身份证的有效验证
		 * 
		 * @param IDStr
		 *            身份证号
		 * @return 有效：返回"" 无效：返回String信息
		 * @throws ParseException
		 */
		@SuppressWarnings("restriction")
		public static String checkIDCard(String IDStr) throws ParseException {
			String errorInfo = "";// 记录错误信息
			String[] ValCodeArr = { "1", "0", "x", "9", "8", "7", "6", "5", "4",
					"3", "2" };
			String[] Wi = { "7", "9", "10", "5", "8", "4", "2", "1", "6", "3", "7",
					"9", "10", "5", "8", "4", "2" };
			String Ai = "";
			if (StringUtils.isBlank(IDStr)) {
				return "身份证号为空";
			}
			// ================ 号码的长度 15位或18位 ================
			if (IDStr.length() != 15 && IDStr.length() != 18) {
				errorInfo = "身份证号码长度应该为15位或18位。";
				return errorInfo;
			}
			// =======================(end)========================

			// ================ 数字 除最后以为都为数字 ================
			if (IDStr.length() == 18) {
				Ai = IDStr.substring(0, 17);
			} else if (IDStr.length() == 15) {
				Ai = IDStr.substring(0, 6) + "19" + IDStr.substring(6, 15);
			}
			if (isNumeric(Ai) == false) {
				errorInfo = "身份证15位号码都应为数字 ; 18位号码除最后一位外，都应为数字。";
				return errorInfo;
			}
			// =======================(end)========================

			// ================ 出生年月是否有效 ================
			String strYear = Ai.substring(6, 10);// 年份
			String strMonth = Ai.substring(10, 12);// 月份
			String strDay = Ai.substring(12, 14);// 月份
			if (isDate(strYear + "-" + strMonth + "-" + strDay) == false) {
				errorInfo = "身份证生日无效。";
				return errorInfo;
			}
			GregorianCalendar gc = new GregorianCalendar();
			SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
			try {
				if ((gc.get(Calendar.YEAR) - Integer.parseInt(strYear)) > 150
						|| (gc.getTime().getTime() - s.parse(
								strYear + "-" + strMonth + "-" + strDay).getTime()) < 0) {
					errorInfo = "身份证生日不在有效范围。";
					return errorInfo;
				}
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (java.text.ParseException e) {
				e.printStackTrace();
			}
			if (Integer.parseInt(strMonth) > 12 || Integer.parseInt(strMonth) == 0) {
				errorInfo = "身份证月份无效";
				return errorInfo;
			}
			if (Integer.parseInt(strDay) > 31 || Integer.parseInt(strDay) == 0) {
				errorInfo = "身份证日期无效";
				return errorInfo;
			}
			// =====================(end)=====================

			// ================ 地区码时候有效 ================
			@SuppressWarnings("rawtypes")
			Hashtable h = GetAreaCode();
			if (h.get(Ai.substring(0, 2)) == null) {
				errorInfo = "身份证地区编码错误。";
				return errorInfo;
			}
			// ==============================================

			// ================ 判断最后一位的值 ================
			int TotalmulAiWi = 0;
			for (int i = 0; i < 17; i++) {
				TotalmulAiWi = TotalmulAiWi
						+ Integer.parseInt(String.valueOf(Ai.charAt(i)))
						* Integer.parseInt(Wi[i]);
			}
			int modValue = TotalmulAiWi % 11;
			String strVerifyCode = ValCodeArr[modValue];
			Ai = Ai + strVerifyCode;

			if (IDStr.length() == 18) {
				if (Ai.equals(IDStr) == false) {
					errorInfo = "身份证无效，不是合法的身份证号码";
					return errorInfo;
				}
			} else {
				return "";
			}
			// =====================(end)=====================
			return "";
		}
		
		/**
		 * 功能：设置地区编码
		 * 
		 * @return Hashtable 对象
		 */
		@SuppressWarnings({ "unchecked", "rawtypes" })
		private static Hashtable GetAreaCode() {
			Hashtable hashtable = new Hashtable();
			hashtable.put("11", "北京");
			hashtable.put("12", "天津");
			hashtable.put("13", "河北");
			hashtable.put("14", "山西");
			hashtable.put("15", "内蒙古");
			hashtable.put("21", "辽宁");
			hashtable.put("22", "吉林");
			hashtable.put("23", "黑龙江");
			hashtable.put("31", "上海");
			hashtable.put("32", "江苏");
			hashtable.put("33", "浙江");
			hashtable.put("34", "安徽");
			hashtable.put("35", "福建");
			hashtable.put("36", "江西");
			hashtable.put("37", "山东");
			hashtable.put("41", "河南");
			hashtable.put("42", "湖北");
			hashtable.put("43", "湖南");
			hashtable.put("44", "广东");
			hashtable.put("45", "广西");
			hashtable.put("46", "海南");
			hashtable.put("50", "重庆");
			hashtable.put("51", "四川");
			hashtable.put("52", "贵州");
			hashtable.put("53", "云南");
			hashtable.put("54", "西藏");
			hashtable.put("61", "陕西");
			hashtable.put("62", "甘肃");
			hashtable.put("63", "青海");
			hashtable.put("64", "宁夏");
			hashtable.put("65", "新疆");
			hashtable.put("71", "台湾");
			hashtable.put("81", "香港");
			hashtable.put("82", "澳门");
			hashtable.put("91", "国外");
			return hashtable;
		}
		/**
		 * 功能：判断字符串是否为数字
		 * 
		 * @param str
		 * @return
		 */
		private static boolean isNumeric(String str) {
			Pattern pattern = Pattern.compile("[0-9]*");
			Matcher isNum = pattern.matcher(str);
			if (isNum.matches()) {
				return true;
			} else {
				return false;
			}
		}
		/**
		 * 功能：判断字符串是否为日期格式
		 * 
		 * @param str
		 * @return
		 */
		public static boolean isDate(String strDate) {
			Pattern pattern = Pattern
					.compile("^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))(\\s(((0?[0-9])|([1-2][0-3]))\\:([0-5]?[0-9])((\\s)|(\\:([0-5]?[0-9])))))?$");
			Matcher m = pattern.matcher(strDate);
			if (m.matches()) {
				return true;
			} else {
				return false;
			}
		}

		/*********************************** 身份证验证结束 ****************************************/
}
