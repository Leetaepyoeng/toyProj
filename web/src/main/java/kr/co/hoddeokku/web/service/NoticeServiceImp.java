package kr.co.hoddeokku.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.hoddeokku.web.entity.Notice;
import kr.co.hoddeokku.web.repository.NoticeRepository;

@Service
public class NoticeServiceImp implements NoticeService {

    @Autowired
    NoticeRepository repository;

    @Override
    public List<Notice> getList() {
        List<Notice> list = repository.findAll();
        return list;
    }

    @Override
    public Notice getById(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    @Override
    public void deleteMenu(int id) {
        repository.delete(id);
    }

    @Override
    public void regMenu(Notice notice) {
        repository.add(notice);
    }
    
}
