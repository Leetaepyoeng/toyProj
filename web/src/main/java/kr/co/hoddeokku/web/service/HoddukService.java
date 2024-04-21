package kr.co.hoddeokku.web.service;

import java.util.List;

import kr.co.hoddeokku.web.entity.Hodduk;
import kr.co.hoddeokku.web.entity.HoddukView;

public interface HoddukService {
    List<HoddukView> getList(Long memberId);
    List<HoddukView> getList(Long memberId, String query);

    Hodduk getById(int id);
    void deleteMenu(int id);
    void regMenu(Hodduk hodduk);

    void editMenu(Hodduk hodduk);
}
