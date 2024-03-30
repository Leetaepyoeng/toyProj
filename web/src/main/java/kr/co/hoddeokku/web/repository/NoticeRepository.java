package kr.co.hoddeokku.web.repository;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import kr.co.hoddeokku.web.entity.Notice;

@Mapper
public interface NoticeRepository {
    List<Notice> findAll();
    Notice findById(int id);
    Notice findByNextId(int id);
    Notice findByPreId(int id);
    
    void add(Notice notice);
    void update(Notice notice);
    void delete(int id);
}
