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
* 회원가입 JUnit 테스트
*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class QnaMapperTest6 {
	
	@Setter(onMethod_ = @Autowired)
	private QnaMapper mapper;
	
	@Test
	public void qnaTotal() throws Exception{
		MemberVO member = new MemberVO();
		
		member.setMid("test01");
		
		mapper.qnaTotal(member.getMid());
	}
	
}//end class
