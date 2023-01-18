package com.example.firstProject.dto.user;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

/**
 * ILMS :  사용자 로그인 (인증) data
 *
 * @author Choi Bo Kyung
 * @version 2022-02-07 최초생성
 *
 * <b>History:</b>
 **/

@Data
public class LoginData {
    
    /** 사용자 아이디 **/
    @NotBlank
    @Length(min = 1, max = 20)
    private String userId;

    /** 사용자 비밀번호 **/
    @NotBlank
    @Length(min = 1, max = 256)
    private String userPwd;
}
