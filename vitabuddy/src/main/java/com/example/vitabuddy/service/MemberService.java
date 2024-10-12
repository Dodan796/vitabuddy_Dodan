package com.example.vitabuddy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.vitabuddy.dao.MemberDAO;
import com.example.vitabuddy.dto.MemberDTO;

@Service
public class MemberService {

    @Autowired
    private MemberDAO memberDAO;
    
    public MemberDTO getUserInfo(String userId) {
        // MemberDAO에서 사용자 정보를 조회
        return memberDAO.getUserById(userId);
    }

    @Transactional  // 트랜잭션 어노테이션 추가
    public boolean registerMember(MemberDTO member) {
        // 데이터베이스에 회원 등록
        memberDAO.insertMember(member);
        return true;  // 회원가입 성공
    }
    
    public boolean isUserIdAvailable(String userId) {
        return memberDAO.getUserById(userId) == null; // 아이디가 존재하지 않으면 true 반환
    }
    
    public boolean isUserEmailAvailable(String userEmail) {
        return memberDAO.getUserByEmail(userEmail) == null;
    }

}
