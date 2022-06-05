package com.jmh.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jmh.domain.QnaVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

/* 
* 작성자 : 고정민
* 
* QNA 상세 조회 JUnit 테스트
*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class QnaMapperTest4 {
	
	@Setter(onMethod_ = @Autowired)
	private QnaMapper mapper;
	
	@Test
	public void qnaDetailGetTest() throws Exception{
		
		log.info(mapper.qnaDetailGet(2));
		
	}
	
}//end class
