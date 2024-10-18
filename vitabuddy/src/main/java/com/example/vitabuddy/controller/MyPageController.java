package com.example.vitabuddy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.vitabuddy.dto.UserSupplementDTO;
import com.example.vitabuddy.service.SupplementService;

import jakarta.servlet.http.HttpSession;

@Controller
public class MyPageController {

	@Autowired
	SupplementService supService; // => 추가된 코드.

	@RequestMapping("/myPage")
	public String myPage(HttpSession session, Model model) {

		String userId = (String) session.getAttribute("sid");
		List<UserSupplementDTO> userSupplements = supService.getUserSupplements(userId);
		model.addAttribute("userSupplements", userSupplements);

		return "member/myPage";
	}

}
