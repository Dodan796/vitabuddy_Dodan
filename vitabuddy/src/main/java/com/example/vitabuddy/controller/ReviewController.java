package com.example.vitabuddy.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.vitabuddy.model.ReviewVO;
import com.example.vitabuddy.service.ReviewService;

@Controller
public class ReviewController {

	@Autowired
	ReviewService revService;

	
	// 1. 리뷰 작성
	@ResponseBody
	@RequestMapping("/insertReview")
	public String insertReview(ReviewVO review) {
		revService.insertReview(review);
		return "success";
	}

	// 2. 리뷰 조회
	@RequestMapping("/reviewList")
	public String reviewList(@PathVariable int supId, Model model) {
		ArrayList<ReviewVO> reviews = revService.reviewList(supId);
		model.addAttribute("reviews",reviews);
		return "supplement/supplementDetailView";
	}
	
	
	// 3. 리뷰 삭제
	@ResponseBody
	@RequestMapping("/deleteReview")
	public String deleteReview(@RequestParam("reviewNo") String reviewNo,
							   @RequestParam("userId") String userId) {
		revService.deleteReview(reviewNo, userId);
		return "success";
	}
	
	
	// 4. 리뷰 수정
	@ResponseBody
	@RequestMapping("/updateReview")
	public String updateReview(ReviewVO reviewVO) {
		revService.updateReview(reviewVO);
		
		return "success";
	}
	
	
}
