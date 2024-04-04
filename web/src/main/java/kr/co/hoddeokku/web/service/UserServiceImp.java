package kr.co.hoddeokku.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import kr.co.hoddeokku.web.dto.SignInDTO;
import kr.co.hoddeokku.web.entity.User;
import kr.co.hoddeokku.web.repository.UserRepository;

@Service
public class UserServiceImp implements UserService{

    @Autowired
    private UserRepository repository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public boolean validate(String username, String password) {
        User user = repository.findByUsername(username);
        
        if(user == null)
            return false;

        if(!user.getPassword().equals(password))
            return false;

        return true;
    }

    @Override
    public User getByUserName(String username) {
        User user = repository.findByUsername(username);
        return user;
    }

    @Override
    public void deleteUser(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteUser'");
    }

    @Override
    public void regUser(User user) {
        //db에 이미 동일한 username을 가진 회원이 존재하는지?
        boolean isUser = repository.existByUsername(user.getUsername());
        if(isUser)
            return;



        User data = new User();
        data.setEmail(user.getEmail());
        data.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        data.setPhoneNumber(user.getPhoneNumber());
        data.setUsername(user.getUsername());
        data.setKorname(user.getKorname());
        data.setRole("ROLE_ADMIN");

        repository.save(data);
    }

    public void regProcess(SignInDTO signInDTO) {


        //db에 이미 동일한 username을 가진 회원이 존재하는지?
        User data = new User();

        data.setUsername(signInDTO.getUsername());
        data.setPassword(bCryptPasswordEncoder.encode(signInDTO.getPassword()));
        data.setRole("ROLE_USER");


        repository.save(data);
    }

    @Override
    public void editUser(User user) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'editUser'");
    }
    
}
