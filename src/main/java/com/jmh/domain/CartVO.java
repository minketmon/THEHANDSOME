package com.jmh.domain;

import lombok.Data;

/* 작성자 : 문혁, 고정민
 * 장바구니에 담긴 상품 정보를 저장하는 객체
 */
@Data
public class CartVO {
	private String mid;
	private String pid;
	private String psize;
	private String pcolor;
	private int pamount;

}//end class
