package com.jmh.service;

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
* QnaService JUnit 테스트
*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class QnaServiceTest {
	
	@Setter(onMethod_ = {@Autowired})
	private QnaService service;
	
	@Test
	public void testQnaPost() throws Exception {
		QnaVO qna = new QnaVO();
		qna.setMid("test01");
		qna.setQcontent("내용 ㅇㅇㅇㅇ");
		qna.setQtitle("제목 ㅇㅇㅇㅇ");
		qna.setQnaimg("ddddd");
		qna.setQnathumimg("ddddddd");
		
		service.qnaPost(qna);
	}

	@Test
	public void testQnaGet() throws Exception {
		log.info(service.qnaGet("test03", 1, 10));
	}
	
	@Test
	public void testQnaDetailGet() throws Exception {
		log.info(service.qnaGetDetail(1));
		
	}
	
	@Test
	public void testQnaModify() throws Exception {
		QnaVO qna = new QnaVO();
		qna.setMid("test01");
		qna.setQcontent("내용 ㅇㅇㅇㅇ");
		qna.setQtitle("제목 ㅇㅇㅇㅇ");
		qna.setQnaimg("ddddd");
		qna.setQnathumimg("ddddddd");
		log.info(service.qnaModify(qna));
	}
	
	@Test
	public void testQnaDelete() throws Exception {
		service.qnaDelete(1);
		log.info("삭제되었습니다");
	}
	
	@Test
	public void testQnaTotal() throws Exception {
		log.info(service.qnaTotal("test03@naver.com"));
	}
	
}//end clas
