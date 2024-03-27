package kr.co.hoddeokku.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
    
    // @ResponseBody
    @GetMapping("index")
    public String index(Model model) {
        model.addAttribute("m", "Rland still alive");
        return "index";
    }

    @GetMapping("test")
    public String test(Model model) {
        model.addAttribute("m", "Rland still alive");
        return "test";
    }

}
