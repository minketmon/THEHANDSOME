package com.jmh.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jmh.domain.MainListVO;
import com.jmh.domain.MainMagazineListVO;

import lombok.extern.log4j.Log4j;
/* 
* 작성자 : 문혁
* 
* 메인페이지 리스트 관련 매퍼 JUnit 테스트
*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class MainMapperTest {
	
	@Autowired
	private MainMapper mapper;
	// 신상품 리스트 조회 테스트
	@Test
	public void getProductList() throws Exception{
		String ref = "NEW";
		String category = "MEN";
		
		List<MainListVO> result = mapper.getProductList(ref, category);
		log.info(result);
	}
	// 매거진 리스트 조회 테스트
	@Test
	public void getMagazineList() throws Exception{
		
		List<MainMagazineListVO> result = mapper.getMagazineList();
		log.info(result);
	}
	
}//end class
