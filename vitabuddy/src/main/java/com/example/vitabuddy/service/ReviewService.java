package com.example.vitabuddy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.vitabuddy.dao.IReviewDAO;
import com.example.vitabuddy.model.ReviewVO;

@Service
public class ReviewService implements IReviewService {

	@Autowired
	@Qualifier("IReviewDAO")
	IReviewDAO dao;

	// 리뷰 조회 기능
	@Override
	public List<ReviewVO> reviewLists(int supId) {
		
		return dao.reviewLists(supId);
	}

	// 리뷰 작성 기능
	@Override
	public int insertReview(ReviewVO review) {
		
		return dao.insertReview(review);
	}
	
	// 리뷰 삭제 기능
	@Override
	public int deleteReview(String reviewNo, String userId) {
		
		return dao.deleteReview(reviewNo, userId);
	}

}