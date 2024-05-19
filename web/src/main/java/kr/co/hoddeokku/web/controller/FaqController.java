package kr.co.hoddeokku.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.hoddeokku.web.entity.Fqa;
import kr.co.hoddeokku.web.service.FqaService;

@Controller
@RequestMapping("/support/faq")
public class FaqController {

    @Autowired
    FqaService fqaService;

    @GetMapping("list")
    public String list(Model model) {
        List<Fqa> list = new ArrayList<>();
        list = fqaService.getList();
        model.addAttribute("list", list);

        return "/support/faq/list";
    }
}
