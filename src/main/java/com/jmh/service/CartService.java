package com.jmh.service;

import java.util.List;

import com.jmh.domain.CartVO;

/* 작성자 : 고정민, 문혁
 * 장바구니에 관련된 DB 호출을 관리하는 인터페이스
 */
public interface CartService {
	
	// cart 추가 
	public void cartPost(String mid, CartVO cart) throws Exception;
	
	// cart 조회 
	public List<CartVO> cartList(String mid) throws Exception;
	
	// cart 삭제
	public int cartDelete(String mid, String pid) throws Exception;
	

}//end int
