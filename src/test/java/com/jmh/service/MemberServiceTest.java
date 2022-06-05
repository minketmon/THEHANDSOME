package com.jmh.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jmh.domain.MemberVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

/* 
* 작성자 : 고정민
* 
* MemberService JUnit 테스트
*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class MemberServiceTest {
	
	@Setter(onMethod_ = {@Autowired})
	private MemberService service;
	
//	@Test
//	public void testRegister() throws Exception {
//		MemberVO member = new MemberVO();
//		
//		member.setMid("test10");
//		member.setMpassword("pw10");
//		member.setMemail("test01@naver.com");
//		member.setMname("테스트");
//		member.setMtel("01011111111");
//		member.setMzipcode("12200");
//		member.setMaddress1("테스트 주소1");
//		member.setMaddress2("테스트 주소2");
//		member.setMbirth("19981026");
//		
//		service.memberJoin(member);
//	}//end test
	
//	@Test
//	public void idCheckTest() throws Exception {
//		String _mid = "test01";
//		
//		log.info(service.idCheck(_mid));
//	}
	
	@Test
	public void loginTest() throws Exception {
		MemberVO member = new MemberVO();
		member.setMid("test10");
		member.setMpassword("pw10");
		
		log.info(service.memberLogin(member));
	}
	
	@Test
	public void modifyTest() throws Exception {
		MemberVO member = new MemberVO();
		
		member.setMid("test10");
		member.setMpassword("pw01");
		member.setMtel("01022222222");
		member.setMzipcode("12200");
		member.setMaddress1("테스트 주소1");
		member.setMaddress2("테스트 주소2");
		member.setMbirth("19981026");
		
		log.info(service.modifyInfo(member));
	}

	@Test
	public void withdrawalTest() throws Exception {
		MemberVO member = new MemberVO();
		
		member.setMid("test01");
		log.info(service.memberWithdrawal(member));
	}
}//end clas
