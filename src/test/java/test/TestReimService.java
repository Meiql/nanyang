package test;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springrain.erp.constants.DicdataTypeEnum;
import org.springrain.erp.gz.entity.Formula;
import org.springrain.erp.gz.service.IFormulaService;
import org.springrain.erp.gz.service.ISalaryService;
import org.springrain.erp.hr.service.IOaOrgService;
import org.springrain.erp.hr.service.IOaUserService;
import org.springrain.erp.hr.service.IUserInfoBakService;
import org.springrain.frame.shiro.RedisShiroSessionDao;
import org.springrain.frame.shiro.ShiroRedisCache;
import org.springrain.frame.shiro.ShiroRedisCacheManager;
import org.springrain.frame.util.DateUtils;
import org.springrain.frame.util.Finder;
import org.springrain.system.entity.DicData;
import org.springrain.system.service.IDicDataService;
import org.springrain.system.service.ITableindexService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TestReimService {
	@Resource
	ISalaryService salaryService;
	ITableindexService tableindexService;
	@Resource
	IFormulaService formulaService;
	@Resource
	IDicDataService dicDateService;
	@Resource
	IOaOrgService oaOrgService;
	// @Resource
	// org.apache.shiro.mgt.SecurityManager securityManager;
	@Resource
	IUserInfoBakService userInfoBakService;
	@Resource
	IOaUserService oaUserService;

	@Test
	public void genUserInfo() throws Exception {
		// 测试人员备份生成
		try {
			Date indate = DateUtils.convertString2Date("2017-07-01");
			userInfoBakService.saveUserInfoBak(indate);
			salaryService.saveGenUserInfo(indate,null);
//			salaryService.saveGenSalary(null, indate);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	
	}


	@Test
	public void syncgzcode() throws Exception {
		//同步公式code
		Finder f = Finder.getSelectFinder(Formula.class);
		List<Formula> list = formulaService.queryForList(f, Formula.class);
		for (Formula la : list) {
			if (StringUtils.isBlank(la.getChineseExpression())) {
				continue;
			}
			String expressionCode = formulaService.cvtChineseExpress2code(la.getChineseExpression());
			la.setExpressionCode(expressionCode);
			formulaService.update(la);
		}
	}
	
	@Test
	public void updateExpression() throws Exception {
		//同步公式code
		String expressionCode = formulaService.cvtChineseExpress2code("应付工资-个税");
		String expression = formulaService.getFormulaExpressionByChineseExpression(expressionCode, "salary");
		System.out.println(expression);
		
		
	}

	@Test
	public void tihuanId() throws Exception {
		List<DicData> tongchouList = dicDateService.findListDicData(DicdataTypeEnum.工资增减项类型.getValue(), null, null);
		if (CollectionUtils.isNotEmpty(tongchouList)) {
			for (DicData tongchou : tongchouList) {
				if (!tongchou.getId().startsWith("N")) {
					String oldId = tongchou.getId();
					String id = tableindexService.updateNewIdSix(DicData.class);
					Formula formula = formulaService.findFormulaById(tongchou.getId());
					tongchou.setId(id);
					formula.setId(id);
					Finder finder = Finder.getUpdateFinder(DicData.class, "id = :id ").setParam("id", id);
					finder.append(" where id = :oldId ").setParam("oldId", oldId);
					Finder ffinder = Finder.getUpdateFinder(Formula.class, "id = :id ").setParam("id", id);
					ffinder.append(" where id = :oldId ").setParam("oldId", oldId);
					dicDateService.update(finder);
					formulaService.update(ffinder);
				}
			}
		}
	}
	
	@Test
	public void synOa()throws Exception{
		try {
			oaUserService.saveOaMsg();
//			oaUserService.saveOaUserForsyn();
			System.out.println("成功");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	@Test
	public void testSynOaOrg() throws Exception{
		try {
			oaOrgService.updateSynOaOrg();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test 
	public void testCache(){
//		RedisCachedImpl ca=new RedisCachedImpl();
//		ca.setRedisTemplate(redisTemplate);
//		try {
//			ca.updateCached("openId".getBytes(), "111".getBytes(), 9999L);
//			System.out.println(ca.getKeys("openId".getBytes()));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		try {
		    dicDateService.getCache("wxname").put("id111", "66666");
		    System.out.println(dicDateService.getCache("wxname").get("id111").get());
		} catch (Exception e) {
		    e.printStackTrace();
	    }
		
	   
	}
}