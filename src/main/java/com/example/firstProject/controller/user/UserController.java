package com.example.firstProject.controller.user;

import com.example.firstProject.dto.user.LoginData;
import com.example.firstProject.service.user.UserService;
import com.example.firstProject.util.ReturnCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.HashMap;

/**
* 사용자 콘트롤러
*
* @author Choi Bo Kyung
* @version 2023-01-22 최초생성
*
* <b>History:</b>
**/

@Slf4j
@RestController
@RequestMapping(value = "/api")
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    /**
    * @Api 5.1.1	[ILMS_USER_001] 사용자 인증 요청(로그인)
    *
    * @param loginData {@link LoginData}
    * @param request {@link HttpServletRequest}
    * @param session {@link HttpSession}
    * @return {@link HashMap}
    * @throws {@link Exception}
    **/
    @PostMapping(value = "/login", produces="application/json; charset=utf-8")
    @ResponseBody
    public HashMap<String,Object> login(@RequestBody @Valid LoginData loginData, HttpServletRequest request, HttpSession session) throws Exception{

        //디비 조회
        HashMap<String,Object> loginResult = userService.login(loginData);

        //사용자 없음
        if(loginResult == null || loginResult.size() == 0) return ReturnCode.E_400.getHashMap();

        //로그인 사용자 정보 담기
        request.setAttribute("loginUserPk", loginResult.get("userPk").toString());
        request.setAttribute("loginUserId", loginResult.get("userId").toString());
        request.setAttribute("loginUserName", loginResult.get("userName").toString());
        HashMap<String,Object> res = ReturnCode.S_0.getHashMap();
        res.putAll(loginResult);
        return res;
    }



}

