package kr.co.hoddeokku.web.dto;

import lombok.Data;


@Data //게터세터 알아서 해주는거, 일단 사용안함.
public class SignInDTO {
    private String username;
    private String password;
}
