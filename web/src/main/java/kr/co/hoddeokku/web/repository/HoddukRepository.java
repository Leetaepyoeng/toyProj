package kr.co.hoddeokku.web.repository;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import kr.co.hoddeokku.web.entity.Hodduk;

@Mapper
public interface HoddukRepository {
    void add(Hodduk hodduk);
    List<Hodduk> findAll();
    Hodduk findById(int id);

    void update(Hodduk hodduk);
    void delete(int id);
}
