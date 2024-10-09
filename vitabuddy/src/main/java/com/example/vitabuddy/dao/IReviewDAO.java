package com.example.vitabuddy.dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.example.vitabuddy.model.ReviewVO;

public interface IReviewDAO {

	// 1. 리뷰 추가
	void insertReview(ReviewVO review);

	// 2. 리뷰 조회
	ArrayList<ReviewVO> reviewList(int supId);

	// 3. 리뷰 삭제
	void deleteReview(HashMap<String, Object> map);

	// 4. 리뷰 수정
	void updateReview(ReviewVO review);

}
