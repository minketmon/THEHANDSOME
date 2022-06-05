package com.jmh.controller;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jmh.domain.AttachImageVO;
import com.jmh.domain.MemberVO;
import com.jmh.domain.QnaVO;
import com.jmh.service.MemberService;
import com.jmh.service.QnaService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

/* 
 * 작성자 : 고정민
 * 
 * 마이페이지에서 관련 기능을 다룬 컨트롤러
 * [개인정보 변경, 회원 탈퇴, QNA 작성, 수정, 삭제, 파일 업로드, 파일출력]
 */
@Log4j
@Controller
@RequestMapping("/mypage")
@AllArgsConstructor
public class MypageController {

	private MemberService service;
	private QnaService qservice;

	// 파일 업로드 경로
	@Resource(name = "uploadPath")
	private String uploadPath;

	// 마이페이지 뷰로 이동
	@GetMapping("")
	public void mypageGet(HttpServletRequest request, Model model) throws Exception {
		log.info("마이페이지 진입");
		
		// 세션에서 로그인된 사용자의 값을 받아옴
		HttpSession session = request.getSession();
		MemberVO memberVO = (MemberVO) session.getAttribute("member");
		
		// 해당 사용자가 작성한 QNA 전체 개수 조회 (페이징에 사용)
		int qnaCount = qservice.qnaTotal(memberVO.getMid());
		model.addAttribute("qnaCount", qnaCount);
		// log.info(qnaList);
		log.info(model.toString());

	}

	// 개인정보변경 뷰로 이동
	@GetMapping("/personInformationChange")
	public void personInformationChangeGet() {
		log.info("개인정보변경 진입");
	}

	// 뷰에서 VO 객체를 전달받아 해당 값으로 회원 정보를 변경해주도록 처리
	@PostMapping("/personInformationChange")
	public String personInformationChangePost(MemberVO member, RedirectAttributes rttr) throws Exception {
		log.info("개인정보변경 처리");
		int result = service.modifyInfo(member);
		rttr.addFlashAttribute("modifyResult", result);

		return "redirect:/mypage"; // 변경이 완료되면 마이페이지로 이동
	}

	// 회원 탈퇴 기능
	@PostMapping("/memberWithdrawal")
	public String memberWithdrawalPost(MemberVO member, HttpServletRequest request, RedirectAttributes rttr) throws Exception {
		log.info("회원 탈퇴");
		int result = service.memberWithdrawal(member);
		rttr.addFlashAttribute("withdrawalResult", result);
		HttpSession session = request.getSession();
		session.invalidate();

		return "redirect:/"; // 메인으로 이동하도록 함
	}

	// QNA 작성 뷰로 이동
	@GetMapping("/QNA")
	public void qnaGet() {
		log.info("Qna 진입");
	}

	// QNA VO 객체를 뷰에서 받아와 테이블에 입력
	@PostMapping("/QNA")
	public String qnaPost(QnaVO qna, MultipartFile uploadFile, RedirectAttributes rttr) throws Exception {
		log.info("Qna 작성 컨트롤러");

		String uploadFolder = "/Users/gojeongmin/Downloads"; // 첨부파일이 업로드될 경로
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		Date date = new Date();

		String str = sdf.format(date);

		String datePath = str.replace("-", File.separator);
		File uploadPath = new File(uploadFolder, datePath); // uploadFolder 내부에 날짜 경로를 추가

		if (uploadPath.exists() == false) {
			uploadPath.mkdirs();
		}
		AttachImageVO vo = new AttachImageVO();
		String uploadFileName = uploadFile.getOriginalFilename();
		String uuid = UUID.randomUUID().toString();
		vo.setFileName(uploadFileName);
		vo.setUploadPath(datePath);
		vo.setUuid(uuid);
		uploadFileName = uuid + "_" + uploadFileName;

		// 파일 위치, 파일 이름을 합친 File 객체
		File saveFile = new File(uploadPath, uploadFileName);
		String[] path_split = saveFile.toString().split(uploadFolder);
		qna.setQnaimg("");
		qna.setQnathumimg("");
		if (!uploadFile.isEmpty()) {
			qna.setQnaimg(path_split[1]);
			qna.setQnathumimg(path_split[1]);

			// 파일 저장 
			try {
				uploadFile.transferTo(saveFile);
				File thumbnailFile = new File(uploadPath, "s_" + uploadFileName);

				BufferedImage bo_image = ImageIO.read(saveFile);
				double ratio = 3;
				
				// 넓이 높이 설정
				int width = (int) (bo_image.getWidth() / ratio);
				int height = (int) (bo_image.getHeight() / ratio);
				BufferedImage bt_image = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);

				Graphics2D graphic = bt_image.createGraphics();

				graphic.drawImage(bo_image, 0, 0, 300, 500, null);

				ImageIO.write(bt_image, "jpg", thumbnailFile);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		log.info(qna.getQnaimg());
		log.info(qna.getQnathumimg());
		qservice.qnaPost(qna); // qna 작성 서비스

		return "redirect:/mypage"; // 작성이 완료되면 마이페이지로 이동
	}
	
	// 사진 파일 불러오는 메소드
	@GetMapping("/display")
	public ResponseEntity<byte[]> getImage(String fileName) {

		File file = new File("/Users/gojeongmin/Downloads/" + fileName);
		ResponseEntity<byte[]> result = null;

		try {

			HttpHeaders header = new HttpHeaders();

			header.add("Content-type", Files.probeContentType(file.toPath()));

			result = new ResponseEntity<>(FileCopyUtils.copyToByteArray(file), header, HttpStatus.OK);

		} catch (IOException e) {
			e.printStackTrace();
		}

		return result;

	}

	// ajax로 작성된 QNA 리스트를 받아오는 메소드 (페이징)
	@GetMapping("/QNAList")
	@ResponseBody
	public List<QnaVO> qnaListGet(@RequestParam String mid, @RequestParam int pageNum, @RequestParam int amount) throws Exception {
		List<QnaVO> qnaList = qservice.qnaGet(mid, pageNum, amount); // 로그인된 사용자와 현재 페이지, 페이지에 보여질 게시물 개수를 전달
		return qnaList; // 리스트 반환
	}

	// QNA 수정 화면 뷰
	@GetMapping("/modifyQNA")
	public void qnaModify(@RequestParam int qid, Model model) throws Exception {
		model.addAttribute("qnaAttribute", qservice.qnaGetDetail(qid));
		log.info("QNA 수정화면 진입");
	}

	// QNA 수정 기능
	@PostMapping("/modifyQNA")
	public String qnaModify(QnaVO qna, RedirectAttributes rttr) throws Exception {
		log.info("QNA 수정" + qna);
		int result = qservice.qnaModify(qna);
		log.info("QNA 수정 result" + result);
		rttr.addFlashAttribute("qmodifyResult", result);

		return "redirect:/mypage"; // 완료되면 마이페이지로 이동
	}

	// QNA 삭제 기능 
	@PostMapping("/deleteQNA")
	public String qnaDelete(@RequestParam int qid) throws Exception {
		log.info("QNA 삭제" + qid); 
		qservice.qnaDelete(qid); // qid를 받아와 해당 게시물 삭제

		return "redirect:/mypage"; // 완료되면 마이페이지로 이동
	}

	// QNA 파일 첨부 기능
	@PostMapping(value = "/uploadImg", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<AttachImageVO> uploadAjaxActionPOST(MultipartFile uploadFile) {

		log.info("uploadAjaxActionPOST..........");

		log.info("파일 이름 : " + uploadFile.getOriginalFilename());
		log.info("파일 타입 : " + uploadFile.getContentType());
		log.info("파일 크기 : " + uploadFile.getSize());

		File checkfile = new File(uploadFile.getOriginalFilename());
		String type = null;

		try {
			type = Files.probeContentType(checkfile.toPath());
			log.info("MIME TYPE : " + type);
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (!type.startsWith("image")) {

			AttachImageVO vo = null;
			return new ResponseEntity<>(vo, HttpStatus.BAD_REQUEST);

		}
		String uploadFolder = "/Users/gojeongmin/Downloads";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		Date date = new Date();

		String str = sdf.format(date);

		String datePath = str.replace("-", File.separator);
		File uploadPath = new File(uploadFolder, datePath);
		
		// 설정 경로와 년/월/일 경로 추가하여 그 안에 저장
		if (uploadPath.exists() == false) {
			uploadPath.mkdirs();
		}
		AttachImageVO vo = new AttachImageVO();
		String uploadFileName = uploadFile.getOriginalFilename();
		String uuid = UUID.randomUUID().toString();
		vo.setFileName(uploadFileName);
		vo.setUploadPath(datePath);
		vo.setUuid(uuid);
		uploadFileName = uuid + "_" + uploadFileName;

		/* 파일 위치, 파일 이름을 합친 File 객체 */
		File saveFile = new File(uploadPath, uploadFileName);

		/* 파일 저장 */
		try {
			uploadFile.transferTo(saveFile);
			File thumbnailFile = new File(uploadPath, "s_" + uploadFileName);

			BufferedImage bo_image = ImageIO.read(saveFile);
			double ratio = 3;
			/* 넓이 높이 */
			int width = (int) (bo_image.getWidth() / ratio);
			int height = (int) (bo_image.getHeight() / ratio);
			BufferedImage bt_image = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);

			Graphics2D graphic = bt_image.createGraphics();

			graphic.drawImage(bo_image, 0, 0, 300, 500, null);

			ImageIO.write(bt_image, "jpg", thumbnailFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<AttachImageVO> result = new ResponseEntity<AttachImageVO>(vo, HttpStatus.OK);

		return result;
	}

}// end class
