package kr.co.hoddeokku.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

@Controller
@RequestMapping("/")
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
