package com.example.firstProject.service.user;

import com.example.firstProject.dto.user.LoginData;

import java.util.HashMap;

/**
* ILMS :  사용자 서비스 - 인터페이스 클래스
*
* @author Choi Bo Kyung
* @version 2022-02-08 최초생성
*
* <b>History:</b>
**/

public interface UserService {

    /**
    * @Api 5.1.1	[ILMS_USER_001] 사용자 인증 요청(로그인)
    *
    * @param loginData {@link LoginData}
    * @return {@link HashMap}
    * @throws Exception {@link Exception}
    **/
    HashMap login(LoginData loginData) throws Exception;

}
