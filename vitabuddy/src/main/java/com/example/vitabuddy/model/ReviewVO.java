package com.example.vitabuddy.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class ReviewVO {

	// 1. 리뷰 필드
	private String ReviewNo;
	private String ReviewTitle;
	private String UserId;
	private int SupId;
	private String Rating;
	private String ReviewHashtag;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date ReviewDate;
	private String Content;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date StartDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date EndDate;
	private String ReviewImg;

	// 2. 클래스 초기화
	public ReviewVO() {

	}

	// 3. getter & setter.
	public String getReviewNo() {
		return ReviewNo;
	}

	public void setReviewNo(String reviewNo) {
		ReviewNo = reviewNo;
	}

	public String getReviewTitle() {
		return ReviewTitle;
	}

	public void setReviewTitle(String reviewTitle) {
		ReviewTitle = reviewTitle;
	}

	public String getUserId() {
		return UserId;
	}

	public void setUserId(String userId) {
		UserId = userId;
	}

	public int getSupId() {
		return SupId;
	}

	public void setSupId(int supId) {
		SupId = supId;
	}

	public String getRating() {
		return Rating;
	}

	public void setRating(String rating) {
		Rating = rating;
	}

	public String getReviewHashtag() {
		return ReviewHashtag;
	}

	public void setReviewHashtag(String reviewHashtag) {
		ReviewHashtag = reviewHashtag;
	}

	public Date getReviewDate() {
		return ReviewDate;
	}

	public void setReviewDate(Date reviewDate) {
		ReviewDate = reviewDate;
	}

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

	public Date getStartDate() {
		return StartDate;
	}

	public void setStartDate(Date startDate) {
		StartDate = startDate;
	}

	public Date getEndDate() {
		return EndDate;
	}

	public void setEndDate(Date endDate) {
		EndDate = endDate;
	}

	public String getReviewImg() {
		return ReviewImg;
	}

	public void setReviewImg(String reviewImg) {
		ReviewImg = reviewImg;
	}

}
