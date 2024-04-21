package kr.co.hoddeokku.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.hoddeokku.web.entity.Hodduk;
import kr.co.hoddeokku.web.entity.HoddukView;
import kr.co.hoddeokku.web.service.CustomUserDetails;
import kr.co.hoddeokku.web.service.HoddukServiceImp;

@Controller
@RequestMapping("/menu/hodduk")
public class HoddukController {

    @Autowired
    private HoddukServiceImp service;

    // @ResponseBody
    @GetMapping("list")
    public String list(
        Model model,
        @RequestParam(name = "query", required = false) String query
        ,@AuthenticationPrincipal CustomUserDetails userDetails // CustomUserDetails
    ) {

        Long memberId = null;
        if(userDetails != null)
            memberId = userDetails.getId();


        List<HoddukView> menus = new ArrayList<>();

        if(query != null){
            menus = service.getList(memberId, query);    
        }
        else{
            menus = service.getList(memberId);
        }
        model.addAttribute("list", menus);
        model.addAttribute("u", memberId);

        return "/menu/hodduk/list";
    }

    @GetMapping("detail")
    public String detail(Model model, @RequestParam("id") Integer id) {
        Hodduk hodduk = service.getById(id);
        
        model.addAttribute("hodduk", hodduk);
        return "menu/hodduk/detail";
    }

   

}
