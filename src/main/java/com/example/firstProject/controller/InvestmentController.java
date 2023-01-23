package com.example.firstProject.controller;

import com.example.firstProject.service.InvestmentService;
import com.example.firstProject.util.ObjectUtils;
import com.example.firstProject.util.ReturnCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

/**
* 투자 현황 콘트롤러
*
* @author Choi Bo Kyung
* @version 2023-01-22 최초생성
*
* <b>History:</b>
**/

@Slf4j
@RestController
@RequestMapping(value = "/api")
public class InvestmentController {

    private InvestmentService investmentService;

    @Autowired
    public void setInvestmentService(InvestmentService investmentService) {
        this.investmentService = investmentService;
    }

    /**
    * 사용자별 투자 현황 조회
    **/
    @GetMapping(value = "/investment", produces="application/json; charset=utf-8")
    @ResponseBody
    public HashMap<String,Object> investment(HttpServletRequest request, HttpSession session) throws Exception{

        if(ObjectUtils.isNull(session.getAttribute("loginUserPk"))) return ReturnCode.E_401.getHashMap();

        int loginUserPk = Integer.parseInt(session.getAttribute("loginUserPk").toString());
        List<HashMap<String,Object>> investmentList = investmentService.getInvestmentList(loginUserPk);

        //사용자 정보 담아서 응답
        HashMap<String,Object> res = ReturnCode.S_0.getHashMap();
        res.put("investmentList", investmentList);
        return res;
    }






}

