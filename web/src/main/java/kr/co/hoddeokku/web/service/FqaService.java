package kr.co.hoddeokku.web.service;

import java.util.List;

import kr.co.hoddeokku.web.entity.Fqa;

public interface FqaService {
    List<Fqa> getList();
    Fqa getById(int id);
}
