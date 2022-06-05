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
 * 마이페이지 컨트롤러 JUnit 테스트
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({ "file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml" })
@Log4j
public class MypageControllerTest {

	@Setter(onMethod_ = { @Autowired })
	private WebApplicationContext ctx;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}// end setup

	// 개인 정보 변경 테스트
//	@Test
//	public void testInfoChange() throws Exception {
//		log.info(
//				mockMvc.perform(
//				MockMvcRequestBuilders.post("/mypage/personInformationChange")
//				.param("mid","abc@naver.com")
//				.param("mpassword", "abccccc")
//				.param("mtel", "01000000000")
//				.param("mzipcode", "11111")
//				.param("maddress1", "gfddfgfds")
//				.param("maddress2", "sdfasd")
//				.param("mbirth", "1998206"))
//				.andReturn()
//				);
//		
//	}//end testList

	// 회원 탈퇴 테스트
//	@Test
//	public void testWithDrawal() throws Exception {
//		log.info(mockMvc.perform(MockMvcRequestBuilders.post("/mypage/memberWithdrawal").param("mid", "test02")).andReturn());
//
//	}// end testList

	// QNA 작성 테스트
//	@Test
//	public void testQNA() throws Exception {
//		log.info(mockMvc.perform(MockMvcRequestBuilders.post("/mypage/QNA")
//				.param("qtitle", "테스트 제목")
//				.param("qcontent", "테스트 내용")).andReturn());
//
//	}// end testList
	
	@Test
	public void testQNAGET() throws Exception{
			log.info(mockMvc.perform(MockMvcRequestBuilders.get("mypage/QNAList")
					.param("mid", "user00")
					.param("pageNum", "1")
					.param("amount", "10"))
					.andReturn());
	}
//	
	// 파일 조회
//	@Test
//	public void testDisplay() throws Exception {
//		log.info(mockMvc.perform(MockMvcRequestBuilders.get("/mypage/display")
//				.param("fileName", "user00"))
//				.andReturn());
//	}
	
	// QNA 수정
	@Test
	public void testModifyQNA() throws Exception {
		log.info(mockMvc.perform(MockMvcRequestBuilders.post("/mypage/modifyQNA")
				.param("mid", "user00")
				.param("qtitle", "1")
				.param("qcontent", "10"))
				.andReturn());
	}

	// QNA 삭제 
	@Test
	public void testDeleteQNA() throws Exception {
		log.info(mockMvc.perform(MockMvcRequestBuilders.post("/mypage/deleteQNA")
				.param("qid", "1"))
				.andReturn());
	}
}// end class
