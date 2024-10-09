package com.example.vitabuddy.service;

import java.util.ArrayList;
import java.util.HashMap;

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

	// 1. 리뷰 작성
	@Override
	public void insertReview(ReviewVO review) {
		dao.insertReview(review);
	}

	// 2. 리뷰 조회.
	@Override
	public ArrayList<ReviewVO> reviewList(int supId) {

		return dao.reviewList(supId);
	}

	// 3. 리뷰 삭제.
	@Override
	public void deleteReview(String reviewNo, String userId) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("reviewNo", reviewNo);
		map.put("userId", userId);

		dao.deleteReview(map);
	}

	// 4. 리뷰 수정.
	@Override
	public void updateReview(ReviewVO review) {

		dao.updateReview(review);

	}

}
