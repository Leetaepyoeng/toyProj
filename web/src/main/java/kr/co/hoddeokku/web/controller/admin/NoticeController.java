package kr.co.hoddeokku.web.controller.admin;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.hoddeokku.web.entity.Notice;
import kr.co.hoddeokku.web.service.NoticeService;
import kr.co.hoddeokku.web.service.NoticeServiceImp;


@Controller("adminNoticeController")
@RequestMapping("admin/support/notice")
public class NoticeController {
    
    @Autowired
    NoticeService noticeService;

    @GetMapping("list")
    public String list(Model model) {
        List<Notice> menus = new ArrayList<>();
        menus = noticeService.getList();
        model.addAttribute("list", menus);

        return "admin/support/notice/list";
    }

    @GetMapping("reg")
    public String menuHoddukReg() {

        return "admin/support/notice/reg";
    }

    @GetMapping("reg-complete")
    public String menuHoddukRegComplete() {

        return "admin/support/reg-complete";
    }

    @PostMapping("reg")
    public String registerMenu(
        @RequestParam("title") String title,
        @RequestParam("content") String content
    ) throws IOException{
        Notice notice = new Notice();
        notice.setTitle(title);
        notice.setContent(content);
        noticeService.regMenu(notice);

        //이미지 경로 저장
        return "redirect:reg-complete";
    }
    
    @PostMapping("delete")
    public String delete(@RequestParam("id") String id) {
        noticeService.deleteMenu(Integer.parseInt(id));
        return "redirect:list";
    }
}
