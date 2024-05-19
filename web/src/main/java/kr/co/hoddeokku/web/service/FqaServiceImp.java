package kr.co.hoddeokku.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.hoddeokku.web.entity.Fqa;
import kr.co.hoddeokku.web.repository.FqaRepository;

@Service
public class FqaServiceImp implements FqaService{
    
    @Autowired
    FqaRepository repository;

    @Override
    public List<Fqa> getList() {
        return repository.findAll();
    }

    @Override
    public Fqa getById(int id) {
        return repository.findById(id);
    }

    @Override
    public void regMenu(Fqa fqa) {
        repository.save(fqa);
    }

    @Override
    public void editMenu(Fqa fqa) {
        repository.update(fqa);
    }

    @Override
    public void deleteMenu(Integer id) {
        repository.delete(id);
    }
    
}
