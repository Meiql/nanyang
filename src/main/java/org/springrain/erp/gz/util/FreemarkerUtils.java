package org.springrain.erp.gz.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springrain.frame.util.SpringUtils;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

/**
 * freemarker模板工具类
 * 
 * @author 李国江
 * @date 2010-1-28
 */
public class FreemarkerUtils {
	private static Logger log =LoggerFactory.getLogger(FreemarkerUtils.class);
	private static String charsetName = "UTF-8";
	//@Resource
	public static FreeMarkerConfigurer freeMarkerConfigurer = null;

	static{
		freeMarkerConfigurer = (FreeMarkerConfigurer) SpringUtils.getBean("freeMarkerConfigurer");
	}
	
	private FreemarkerUtils() {
	}

	public static void execute(File ftlFile, String distFilePath,
			Map<String, Object> data) throws TemplateException, IOException {
		File packageFile = new File(distFilePath).getParentFile();
		if (!packageFile.exists()) {
			packageFile.mkdirs();
		}
		Template template = createTemplate(ftlFile);
		// 定义输入文件，默认生成在工程根目录
		Writer out = new OutputStreamWriter(new FileOutputStream(distFilePath),
				charsetName);
		// 最后开始生成
		template.process(data, out);
		out.toString();
	}

	public static String execute(String ftlurl, Map<String, Object> data)
			throws TemplateException, IOException {
		StringWriter sw = new StringWriter();
//		Template template =  createTemplate(ftlFile);
		Template template = freeMarkerConfigurer.getConfiguration().getTemplate(ftlurl);
		template.process(data, sw);
		return sw.toString();
	}

	
	public static Template createTemplate(File ftlFile) throws IOException {
		Configuration cfg = new Configuration();

		// 加载freemarker模板文件
		cfg.setDirectoryForTemplateLoading(ftlFile.getParentFile());
		cfg.setClassicCompatible(true);
		cfg.setDateFormat("yyyy-MM-dd");
		cfg.setNumberFormat("");
		cfg.setDefaultEncoding("utf-8");
		// 设置对象包装器
		cfg.setObjectWrapper(new DefaultObjectWrapper());

		// 设计异常处理器
		cfg.setTemplateExceptionHandler(TemplateExceptionHandler.IGNORE_HANDLER);

		// 获取指定模板文件
		Template template = cfg.getTemplate(ftlFile.getName());

		return template;
	}

}
