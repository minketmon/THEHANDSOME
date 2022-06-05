package com.jmh.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/* 작성자 : 변민혁
 * 페이징에 필요한 정보를 저장하는 객체
 */
@Getter
@Setter
@ToString
public class Criteria {	
	
	private int pageNum;	
	private int amount;
	
	
	public Criteria() {
		this(1,12);
	}//end cri...	

	public Criteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}//end Cri..	

}//end class
