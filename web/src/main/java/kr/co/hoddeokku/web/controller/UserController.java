package kr.co.hoddeokku.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("user")
public class UserController {
    // @ResponseBody
    @GetMapping("signin")
    public String signin() {

        return "user/signin";
    }

    @GetMapping("signup")
    public String signup() {

        return "user/signup";
    }

    @PostMapping("signup")
    public String signup(HttpServletResponse response) {


        return "user/signup-complete";
    }

    @GetMapping("signup-complete")
    public String signupComplete() {

        return "user/signup-complete";
    }

    @GetMapping("find-username")
    public String findUsername() {

        return "user/find-username";
    }

    @GetMapping("find-password")
    public String findPassword() {

        return "user/find-password";
    }
    
}
