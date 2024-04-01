package kr.co.hoddeokku.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.hoddeokku.web.entity.Drink;
import kr.co.hoddeokku.web.repository.DrinkRepository;

@Service
public class DrinkServiceImp implements DrinkService {

    @Autowired
    DrinkRepository repository;

    @Override
    public void regMenu(Drink drink) {
        repository.save(drink);  
    }

    @Override
    public List<Drink> getList() {
        List<Drink> list = repository.findAll();
        return list;
    }

    @Override
    public Drink getById(int id) {
        Drink drink = repository.findById(id);
        return drink;    
    }

    @Override
    public void deleteMenu(int id) {
        repository.delete(id);
    }

    @Override
    public void editMenu(Drink drink) {
        repository.update(drink);
    }
}
