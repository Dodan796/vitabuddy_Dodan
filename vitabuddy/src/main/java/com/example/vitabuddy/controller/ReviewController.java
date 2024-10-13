package com.example.vitabuddy.controller;

import com.example.vitabuddy.model.ReviewVO;
import com.example.vitabuddy.service.IReviewService;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/supplement")
public class ReviewController {

    @Autowired
    private IReviewService reviewService;

    private static final String UPLOAD_DIR = "C:/Review_Upload/"; // 파일이 저장될 경로

    // 1. 리뷰 목록 조회 (회원/비회원 모두 가능)
    @GetMapping("/supplementDetail/{supId}/reviews")
    public String getReviewList(@PathVariable("supId") int supId, Model model) {
        List<ReviewVO> reviews = reviewService.reviewLists(supId);
        model.addAttribute("reviewList", reviews);
        return "supplement/reviewList"; // 리뷰 목록을 보여주는 JSP 파일
    }

    // 2. 리뷰 작성 처리 (회원만 가능)
    @PostMapping("/supplementDetail/{supId}/review")
    public String insertReview(
            @PathVariable("supId") int supId,
            @RequestParam("reviewTitle") String reviewTitle,
            @RequestParam("rating") String rating,
            @RequestParam("reviewHashtag") String reviewHashtag,
            @RequestParam("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
            @RequestParam("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate,
            @RequestParam("content") String content,
            @RequestParam(value = "reviewImg", required = false) List<MultipartFile> reviewImgFiles,
            HttpSession session) {

        // 로그인 여부 확인
        String userId = (String) session.getAttribute("sid");
        if (userId == null) {
            return "redirect:/"; // 비회원일 경우 로그인 페이지로 리다이렉트
        }

        ReviewVO reviewVO = new ReviewVO();
        String reviewNo = UUID.randomUUID().toString();
        reviewVO.setReviewNo(reviewNo);
        reviewVO.setSupId(supId);
        reviewVO.setUserId(userId);
        reviewVO.setReviewDate(new Date());
        reviewVO.setReviewTitle(reviewTitle);
        reviewVO.setRating(rating);
        reviewVO.setReviewHashtag(reviewHashtag);
        reviewVO.setStartDate(startDate);
        reviewVO.setEndDate(endDate);
        reviewVO.setContent(content);

        // 이미지 파일 처리 (최대 3개)
        StringBuilder imageNames = new StringBuilder();
        if (reviewImgFiles != null && !reviewImgFiles.isEmpty()) {
            for (int i = 0; i < Math.min(3, reviewImgFiles.size()); i++) {
                MultipartFile file = reviewImgFiles.get(i);
                if (!file.isEmpty()) {
                    String originalFilename = file.getOriginalFilename();
                    String extension = originalFilename.substring(originalFilename.lastIndexOf("."));
                    String uniqueFileName = UUID.randomUUID().toString() + extension;

                    // 파일 저장
                    try {
                        File destFile = new File(UPLOAD_DIR + uniqueFileName);
                        file.transferTo(destFile);
                        imageNames.append(uniqueFileName);

                        // 마지막 파일이 아니면 세미콜론 추가
                        if (i < Math.min(3, reviewImgFiles.size()) - 1) {
                            imageNames.append(";");
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                        return "error/fileUploadError"; // 파일 저장 실패 시 에러 페이지로 이동
                    }
                }
            }
        }

        // 이미지 파일명을 reviewVO에 설정 (빈 경우 빈 문자열 저장)
        reviewVO.setReviewImg(imageNames.length() > 0 ? imageNames.toString() : "");

        // 리뷰 저장
        int result = reviewService.insertReview(reviewVO);
        if (result == -1) {
        	// 파일 저장 실패 시 에러 페이지로 이동
            return "error/fileUploadError"; 
        }
        	// 리뷰 작성 후 상세 페이지로 리다이렉트
        return "redirect:/supplement/supplementDetail/" + supId; 
    }
    
    // 3. 리뷰 삭제
    @PostMapping("/supplementDetail/{supId}/review/{reviewNo}/delete")
    public String deleteReview(@PathVariable("supId") int supId, @PathVariable("reviewNo") String reviewNo, HttpSession session) {
    	
    	// 로그인 확인
    	String userId = (String) session.getAttribute("sid");
    	if(userId==null) {
    		return "redirect:/intro";
    	}
    	
    	// 삭제 로직
    	int result =reviewService.deleteReview(reviewNo, userId);
    	if(result == 0) {
    		return "삭제실패";
    	}
    	
    	return "redirect:/supplement/supplementDetail/" + supId;
    	
    	
    	
    }
    
    
    
    
    
    
}
