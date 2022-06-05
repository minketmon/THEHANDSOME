package com.jmh.service;

import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jmh.domain.ProductVO;
import com.jmh.domain.Criteria;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

/* 
* 작성자 : 고정민
* 
* ProductService JUnit 테스트
*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ProductServiceTest {
	
	@Setter(onMethod_ = {@Autowired})
	private ProductService service;
	
	@Test
	public void testGetList() {
		//service.getList().forEach(product -> log.info(product));	
        service.getList(new Criteria(2, 12), "WOMEN", "Top", "T-Shirts").forEach(product -> log.info(product));
	}//end test
	
	// 작성자 : 변민혁
	//@Test public void testGetList2() {
		//  for (ProductVO product:service.getList()) { 
			//   log.info(product); 
		  //}//end for 
	 // }//end test
	 	
	@Test
	public void produdctDetailTest() throws Exception {
		String pid = "HS2C3TTO016MPO_WT";
		
		log.info(service.productGetDetail(pid));
	}
}//end class
