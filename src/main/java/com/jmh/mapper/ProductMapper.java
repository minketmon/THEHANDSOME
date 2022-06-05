package com.jmh.mapper;

import java.util.List;

import com.jmh.domain.Criteria;
import com.jmh.domain.ProductColorVO;
import com.jmh.domain.ProductVO;

/* 
 * 작성자 : 고정민, 변민혁, 문혁
 * 
 * 상품과 관련한 SQL을 호출하기 위한 인터페이스
 */
public interface ProductMapper {

	public ProductVO productGetDetail(String pid); // 상품 상세 정보

	public List<ProductColorVO> productGetColor(String pid); // 상품 컬러 리스트

	public List<ProductVO> getList(); // 상품 리스트

	public List<ProductVO> getListWithPaging(Criteria cri, String clarge, String cmedium, String csmall); // 상품 리스트 페이징

	public int getTotal(String clarge, String cmedium, String csmall); // 페이징 시 필요한 총 상품 개수

	public ProductVO read(int bno); // 상품 조회 테스트
}// end inter...
