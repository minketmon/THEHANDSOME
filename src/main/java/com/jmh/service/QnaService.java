package com.jmh.service;

import java.util.List;

import com.jmh.domain.QnaVO;
/* 작성자 : 고정민
 * QNA에 관련된 DB 호출을 관리하는 인터페이스
 */
public interface QnaService {
	
	// qna 작성 
	public void qnaPost(QnaVO qna) throws Exception;
	
	// qna 조회 
	public List<QnaVO> qnaGet(String mid, int pageNum, int amount) throws Exception;
	
	// qna 상세조회
	public QnaVO qnaGetDetail(int qid) throws Exception;
	
	// qna 수정
	public int qnaModify(QnaVO qna) throws Exception;
	
	// qna 삭제
	public void qnaDelete(int qid) throws Exception;
	
	// qna 총 개수 조회
	public int qnaTotal(String mid) throws Exception;

}//end int
