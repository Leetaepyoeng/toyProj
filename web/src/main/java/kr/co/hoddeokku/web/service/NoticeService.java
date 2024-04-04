package kr.co.hoddeokku.web.service;

import java.util.List;

import kr.co.hoddeokku.web.entity.Notice;

public interface NoticeService {
    List<Notice> getList();

    Notice getById(int id);
    Notice getByNextId(int id);
    Notice getByPreId(int id);
    void deleteMenu(int id);
    void regMenu(Notice notice);
    void editMenu(Notice notice);
}
