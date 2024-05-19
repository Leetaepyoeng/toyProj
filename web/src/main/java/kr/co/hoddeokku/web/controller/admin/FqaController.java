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

import kr.co.hoddeokku.web.entity.Fqa;
import kr.co.hoddeokku.web.entity.Notice;
import kr.co.hoddeokku.web.service.FqaService;

@Controller("adminFqaController")
@RequestMapping("admin/support/fqa")
public class FqaController {
    
    @Autowired
    FqaService fqaService;

    @GetMapping("list")
    public String list(Model model) {
        List<Fqa> list = new ArrayList<>();
        list = fqaService.getList();
        model.addAttribute("list", list);

        return "admin/support/fqa/list";
    }
    
    @GetMapping("reg")
    public String reg() {

        return "admin/support/fqa/reg";
    }
    
    @GetMapping("reg-complete")
    public String regComplete() {

        return "admin/support/reg-complete";
    }

    @PostMapping("reg")
    public String registerMenu(
        @RequestParam("title") String title,
        @RequestParam("content") String content
    ) throws IOException{
        Fqa fqa = new Fqa();
        fqa.setTitle(title);
        fqa.setContent(content);
        fqaService.regMenu(fqa);

        //이미지 경로 저장
        return "redirect:reg-complete";
    }

    @GetMapping("edit")
    public String edit(Model model, @RequestParam("id") Integer id){
        Fqa fqa = fqaService.getById(id);

        model.addAttribute("n", fqa);
        return "admin/support/fqa/edit";
    }

    @PostMapping("edit")
    public String edit(
        @RequestParam("id") Integer id,
        @RequestParam("title") String title,
        @RequestParam("content") String content
    ){
        Fqa fqa = new Fqa();
        fqa.setContent(content);
        fqa.setId(id);
        fqa.setTitle(title);
        fqaService.editMenu(fqa);

        return "redirect:reg-complete";
    }

    @PostMapping("delete")
    public String delete(@RequestParam("id") Integer id) {
        fqaService.deleteMenu(id);
        return "redirect:list";
    }

}
