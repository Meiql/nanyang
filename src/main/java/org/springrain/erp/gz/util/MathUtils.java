package org.springrain.erp.gz.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.apache.commons.lang3.StringUtils;

public class MathUtils {

	/**
	 * 加法运算
	 * 
	 * @author zhangyv
	 * @param num1
	 *            加数
	 * @param num2
	 *            加数
	 */
	public static String add(String num1, String num2) {
		num1 = getNumberStr(num1);
		num2 = getNumberStr(num2);
		BigDecimal b1 = new BigDecimal(num1);
		BigDecimal b2 = new BigDecimal(num2);
		b1 = b1.add(b2);
		return getNumberStr(b1);
	}

	/**
	 * 加法运算四舍五入并保留两位小数
	 * 
	 * @author zhangyv
	 * @param num1
	 *            加数
	 * @param num2
	 *            加数
	 */
	public static String addScale(String num1, String num2) {
		return addScale(num1, num2, 2);
	}

	/**
	 * 加法运算四舍五入并保留相应小数位数
	 * 
	 * @author zhangyv
	 * @param num1
	 *            加数
	 * @param num2
	 *            加数
	 * @param scale
	 *            要保留的位数
	 */
	public static String addScale(String num1, String num2, int scale) {
		String sum = add(num1, num2);
		return formatNumber(sum, scale);
	}

	/**
	 * 减法运算
	 * 
	 * @author zhangyv
	 * @param num1
	 *            被减数
	 * @param num2
	 *            减数
	 */
	public static String sub(String num1, String num2) {
		num1 = getNumberStr(num1);
		num2 = getNumberStr(num2);
		BigDecimal b1 = new BigDecimal(num1);
		BigDecimal b2 = new BigDecimal(num2);
		b1 = b1.subtract(b2);
		return getNumberStr(b1);
	}

	/**
	 * 减法运算四舍五入并保留两位小数
	 * 
	 * @author zhangyv
	 * @param num1被
	 *            减数
	 * @param num2
	 *            减数
	 */
	public static String subScale(String num1, String num2) {
		return subScale(num1, num2, 2);
	}

	/**
	 * 减法运算四舍五入并保留相应小数位数
	 * 
	 * @author zhangyv
	 * @param num1
	 *            被减数
	 * @param num2
	 *            减数
	 * @param scale
	 *            要保留的位数
	 */
	public static String subScale(String num1, String num2, int scale) {
		String sub = sub(num1, num2);
		return formatNumber(sub, scale);
	}

	/**
	 * 乘法运算
	 * 
	 * @author zhangyv
	 * @param num1
	 *            乘数
	 * @param num2
	 *            乘数
	 */
	public static String mul(String num1, String num2) {
		num1 = getNumberStr(num1);
		num2 = getNumberStr(num2);
		BigDecimal b1 = new BigDecimal(num1);
		BigDecimal b2 = new BigDecimal(num2);
		b1 = b1.multiply(b2);
		return getNumberStr(b1);
	}

	/**
	 * 乘法运算四舍五入并保留两位小数
	 * 
	 * @author zhangyv
	 * @param num1
	 *            乘数
	 * @param num2
	 *            乘数
	 */
	public static String mulScale(String num1, String num2) {
		return mulScale(num1, num2, 2);
	}

	/**
	 * 乘法运算四舍五入并保留相应小数位数
	 * 
	 * @author zhangyv
	 * @param num1
	 *            乘数
	 * @param num2
	 *            乘数
	 * @param 要保留的位数
	 */
	public static String mulScale(String num1, String num2, int scale) {
		String mul = mul(num1, num2);
		return formatNumber(mul, scale);
	}

	/**
	 * 除法运算
	 * 
	 * @author zhangyv
	 * @param num1
	 *            被除数
	 * @param num2
	 *            除数
	 */
	public static String div(String num1, String num2) {
		num1 = getNumberStr(num1);
		num2 = getNumberStr(num2);
		BigDecimal b1 = new BigDecimal(num1);
		BigDecimal b2 = new BigDecimal(num2);
		try {
			b1 = b1.divide(b2, 50, BigDecimal.ROUND_HALF_UP);
			return getNumberStr(b1);
		} catch (Exception e) {
			return "0";
		}
	}

	/**
	 * 除法运算四舍五入并保留两位小数
	 * 
	 * @author zhangyv
	 * @param num1
	 *            被除数
	 * @param num2
	 *            除数
	 */
	public static String divScale(String num1, String num2) {
		return divScale(num1, num2, 2);
	}

	/**
	 * 除法运算四舍五入并保留相应小数位数
	 * 
	 * @author zhangyv
	 * @param num1
	 *            除数
	 * @param num2
	 *            被除数
	 * @param 要保留的位数
	 */
	public static String divScale(String num1, String num2, int scale) {
		String div = div(num1, num2);
		return formatNumber(div, scale);
	}

	/**
	 * 把一个数值类型的数四舍五入，并保留小数点后两位小数
	 * 
	 * @author zhangyv
	 * @param num
	 *            要四舍五入的数值
	 */
	public static String formatNumber(String num) {
		return formatNumber(num, 2);
	}

	/**
	 * 把一个数值类型的数四舍五入，并保留小数点后相应的位数
	 * 
	 * @author zhangyv
	 * @param num
	 *            要四舍五入的数值
	 * @param scale
	 *            小数点后要保留的位数
	 */
	public static String formatNumber(String num, Integer scale) {
		num = getNumberStr(num);
		BigDecimal numb = new BigDecimal(num);
		numb = numb.setScale(scale, BigDecimal.ROUND_HALF_UP);
		return getNumberStr(numb);
	}

	/**
	 * 格式化需要进行表达式运算的数值
	 * 
	 * @author zhangyu
	 * @param exp
	 * 
	 * @return String 返回带小括号，及科学技术法转为原始数值格式的数据 exp为空时，返回null
	 */
	public static String getStringNumberExecute(String numberVal) {
		if (StringUtils.isBlank(numberVal)) {
			return null;
		}
		return "(" + formatDecimal(numberVal) + ")";
	}

	/**
	 * 将double类型的科术计数法改为正常数值计数格式
	 * 
	 * @param args
	 */
	public static String getNumberStr(Double value) {
		if (value == null) {
			return null;
		}
		String valStr = value.toString();
		return getNumberStr(valStr);
	}

	/**
	 * 将String类型的科术计数法改为正常数值计数格式
	 * 
	 * @param args
	 */
	public static String getNumberStr(String value) {
		if (value == null) {
			return null;
		}
		String valStrClone = value;
		String valStr = value;
		if (valStr.contains("E")) {
			if (valStr.substring(0, 1).equals(("-"))) {
				// 为负数时去除负号
				valStr = valStr.substring(1);
			}
			// valStr = valStr.replaceAll("-", "");
			// 科学计数法时
			// 取出科学计数的指数
			int index = Integer.valueOf(valStr.substring(valStr.indexOf("E") + 1, valStr.length()));
			// valStr 去除E之后部分
			valStr = valStr.substring(0, valStr.indexOf("E"));
			// 去除"."
			valStr = valStr.replaceAll("\\.", "");
			// 除第一位后边还有多少位
			int digit = valStr.length() - 1;
			if (digit > index && index > 0) {
				// 指数小于底数的位数时，重新上小数点
				valStr = valStr.substring(0, index + 1) + "." + valStr.substring(index + 1, valStr.length());
			} else if (digit < index && index > 0) {
				// 指数大于底数的位数时
				// 相差位数
				int difference = index - digit;
				for (int i = 0; i < difference; i++) {
					valStr = valStr + "0";
				}
			} else if (digit > index && index < 0) {
				// 如果指数为负数，且
				index = 0 - index;
				for (int i = 0; i < index; i++) {
					if (index - i - 1 == 0) {
						// 最后一个时
						valStr = "0." + valStr;
					} else {
						valStr = "0" + valStr;
					}
				}
			}
			if (valStrClone.substring(0, 1).equals(("-"))) {
				// valStr = valStr.replaceAll("-", "");
				valStr = "-" + valStr;
			}
		}
		if (Double.valueOf(valStr) + 0.0 == 0) {
			valStr = "0";
		}
		return valStr;
	}

	/**
	 * 将BigDecimal类型的科术计数法改为正常数值计数格式
	 * 
	 * @param args
	 */
	public static String getNumberStr(BigDecimal value) {
		if (value == null) {
			return null;
		}
		String valStrClone = value.toString();
		return getNumberStr(valStrClone);
	}

	/**
	 * 对一个表示数值的字符串，进行格式化
	 * 
	 * @param value
	 *            指定的数值
	 * @param scale
	 *            小数保定位数
	 * @param type
	 *            舍入方式（取值 ："四舍五入","直接舍去","直接进位"）
	 * @return
	 */
	public static String formatNumber(String value, int scale, String type) {
		if (StringUtils.isBlank(value) || StringUtils.isBlank(type)
				|| (!"四舍五入".equals(type) && !"直接舍去".equals(type) && !"直接进位".equals(type))) {
			return null;
		}
		value = getNumberStr(value);
		BigDecimal valBD = new BigDecimal(value);
		if ("四舍五入".equals(type)) {
			valBD = valBD.setScale(scale, RoundingMode.HALF_UP);
		} else if ("直接舍去".equals(type)) {
			valBD = valBD.setScale(scale, RoundingMode.DOWN);
		} else if ("直接进位".equals(type)) {
			valBD = valBD.setScale(scale, RoundingMode.CEILING);
		}
		return valBD.toString();
	}

	/**
	 * 对一个数值，进行格式化
	 * 
	 * @param value
	 *            指定的数值
	 * @param scale
	 *            小数保定位数
	 * @param type
	 *            舍入方式（取值 ："四舍五入","直接舍去","直接进位"）
	 * @return
	 */
	public static Double formatNumber(Double doubleValue, int scale, String type) {
		if (doubleValue == null || StringUtils.isBlank(type)
				|| (!"四舍五入".equals(type) && !"直接舍去".equals(type) && !"直接进位".equals(type))) {
			return null;
		}
		String value = getNumberStr(doubleValue);
		value = formatNumber(value, scale, type);
		return Double.valueOf(value);
	}

	/**
	 * 对一个数值，进行格式化
	 * 
	 * @param value
	 *            指定的数值
	 * @param stringValue
	 *            指定情况时时进行保留小数操作 (0: 任何情况下 ,1: 小数位不精确时)
	 * @param scale
	 *            小数保定位数
	 * @param type
	 *            舍入方式（取值 ："四舍五入","直接舍去","直接进位"）
	 * @return
	 */
	public static String formatNumber(String stringValue, int scaleType, int scale, String type) {
		if (stringValue == null || StringUtils.isBlank(type)
				|| (!"四舍五入".equals(type) && !"直接舍去".equals(type) && !"直接进位".equals(type))) {
			return null;
		}
		String value = getNumberStr(stringValue);
		value = formatDecimal(value);
		if (scaleType - 0 == 0) {
			value = formatNumber(value, scale, type);
		} else if (scaleType - 1 == 0) {
			if (getDecimalDigits(value) - 10 >= 0) {
				value = formatNumber(value, scale, type);
			}
		}
		return value;
	}

	/**
	 * 获取小数位数
	 * 
	 * @param args
	 */
	public static int getDecimalDigits(String value) {
		if (value != null && value.contains(".")) {
			value = getNumberStr(value);
			return Integer.valueOf(value.length() - value.indexOf(".") - 1);
		} else {
			return 0;
		}
	}

	/**
	 * 去小数末尾边的0，同时如果是科学技术法（2.3E5）的格式，则格式化成普通格式（23000），
	 * 
	 * @param args
	 */
	public static String formatDecimal(String value) {
		value = getNumberStr(value);
		if (value != null && value.contains(".")) {
			for (int i = value.length() - 1; i >= 0; i--) {
				if ("0".equals(value.charAt(i) + "")) {
					value = value.substring(0, value.length() - 1);
				} else if (".".equals(value.charAt(i) + "")) {
					value = value.substring(0, value.length() - 1);
					return value;
				} else {
					return value;
				}
			}
			return value;
		} else {
			return value;
		}
	}

	/**
	 * 元到分 0位小数 四舍五入
	 * 
	 * @param money
	 * @return
	 */
	public static String formatYuan2Fen(BigDecimal money) {
		if (money == null) {
			return "0";
		}
		return formatNumber(money.multiply(BigDecimal.valueOf(100)).toString(), 0);
	}

}
