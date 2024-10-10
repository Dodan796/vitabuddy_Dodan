/**
 *
 */
$(document).ready(function () {
  $("#reviewForm").on("submit", function (event) {
    event.preventDefault(); // 기본 폼 제출 방지

    var formData = new FormData(this);

    $.ajax({
      url: "/insertReview",
      type: "POST",
      data: formData,
      processData: false,
      contentType: false,
      success: function (response) {
        if (response === "success") {
          alert("리뷰가 성공적으로 작성되었습니다!");
          location.reload(); // 성공 시 페이지 새로고침
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
