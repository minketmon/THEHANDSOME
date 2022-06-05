package com.jmh.domain;

import lombok.Data;

/* 
 * 작성자 : 고정민, 변민혁
 * 
 * 상품 상세 정보 저장하는 객체
 */
@Data
public class ProductVO {
	
	/* 상품 품번 */
	private String pid; 
	/* 브랜드 넘버 */
	 private int bno;
	/* 카테고리 대분류 */
	 private String clarge;
	/* 카테고리 중분류 */
	 private String cmedium;
	/* 카테고리 소분류 */
	 private String csmall;
	/* 상품 이름*/
	 private String pname;
	/* 상품 가격 */
	 private int pprice;
	/* 상품 상세정보 */
	 private String pdetail;
	/* 상품 이미지1 */
	 private String t01_imageurl;
	/* 상품 이미지2 */
	 private String t02_imageurl;
	/* 상품 이미지3 */
	 private String t03_imageurl;
	/* 참고 */
	 private String ref;
	/* 브랜드 이름 */
	 private String bname; 
	 
}