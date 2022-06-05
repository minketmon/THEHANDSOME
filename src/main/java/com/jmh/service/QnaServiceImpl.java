package com.jmh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jmh.domain.QnaVO;
import com.jmh.mapper.QnaMapper;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
/* 작성자 : 고정민
 * QNA에 관련된 DB 호출을 관리하는 클래스
 */
@Log4j
@Service
@AllArgsConstructor
public class QnaServiceImpl implements QnaService {

	@Setter(onMethod_ = @Autowired)
	private QnaMapper mapper;
	// qna 작성
	@Override
	public void qnaPost(QnaVO qna) throws Exception {
		mapper.qnaPost(qna);
	}
	// qna 조회
	@Override
	public List<QnaVO> qnaGet(String mid, int pageNum, int amount) throws Exception {
		return mapper.qnaGet(mid, pageNum, amount);
	}
	// qna 상세조회
	@Override
	public QnaVO qnaGetDetail(int qid) throws Exception {
		return mapper.qnaDetailGet(qid);
	}
	// qna 수정
	@Override
	public int qnaModify(QnaVO qna) throws Exception {
		return mapper.qnaModify(qna);
	}
	// qna 삭제
	@Override
	public void qnaDelete(int qid) throws Exception {
		mapper.qnaDelete(qid);
	}
	// qna 총 개수 조회
	@Override
	public int qnaTotal(String mid) throws Exception {
		return mapper.qnaTotal(mid);
	}
}// end class
