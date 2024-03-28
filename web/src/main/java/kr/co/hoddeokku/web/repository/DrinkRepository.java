package kr.co.hoddeokku.web.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.hoddeokku.web.entity.Drink;

@Mapper
public interface DrinkRepository {
    void add(Drink drink);
    List<Drink> findAll();
    Drink findById(int id);

    void update(Drink drink);
    void delete(int id);
}
