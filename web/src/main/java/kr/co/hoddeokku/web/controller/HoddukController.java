package kr.co.hoddeokku.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.hoddeokku.web.service.HoddukService;

@Controller
@RequestMapping("/menu/hodduk")
public class HoddukController {

    @Autowired
    private HoddukService service;

    // @ResponseBody
    @GetMapping("list")
    public String list() {
        return "/menu/hodduk/list";
    }

    @GetMapping("detail")
    public String detail() {
        return "/menu/hodduk/detail";
    }

   

}
