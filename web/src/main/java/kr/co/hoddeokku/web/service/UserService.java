package kr.co.hoddeokku.web.service;

import kr.co.hoddeokku.web.entity.User;

public interface UserService {
    boolean validate(String username, String password);
    User getByUserName(String username);

    void deleteUser(int id);
    void regUser(User user);
    void editUser(User user);
}
