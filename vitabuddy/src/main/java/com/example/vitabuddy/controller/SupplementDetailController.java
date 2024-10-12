package com.example.vitabuddy.controller;

import com.example.vitabuddy.model.ReviewVO;
import com.example.vitabuddy.model.SupplementDetailVO;
import com.example.vitabuddy.service.ReviewService;
import com.example.vitabuddy.service.SupplementDetailService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller 
@RequestMapping("/supplement")
public class SupplementDetailController {
    @Autowired
    private SupplementDetailService supplementDetailService;

    @Autowired
    private ReviewService reviewService;
    
    @GetMapping("/supplementDetail/{id}")
    public String getSupplementDetailPage(@PathVariable("id") int supplementDetailId, Model model) {
        // 1. 상품 상세 정보 조회
        SupplementDetailVO detail = supplementDetailService.getSupplementDetailById(supplementDetailId);
        model.addAttribute("sup", detail);

        // 2. 리뷰 목록 조회
        List<ReviewVO> reviews = reviewService.reviewLists(supplementDetailId); // supId에 해당하는 리뷰 목록 조회
        model.addAttribute("reviewList", reviews);

        // 3. 상품 상세 정보와 함께 리뷰 목록도 추가해서 JSP 반환
        return "supplement/supplementDetail"; // 상품 상세 정보와 리뷰 목록을 보여주는 JSP 파일
    }
}
