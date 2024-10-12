package com.example.vitabuddy.service;

import com.example.vitabuddy.dao.SupplementDetailDAO;
import com.example.vitabuddy.model.SupplementDetailVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Base64;

@Service
public class SupplementDetailService {
    @Autowired
    private SupplementDetailDAO supplementDetailDAO;

    public SupplementDetailVO getSupplementDetailById(int supId) {
        SupplementDetailVO detail = supplementDetailDAO.getSupplementDetailById(supId);

        // 이미지 byte[]를 Base64 인코딩하여 문자열로 변환
        if (detail.getSupImg() != null) {
            String base64Img = Base64.getEncoder().encodeToString(detail.getSupImg());
            detail.setBase64SupImg(base64Img); // 변환된 값을 VO에 추가
        }

        return detail;
    }
}
