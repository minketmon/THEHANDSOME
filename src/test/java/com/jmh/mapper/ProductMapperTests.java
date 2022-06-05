package com.jmh.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jmh.domain.ProductVO;
import com.jmh.mapper.ProductMapper;
import com.jmh.domain.Criteria;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

/*
 * 작성자 : 변민혁
 * 
 * 상품 리스트 조회 JUnit 테스트
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j

public class ProductMapperTests {
	
	@Setter(onMethod_ = @Autowired)
	private ProductMapper mapper;
	
//	@Test
//	public void testGetList() {
//		mapper.getList().forEach(product -> log.info(product));		
//	}
	
//	@Test
//	public void testRead() {
//		ProductVO product = mapper.read(1);		
//		log.info(product);
//	}//end void
	
	@Test
	public void testPaging() {
		Criteria cri = new Criteria();
		//12개씩 3페이지
		cri.setPageNum(3);
		cri.setAmount(12);
		List<ProductVO> list = mapper.getListWithPaging(cri, "WOMEN", "Top", "T-Shirts");
		list.forEach(product -> log.info("" + product));
	}
	
}//end class
