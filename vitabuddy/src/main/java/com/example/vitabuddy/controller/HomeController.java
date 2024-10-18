package com.example.vitabuddy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import jakarta.servlet.http.HttpSession;
import org.springframework.ui.Model;

@Controller
public class HomeController {

    // 1. 인트로 화면 (로그인화면)
    @RequestMapping("/intro") 
    public String intro() {
        return "intro";
    }
    
    // 2. 메인홈페이지
    @RequestMapping("/home")
    public String home(HttpSession session, Model model) {
        // 세션에서 sid 확인
        String sid = (String) session.getAttribute("sid");
        if (sid == null) {
            // 세션에 sid가 없으면 intro 화면으로 리다이렉트
            return "redirect:/intro";
        }
        
        // 세션에 sid가 있으면 홈 화면으로 이동
        model.addAttribute("sid", sid);
        return "home";
    }
    
    // 3. 상품상세페이지
    @RequestMapping("/prdDetail")
    public String prdDetail() {
        return "supplement/productDetailView";
    }
}