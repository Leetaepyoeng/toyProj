package kr.co.hoddeokku.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import kr.co.hoddeokku.web.dto.SignInDTO;
import kr.co.hoddeokku.web.entity.User;
import kr.co.hoddeokku.web.service.CustomUserDetails;
import kr.co.hoddeokku.web.service.UserService;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService service;

    // @ResponseBody
    @GetMapping("signin")
    public String signin() {

        return "user/signin";
    }

    @GetMapping("info")
    public String info(@AuthenticationPrincipal CustomUserDetails userdetails) {

        
        return "user/info";
    }

    // 기존 로그인
    // @PostMapping("signin")
    // public String signin(String username,String password, HttpServletResponse response
    // // , HttpSession session
    // ) {

    //     boolean valid = service.validate(username, password);//인증검사
    //     User user = service.getByUserName(username);

    //     if(!valid)//유효하지 않으면
    //         return "redirect:signin?error";

    //     Cookie uidCookie = new Cookie("uid", String.valueOf(user.getId()));
    //     uidCookie.setPath("/");
    //     // uidCookie.setMaxAge(0);//쿠키
    //     // uidCookie.setSecure(false);
    //     uidCookie.setHttpOnly(true);

    //     Cookie usernameCookie =  new Cookie("username", user.getUserName());
    //     usernameCookie.setPath("/");
    //     // session.setAttribute("uid", "1");
    //     // session.setAttribute("username", "newlec");

    //     response.addCookie(uidCookie);
    //     response.addCookie(usernameCookie);

    //     return "redirect:../index";//클라이언트가 2번 요청하게 되는 것
    // }

    @PostMapping("signin")
    public String signin(
        SignInDTO dto
    // , HttpSession session
    ) {
        System.out.println(dto);
        // service.joinProcess(dto);
        

        return "redirect:/user/signin";//클라이언트가 2번 요청하게 되는 것
    }

    @GetMapping("signup")
    public String signup() {

        return "user/signup";
    }

    @PostMapping("signup")
    public String signup(
        User user,
        @RequestParam("emailstate") String eamilState
        ) {
        // System.out.println(eamilState);

        service.regUser(user);

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
