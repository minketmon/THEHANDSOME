package com.jmh.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jmh.domain.MainCategoryListVO;
import com.jmh.domain.MainListVO;
import com.jmh.domain.MainMagazineListVO;
import com.jmh.service.MainService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

/* 작성자 : 문혁
 * 메인페이지의 신상품, 베스트 상품, 매거진 List ajax에 필요한 데이터를 뿌려주는
 * Rest Controller
 */
@RequestMapping("/ko/intro")
@RestController
@Log4j
@AllArgsConstructor
public class MainListController {
	
	@Autowired
	private MainService service;
	
	// 메인페이지 내 신상품 리스트 조회.
	// REST - get 방식을 사용하여 쿼리스트링으로 전달받은 categoryCode를 이용하여 상품 목록 조회
	// JSON 형식으로 화면 출력에 필요한 데이터 전달
	@GetMapping(value = "/mainNewProductList",
			produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
	public List<MainListVO> getNewProductList(@RequestParam("categoryCode") String cCode){		
		log.info("getNewProductList..........");
		// 기존 더한섬닷컴 홈페이지 내의 상품 코드를 활용하여 그에 맞는 데이터를 출력하도록 함.
		// 상품코드 - 여성 WE , 남성 ME, 포인트 ACC WE03, 셀렉티드 WE01
		// 상품 코드를 DB에 저장된 카테고리 명으로 변환하는 작업
		String category = null;
		if(cCode.equals("WE")) {
			category = "WOMEN";
		} else if(cCode.equals("ME")) {
			category = "MEN";
		} else if(cCode.equals("WE03")) {
			category = "FASHION-ACC-";
		} else if(cCode.equals("WE01")) {
			category = "BEAUTY";
		}
		
		// Product 테이블 ref 컬럼의 데이터가 'NEW'이면 신상품.  
		String ref = "NEW";
		log.info(cCode + " = " + category);
		log.info(service.getProductList(ref, category).toString());
		
		return service.getProductList(ref, category);
		
	}//end getNewProductList
	
	// 메인페이지 내 베스트 상품 리스트 조회.
	// REST - get 방식을 사용하여 쿼리스트링으로 전달받은 categoryCode를 이용하여 상품 목록 조회
	// JSON 형식으로 화면 출력에 필요한 데이터 전달
	@GetMapping(value = "/mainBestProductList",
			produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
	public List<MainListVO> getBestProductList(@RequestParam("categoryCode") String cCode){		
		log.info("getBestProductList..........");
		
		// 상품 코드를 DB에 저장된 카테고리 명으로 변환하는 작업
		String category = null;
		if(cCode.equals("WE")) {
			category = "WOMEN";
		} else if(cCode.equals("ME")) {
			category = "MEN";
		}
		
		// Product 테이블 ref 컬럼의 데이터가 'BEST'이면 베스트 상품.  
		String ref = "BEST";
		log.info(cCode + " = " + category);
		log.info(service.getProductList(ref, category).toString());
		
		return service.getProductList(ref, category);
		
	}//end getBestProductList
	
	// 신상품, 베스트 상품 목록 카테고리 선택 버튼 리스트
	// MainCategoryListVO의 displayType 값을 기준으로
	// 신상품 리스트의 카테고리와 베스트 상품 리스트의 카테고리 구분
	@GetMapping(value = "/mainCategoryList",
			produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
	public List<MainCategoryListVO> getCategoryList(){		
		log.info("getCategoryList..........");		
		List<MainCategoryListVO> list = new ArrayList<>();
		list.add(new MainCategoryListVO(true, true, "여성", "WE"));
		list.add(new MainCategoryListVO(true, true, "남성", "ME"));
		list.add(new MainCategoryListVO(true, true, "포인트 ACC.", "WE03"));
		list.add(new MainCategoryListVO(true, true, "셀렉티드", "WE01"));
		list.add(new MainCategoryListVO(true, false, "여성", "WE"));
		list.add(new MainCategoryListVO(true, false, "남성", "ME"));
		
		log.info(list.toString());
		return list;
	}//end mainCategoryList
	
	// 메인 페이지 메거진 리스트 ajax
	// 메인페이지 진입 시 매거진을 조회하는 함수가 실행되어 REST - get 방식으로 화면에 보여줄 매거진 정보 요청
	// JSON 형식으로 화면 출력에 필요한 데이터 전달
	@GetMapping(value = "/mainMagazine",
			produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
	public List<MainMagazineListVO> getMagazineList(){		
		log.info("getMagazineList..........");		
		List<MainMagazineListVO> list = new ArrayList<>();
		
		log.info(service.getMagazineList().toString());

		return service.getMagazineList();
	}//end mainCategoryList
	
	
}//end class
