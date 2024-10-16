package com.example.vitabuddy.service;

import java.util.List;

import com.example.vitabuddy.model.ReviewVO;

public interface IReviewService {

	// 리뷰 조회 기능
	List<ReviewVO> reviewLists(int supId);

	// 리뷰 작성 기능
	int insertReview(ReviewVO review);
	
	// 리뷰 삭제 기능
		int deleteReview(String reviewNo, String userId);

}