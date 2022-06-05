package com.jmh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jmh.domain.MainListVO;
import com.jmh.domain.MainMagazineListVO;
import com.jmh.mapper.MainMapper;

import lombok.extern.log4j.Log4j;
/* 작성자 :  문혁
 * 메인 페이지에 관련된 DB 호출을 관리하는 클래스
 */
@Service
@Log4j
public class MainServiceImpl  implements MainService{
	
	@Autowired
	private MainMapper mapper;
	
	// 메인 페이지 상품 리스트 조회
	@Override
	public List<MainListVO> getProductList(String ref, String category){
		log.info("get Product List");
		log.info(ref + " " + category);
		return mapper.getProductList(ref, category);
	};
	
	// 메인 페이지 매거진 리스트 조회
	@Override
	public List<MainMagazineListVO> getMagazineList(){
		log.info("get Magazine List");
		return mapper.getMagazineList();
	}

}//end class
