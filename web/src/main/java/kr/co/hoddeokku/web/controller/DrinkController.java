package kr.co.hoddeokku.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.hoddeokku.web.entity.Drink;
import kr.co.hoddeokku.web.service.DrinkService;

@Controller
@RequestMapping("/menu/drink")
public class DrinkController {
    
    @Autowired
    private DrinkService service;

    // @ResponseBody
    @GetMapping("list")
    public String list(Model model) {
        List<Drink> menus = new ArrayList<>();
        menus = service.getList();
        model.addAttribute("list", menus);

        return "/menu/drink/list";
    }

    @GetMapping("detail")
    public String detail() {
        return "/menu/drink/detail";
    }

}
