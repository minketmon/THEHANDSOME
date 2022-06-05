package com.jmh.mapper;

import java.util.List;

import com.jmh.domain.MainListVO;
import com.jmh.domain.MainMagazineListVO;
/* 작성자 : 문혁
 * 메인 페이지 상품 목록 및 매거진 조회에 관련된 SQL을 호출하는 인터페이스
 */
public interface MainMapper {
	
	public List<MainListVO> getProductList(String ref, String category);
	
	public List<MainMagazineListVO> getMagazineList();


}//end inter
