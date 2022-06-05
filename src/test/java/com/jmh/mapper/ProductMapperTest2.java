package com.jmh.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jmh.domain.ProductColorVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

/* 
* 작성자 : 고정민
* 
* 상품 컬러 리스트 조회 JUnit 테스트
*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ProductMapperTest2 {
	
	@Setter(onMethod_ = @Autowired)
	private ProductMapper mapper;
	
	@Test
	public void productGetColorTest() {
		
		String pid = "MW2C3WSH403E_WT";
		
		List<ProductColorVO> result = mapper.productGetColor(pid);
		
		for(ProductColorVO vo : result) {
			System.out.println("상품 컬러 데이터 : " + vo);
		}
		
	}
	
}//end class
