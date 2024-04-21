package kr.co.hoddeokku.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableWebSecurity
public class SecurityConfig{

    // 비밀번호 암호화를 위해 BCrypt Password Encoder를 제공
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{

        //권한설정
        http
            .csrf(csrf->csrf.disable()) // 일단 켜 수바
            .authorizeHttpRequests((auth) -> auth
                    // .requestMatchers("/index", "/sendVerificationEmail", "/menu/**", "/support/**", "/user/**", "/css/**", "/js/**", "/image/**").permitAll()
                    .requestMatchers("/admin/**").hasRole("ADMIN")
                    // .requestMatchers("/admin").hasRole("ADMIN")
                    // .requestMatchers("/my/**").hasAnyRole("ADMIN", "USER")
                    .anyRequest().permitAll()
                    // .anyRequest().authenticated()//나머지는 모두 사용하겠다.
            );

        //permitAll()은 모든 사용자 접근
        //authenticated()는 로그인 하면 모두 접근할 수 있는 메서드
        //denyAll()은 모든 사용자 접근 금지
        //hasAnyRole()은 두개 이상의 등급을 등록할 때 사용

        //로그인 설정
        http
            .formLogin((auth) -> auth.loginPage("/user/signin")
                    .loginProcessingUrl("/user/signin")
                    // 로그인 성공 후에 홈페이지로 리다이렉트
                    .defaultSuccessUrl("/index", true) 
                    .permitAll()
            );
        //loginProcessingUrl

        //로그아웃 설정
        http
            .logout((logout) -> logout
                    .logoutRequestMatcher(new AntPathRequestMatcher("/user/logout"))
                    // 성공하면 루트 페이지로 이동
                    .logoutSuccessUrl("/index")
                    // 로그아웃 시 생성된 사용자 세션 삭제
                    .invalidateHttpSession(true)
                    .permitAll()
        );


        //CSRF(Cross-Site Request Forgery)는 요청을 위조하여 사용자가 원하지 않아도 
        //서버측으로 특정 요청을 강제로 보내는 방식 
        //(회원 정보 변경, 게시글 CRUD를 사용자 모르게 요청)
        // http
        //     .csrf((auth) -> auth.disable());
        // http
        //     .csrf(csrf -> csrf
        //     .ignoringRequestMatchers("/user/signin")); 
            // CSRF 보호 제외할 URL 패턴 설정


        http
            .sessionManagement((auth) -> auth
            .maximumSessions(1) // 중복 로그인 개수 설정, 최대 3개
            .maxSessionsPreventsLogin(false));
            //다중 로그인 개수를 초과하였을 경우 처리 방법
            // - true : 초과시 새로운 로그인 차단
            // - false : 초과시 기존 세션 하나 삭제


        //세션 아이디 체인지를 통해 세션 고정 보호 공격을 방지함.
        http
            .sessionManagement((auth) -> auth
            .sessionFixation().changeSessionId());
            // - sessionManagement().sessionFixation().none() : 로그인 시 세션 정보 변경 안함
            // - sessionManagement().sessionFixation().newSession() : 로그인 시 세션 새로 생성
            // - sessionManagement().sessionFixation().changeSessionId() : 로그인 시 동일한 세션에 대한 id 변경
    

        return http.build();
    }


}
