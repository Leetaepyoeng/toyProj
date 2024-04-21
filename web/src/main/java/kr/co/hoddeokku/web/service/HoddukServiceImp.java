package kr.co.hoddeokku.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.hoddeokku.web.entity.Hodduk;
import kr.co.hoddeokku.web.entity.HoddukView;
import kr.co.hoddeokku.web.repository.HoddukRepository;

@Service
public class HoddukServiceImp implements HoddukService {

    @Autowired
    HoddukRepository repository;

    @Override
    public void regMenu(Hodduk hodduk) {
        repository.save(hodduk);  
    }

    @Override
    public List<HoddukView> getList(Long memberId) {
        return getList(memberId, 1, null);
    }

    @Override
    public List<HoddukView> getList(Long memberId, String query) {
        return getList(memberId, 1, query);
    }

    public List<HoddukView> getList(Long memberId, int page, String query) {
        //페이징은 일단 패스
        int p = page;
        List<HoddukView> list = repository.findAll(memberId, query);
        return list;
    }

    @Override
    public Hodduk getById(int id) {
        Hodduk hodduk = repository.findById(id);
        return hodduk;
    }

    @Override
    public void deleteMenu(int id) {
        repository.delete(id);
    }

    @Override
    public void editMenu(Hodduk hodduk) {
        repository.update(hodduk);
    }
}
