package kr.co.hoddeokku.web.controller.admin;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.hoddeokku.web.entity.User;
import kr.co.hoddeokku.web.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@Controller("adminHomeController")
@RequestMapping("admin")
public class HomeController {

    
    @GetMapping("index")
    public String index() {

        return "admin/index";
    }    

   
}
