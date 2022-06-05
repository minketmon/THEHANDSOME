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
 * 작성자 : 고정민
 * 
 * 멤버 컨트롤러 JUnit 테스트
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({ "file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml" })
@Log4j
public class MemberControllerTest {

	@Setter(onMethod_ = { @Autowired })
	private WebApplicationContext ctx;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}// end setup

	// 회원 가입 테스트
	@Test
	public void testJoin() throws Exception {
		log.info(
				mockMvc.perform(
				MockMvcRequestBuilders.post("/member/joininfoform")
				.param("mid","abc@naver.com")
				.param("mpassword", "abc")
				.param("mname", "ABC")
				.param("memail", "abc@naver.com")
				.param("mtel", "01000000000")
				.param("mzipcode", "11111")
				.param("maddress1", "gfddfgfds")
				.param("maddress2", "sdfasd")
				.param("mbirth", "1998206"))
				.andReturn()
				.getModelAndView()
				.getModelMap()
				);
		
	}//end testList

	// 중복확인 테스트
	@Test
	public void testIdCheck() throws Exception {
		log.info(mockMvc.perform(MockMvcRequestBuilders.post("/member/idCheck").param("mid", "user00")).andReturn()
				.getModelAndView());

	}// end testList

	// 로그인 테스트
	@Test
	public void testLogin() throws Exception {
		log.info(mockMvc.perform(MockMvcRequestBuilders.post("/member/login")
				.param("mid", "user00")
				.param("mpassword", "pw00")).andReturn()
				.getModelAndView());

	}// end testList
	
	// 로그아웃 테스트
	@Test
	public void testLogout() throws Exception {
		log.info(mockMvc.perform(MockMvcRequestBuilders.get("/member/logout"))
				.andReturn());
	}

}// end class
