package com.jmh.domain;

import lombok.Data;

/* 
 * 작성자 : 고정민
 * 
 * QNA 작성시 파일 첨부할 때 필요한 정보 저장
 */
@Data
public class AttachImageVO {
	
	private String fileName;
	private String uploadPath;
	private String uuid;
	private int qid;
	
}//end class
