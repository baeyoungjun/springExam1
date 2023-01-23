package com.example.firstProject.controller;

import com.example.firstProject.service.AnalysisService;
import com.example.firstProject.util.ReturnCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

/**
* 주가 분석 화면용 콘트롤러
*
* @author Choi Bo Kyung
* @version 2023-01-22 최초생성
*
* <b>History:</b>
**/

@Slf4j
@RestController
@RequestMapping(value = "/api")
public class AnalysisController {

    private AnalysisService analysisService;

    @Autowired
    public void setAnalysisService(AnalysisService analysisService) {
        this.analysisService = analysisService;
    }

    /**
    * 테마 목록 조회
    **/
    @GetMapping(value = "/theme", produces="application/json; charset=utf-8")
    @ResponseBody
    public HashMap<String,Object> getTheme(HttpServletRequest request, HttpSession session) throws Exception{

        List<HashMap<String,Object>> themeList = analysisService.getThemeList();
        HashMap<String,Object> res = ReturnCode.S_0.getHashMap();
        res.put("themeList", themeList);
        return res;
    }




}

