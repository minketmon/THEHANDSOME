package com.jmh.mapper;

import java.util.List;

import com.jmh.domain.QnaVO;

/* 
 * 작성자 : 고정민
 * 
 * QNA 관련한 SQL을 호출하기 위한 인터페이스
 */
public interface QnaMapper {
	
	public void qnaPost(QnaVO qna);
	
	public List<QnaVO> qnaGet(String mid, int pageNum, int amount);
	
	public QnaVO qnaDetailGet(int qid);
	
	public int qnaModify(QnaVO qna);
	
	public int qnaDelete(int aid);
	
	public int qnaTotal(String mid);

}//end inter...
