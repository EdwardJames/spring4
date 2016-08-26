package com.test.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.entity.TestEntity;
import com.test.service.TestService;



@Controller
@RequestMapping("/index")
public class IndexController {
	@Autowired 
	private TestService  testService;
	
	
	static   Logger logger  =  Logger.getLogger(IndexController. class );
	//对于远程接口的调�??
	@RequestMapping("/testPage")
	public String indexPage(HttpServletRequest request , HttpServletResponse response , Model model) {
		logger.info("打印出logger info日志");
		logger.error("打印出logger异常信息");
		System.out.println("===");
		TestEntity testEntity  = new TestEntity();
		int num = testService.getCountForAllListByPage(testEntity);
		System.out.println(num);
		
//		TestEntity testEntity = new TestEntity();
//		PageVo<TestEntity> pageVo = new PageVo<TestEntity>();
//		Integer count = testService.getCountForAllListByPage(testEntity);
//		System.out.println(count);
//		pageVo =  testService.getAllListByPage(pageVo, testEntity);
		model.addAttribute("index", "success");
		
//		model.addAttribute("testResult",pageVo.getVoList());
		return "test/testPage";
	}
	
	
}
