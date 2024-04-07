package kr.co.hoddeokku.web.service;

import java.util.List;

import kr.co.hoddeokku.web.entity.Hodduk;

public interface HoddukService {
    List<Hodduk> getList();
    List<Hodduk> getList(String query);

    Hodduk getById(int id);
    void deleteMenu(int id);
    void regMenu(Hodduk hodduk);

    void editMenu(Hodduk hodduk);
}
