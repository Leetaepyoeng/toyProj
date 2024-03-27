package kr.co.hoddeokku.web.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.co.hoddeokku.web.entity.Hodduk;
import kr.co.hoddeokku.web.repository.HoddukRepository;

@Service
public class HoddukServiceImp implements HoddukService {

    HoddukRepository repository;

    @Override
    public List<Hodduk> getList() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getList'");
    }

    @Override
    public Hodduk getById(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    @Override
    public void regMenu(Hodduk hodduk) {
        repository.save(hodduk);   
    }
    
}
