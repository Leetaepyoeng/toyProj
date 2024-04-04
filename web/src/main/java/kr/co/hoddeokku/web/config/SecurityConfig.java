package kr.co.hoddeokku.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    //비밀번호 암호화를 위해 BCrypt Password Encoder를 제공
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        //권한설정
        http
            .authorizeHttpRequests((auth) -> auth
                    .requestMatchers("/index", "/user/**", "/menu/**", "/css/**", "/image/**").permitAll()
                    .requestMatchers("/admin/**").hasRole("ADMIN")
                    // .requestMatchers("/admin").hasRole("ADMIN")
                    // .requestMatchers("/my/**").hasAnyRole("ADMIN", "USER")
                    .anyRequest().authenticated()//나머지는 모두 사용하겠다.
            );

        //permitAll()은 모든 사용자 접근
        //authenticated()는 로그인 하면 모두 접근할 수 있는 메서드
        //denyAll()은 모든 사용자 접근 금지
        //hasAnyRole()은 두개 이상의 등급을 등록할 때 사용

        //
        http
            .formLogin((auth) -> auth.loginPage("/user/signin")
                    .loginProcessingUrl("/user/signin")
                    // 로그인 성공 후에 홈페이지로 리다이렉트
                    .defaultSuccessUrl("/index") 
                    .permitAll()
            );
        //loginProcessingUrl

        http
            .csrf((auth) -> auth.disable());

        return http.build();
    }
}
