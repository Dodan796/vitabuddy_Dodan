package com.example.vitabuddy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyPageController {

    // 마이페이지로 이동
    @RequestMapping("/myPage")
    public String myPage() {
        return "member/myPage";  // myPage.jsp로 이동
    }
}
