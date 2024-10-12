<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>상품 상세 조회</title>
		<script src="<c:url value='/js/jquery-3.7.1.min.js'/>"></script>
		<script src="<c:url value='/js/rating.js'/>"></script>
		<!-- css 링크 수정 --><link rel="stylesheet" type="text/css" href="<c:url value='/css/supplementDetail.css'/>">
		<c:import url="/WEB-INF/views/layout/head.jsp" />
	</head>
	<body>
		<div id="wrap">
			<!--  top -->         
		
        	<c:import url="/WEB-INF/views/layout/top.jsp" />
			
			<div class="prdProfile">

			<br><br>
			<table>
			<tr><td><h2>
			${sup.supName}</h2></td><td></td><td rowspan="5"><img class="prdImg" src="${sup.supImg}" width="300" height="300"></td></tr>
			<!-- 별점 -->
			<tr><td>
			<%-- <div class="rating">
			<c:forEach var="i" begin="1" end="5">
	            <i class="${i <= sup.rating ? 'fa-solid fa-star' : 'fa-regular fa-star'}"></i>
	        </c:forEach>
	        </div> --%></td><td></td><td></td></tr>
	        
	        <tr><td>
			<%-- <div class="hashTag"> 
			${sup.supTag} --%>
        	</div></td><td></td><td></td></tr>
			<tr><td>
			<a href="#" id="addWish" data-prd-id="${sup.supId}">찜목록 추가</a></td>
			<td><a href="#" id="addCart" data-prd-id="${sup.supId}">장바구니 추가</a></td><td></td></tr>
					<tr><td>가격  </td>
							<td><span id="price" data-price="${sup.supPrice}">
									<fmt:formatNumber value="${sup.supPrice}" pattern="#,###" /></span> 원</td><td></td></tr>
						<tr><td>브랜드</td><td>${sup.supBrand}</td><td></td></tr>
				</table>

			</div>
				
				<br>
				
				<!-- 상품 상세 정보 -->
				<div class="prdInfo">
				<h2>상품 상세 정보</h2>
					<div>
							<h3>상품설명</h3>
							<p>${sup.supDetail}</p>
					</div>
					<div>
							<h3>복용법</h3>
							<p>${sup.supDosage}</p>
					</div>
					<div>
							<h3>주의사항</h3>
							<p>${sup.supPrecautions}</p>
					</div>
					<div>
							<h3>영양정보</h3>
							<table>
							<tr><td>${sup.supNutri}</td><td>${sup.supNutriInfo}</td></tr>
							</table>
					</div>
				</div>
				
				<!-- 리뷰작성 -->
				<div class="reviewWrite">
				<form method="post" id="reviewForm" enctype="multipart/form-data" action="/supplement/supplementDetail/${sup.supId}/review">
					<input type="hidden" name="reviewNo" value="${review.reviewNo}">
        			<input type="hidden" name="userId" value="${sessionScope.sid}">
        			<input type="hidden" name="supId" value="${sup.supId}">
		       		<!-- 리뷰 제목 -->
		       		<label>리뷰제목</label>
		       		<br>
		       		<input class="reviewTitle" type="text" name="reviewTitle" value="${review.reviewTitle}">

		       		<br>
		       	
		       		<!-- 별점 -->
					<div class="rating">
					    <label class="ratingLabel" for="star1">
					        <input type="radio" id="star1" class="ratingInput" name="rating" value="1" 
					            ${review.rating == 1 ? 'checked' : ''}>
					        <span class="starIcon" data-value="1"><i class="fa-regular fa-star"></i></span>
					    </label>
					    
					    
					    <label class="ratingLabel" for="star2">
					        <input type="radio" id="star2" class="ratingInput" name="rating" value="2" 
					            ${review.rating == 2 ? 'checked' : ''}>
					        <span class="starIcon" data-value="2"><i class="fa-regular fa-star"></i></span>
					    </label>
					    
					    <label class="ratingLabel" for="star3">
					        <input type="radio" id="star3" class="ratingInput" name="rating" value="3" 
					            ${review.rating == 3 ? 'checked' : ''}>
					        <span class="starIcon" data-value="3"><i class="fa-regular fa-star"></i></span>
					    </label>
					    
					    <label class="ratingLabel" for="star4">
					        <input type="radio" id="star4" class="ratingInput" name="rating" value="4" 
					            ${review.rating == 4 ? 'checked' : ''}>
					        <span class="starIcon" data-value="4"><i class="fa-regular fa-star"></i></span>
					    </label>
					    
					    <label class="ratingLabel" for="star5">
					        <input type="radio" id="star5" class="ratingInput" name="rating" value="5" 
					            ${review.rating == 5 ? 'checked' : ''}>
					        <span class="starIcon" data-value="5"><i class="fa-regular fa-star"></i></span>
					    </label>
					</div>
    
					<br>
					
					<table class="option">
					<tr><td></td><td></td><td><label for="date">복용기간</label></td></tr>
						
					<!-- 해시태그 -->
						<tr>
							<td><select id="hashtag" name="reviewHashtag">
								<option value="1" >1</option>
								<option value="2" >2</option>
								<option value="3" >3</option>
									 <c:forEach var="tag" items="${taglist}">
            							<option value="${tag.tagNo}">${tag.tagName}</option>
        							</c:forEach>
								</select>
							</td>
						
					<!-- 복용기간 설정 -->	
							<td>
								<input type="date" id="date1" name="startDate" value="${review.startDate}" max="2100-12-31" min="2000-01-01"> ~  	 
			        		</td>
							<td>
								<input type="date" id="date2" name="endDate" value="${review.endDate}" max="2100-12-31" min="2000-01-01">
				        	</td>
				        </tr>
					</table>
				
		       		<!-- 리뷰 내용 -->
		       		<br>
		       		<textarea class="reviewTxt" name="content" cols="150" rows="5">${review.content}</textarea><br>
		       		<!-- 사진 첨부 -->
		       		<input class="Upload" type="file" id="uploadFile" name="reviewImg">
		       		
					    <br>

	        		<!-- submit -->
	        			<input type="submit" value="작성하기" class="btn btnFilled">
        		</form>
        		</div>
        		
        		<!-- 리뷰목록 -->
        		<div class="reviews">
        			<c:forEach var="review" items="${getReviewList}">
				        <table class="reviewItem">
						    <tr><td><h3>${review.reviewTitle}</h3></td><td></td><td></td><td></td></tr>
						    <tr><td><p>${review.userId}</p></td><td><div class="hashTag">${review.reviewHashTag}</div></td><td></td><td><c:if test="${review.userId == sessionScope.sid}">
										                <a href="#" class="deleteReview" data-review-id="${review.userId}">리뷰삭제</a>
										            </c:if></td></tr>
						    <tr><td><p>리뷰 내용</p></td><td><div class="rate"><c:forEach var="i" begin="1" end="5">
							            <i class="${i <= review.rating ? 'fa-solid fa-star' : 'fa-regular fa-star'}"></i>
							        </c:forEach></div></td><td></td><td rowspan="2"><img class="reviewImg" src="/image/review.png" width="100" height="100"></td></tr>
							<tr><td colspan="3" class="content"><p>${review.content}</p></td></tr>
							<tr><td></td><td></td><td></td><td><a href="#" class="btn btnUnfilled">신고하기</a></td></tr>
						</table>
				    </c:forEach>
			    
				    	<nav>
							<!-- 페이지네이션 -->
								<div class="pagination">
								    <a href="#" class="prev <c:if test='${currentPage == 1}'>disabled</c:if>" data-page="${currentPage - 1}""><i class="fa-solid fa-caret-left"></i></a>
								    <c:forEach var="i" begin="1" end="${totalPages}">
								        <a href="#" class="page" onclick="changePage(${i})">${i}</a>
								    </c:forEach>
								    <a href="#" class="next <c:if test='${currentPage == totalPages}'>disabled</c:if>" data-page="${currentPage + 1}"><i class="fa-solid fa-caret-right"></i></a>
								</div>
						</nav>
				
				</div>
			
			 <!--  footer -->         
	         <c:import url="/WEB-INF/views/layout/footer.jsp" /> 
    
		</div>
	</body>
</html>