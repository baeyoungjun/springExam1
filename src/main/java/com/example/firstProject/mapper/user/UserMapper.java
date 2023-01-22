package com.example.firstProject.mapper.user;

import com.example.firstProject.dto.user.LoginData;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;

/**
* ILMS :  사용자 맵퍼 - 인터페이스 클래스
*
* @author Choi Bo Kyung
* @version 2022-02-07 최초생성
*
* <b>History:</b>
**/

@Mapper
public interface UserMapper {

    /**
     * @param loginData {@link LoginData}
     * @return {@link HashMap}
     * @throws Exception {@link Exception}
     **/
    HashMap login(LoginData loginData) throws Exception;

}
