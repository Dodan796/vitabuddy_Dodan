package com.example.vitabuddy.service;

import com.example.vitabuddy.dao.SupplementDAO;
import com.example.vitabuddy.dto.UserSupplementDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SupplementService {

    private final SupplementDAO supplementDAO;

    @Autowired
    public SupplementService(SupplementDAO supplementDAO) {
        this.supplementDAO = supplementDAO;
    }

    // 키워드와 브랜드로 영양제 검색
    public List<UserSupplementDTO> searchSupplements(String keyword, String brand) {
        return supplementDAO.findSupplementsByKeywordAndBrand(keyword, brand);
    }

    // 사용자가 복용 중인 영양제 목록 조회
    public List<UserSupplementDTO> getUserSupplements(String userId) {
        return supplementDAO.findUserSupplementsByUserId(userId);
    }
    
    // 사용자가 복용 중인 영양제 삭제
    public boolean deleteSupplement(String userId, Integer supId) {
        return supplementDAO.deleteSupplementBySupID(userId, supId) > 0;
    }
}
