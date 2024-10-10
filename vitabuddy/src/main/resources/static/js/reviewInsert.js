/**
 *
 */
$(document).ready(function () {
  // 리뷰 작성 폼이 제출될 때 AJAX 요청 보내기
  $("#reviewForm").on("submit", function (event) {
    event.preventDefault(); // 기본 폼 제출 방지

    // FormData 객체 생성하여 폼 데이터를 포함시킴
    var formData = new FormData(this);

    $.ajax({
      url: "/insertReview", // 서버의 엔드포인트 URL
      type: "POST",
      data: formData,
      processData: false, // 파일 전송을 위해 기본 처리 비활성화
      contentType: false, // 파일 전송을 위해 Content-Type 설정 비활성화
      enctype: "multipart/form-data",
      success: function (response) {
        if (response === "success") {
          alert("리뷰가 성공적으로 작성되었습니다!");
          location.reload(); // 페이지 새로고침 또는 다른 동작 수행
        } else {
          alert("리뷰 작성에 실패했습니다. 다시 시도해주세요.");
        }
      },
      error: function () {
        alert("서버 오류가 발생했습니다. 잠시 후 다시 시도해주세요.");
      },
    });
  });
});
