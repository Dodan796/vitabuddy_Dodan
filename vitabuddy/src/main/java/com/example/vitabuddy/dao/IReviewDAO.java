package com.example.vitabuddy.dao;

import com.example.vitabuddy.model.ReviewVO;

import java.util.List;

public interface IReviewDAO {

	// 리뷰 조회 기능
	List<ReviewVO> reviewLists(int supId);

	// 리뷰 작성 기능
	int insertReview(ReviewVO review);
	
	// 리뷰 삭제 기능
	int deleteReview(String reviewNo, String userId);
}