package com.jmh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.log4j.Log4j;

/* 작성자 : 문혁
 * 데이터가 없는 페이지나, 구현하지 않은 페이지에 접속 시 에러 페이지로 이동시키는 controller
 * 에러페이지에 해당하는 error.jsp로 이동
 */
// 데이터가 없는 페이지나, 구현하지 않은 페이지에 접속 시 표시할 에러 페이지
@Log4j
@Controller
public class ErrorController {	
	
	@GetMapping("error")
	public void error(){
		log.info("아직 준비중인 페이지 입니다.");
	}
	}//end class
