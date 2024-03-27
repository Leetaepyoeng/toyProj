package kr.co.hoddeokku.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/support/notice")
public class NoticeController {

    @GetMapping("list")
    public String list() {
        return "/support/notice/list";
    }

    @GetMapping("detail")
    public String detail() {
        return "/support/notice/detail";
    }

}
