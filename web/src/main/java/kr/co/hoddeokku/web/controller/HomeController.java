package kr.co.hoddeokku.web.controller;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.hoddeokku.web.entity.Drink;
import kr.co.hoddeokku.web.entity.Hodduk;
import kr.co.hoddeokku.web.entity.Notice;
import kr.co.hoddeokku.web.service.DrinkServiceImp;
import kr.co.hoddeokku.web.service.HoddukServiceImp;
import kr.co.hoddeokku.web.service.NoticeServiceImp;
import lombok.RequiredArgsConstructor;


@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class HomeController {
    
    @Autowired
    DrinkServiceImp serviceDrink;

    @Autowired
    HoddukServiceImp serviceHodd;

    @Autowired
    NoticeServiceImp serviceNot;


    // @ResponseBody
    @GetMapping("index")
    public String index(Model model) {
        List<Drink> listD = serviceDrink.getList();
        List<Hodduk> listH = serviceHodd.getList();
        List<Notice> listN = serviceNot.getList();

        //세션 현재 사용자 아이디 정보를 가져옴
        String id = SecurityContextHolder.getContext().getAuthentication().getName();

        //세션 현재 사용자 권한 정보를 가져옴
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        Iterator<? extends GrantedAuthority> iter = authorities.iterator();
        GrantedAuthority auth = iter.next();
        String role = auth.getAuthority();
        
        System.out.println(id);
        System.out.println(role);

        model.addAttribute("id", id);
        model.addAttribute("role", role);



        model.addAttribute("listD", listD);
        model.addAttribute("listH", listH);
        model.addAttribute("listN", listN);

        return "index";
    }

    @GetMapping("test")
    public String test(Model model) {
        model.addAttribute("m", "Rland still alive");
        return "test";
    }


}
