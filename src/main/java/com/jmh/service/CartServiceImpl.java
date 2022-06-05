package com.jmh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jmh.domain.CartVO;
import com.jmh.mapper.CartMapper;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

/* 작성자 : 고정민, 문혁
 * 장바구니에 관련된 DB 호출을 관리하는 클래스
 */
@Log4j
@Service
@AllArgsConstructor
public class CartServiceImpl implements CartService {

	@Setter(onMethod_ = @Autowired)
	private CartMapper mapper;
	
	// 장바구니에 상품 추가
	@Override
	public void cartPost(String mid, CartVO cart) throws Exception {
		log.info("Move to Cart List");
		mapper.cartPost(mid, cart);
	}
	// 유저의 장바구니 목록 조회
	@Override
	public List<CartVO> cartList(String mid) throws Exception {
		log.info("get Cart List");
		return mapper.cartList(mid);
	}
	// 장바구니 상품 제거
	@Override
	public int cartDelete(String mid, String pid) throws Exception {
		log.info("Delete Cart List");
		return mapper.cartDelete(mid, pid);
	}

	
}// end class
