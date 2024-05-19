package kr.co.hoddeokku.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.hoddeokku.web.entity.Notice;

@Controller
@RequestMapping("/support/faq")
public class FaqController {

    @GetMapping("list")
    public String list(Model model) {
        // List<faq> menus = new ArrayList<>();
        // menus = service.getList();
        // model.addAttribute("list", menus);

        return "/support/faq/list";
    }
}
