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
* QNA 수정 JUnit 테스트
*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class QnaMapperTest3 {
	
	@Setter(onMethod_ = @Autowired)
	private QnaMapper mapper;
	
	@Test
	public void qnaModifyTest() throws Exception{
		QnaVO qna = new QnaVO();
		
		qna.setQtitle("junit테스트 제목 ");
		qna.setQcontent("junit테스트 내용");
		qna.setQid(2);
		int count = mapper.qnaModify(qna);
		log.info("Update COUNT" + count);
//		log.info(mapper.qnaModify(qna));
		
	}
	
}//end class
