package com.jmh.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jmh.domain.Criteria;
import com.jmh.domain.ProductColorVO;
import com.jmh.service.ProductService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

/* 
 * 작성자 : 고정민
 * 
 * 상품 상세 조회 관련 기능을 다룬 컨트롤러
 * [상품 상세 정보, 상품 컬러 리스트]
 */
@Log4j
@Controller
@RequestMapping("/product")
@AllArgsConstructor
public class ProductController {

	private ProductService service;
	
	// pid 값으로 상품 정보를 받아와 모델 객체에 저장
	@GetMapping("/productDetail")
	public void productGetDetail(@RequestParam("pid") String pid, Criteria cri, Model model) {
		
		log.info("productGetDetail ................" + pid);
		
		model.addAttribute("cri", cri);
		model.addAttribute("productInfo", service.productGetDetail(pid));
	}
	
	// ajax로 해당 상품에 대한 컬러리스트를 가져옴
	@ResponseBody
	@GetMapping(value = "/productColor",
	         produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
	public List<ProductColorVO> productGetColor(@RequestParam("pid") String pid) {
		
		log.info("productGetColor .................." + pid);
		log.info(service.productGetColor(pid));
		return service.productGetColor(pid);
	}

}// end class
