package kr.co.hoddeokku.web.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("adminDrinkController")
@RequestMapping("admin/menu/drink")
public class DrinkController {

    @GetMapping("list")
    public String menuDrinkList() {

        return "admin/menu/Drink/list";
    }

    @GetMapping("reg")
    public String menuDrinkReg() {

        return "admin/menu/Drink/reg";
    }
}
