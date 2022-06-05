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
* 로그인 JUnit 테스트
*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class MemberMapperTest3 {
	
	@Setter(onMethod_ = @Autowired)
	private MemberMapper mapper;
	
	@Test
	public void memberLogin() throws Exception{
		MemberVO member = new MemberVO();
		
		member.setMid("test05@naver.com");
		//member.setMpassword("test");
		member.setMpassword("wrongpw");
		mapper.memberLogin(member);
		System.out.println("결과 값 : " + mapper.memberLogin(member));
	}
	
}//end class
