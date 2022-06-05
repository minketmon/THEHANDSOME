package com.jmh.domain;

import lombok.Data;

/* 
 * 작성자 : 고정민
 * 
 * QNA 상세 정보를 저장하는 객체
 */
@Data
public class QnaVO {
	private int qid;
	private String mid;
	private String qtitle;
	private String qcontent;
	private String qdate;
	private String qnaimg;
	private String qnathumimg;

}//end class
