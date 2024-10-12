/**
 *
 */
 $(document).ready(function () {
    $('#reviewForm').submit(function (event) {
        event.preventDefault(); // 폼의 기본 제출 동작을 방지

        // 폼 데이터 수집
        var reviewData = {
            reviewTitle: $('input[name="reviewTitle"]').val(),
            userId: $('input[name="userId"]').val(),
            supId: $('input[name="supId"]').val(),
            rating: $('input[name="rating"]:checked').val(),
            reviewHashtag: $('#hashtag').val(),
            startDate: $('#date1').val(),
            endDate: $('#date2').val(),
            content: $('textarea[name="content"]').val()
        };

        var formData = new FormData();
        formData.append('review', new Blob([JSON.stringify(reviewData)], { type: "application/json" }));

        // 파일 추가 (이미지 최대 3개)
        var files = $('#uploadFile')[0].files;
        if (files.length > 3) {
            alert('이미지는 최대 3개까지 업로드할 수 있습니다.');
            return;
        }
        for (var i = 0; i < files.length; i++) {
            formData.append('imageUrl', files[i]);
        }

        $.ajax({
            url: '/reviews',
            type: 'POST',
            data: formData,
            processData: false,
            contentType: false,
            enctype: 'multipart/form-data',
            success: function (response) {
                alert(response);
                location.reload(); // 작성 완료 후 페이지 새로고침
            },
            error: function (xhr, status, error) {
                alert('오류발생: ' + xhr.responseText);
            }
        });
    });
});

