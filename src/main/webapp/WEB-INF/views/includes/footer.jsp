<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <!-- 
  /* 작성자 : 고정민, 문혁, 변민혁
 * 모든 페이지 공통 footer 
 */
   -->    
    
<div id="footerWrap">
	<div id="topBtn">
		<a href="javascript:void(0);" class="viewTopArea"><img src="/resources/_ui/desktop/common/images/common/top_btn.png" alt="맨 위로" onclick="GA_Event('공통','퀵버튼','TOP');"/></a>
	</div>
	<div class="footer">
		<!--footer_cnts1 -->
		<div class="footer_cnts1 clearfix">
			<!-- footer_menu-->
			<div class="footer_menu cnts1_left">
				<div class="footer_logo"><a href="/ko/main" onclick="GA_Event('공통','로고','하단');"><img src="/resources/_ui/desktop/common/images/common/footer_logo_renew.png" alt="HANDSOME" /></a></div>
				<div class="footer_link">
					<ul class="clearfix">
					    <li><a href="/ko/svcenter/theClubInfo" onclick="GA_Event('공통','푸터_메뉴','온라인 멤버십');">온라인 멤버십</a></li>
						<li><a href="/ko/svcenter/memberbenefitguide" onclick="GA_Event('공통','푸터_메뉴','한섬 VVIP 혜택');">한섬 VVIP 혜택</a></li>
						<li><a href="/ko/svcenter/pointguide" onclick="GA_Event('공통','푸터_메뉴','한섬마일리지 혜택');">한섬마일리지 혜택</a></li>
						<li><a href="/ko/svcenter/couponguide" onclick="GA_Event('공통','푸터_메뉴','쿠폰');">쿠폰</a></li>
<li><a href="/ko/svcenter/asguide" onclick="GA_Event('공통','푸터_메뉴','반품&환불안내');">반품&amp;환불안내</a></li>
							</ul>
					<ul class="clearfix">
						<li><a href="/ko/svcenter/submain" onclick="GA_Event('공통','푸터_메뉴','고객센터');">고객센터</a></li>
						<li><a href="/ko/svcenter/faq" onclick="GA_Event('공통','푸터_메뉴','FAQ');">FAQ</a></li>
						<li><a href="/ko/svcenter/mending" onclick="GA_Event('공통','푸터_메뉴','수선진행조회');">수선진행조회</a></li>
						</ul>
					<ul class="clearfix">
					   <li><a href="javascript:setLogout();" onclick="GA_Event('공통','푸터_메뉴','로그아웃');">로그아웃</a></li>
					   <li><a href="/ko/mypage/order/myorders" onclick="GA_Event('공통','푸터_메뉴','주문배송조회');">주문배송조회</a></li>
						<li><a href="/ko/mypage/order/myorders" onclick="GA_Event('공통','푸터_메뉴','취소/반품');">취소/반품</a></li>
						<li><a href="/ko/mypage/myWish" onclick="GA_Event('공통','푸터_메뉴','위시리스트');">위시리스트</a></li>
					</ul>
					<ul class="clearfix">
						<li><a href="http://www.handsome.co.kr/ko/company/aboutHandsome.do" target="_blank" onclick="GA_Event('공통','푸터_메뉴','회사소개');">회사소개<!-- 회사소개 --></a></li>
						<li><a href="http://www.handsome.co.kr/ko/brand/fashion.do" target="_blank" onclick="GA_Event('공통','푸터_메뉴','브랜드소개');">브랜드소개</a></li>
						<li><a href="http://www.handsome.co.kr/ko/ir/governance01.do" target="_blank" onclick="GA_Event('공통','푸터_메뉴','투자정보');">투자정보</a></li>
						<li><a href="https://recruit.ehyundai.com/recruit-info/announcement/list.nhd?pageNo=1&hireGb=01&coCd=HDHAN" target="_blank" onclick="GA_Event('공통','푸터_메뉴','채용정보');">채용정보</a></li>
						<li><a href="http://www.handsome.co.kr/ko/sustainability/sharedGrowth01.do" target="_blank" onclick="GA_Event('공통','푸터_메뉴','동반성장');">동반성장</a></li>
						</ul>
				</div>
			</div>
			<!-- //footer_menu-->
			<div class="footer_apps cnts1_right">
				<ul>
					<li class="loca"><a href="/ko/b/storeInformation" onclick="GA_Event('공통','푸터','매장안내');">매장안내</a></li>
					<li class="look"><a href="/ko/magazine/lookbook" onclick="GA_Event('공통','푸터','룩북');">룩북</a></li>
					<li class="ico_youtube"><a href="/ko/magazine/youtubeList" onclick="GA_Event('공통','푸터_SNS','YOUTUBE');">비디오</a></li><!-- 200330 추가 -->
					<li class="ico_insta" id="f_insta"><a href="https://www.instagram.com/thehandsome_official/" target="_blank" onclick="GA_Event('공통','푸터_SNS','INSTAGRAM');">인스타그램</a></li><!-- 200330 추가 -->
				</ul>
				<!--download_app , athome-->
				<div class="cnts1_right_inner">
				    <a href="/ko/appDownloadSMS/sendSMSPage" onclick="GA_Event('공통','푸터','APP다운로드');">
<img src="/resources/_ui/desktop/common/images/common/footer_ico_apps.png" alt="APP 다운로드" style="width:52px;height:71px;">
<!-- 				        <img src="/resources/_ui/desktop/common/images/common/ico_apps_new.png" alt="APP 다운로드" style="width:54px;height:70px;"> -->
<p>APP 다운로드 &gt;</p>
			        </a>
				    <a href="/ko/svcenter/footerAthomeInfo" style="margin-right:0;" onclick="GA_Event('공통','푸터','딜리버리서비스');">
<img src="/resources/pc/footer/footer_athome_car.png" alt="딜리버리 서비스" style="width:85px;">
<!-- 				        <img src="http://cdn.thehandsome.com/pc/footer_athome_car.jpg" alt="딜리버리 서비스" style="width:95px;"> -->
<p>딜리버리 서비스 &#62;</p>
			        </a>
			    </div>
				<!--//download_app , athome-->
			</div>
		</div>
		<!--//footer_cnts1 -->
	</div>
	<!--footer_cnts2 -->
	<div class="footer_cnts2 clearfix">
		<div class="footer">
			<div class="cnts2_left">
				<a href="/ko/footer/footerTermBusiness" onclick="GA_Event('공통','푸터_CNT','서비스이용약관');">서비스이용약관</a>
				<a href="/ko/footer/footerPrivacy" onclick="GA_Event('공통','푸터_CNT','개인정보처리방침');"><strong>개인정보처리방침<!-- 개인정보처리방침 --></strong></a>
				<a href="javascript:void(0);" class="box" onclick="javascript:window.open('http://www.ftc.go.kr/info/bizinfo/communicationViewPopup.jsp?wrkr_no=1208126337', 'communicationViewPopup', 'width=750, height=700');GA_Event('공통','푸터_CNT','통신판매사업자정보확인');">통신판매사업자정보확인</a>
				<a href="https://mark.inicis.com/mark/escrow_popup.php?mid=handsomep1" class="box" onclick="GA_Event('공통','푸터_CNT','에스크로서비스가입확인');">에스크로서비스 가입 확인</a>
				<p class="top_p"><span>(주)한섬</span><span>대표이사 : 김민덕</span><span>서울시 강남구 도산대로 523 한섬빌딩</span><span>TEL 1800-5700 (유료)</span><span class="bgnone">FAX 02-6078-2856</span></p>
				<p><span>사업자등록번호 120-81-26337</span><span>통신판매업신고번호 강남 제 00826호</span><span>개인정보관리책임자 윤인수</span><span class="bgnone">호스팅서비스 : (주) 한섬</span></p>
				<p class="copyright">COPYRIGHT © 2017 HANDSOME. ALL RIGHT RESERVED.</p>
			</div>
			<div class="cnts2_right">
				<div class="related_site clearfix">
					<dl class="global lang_1911">
					    <dt><a href="javascript:void(0);" class="" onclick="GA_Event('공통','푸터_CNT','LANGUAGE');">LANGUAGE</a></dt>
						<dd style="display: none;">
							<ul>
								<li><a href="javascript:language('ko')" onclick="GA_Event('공통','푸터_CNT','LANGUAGE_한국어');">한국어</a></li>
								<li><a href="javascript:language('en')" onclick="GA_Event('공통','푸터_CNT','LANGUAGE_ENGLISH');">ENGLISH</a></li>
								<li><a href="javascript:language('zh')" onclick="GA_Event('공통','푸터_CNT','LANGUAGE_中文');">中文</a></li>
							</ul>
						</dd>
					</dl>
					<dl class="family">
						<dt><a href="javascript:void(0);" onclick="GA_Event('공통','푸터_CNT','FAMILY SITE');">FAMILY SITE<!-- FAMILY SITE --></a></dt>
						<dd style="">
							<ul>
	                            <li class="bold_division1811">쇼핑몰 Site<!-- 쇼핑몰 Site --></li>
	                            <li><a href="https://www.thehyundai.com/Home.html" target="_blank" onclick="GA_Event('공통','푸터_CNT','FAMILY SITE_더현대닷컴');">더현대닷컴<!-- 더현대닷컴 --></a></li>
	                            <li><a href="https://www.hddfs.com/shop/dm/main.do?ptnrChlCd=00003014" target="_blank" onclick="GA_Event('공통','푸터_CNT','FAMILY SITE_현대백화점 면세점');">현대백화점 면세점<!-- 현대백화점 DUTY FREE --></a></li>
	                            <li><a href="http://esuper.ehyundai.com/" target="_blank" onclick="GA_Event('공통','푸터_CNT','FAMILY SITE_e수퍼마켓');">e수퍼마켓<!-- e수퍼마켓 --></a></li>
	                            <li><a href="https://www.hyundaihmall.com/Home.html" target="_blank" onclick="GA_Event('공통','푸터_CNT','FAMILY SITE_현대Hmall');">현대Hmall<!-- 현대 Hmall --></a></li>
	                            <li><a href="http://mall.hyundailivart.co.kr/front/vrStoreList.lv" target="_blank" onclick="GA_Event('공통','푸터_CNT','FAMILY SITE_현대리바트몰');">현대리바트몰<!-- 현대리바트몰 --></a></li>
	                            <li><a href="http://www.hyundairentalcare.co.kr/" target="_blank" onclick="GA_Event('공통','푸터_CNT','FAMILY SITE_현대렌탈케어');">현대렌탈케어<!-- 현대렌탈케어 --></a></li>
	                            <li><a href="http://www.hfashionmall.com/sfmweb/" target="_blank" onclick="GA_Event('공통','푸터_CNT','FAMILY SITE_H패션몰');">H패션몰<!-- H패션몰 --></a></li>
	                            <li><a href="https://www.h-vrstation.com/main" target="_blank" onclick="GA_Event('공통','푸터_CNT','FAMILY SITE_VR STATION');">VR STATION<!-- VR STATION --></a></li>
	                            
	                            <li class="bold_division1811">관계사 Site<!-- 관계사 Site --></li>
	                            <li><a href="http://www.ehyundai.com/newPortal/ir/main.do" target="_blank" onclick="GA_Event('공통','푸터_CNT','FAMILY SITE_현대백화점그룹');">현대백화점그룹<!-- 현대백화점 그룹 --></a></li>
	                            <li><a href="https://www.ehyundai.com/newPortal/index.do" target="_blank" onclick="GA_Event('공통','푸터_CNT','FAMILY SITE_현대백화점');">현대백화점<!-- 현대백화점 --></a></li>
	                            <li><a href="http://www.hyundaigreenfood.com/" target="_blank" onclick="GA_Event('공통','푸터_CNT','FAMILY SITE_현대그린푸드');">현대그린푸드<!-- (주)현대그린푸드 --></a></li>
	                            <li><a href="https://www.hyundaihmall.com/Home.html" target="_blank" onclick="GA_Event('공통','푸터_CNT','FAMILY SITE_현대홈쇼핑');">현대홈쇼핑<!-- (주)현대홈쇼핑 --></a></li>
	                            <li><a href="http://www.hyundailivart.co.kr/ko/intro/index.lvt" target="_blank" onclick="GA_Event('공통','푸터_CNT','FAMILY SITE_현대리바트');">현대리바트<!-- (주)현대 리바트 --></a></li>
	                            <li><a href="http://www.hyundaimedia.com/mpp/index.hcn" target="_blank" onclick="GA_Event('공통','푸터_CNT','FAMILY SITE_현대미디어');">현대미디어<!-- 현대 미디어 --></a></li>
	                            <li><a href="http://www.hyundairentalcare.co.kr/" target="_blank" onclick="GA_Event('공통','푸터_CNT','FAMILY SITE_현대렌탈케어');">현대렌탈케어<!-- 현대렌탈케어 --></a></li>
	                            <li><a href="http://www.hyundaidreamtour.com/" target="_blank" onclick="GA_Event('공통','푸터_CNT','FAMILY SITE_현대드림투어');">현대드림투어<!-- 현대드림투어 --></a></li>
	                            <li><a href="http://www.everdigm.com/" target="_blank" onclick="GA_Event('공통','푸터_CNT','FAMILY SITE_에버다임');">에버다임<!-- 에버다임 --></a></li>
	                            <li><a href="http://www.cnsfoodsystem.co.kr/" target="_blank" onclick="GA_Event('공통','푸터_CNT','FAMILY SITE_씨엔에스푸드시스템');">씨엔에스푸드시스템<!-- 씨엔에스푸드시스템 --></a></li>
	                            <li><a href="http://www.hyundaicatering.co.kr/" target="_blank" onclick="GA_Event('공통','푸터_CNT','FAMILY SITE_현대캐터링시스템');">현대캐터링시스템<!-- 현대캐터링시스템 --></a></li>
	                            <li><a href="http://www.hyundai-ite.com/index.jsp" target="_blank" onclick="GA_Event('공통','푸터_CNT','FAMILY SITE_현대IT&amp;E');">현대IT&amp;E<!-- 현대IT&amp;E --></a></li>
	                            <li><a href="http://www.hyundailnc.com/" target="_blank" onclick="GA_Event('공통','푸터_CNT','FAMILY SITE_현대L&amp;C');">현대L&amp;C<!-- 현대L&amp;C --></a></li>
	                        </ul>
						</dd>
					</dl>
				
				
				</div>
				<!-- 푸터 공지 추가 220404 -->
				<!-- 공지 -->
				<div id="noticeWrap" class="notice">
					<div class="controls">
						<a href="javascript:void(0);" class="prev">이전</a>
						<a href="javascript:void(0);" class="next">다음</a>
					</div>
					<div class="list">
						<div class="tlt">공지<!-- 공지 --></div>
						<ul class="list_new">
							<!-- NoticeContent -->
							<li>
								<a href="/ko/svcenter/notice?noticeCode=8803793555376">[당첨자발표] 더한섬닷컴 3월 신규회원 댓글 이벤트 당첨자 발표</a>
							</li>
						</ul>
					</div>
				</div>
				<!-- //공지 -->
				
				<!-- 뉴스 -->
				<div id="newsWrap" class="news">
					<div class="controls">
						<a href="javascript:void(0);" class="prev">이전</a>
						<a href="javascript:void(0);" class="next">다음</a>
					</div>
					<div class="list">
						<div class="tlt">뉴스<!-- 뉴스 --></div>
						<ul class="list_new">
							<!-- NewsContent -->
							<li>
								<a href="/ko/magazine/newsDetailtemplatetype4?newsCode=8803465877276&amp;typeCode=WEB" onclick="GA_Common('news',$(this))">[핸썸TV] 딱 지금을 위한! FOURM 에센셜 아이템</a>
							</li>
						</ul>
					</div>
				</div>
				<!-- //뉴스 -->
				<!-- // 푸터 공지 추가 220404 -->
				</div>
		</div>
	</div>
	<!--//footer_cnts2 -->
	</div>
	
	<div id="ariaStatusMsg" class="skip" role="status" aria-relevant="text" aria-live="polite"></div>
	
	<!--loadingbar-->
	<div class="layerBg"></div>
	<!--//loadingbar-->
	
	<div class="layerArea" id="mapleLayer" style="display:none;">
	   <div class="layerBg"></div>
	</div>
	
	<script type="text/javascript">  
	
	    var virtusizeViewYn = false;
	    
	        virtusizeViewYn = true;
	        
	    if(virtusizeViewYn){
	         
	    }
	</script>

<input type="hidden" id="apiConfmKey" value="U01TX0FVVEgyMDE5MDYxNzE2NDczMzEwODgxNTI="/>

</body>
<%-- 로그인 상태 일 때 나오는 스크립트
<!-- This script is for AceCounter START -->
<script language='javascript' type="text/javascript">
var birthday = 'Tue Jan 30 00:00:00 UTC 1996';
var splitBirthday = birthday.split(" ");
var AceAge = "";
if(splitBirthday.length == 6) {
	var AceDate = new Date();
	AceAge = AceDate.getFullYear()-splitBirthday[5]+1
} else {
	AceAge = 0;
}
var _ag   = AceAge;         
var _id   = 'ansgurtk';    		
var _mr   = '';        	
var _gd   = 'man';         
var _ud1 = "1" ;		// 사용자 정의변수 1 ( 1 ~ 10 정수값)
</script>
<!-- AceCounter END -->  
--%>

<!-- AceCounter Log Gathering Script V.7.5.2013010701 -->
<script language='javascript'>
	var _AceGID=(function(){var Inf=['dgc17.acecounter.com','8080','AP6F40149814536','CW','0','NaPm,Ncisy','ALL','0']; var _CI=(!_AceGID)?[]:_AceGID.val;var _N=0;var _T=new Image(0,0);if(_CI.join('.').indexOf(Inf[3])<0){ _T.src =( location.protocol=="https:"?"https://"+Inf[0]:"http://"+Inf[0]+":"+Inf[1]) +'/?cookie'; _CI.push(Inf);  _N=_CI.length; } return {o: _N,val:_CI}; })();
	var _AceCounter=(function(){var G=_AceGID;if(G.o!=0){var _A=G.val[G.o-1];var _G=( _A[0]).substr(0,_A[0].indexOf('.'));var _C=(_A[7]!='0')?(_A[2]):_A[3];	var _U=( _A[5]).replace(/\,/g,'_');var _S=((['<scr','ipt','type="text/javascr','ipt"></scr','ipt>']).join('')).replace('tt','t src="'+location.protocol+ '//cr.acecounter.com/Web/AceCounter_'+_C+'.js?gc='+_A[2]+'&py='+_A[4]+'&gd='+_G+'&gp='+_A[1]+'&up='+_U+'&rd='+(new Date().getTime())+'" t');document.writeln(_S); return _S;} })();
</script>
<noscript><img src='http://dgc17.acecounter.com:8080/?uid=AP6F40149814536&je=n&' border='0' width='0' height='0' alt=''></noscript>	
<!-- AceCounter Log Gathering Script End --> 

</html>