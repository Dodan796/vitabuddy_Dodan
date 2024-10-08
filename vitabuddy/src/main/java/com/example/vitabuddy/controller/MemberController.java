package com.example.vitabuddy.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.vitabuddy.dto.MemberDTO;
import com.example.vitabuddy.service.MemberService;

@Controller
@RequestMapping("/member") // register.jsp는 /member/register에서 접근 가능하도록 함.
public class MemberController {

    @Autowired
    private MemberService memberService;

    // GET 요청으로 JSP 페이지를 로드할 수 있도록 설정
    @GetMapping("/register")
    public String showRegisterPage() {
        return "member/register"; // /WEB-INF/views/member/register.jsp로 이동
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody MemberDTO member) {
        boolean isRegistered = memberService.registerMember(member);

        if (!isRegistered) {
            return new ResponseEntity<>("Passwords do not match", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Registration successful", HttpStatus.OK);
    }
    
    @GetMapping("/checkId")
    public ResponseEntity<Map<String, Boolean>> checkId(@RequestParam String userId) {
        boolean isAvailable = memberService.isUserIdAvailable(userId);
        Map<String, Boolean> response = new HashMap<>();
        response.put("available", isAvailable);
        return ResponseEntity.ok(response);
    }
}
