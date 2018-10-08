package  org.springrain.erp.zc.web;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springrain.erp.zc.entity.Zichan;
import org.springrain.erp.zc.entity.ZichanRecord;
import org.springrain.erp.zc.service.IZichanRecordService;
import org.springrain.erp.zc.service.impl.ZichanLingyongImportService;
import org.springrain.frame.common.SessionUser;
import org.springrain.frame.controller.BaseController;
import org.springrain.frame.util.GlobalStatic;
import org.springrain.frame.util.Page;
import org.springrain.frame.util.ReturnDatas;
import org.springrain.frame.util.property.MessageUtils;


/**
 * TODO 在此加入类描述
 * @copyright {@link weicms.net}
 * @author springrain<Auto generate>
 * @version  2017-08-14 09:45:09
 * @see org.springrain.erp.zc.web.ZichanRecord
 */
@Controller
@RequestMapping(value="/zichanrecord")
public class ZichanRecordController  extends BaseController {
	@Resource
	private IZichanRecordService zichanRecordService;
	@Resource
	private ZichanLingyongImportService zichanLingyongImportService;
	
	private String listurl="/erp/zc/zichanrecord/zichanrecordList";
	
	
	   
	/**
	 * 列表数据,调用listjson方法,保证和app端数据统一
	 * 
	 * @param request
	 * @param model
	 * @param zichanRecord
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list/{isadmin}")
	public String list(HttpServletRequest request,@PathVariable String isadmin, Model model,ZichanRecord zichanRecord) 
			throws Exception {
		if(zichanRecord==null){
			zichanRecord=new ZichanRecord();
		}
		zichanRecord.setIsAdmin(isadmin); 
		ReturnDatas returnObject = listjson(request, model, zichanRecord);
		model.addAttribute(GlobalStatic.returnDatas, returnObject);
		return listurl;
	}
	
	/**
	 * json数据,为APP提供数据
	 * 
	 * @param request
	 * @param model
	 * @param zichanRecord
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list/json")
	@ResponseBody   
	public  ReturnDatas listjson(HttpServletRequest request, Model model,ZichanRecord zichanRecord) throws Exception{
		ReturnDatas returnObject = ReturnDatas.getSuccessReturnDatas();
		// ==构造分页请求
		Page page = newPage(request);
		// ==执行分页查询
		List<ZichanRecord> datas=zichanRecordService.findListDataByFinder(null,page,ZichanRecord.class,zichanRecord);
			returnObject.setQueryBean(zichanRecord);
		returnObject.setPage(page);
		returnObject.setData(datas);
		return returnObject;
	}
	
	@RequestMapping("/list/{isadmin}/export")
	public void listexport(HttpServletRequest request,@PathVariable String isadmin,HttpServletResponse response, Model model,ZichanRecord zichanRecord) throws Exception{
		// ==构造分页请求
		Page page = newPage(request);
		if(zichanRecord==null){
			zichanRecord=new ZichanRecord();
		}
		zichanRecord.setIsAdmin(isadmin);
		File file = zichanRecordService.findDataExportExcel(null,listurl, page,ZichanRecord.class,zichanRecord);
		String fileName="zichanRecord"+GlobalStatic.excelext;
		downFile(response, file, fileName,true);
		return;
	}
	
		/**
	 * 查看操作,调用APP端lookjson方法
	 */
	@RequestMapping(value = "/look")
	public String look(Model model,HttpServletRequest request,HttpServletResponse response)  throws Exception {
		ReturnDatas returnObject = lookjson(model, request, response);
		model.addAttribute(GlobalStatic.returnDatas, returnObject);
		return "/zc/zichanrecord/zichanrecordLook";
	}

	
	/**
	 * 查看的Json格式数据,为APP端提供数据
	 */
	@RequestMapping(value = "/look/json")
	@ResponseBody      
	public ReturnDatas lookjson(Model model,HttpServletRequest request,HttpServletResponse response) throws Exception {
		ReturnDatas returnObject = ReturnDatas.getSuccessReturnDatas();
		java.lang.String id=request.getParameter("id");
		if(StringUtils.isNotBlank(id)){
		  ZichanRecord zichanRecord = zichanRecordService.findZichanRecordById(id);
		   returnObject.setData(zichanRecord);
		}else{
		returnObject.setStatus(ReturnDatas.ERROR);
		}
		return returnObject;
		
	}
	
	
	/**
	 * 新增/修改 操作吗,返回json格式数据
	 * 
	 */
	@RequestMapping("/update")
	@ResponseBody      
	public ReturnDatas saveorupdate(Model model,ZichanRecord zichanRecord,HttpServletRequest request,HttpServletResponse response) throws Exception{
		ReturnDatas returnObject = ReturnDatas.getSuccessReturnDatas();
		returnObject.setMessage(MessageUtils.UPDATE_SUCCESS);
		try {
		
			java.lang.String id =zichanRecord.getId();
			if(StringUtils.isBlank(id)){
			  zichanRecord.setId(null);
			}
		
			zichanRecordService.saveorupdate(zichanRecord);
			
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			returnObject.setStatus(ReturnDatas.ERROR);
			returnObject.setMessage(MessageUtils.UPDATE_ERROR);
		}
		return returnObject;
	
	}
	
	/**
	 * 进入修改页面,APP端可以调用 lookjson 获取json格式数据
	 */
	@RequestMapping(value = "/update/pre")
	public String updatepre(Model model,HttpServletRequest request,HttpServletResponse response)  throws Exception{
		ReturnDatas returnObject = lookjson(model, request, response);
		model.addAttribute(GlobalStatic.returnDatas, returnObject);
		return "/zc/zichanrecord/zichanrecordCru";
	}
	
	/**
	 * 删除操作
	 */
	@RequestMapping(value="/delete")
	@ResponseBody      
	public  ReturnDatas delete(HttpServletRequest request) throws Exception {

			// 执行删除
		try {
		java.lang.String id=request.getParameter("id");
		if(StringUtils.isNotBlank(id)){
				zichanRecordService.deleteById(id,ZichanRecord.class);
				return new ReturnDatas(ReturnDatas.SUCCESS,MessageUtils.DELETE_SUCCESS);
			} else {
				return new ReturnDatas(ReturnDatas.WARNING,MessageUtils.DELETE_WARNING);
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return new ReturnDatas(ReturnDatas.WARNING, MessageUtils.DELETE_WARNING);
	}
	
	/**
	 * 删除多条记录
	 * 
	 */
	@RequestMapping("/delete/more")
	@ResponseBody      
	public ReturnDatas deleteMore(HttpServletRequest request, Model model) {
		String records = request.getParameter("records");
		if(StringUtils.isBlank(records)){
			 return new ReturnDatas(ReturnDatas.ERROR,MessageUtils.DELETE_ALL_FAIL);
		}
		String[] rs = records.split(",");
		if (rs == null || rs.length < 1) {
			return new ReturnDatas(ReturnDatas.ERROR,MessageUtils.DELETE_NULL_FAIL);
		}
		try {
			List<String> ids = Arrays.asList(rs);
			zichanRecordService.deleteByIds(ids,ZichanRecord.class);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return new ReturnDatas(ReturnDatas.ERROR,MessageUtils.DELETE_ALL_FAIL);
		}
		return new ReturnDatas(ReturnDatas.SUCCESS,MessageUtils.DELETE_ALL_SUCCESS);
		
		
	}
	
	/**
	 * 下载模板
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @throws Exception
	 */
	@RequestMapping("/ajax/downMoban")
	public void downloadmoban(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		String userId = SessionUser.getUserId();
		if (StringUtils.isBlank(userId)) {
			return;
		}
		String path = "/WEB-INF/tmpl/zichanlingyongImport.xls";
		String filePath = request.getSession().getServletContext().getRealPath("/");
		File file = new File(filePath + path);
		super.downFile(response, file, "资产领用导入模板.xls", false);
	}

	/**
	 * 导入资产
	 * 
	 * @param uploadfile
	 * @param request
	 * @param model
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/import")
	public @ResponseBody ReturnDatas upload(@RequestParam("uploadfile") MultipartFile uploadfile,
			HttpServletRequest request, Model model, HttpServletResponse response) throws Exception {
		ReturnDatas rd = ReturnDatas.getSuccessReturnDatas();
		ZichanLingyongImportService.map = new HashMap<String, Zichan>();
		String msg = zichanLingyongImportService.importExcel(uploadfile, ZichanLingyongImportService.titles, request);
		if (StringUtils.isNotBlank(msg)) {
			rd.setStatus(ReturnDatas.ERROR);
			rd.setMessage(msg);
			return rd;
		} else {
			rd.setMessage("导入成功!");
		}
		return rd;
	}

}
