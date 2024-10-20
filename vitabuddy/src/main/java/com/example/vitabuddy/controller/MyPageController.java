package com.example.vitabuddy.controller;

import java.util.List;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.vitabuddy.dto.UserSupplementDTO;
import com.example.vitabuddy.model.InteractionVO;
import com.example.vitabuddy.model.ReviewVO;
import com.example.vitabuddy.service.InteractionService;
import com.example.vitabuddy.service.ReviewService;
import com.example.vitabuddy.service.SupplementService;

@Controller
@RequestMapping("/member")
public class MyPageController {

    @Autowired
    private SupplementService supService;

    @Autowired
    private ReviewService reviewService; // 리뷰 서비스를 주입받습니다.

    @Autowired
    private InteractionService intService;
    
    // 마이페이지로 이동
    @GetMapping("/myPage")
    public String myPage(HttpSession session, Model model) {
        // 세션에서 사용자 ID를 가져옴
        String userId = (String) session.getAttribute("sid");
        if (userId == null) {
            return "redirect:/intro"; // 로그인 페이지로 리다이렉트
        }

        // 사용자가 복용 중인 영양제 목록을 조회
        List<UserSupplementDTO> userSupplements = supService.getUserSupplements(userId);
        model.addAttribute("userSupplements", userSupplements);
        
        // 상호작용 정보 조회
        List<String> ingredientNames = intService.getIngredientNames(userId);
        List<InteractionVO> interactions = intService.getInteractionDetails(userId);
        System.out.println("Interactions 데이터: " + interactions);
    
        model.addAttribute("ingredientNames", ingredientNames);
        model.addAttribute("interactions", interactions);
        
        
        
        // 사용자가 작성한 리뷰 목록을 조회
        List<ReviewVO> userReviews = reviewService.getUserReviews(userId);
        model.addAttribute("reviews", userReviews); // JSP에 전달할 리뷰 목록 추가

        return "member/myPage"; // member/myPage.jsp로 이동
    }
}
