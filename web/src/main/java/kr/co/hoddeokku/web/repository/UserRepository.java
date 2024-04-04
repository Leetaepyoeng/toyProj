package kr.co.hoddeokku.web.repository;

import org.apache.ibatis.annotations.Mapper;

import kr.co.hoddeokku.web.entity.User;
@Mapper
public interface UserRepository {
    User findById(String username);
    User findByUsername(String username);
    boolean existByUsername(String username);

    void save(User user);
    void update(User user);
    void delete(int id);
}

