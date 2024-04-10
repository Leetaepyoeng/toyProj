package kr.co.hoddeokku.web.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import kr.co.hoddeokku.web.entity.User;
import kr.co.hoddeokku.web.repository.UserRepository;

@Service
public class CustomUserDetailService implements UserDetailsService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        User userData = userRepository.findByUsername(username);
        
        if (userData != null) {
            return new CustomUserDetails(userData);
            //새로운 처리
            //권한정보
            // List<GrantedAuthority> authorities = new ArrayList<>();

            //사용자권한처리
            // authorities.add(new SimpleGrantedAuthority(userData.getRole()));
            
            // Spring Security의 User 객체로 매핑하여 반환
            // return new org.springframework.security.core.userdetails.User(
            //     userData.getUsername(), 
            //     userData.getPassword(), 
            //     authorities
            // );
        }
        return null;
    }
    
}
