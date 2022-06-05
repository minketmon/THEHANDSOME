package com.jmh.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
/* 
* 작성자 : 문혁
* 
* 메인페이지 리스트 조회 서비스 JUnit 테스트
*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class MainServiceTest {
	
	@Setter(onMethod_ = {@Autowired})
	private MainService service;
	
	@Test
	public void testGetProductList() {
		service.getProductList("NEW", "MEN").forEach(plist -> log.info(plist));		
	}//end test
	
	
	@Test
	public void testGetMagazineList() {
		service.getMagazineList().forEach(mlist -> log.info(mlist));		
	}//end test
	 	

}//end class
