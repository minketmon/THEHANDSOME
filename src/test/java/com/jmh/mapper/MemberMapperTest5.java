package com.jmh.mapper;

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
* 회원정보 변경 JUnit 테스트
*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class MemberMapperTest5 {
	
	@Setter(onMethod_ = @Autowired)
	private MemberMapper mapper;
	
	@Test
	public void modifyInfo() throws Exception{
		MemberVO member = new MemberVO();
		
		member.setMid("test05@naver.com");
		member.setMpassword("ssss");
		member.setMzipcode("22222");
		member.setMaddress2("modify 테스트");
		member.setMaddress1("테스트 주소1");
		member.setMtel("01000000000");
		mapper.modifyInfo(member);
	}
	
}//end class
