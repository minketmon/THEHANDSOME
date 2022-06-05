package com.jmh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jmh.domain.Criteria;
import com.jmh.domain.ProductColorVO;
import com.jmh.domain.ProductVO;
import com.jmh.mapper.ProductMapper;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
/* 작성자 : 고정민, 변민혁, 문혁
 * 상품에 관련된 DB 호출을 관리하는 클래스
 */
@Log4j
@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

	@Setter(onMethod_ = @Autowired)
	private ProductMapper mapper;
	// 상품 상세 조회
	@Override
	public ProductVO productGetDetail(String pid) {
		return mapper.productGetDetail(pid);
	}
	// 상품 색상 조회
	@Override
	public List<ProductColorVO> productGetColor(String pid) {
		log.info("ProductServiceImpl");
		log.info(mapper.productGetColor(pid));
		return mapper.productGetColor(pid);
	}

	// 상품 조회 테스트
	@Override
	public ProductVO get(int bno) {
		log.info("get....." + bno);
		return mapper.read(bno);
	}
	
	// 대, 중, 소 분류에 해당하는 상품 리스트 조회
	@Override
	public List<ProductVO> getList(Criteria cri, String clarge, String cmedium, String csmall) {
		log.info("get List with criteria: " + cri);
		return mapper.getListWithPaging(cri, clarge, cmedium, csmall);
	}
	
	// 상품 리스트의  마지막 페이지 구하기 위한 해당 카테고리 상품 총 개수 조회
	@Override
	public int getTotal(String clarge, String cmedium, String csmall) {
		log.info("get Total Product");
		return mapper.getTotal(clarge, cmedium, csmall);
	}
}// end class
