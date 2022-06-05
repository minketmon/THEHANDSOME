package com.jmh.domain;

import lombok.Data;

/* 
 * 작성자 : 고정민
 * 
 * 회원 정보를 저장하는 VO 객체
 */
@Data
public class MemberVO {
	private String mid;
	private String mpassword;
	private String mname;
	private String memail;
	private String mtel;
	private String mzipcode;
	private String maddress1;
	private String maddress2;
	private String mgrade;
	private String mdate;
	private String mpoint;
	private String menabled;
	private String mbirth;

}//end class
