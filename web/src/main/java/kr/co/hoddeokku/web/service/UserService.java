package kr.co.hoddeokku.web.service;

import org.springframework.stereotype.Service;

import kr.co.hoddeokku.web.entity.User;

@Service
public interface UserService {
    boolean validate(String username, String password);
    User getByUserName(String username);

    void deleteUser(int id);
    void regUser(User user);
    void editUser(User user);
}
