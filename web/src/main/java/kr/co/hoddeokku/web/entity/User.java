package kr.co.hoddeokku.web.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private long id;
	private String username;
    private String korname;
    private String password;
    private String phoneNumber;
	private String email;
    private Date regDate;
    private String role; // 등급 정보 추가
}
