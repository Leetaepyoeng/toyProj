package kr.co.hoddeokku.web.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.hoddeokku.web.entity.HoddukLike;
import kr.co.hoddeokku.web.service.HoddukLikeService;

@RestController
@RequestMapping("api/hodduk-likes")
public class HoddukLikeController {
    
    @Autowired
    HoddukLikeService service;

    @PostMapping
    public HoddukLike add(
        @RequestBody HoddukLike hodduk
    ){
        HoddukLike hoddukLike = service.add(hodduk);
        return hoddukLike;
    }

    @DeleteMapping
    public String delete(@RequestBody HoddukLike hodduk){
        service.cancel(hodduk);
        return null;
    }
}
