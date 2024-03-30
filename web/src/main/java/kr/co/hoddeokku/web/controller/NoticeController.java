package kr.co.hoddeokku.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.hoddeokku.web.entity.Notice;
import kr.co.hoddeokku.web.service.NoticeServiceImp;

@Controller
@RequestMapping("/support/notice")
public class NoticeController {

    @Autowired
    NoticeServiceImp service;

    @GetMapping("list")
    public String list(Model model) {
        List<Notice> menus = new ArrayList<>();
        menus = service.getList();
        model.addAttribute("list", menus);

        return "/support/notice/list";
    }

    @GetMapping("detail")
    public String detail(Model model, @RequestParam("id") Integer id) {
        Notice menu = new Notice();
        menu = service.getById(id);
        model.addAttribute("m", menu);

        return "/support/notice/detail";
    }

}
