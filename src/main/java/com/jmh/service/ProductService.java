package com.jmh.service;

import java.util.List;

import com.jmh.domain.Criteria;
import com.jmh.domain.ProductColorVO;
import com.jmh.domain.ProductVO;
/* 작성자 : 고정민, 변민혁, 문혁
 * 상품에 관련된 DB 호출을 관리하는 인터페이스
 */
public interface ProductService {

	// 상품 상세 조회
	public ProductVO productGetDetail(String pid);

	// 상품 색상 조회
	public List<ProductColorVO> productGetColor(String pid);

	public ProductVO get(int bno);
	
	// 대, 중, 소 분류에 해당하는 상품 리스트 조회
	public List<ProductVO> getList(Criteria cri, String clarge, String cmedium, String csmall);
	
	// 대, 중, 소 분류에 해당하는 상품 총 개수 조회
	public int getTotal(String clarge, String cmedium, String csmall);
}// end int
