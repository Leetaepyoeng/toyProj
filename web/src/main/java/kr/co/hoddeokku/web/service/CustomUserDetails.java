package kr.co.hoddeokku.web.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import kr.co.hoddeokku.web.entity.User;

//여기서 사용자 검증
public class CustomUserDetails implements UserDetails{
    
    private User user;
    private List<GrantedAuthority> authorities;

    public CustomUserDetails(User user) {
        this.user = user;
    }

    public void setAuthorities(List<GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //사용자의 특정한 권한에 대한 리턴 role
        Collection<GrantedAuthority> collection = new ArrayList<>();

        collection.add(new GrantedAuthority() {

            @Override
            public String getAuthority() {
                //유저의 권한
                return user.getRole();
            }
        });
        return collection;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    public String getPhoneNumber() {
        return user.getPhoneNumber();
    }
    
    public String getEmail() {
        return user.getEmail();
    }

    public Long getId() {
        return user.getId();
    }

    public String getKorname() {
        return user.getKorname();
    }


    

    //다음 설정값들은 일단 계정이 잠기지 않게 설정
    //사용하려면 db에 필드를 만들고 써야함.
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
