package kr.co.hoddeokku.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.hoddeokku.web.entity.Drink;
import kr.co.hoddeokku.web.entity.Hodduk;
import kr.co.hoddeokku.web.service.DrinkService;

@Controller
@RequestMapping("/menu/drink")
public class DrinkController {
    
    @Autowired
    private DrinkService service;

    // @ResponseBody
    @GetMapping("list")
    public String list(
        Model model,
        @RequestParam(name = "query", required = false) String query
    ) {
        List<Drink> menus = new ArrayList<>();

        if(query != null){
            menus = service.getList(query);    
        }
        else{
            menus = service.getList();
        }
        model.addAttribute("list", menus);

        return "/menu/drink/list";
    }

    @GetMapping("detail")
    public String detail(Model model,  @RequestParam("id") Integer id) {
        Drink drink = service.getById(id);
        
        model.addAttribute("drink", drink);
        return "/menu/drink/detail";
    }

}
