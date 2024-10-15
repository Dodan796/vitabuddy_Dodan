package com.example.vitabuddy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	// 1. 인트로 화면 (로그인화면)
	@RequestMapping("/")
	public String intro() {
		return "intro";
	}
	
	// 2. 메인홈페이지.
	@RequestMapping("/home")
	public String home() {
		return "home";
	}
	
	// 3. 상품상세페이지
	@RequestMapping("/review")
	public String prdDetail() {
		return"supplement/review";
	}
	
	// 4. 
	@RequestMapping("/register")
	public String register() {
		return "member/register";
	}
	
	// 5. 상품상세페이지
		@RequestMapping("/review2")
		public String supDetail() {
			return"supplement/supplementDetailView";
		}
	
	// 6. edit review
		@RequestMapping("/edit")
		public String edit() {
			return "supplement/editReview";
		}
		
	// 7. mypage
		@RequestMapping("/mypage")
		public String mypage() {
			return "mypage";
		}
		
}