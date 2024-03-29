package kr.co.hoddeokku.web.repository;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import kr.co.hoddeokku.web.entity.Hodduk;

@Mapper
public interface HoddukRepository {
    List<Hodduk> findAll();
    Hodduk findById(int id);
    
    void add(Hodduk hodduk);
    void update(Hodduk hodduk);
    void delete(int id);
}
