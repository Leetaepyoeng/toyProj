package kr.co.hoddeokku.web.repository;

import kr.co.hoddeokku.web.entity.User;

public interface UserRepository {
    User findById(String username);

    void svae(User user);
    void update(User user);
    void delete(int id);
}

