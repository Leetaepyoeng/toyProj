package kr.co.hoddeokku.web.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.hoddeokku.web.entity.Fqa;

@Mapper
public interface FqaRepository {

    List<Fqa> findAll();
    Fqa findById(int id);
    
}
