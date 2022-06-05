package com.jmh.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jmh.domain.CartVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
/* 
* 작성자 : 문혁
* 
* 장바구니 관련 서비스 JUnit 테스트
*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class CartServiceTest {
	
	@Setter(onMethod_ = {@Autowired})
	private CartService service;
	
	@Test
	public void testInsertCart() throws Exception {
		String mid = "user00";
		CartVO cart = new CartVO();
		cart.setMid(mid);
		cart.setPid("TH2C3TTN639N_BK");
		cart.setPsize("F");
		cart.setPcolor("BK");
		cart.setPamount(1);
		service.cartPost(mid, cart);		
		log.info(mid +" 유저의 장바구니에 해당 상품이 담겼습니다.");
	}//end test
	
	
	@Test
	public void testGetCartList() throws Exception {
		service.cartList("user00").forEach(clist -> log.info(clist));		
	}//end test
	
	@Test
	public void testDelteCart() throws Exception {
		String mid = "user00";
		String pid = "TH2C3TTN639N_BK";
		service.cartDelete(mid, pid);
		log.info(mid + " 유저의 장바구니에서 " + pid +" 상품이 삭제되었습니다.");
	}//end test
	 	

}//end class
