package kr.co.hoddeokku.web.service;

import java.util.List;

import kr.co.hoddeokku.web.entity.Fqa;

public interface FqaService {
    List<Fqa> getList();
    Fqa getById(int id);
    void regMenu(Fqa fqa);
    void editMenu(Fqa fqa);
    void deleteMenu(Integer id);
}
