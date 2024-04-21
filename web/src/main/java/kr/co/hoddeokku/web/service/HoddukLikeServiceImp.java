package kr.co.hoddeokku.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.hoddeokku.web.entity.HoddukLike;
import kr.co.hoddeokku.web.repository.HoddukLikeRepository;

@Service
public class HoddukLikeServiceImp implements HoddukLikeService{
    
    @Autowired
    HoddukLikeRepository repository;
    
    @Override
    public HoddukLike add(HoddukLike hoddukLike) {
        int result = repository.save(hoddukLike);
        return hoddukLike;
    }

    @Override
    public String cancel(HoddukLike hoddukLike) {
        repository.delete(hoddukLike);
        return null;
    }
    
}
