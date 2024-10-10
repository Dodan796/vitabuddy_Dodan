package com.example.vitabuddy.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.example.vitabuddy.model.ReviewVO;
import com.example.vitabuddy.service.ReviewService;

import jakarta.servlet.http.HttpSession;

@Controller
public class ReviewController {

	@Autowired
	ReviewService revService;

	// 파일(이미지) 업로드 경로 읽어오기
	@Value("${file.upload-dir}")
	private String uploadDir;

	// 1. 회원 Id 추출
	private String getUserId(HttpSession session) {
		return (String) session.getAttribute("sid");
	}

	// 2. 리뷰 작성
	@ResponseBody
	@RequestMapping("/insertReview")
	public String insertReview(ReviewVO review, @RequestParam("file") MultipartFile file, HttpSession session) {
		String userId = getUserId(session);
		if (userId == null) {
			return "fail";
		}
		try {
			if (file != null && !file.isEmpty()) {
				// 파일 경로를 상대 경로로 설정
				Path path = Paths.get(uploadDir + file.getOriginalFilename());
				Files.write(path, file.getBytes());

				// 업로드된 파일 경로를 ReviewVO에 설정
				review.setReviewImg(file.getOriginalFilename());
			} else {
				review.setReviewImg(null); // 파일이 없는 경우 null로 설정
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "fail"; // 파일 업로드 실패 시
		}

		review.setUserId(userId);
		revService.insertReview(review);
		return "success";
	}

	// 3. 리뷰 조회
	@RequestMapping("/reviewList")
	public String reviewList(@PathVariable int supId, Model model) {
		ArrayList<ReviewVO> reviews = revService.reviewList(supId);
		model.addAttribute("reviews", reviews);
		return "supplement/supplementDetailView";
	}

	// 4. 리뷰 삭제
	@ResponseBody
	@RequestMapping("/deleteReview")
	public String deleteReview(@RequestParam("reviewNo") String reviewNo, HttpSession session) {
		String userId = getUserId(session);

		if (userId == null) {
			return "fail";
		}
		ReviewVO review = revService.getReview(reviewNo);
		if (review == null || !review.getUserId().equals(userId)) {
			return "fail";
		}
		revService.deleteReview(reviewNo, userId);
		return "success";
	}

	// 5. 리뷰 수정
	@ResponseBody
	@RequestMapping("/updateReview")
	public String updateReview(ReviewVO reviewVO, @RequestParam("file") MultipartFile file, HttpSession session) {
		String userId = getUserId(session);

		if (userId == null) {
			return "fail";
		}

		ReviewVO checkReview = revService.getReview(reviewVO.getReviewNo());
		if (checkReview == null || !checkReview.getUserId().equals(userId)) {
			return "fail";
		}
		try {
			if (file != null && !file.isEmpty()) {
				// 파일 경로를 상대 경로로 설정
				Path path = Paths.get(uploadDir + file.getOriginalFilename());
				Files.write(path, file.getBytes());

				// 업로드된 파일 경로를 ReviewVO에 설정
				reviewVO.setReviewImg(file.getOriginalFilename());
			} else {
				reviewVO.setReviewImg(checkReview.getReviewImg()); // 파일이 없으면 기존 파일 경로 유지
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "fail"; // 파일 업로드 실패 시
		}

		reviewVO.setUserId(userId);
		revService.updateReview(reviewVO);
		return "success";
	}
}