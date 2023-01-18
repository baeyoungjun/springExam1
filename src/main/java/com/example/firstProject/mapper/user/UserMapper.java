package com.example.firstProject.mapper.user;

import com.example.firstProject.dto.user.LoginData;
import com.example.firstProject.dto.user.SessionData;
import com.example.firstProject.dto.user.UserInfoData;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

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
     * @Api 5.1.1	[ILMS_USER_001] 사용자 인증 요청(로그인)
     *
     * @param loginData {@link LoginData}
     * @return {@link HashMap}
     * @throws Exception {@link Exception}
     **/
    HashMap login(LoginData loginData) throws Exception;

    /**
     * @Api 5.1.3	[ILMS_USER_003] 사용자 정보 조회
     *
     * @param sessionData {@link SessionData}
     * @return {@link HashMap}
     * @throws {@link Exception}
     **/
    HashMap getUserInfo(SessionData sessionData) throws Exception;

    /**
     * @Api 5.1.4	[ILMS_USER_004] 사용자 정보 수정
     *
     * @param userInfoData {@link UserInfoData}
     * @return {@link Integer}
     * @throws {@link Exception}
     **/
    int updateUserInfo(UserInfoData userInfoData) throws Exception;

    /**
     * @Api 5.1.5	[ILMS_USER_005] 사용자 별 총판/고객사/제품/부서 코드 조회
     *
     * @param sessionData,paramMap {@link SessionData}{@link HashMap}
     * @return {@link List}
     * @throws {@link Exception}
     **/
    List<HashMap<String,Object>> getUserCustomerOption(SessionData sessionData) throws Exception;
    List<HashMap<String,Object>> getUserProductOption(SessionData sessionData) throws Exception;
    List<HashMap<String,Object>> getVersionOption(HashMap<String,Object> paramMap)throws Exception;
    List<HashMap<String,Object>> getUserResellerOption(SessionData sessionData) throws Exception;
    List<HashMap<String,Object>> getUserDepartmentOption(SessionData sessionData) throws Exception;
}
