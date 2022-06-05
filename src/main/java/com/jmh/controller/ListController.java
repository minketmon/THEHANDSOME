package com.jmh.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jmh.domain.Criteria;
import com.jmh.domain.PageDTO;
import com.jmh.domain.ProductColorVO;
import com.jmh.domain.ProductVO;
import com.jmh.service.ProductService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

/* 작성자 : 변민혁
 * 상품리스트 페이지의 페이징 정보와 해당하는 상품 목록 조회를 담당하는 controller
 * 헤더의 네비게이션 바를 통해 상품의 대,중,소 분류를 선택시 해당 카테고리의 상품 리스트 페이지로 이동
 */
@Controller
@RequestMapping("")
@AllArgsConstructor
@Log4j
public class ListController {
	
	private ProductService service;
	
	// 작성자 : 고정민, 문혁, 변민혁
	// pathVariable를 이용해서 카테고리 정보를 전달 받음
	@GetMapping("/list/{clarge}/{cmedium}/{csmall}")
	public String list(Criteria cri, Model model, 
			@PathVariable("clarge") String clarge,
			@PathVariable("cmedium") String cmedium,
			@PathVariable("csmall") String csmall) {
		log.info("list: " + cri);
		// ProductVO에는 상품의 색상정보가 없어서 추가로 ProductColor 정보 조회 필요
		// pid 당 여러개의 color를 가지고 있을 수 있어 colorMap안에 colorList 저장
		List<ProductVO> list = service.getList(cri, clarge, cmedium, csmall);
		List<ProductColorVO> colorList = null;
		List<List<ProductColorVO>> colorMap = new ArrayList<>();
		model.addAttribute("list", list);
		int total = service.getTotal(clarge, cmedium, csmall);
		log.info("total = " + total);
		model.addAttribute("pageMaker", new PageDTO(cri, total));
		
		for(int i=0; i<list.size(); i++) {
			colorList = service.productGetColor(list.get(i).getPid());
			colorMap.add(colorList);
		}
		log.info(colorMap);
		log.info(clarge + cmedium + csmall);
		
		model.addAttribute("colorMap", colorMap);
		return "list";
	}
	
	@GetMapping("/get")
	public void get(int bno, Model model) {
		log.info("/get");
		model.addAttribute("product", service.get(bno));
	}
	
	@GetMapping("/productlist")
	public void productlist(){
	}

}