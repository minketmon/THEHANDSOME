package com.jmh.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jmh.domain.CartVO;
import com.jmh.domain.MemberVO;
import com.jmh.domain.ProductColorVO;
import com.jmh.domain.ProductVO;
import com.jmh.service.CartService;
import com.jmh.service.ProductService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

/* 작성자 : 문혁
 * 장바구니 조회, 추가, 삭제 등을 담당하는 컨트롤러
 */
@Controller
@Log4j
@AllArgsConstructor
public class ShoppingListController {
	
	private CartService service;
	// 옵션 변경시 카트에 담긴 상품 정보외에 추가로 필요한 디테일 정보 수집을 위한 상품 서비스 객체
	private ProductService pservice;
	
	// 장바구니 페이지에 진입시 세션에 저장된 유저의 아이디를 통해 해당 유저의 장바구니 목록 조회
	@GetMapping("/shoppingbag")
	public String getCart(HttpServletRequest request, Model model) throws Exception {
		log.info("장바구니 목록");
		HttpSession session = request.getSession();
		MemberVO memberVO = (MemberVO) session.getAttribute("member");
		// 로그인하지 않았을 경우 로그인 페이지로 이동
		if (memberVO == null) {
			return "redirect:member/login";
		}
		String mid = memberVO.getMid();
		
		// 로그인한 유저의 장바구니 상품 총 개수를 조회하여 헤더에 표시
		List<CartVO> cartList = new ArrayList<>();
		cartList = service.cartList(mid);
		log.info(cartList);
		int cartTotal = cartList.size();
		session.setAttribute("cartTotal", cartTotal);
		log.info("장바구니 개수 = " + cartTotal);
		
		// 옵션변경 버튼 누를 시 보여줄 상품의 디테일 정보 전달
		// 장바구니 상품 리스트의 개수 = 상품 디테일 리스트 개수 이용
		// 상품 컬러의 경우 ProductColorVO List를 추가로 전달해줘야 함
		ArrayList<ProductVO> detailList = new ArrayList<>();
		List<ProductColorVO> colorList = null;
		List<List<ProductColorVO>> colorMap = new ArrayList<>();
		for(int i=0; i<cartList.size(); i++) {
			String pid = cartList.get(i).getPid();
			ProductVO pvo = pservice.productGetDetail(pid);
			detailList.add(pvo);
			colorList = pservice.productGetColor(pid);
			colorMap.add(colorList);
		}
		log.info("cartList 사이즈 = " + cartList.size());
		log.info("detailList 사이즈 = " + detailList.size());
		log.info(detailList);
		log.info(colorMap);
		
		model.addAttribute("cartList", cartList);
		model.addAttribute("detailList", detailList);
		model.addAttribute("total", cartList.size());
		model.addAttribute("colorMap", colorMap);
		return "shoppingbag";
	}
	
	// 상품 디테일 페이지에서 상품id, 사이즈, 색상을 선택후 장바구니 담기 버튼을 누를시 
	// post 방식으로  위의 정보를 전달받아 장바구니 테이블에 추가.
	@PostMapping("/shoppingbag")
	public String addCart(CartVO cart, HttpServletRequest request) throws Exception{
		HttpSession session = request.getSession();
		MemberVO memberVO = (MemberVO) session.getAttribute("member");
		log.info("장바구니 추가");
		log.info("mid : " + memberVO.getMid());
		log.info("cart : " + cart);
		service.cartPost(memberVO.getMid(), cart);
		log.info(cart);
		return "redirect:/shoppingbag";
	}
	
	// 장바구니 페이지에서 선택상품 삭제 버튼을 누를 시
	// 전달받은 상품id를 통해 장바구니 테이블에서 해당 상품 제거
	@PostMapping("/deleteShoppingbag")
	public String deleteCart(HttpServletRequest request, @RequestParam String pid) throws Exception {
		log.info("장바구니 삭제");
		HttpSession session = request.getSession();
		MemberVO memberVO = (MemberVO) session.getAttribute("member");
		service.cartDelete(memberVO.getMid(), pid);
		log.info(pid);
		return "redirect:/shoppingbag";
	}
}
