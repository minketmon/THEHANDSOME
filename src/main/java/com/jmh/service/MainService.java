package com.jmh.service;

import java.util.List;

import com.jmh.domain.MainListVO;
import com.jmh.domain.MainMagazineListVO;
/* 작성자 :  문혁
 * 메인 페이지에 관련된 DB 호출을 관리하는 인터페이스
 */
public interface MainService {
	
	// 상품 리스트 조회. ref 값은 new = 신상품, best = 베스트
	public List<MainListVO> getProductList(String ref, String category);
	
	// 매거진 리스트 조회
	public List<MainMagazineListVO> getMagazineList();

	
}//end interface
