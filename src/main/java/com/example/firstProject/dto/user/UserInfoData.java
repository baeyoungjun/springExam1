package com.example.firstProject.dto.user;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.servlet.http.HttpSession;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

/**
 * ILMS :  사용자 정보 data
 *
 * @author Choi Bo Kyung
 * @version 2022-02-09 최초생성
 *
 * <b>History:</b>
 **/

@Data
public class UserInfoData {

    /** 사용자 비밀번호 **/
    @Length(min = 1, max = 256)
    private String userPwd;

    /** 사용자 휴대폰 번호 **/
    @Pattern(regexp = "^\\d{9,12}$")
    private String userPhone;

    /** 사용자 이메일 **/
    @Email
    @Length(min = 1, max = 256)
    private String userMail;

    /** 총판 업체 전화 번호 **/
    @Pattern(regexp = "^\\d{9,12}$")
    private String rslPhone;

    /** 부서 (자사 사용자일 경우) **/
    @Digits(integer = 3, fraction = 0)
    private Integer departNo;

    //======================//

    /** 사용자 고유 번호 **/
    private Integer loginUserNo;

    /** 사용자 유형 **/
    private Integer loginUserType;

    public void setSessionData(HttpSession session) {
        loginUserNo = Integer.parseInt(session.getAttribute("loginUserNo").toString());
        loginUserType = Integer.parseInt(session.getAttribute("loginUserType").toString());
    }

}
