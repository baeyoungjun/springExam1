package com.example.firstProject.dto.user;

import lombok.Data;

import javax.servlet.http.HttpSession;

/**
* ILMS : 세션 값 관리 data
*
* @author Choi Bo Kyung
* @version 2022-02-09 최초생성
*
* <b>History:</b>
**/

@Data
public class SessionData {
    
    /** 사용자 고유 번호 **/
    private Integer loginUserNo;

    /** 사용자 유형 **/
    private Integer loginUserType;

    /** 사용자 이름 **/
    private String loginUserName;

    /** 사용자 전화 번호 **/
    private String loginUserPhone;

    /** 총판사 번호 **/
    private Integer loginRslNo; //null일수 있으므로, 데이터 타입은 Integer


    public SessionData(HttpSession session){
        loginUserNo = Integer.parseInt(session.getAttribute("loginUserNo").toString());
        loginUserType = Integer.parseInt(session.getAttribute("loginUserType").toString());
        loginUserName = session.getAttribute("loginUserName").toString();
        loginUserPhone = session.getAttribute("loginUserPhone").toString();
        Object rslNoObj = session.getAttribute("loginRslNo");
        loginRslNo = rslNoObj == null? null : Integer.parseInt(rslNoObj.toString());
    }
}
