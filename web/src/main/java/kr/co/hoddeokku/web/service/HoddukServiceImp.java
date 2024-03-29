package kr.co.hoddeokku.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.hoddeokku.web.entity.Hodduk;
import kr.co.hoddeokku.web.repository.HoddukRepository;

@Service
public class HoddukServiceImp implements HoddukService {

    @Autowired
    HoddukRepository repository;

    @Override
    public void regMenu(Hodduk hodduk) {
        repository.add(hodduk);  
    }

    @Override
    public List<Hodduk> getList() {
        List<Hodduk> list = repository.findAll();
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

    
}
