package com.jmh.controller;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
/*
 * 작성자 : 변민혁
 * 
 * 상품 리스트 컨트롤러 JUnit 테스트
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml",
	"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
@Log4j
public class ListControllerTest {
	
	@Setter(onMethod_ = {@Autowired})
	private WebApplicationContext ctx;
		
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();		
	}//end setup
	
	@Test
	public void testList() throws Exception {
		log.info(
				mockMvc.perform(
				MockMvcRequestBuilders.get("/list"))
				.andReturn()
				.getModelAndView()
				.getModelMap()
				);
		
	}//end testList
	
	@Test
	public void testGet() throws Exception {
		log.info(
				mockMvc.perform(
				MockMvcRequestBuilders.get("/list")
				.param("bno", "15"))
				.andReturn()
				.getModelAndView()
				.getModelMap()
				);
		
	}//end testGet
	
	@Test
	public void testListPaging() throws Exception {
		log.info(mockMvc.perform(
				MockMvcRequestBuilders.get("/list")
				.param("pageNum", "2")
				.param("amount", "10"))
				.andReturn().getModelAndView().getModelMap());
	}
	

}//end class
