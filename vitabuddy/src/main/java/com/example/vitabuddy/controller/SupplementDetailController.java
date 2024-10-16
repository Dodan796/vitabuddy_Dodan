package com.example.vitabuddy.controller;

import com.example.vitabuddy.model.ReviewVO;
import com.example.vitabuddy.model.SupplementDetailVO;
import com.example.vitabuddy.service.ReviewService;
import com.example.vitabuddy.service.SupplementDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Base64;
import java.util.List;

@Controller
@RequestMapping("/supplement")
public class SupplementDetailController {

    @Autowired
    private SupplementDetailService supplementDetailService;
    
    @Autowired
    private ReviewService reviewService;
    
    @GetMapping("/supplementDetail/{id}")
    public String getSupplementDetail(@PathVariable("id") int supplementDetailId, Model model) {
        SupplementDetailVO supplementDetail = supplementDetailService.getSupplementDetailById(supplementDetailId);
        
        if (supplementDetail.getSupImg() != null) {
            String base64Image = Base64.getEncoder().encodeToString(supplementDetail.getSupImg());
            model.addAttribute("supImgBase64", base64Image);
        } else {
            model.addAttribute("supImgBase64", ""); // 이미지가 없는 경우 빈 문자열로 설정
        }

        // 2. 리뷰 목록 조회 => 팀장님 코드에서 추가된 부분입니다. 
        List<ReviewVO> reviews = reviewService.reviewLists(supplementDetailId); // supId에 해당하는 리뷰 목록 조회
        model.addAttribute("reviewList", reviews);
        
        model.addAttribute("supplementDetail", supplementDetail);
        return "supplement/supplementDetail"; // 뷰 이름을 반환
    }
}
