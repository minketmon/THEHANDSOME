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

import lombok.extern.log4j.Log4j;
/*
 * 작성자 : 문혁
 * 
 * 메인페이지 리스트 컨트롤러 JUnit 테스트
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml",
	"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
@Log4j
public class MainListControllerTest {
	
	@Autowired
	private WebApplicationContext ctx;
		
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();		
	}//end setup
	
	@Test
	public void testGetProduct() throws Exception {
		log.info(
				mockMvc.perform(
				MockMvcRequestBuilders.get("/ko/intro/mainNewProductList")
				.param("categoryCode", "WE"))
				.andReturn());
		
	}//end testGetProduct
	
	@Test
	public void testGetCategory() throws Exception {
		log.info(
				mockMvc.perform(
				MockMvcRequestBuilders.get("/ko/intro/mainCategoryList")
				)
				.andReturn());
		
	}//end testGetMagazine
	
	@Test
	public void testGetMagazine() throws Exception {
		log.info(
				mockMvc.perform(
				MockMvcRequestBuilders.get("/ko/intro/mainMagazine")
				)
				.andReturn());
		
	}//end testGetMagazine
}//end class
