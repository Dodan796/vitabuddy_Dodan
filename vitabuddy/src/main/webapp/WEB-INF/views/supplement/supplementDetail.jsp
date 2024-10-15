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
		<script src="<c:url value='/js/toggle.js'/>"></script>
		<link rel="stylesheet" type="text/css" href="<c:url value='/css/supplementDetail.css'/>">
		<c:import url="/WEB-INF/views/layout/head.jsp" />
	</head>
	<body>
		<div id="wrap">
			<!-- top 메뉴 포함 -->
			<c:import url="/WEB-INF/views/layout/top.jsp" />

			<!-- 상품 프로필 -->
			<section class="prdProfile">
				<br><br>
				<table>
					<tr>
						<td colspan="4">
							<h2>${supplementDetail.supName}</h2>
						</td>
						<td rowspan="6">
							<!-- 이미지 표시 방식 수정: Base64 인코딩으로 변환된 이미지를 표시 -->
							<img class="prdImg" src="data:image/png;base64,${supImgBase64}" width="300" height="300" alt="Product Image">
						</td>
					</tr>

					<!-- 별점 -->
					<tr>
						<td>
							<%-- <div class="rating">
							<c:forEach var="i" begin="1" end="5">
								<i class="${i <= supplementDetail.rating ? 'fa-solid fa-star' : 'fa-regular fa-star'}"></i>
							</c:forEach>
							</div> --%>
						</td>
						<td></td><td></td><td></td><td></td>
					</tr>

					<!-- 태그 -->
					<tr>
						<td>
							<%-- <div class="hashTag"> 
							${supplementDetail.supTag} --%>
							</div>
						</td>
						<td></td><td></td><td></td><td></td>
					</tr>

					<!-- 찜목록 및 장바구니 추가 -->
					<tr>
						<td colspan="2">
							<a href="#" id="addWish" data-prd-id="${supplementDetail.supId}">찜목록 추가</a>
						</td>
						<td colspan="2">
							<a href="#" id="addCart" data-prd-id="${supplementDetail.supId}">장바구니 추가</a>
						</td>
						<td></td>
					</tr>

					<!-- 가격 정보 -->
					<tr>
						<td>가격</td>
						<td>
							<span id="price" data-price="${supplementDetail.supPrice}">
								<fmt:formatNumber value="${supplementDetail.supPrice}" pattern="#,###" />
							</span> 원
						</td>
						<td></td><td></td>
					</tr>

					<!-- 브랜드 정보 -->
					<tr>
						<td>브랜드</td>
						<td>${supplementDetail.supBrand}</td>
						<td></td><td></td>
					</tr>
				</table>
			</section>
			
			<br>
			
			<!-- 상품 상세 정보 -->
			<section class="prdInfo">
				<h2>상품 상세 정보</h2>
				<div>
					<!-- 상품 설명 -->
					<div>
						<h3>상품설명</h3>
						<p>${supplementDetail.supDetail}</p>
					</div>
					
					<!-- 복용법 -->
					<div>
						<h3>복용법</h3>
						<p>${supplementDetail.supDosage}</p>
					</div>
					
					<!-- 주의사항 -->
					<div>
						<h3>주의사항</h3>
						<p>${supplementDetail.supPrecautions}</p>
					</div>
					
					<!-- 영양 정보 -->
					<div>
						<h3>영양정보</h3>
						<table>
							<tr>
								<td>${supplementDetail.supNutri}</td>
								<td>${supplementDetail.supNutriInfo}</td>
							</tr>
						</table>
					</div>
				</div>
			</section>
			
			<!-- footer 포함 -->
			<c:import url="/WEB-INF/views/layout/footer.jsp" /> 
		</div>
	</body>
</html>
