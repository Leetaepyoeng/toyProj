package kr.co.hoddeokku.web.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.co.hoddeokku.web.entity.Fqa;
import kr.co.hoddeokku.web.service.FqaService;

@RestController
@RequestMapping("/api/fqa")
public class FqaController {
    
    @Autowired
    FqaService fqaService;

    @GetMapping("list")
    public Fqa list(
        @RequestParam(name = "id", required = false) Integer id
    ){
        Fqa menu = fqaService.getById(id);
        return menu;
    }
        
}
