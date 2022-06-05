package com.jmh.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jmh.domain.CartVO;

import lombok.extern.log4j.Log4j;
/* 
* 작성자 : 문혁
* 
* 장바구니 관련 매퍼 JUnit 테스트
*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class CartMapperTest {
	
	@Autowired
	private CartMapper mapper;
	// 장바구니 추가 테스트
	@Test
	public void cartPost() throws Exception{
		String mid = "user00";
		CartVO cart = new CartVO();
		cart.setMid(mid);
		cart.setPid("TH2C3TTN639N_BK");
		cart.setPsize("F");
		cart.setPcolor("BK");
		cart.setPamount(1);
		
		mapper.cartPost(mid, cart);
		log.info(mid + "유저의 카트에" + cart.getPid()+ "상품이 추가되었습니다.");
	}
	// 장바구니 목록 조회 테스트
	@Test
	public void cartList() throws Exception{
		String mid = "user00";
		List<CartVO> result = mapper.cartList(mid);
		log.info("장바구니 목록 = " + result);
	}
	// 장바구니 삭제 테스트
	@Test
	public void cartDelete() throws Exception{
		String mid = "user00";
		String pid = "TH2C3TTN639N_BK";
		mapper.cartDelete(mid, pid);
		log.info("장바구니에서 " + pid + "상품이 삭제되었습니다.");
	}
	
}//end class
