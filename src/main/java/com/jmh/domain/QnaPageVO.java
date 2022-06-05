package com.jmh.domain;

import java.util.List;

import lombok.Data;

/* 
 * 작성자 : 고정민
 * 
 * QNA 페이징 정보 저장하는 객체
 */
@Data
public class QnaPageVO {
	
	List<QnaVO> list;
	PageDTO pageInfo;
	
	public List<QnaVO> getList() {
		return list;
	}
	
	public void setList(List<QnaVO> list) {
		this.list = list;
	}
	
	public PageDTO getPageInfo() {
		return pageInfo;
	}
	
	@Override
	public String toString() {
		return "PageDTO [list=" + list + ", pageInfo=" + pageInfo + "]";
	}
	
}//end class
