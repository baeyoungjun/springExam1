package com.example.firstProject.dto;

import lombok.Data;

import javax.servlet.http.HttpSession;

/**
* 세션 값 관리 data
*
* @author Choi Bo Kyung
* @version 2023-01-19 최초생성
*
* <b>History:</b>
**/

@Data
public class SessionData {
    
    /** 사용자 고유 번호 **/
    private Integer loginUserPk;

    /** 사용자 아이디 **/
    private String loginUserId;

    /** 사용자 이름 **/
    private String loginUserName;

    public SessionData(HttpSession session){
        loginUserPk = Integer.parseInt(session.getAttribute("loginUserPk").toString());
        loginUserId = session.getAttribute("loginUserId").toString();
        loginUserName = session.getAttribute("loginUserName").toString();
    }
}
