package com.example.firstProject.dto.user;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Digits;

/**
 * 사용자 로그인 (인증) data
 *
 * @author Choi Bo Kyung
 * @version 2023-01-19 최초생성
 *
 * <b>History:</b>
 **/

@Data
public class LoginData {

    /** 사용자 아이디 **/
    @Length(min = 1, max = 100)
    private String userId;

    /** 사용자 비밀번호 **/
    @Length(min = 1, max = 100)
    private String userPw;

    /** 사용자 고유 번호 **/
    @Digits(integer = 10, fraction = 0)
    private Integer userPk;

    /** 사용자 이름 **/
    @Length(min = 1, max = 100)
    private String userName;

}
