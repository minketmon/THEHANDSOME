package com.jmh.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jmh.domain.ProductVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

/* 
* 작성자 : 고정민
* 
* 상품 상세 조회 JUnit 테스트
*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ProductMapperTest {
	
	@Setter(onMethod_ = @Autowired)
	private ProductMapper mapper;
	
	@Test
	public void productGetDetailTest() {
		
		String pid = "LV2C1WTO007W_MT";
		
		ProductVO result = mapper.productGetDetail(pid);
		
		System.out.println("상품 조회 데이터 : " + result);
	}
	
}//end class
