package kr.co.hoddeokku.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration //Spring의 구성 클래스임
@EnableWebSecurity //Spring Security를 활성화
public class WebSecurityConfig {

    //빈 등록
    @Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // Spring Security의 필터 체인을 구성. 
        // 보안 필터 체인은 HTTP 요청을 처리하여 인증 및 권한 부여를 수행
		http
            .csrf(csrf->csrf.disable())
            //CSRF(Cross-Site Request Forgery) 보호를 비활성화
            //CSRF 공격에 대한 보호를 제공하지 않고 사용하는 경우, 보통은 비활성화하지 않고 사용
			.authorizeHttpRequests((requests) -> requests //HTTP 요청에 대한 권한을 구성
                .requestMatchers("/user/**").hasAnyRole("USER", "ADMIN")
                .requestMatchers("/admin/**").hasAnyRole("ADMIN")
                .anyRequest().permitAll()
			)
            //로그인할 때 사용되는 form 기반 로그인을 구성
			.formLogin((form) -> form 
				.loginPage("/user/signin")
				.permitAll()
			)
            //로그아웃을 구성, 
			.logout((logout) -> logout
            .logoutUrl("/user/logout")//로그아웃 URL로 지정
            .logoutSuccessUrl("/")//로그아웃 후에는 홈 페이지(/)로 리다이렉트
            .permitAll());

		return http.build();
        //ecurityFilterChain을 생성하여 반환하는 역할을 함. 
        //이렇게 생성된 SecurityFilterChain은 Spring Security에 의해 자동으로 사용되어 웹 애플리케이션의 보안을 구성
	}

    @Bean
	public UserDetailsService userDetailsService() {
        //UserDetailsService는 Spring Security가 사용자의 인증 정보를 가져오는 데 사용하는 인터페이스
		UserDetails user1 = User.builder()
				            .username("user1")
				            .password("{noop}111")
		    		        .roles("USER", "ADMIN")
				            .build();

        UserDetails user2 = User.builder()
				            .username("user2")
				            .password("{noop}222")
		    		        .roles("USER")
				            .build();

		return new InMemoryUserDetailsManager(user1, user2);
        //일단 2개의 사용자 정보를 생성하여 메모리 내에서 관리하는 InMemoryUserDetailsManager를 반환
        //생성된 사용자 정보는 사용자의 인증을 처리하는 데 사용
	}
    
}