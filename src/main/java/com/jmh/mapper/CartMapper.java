package com.jmh.mapper;

import java.util.List;

import com.jmh.domain.CartVO;

/* 작성자 : 문혁, 고정민
 * 장바구니 추가, 목록 조회, 삭제 쿼리에 관련된 SQL을 호출하는 인터페이스
 */
public interface CartMapper {
	
	public void cartPost(String mid, CartVO cart);
	
	public List<CartVO> cartList(String mid);
	
	public int cartDelete(String mid, String pid);
	
}//end inter...
