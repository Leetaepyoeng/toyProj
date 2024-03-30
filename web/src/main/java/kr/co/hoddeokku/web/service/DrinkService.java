package kr.co.hoddeokku.web.service;

import java.util.List;

import kr.co.hoddeokku.web.entity.Drink;

public interface DrinkService {
    List<Drink> getList();

    Drink getById(int id);
    void deleteMenu(int id);
    void regMenu(Drink drink);

    void editMenu(Drink drink);
}
