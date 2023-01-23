package com.example.firstProject.service;

import java.util.HashMap;
import java.util.List;

/**
* ILMS :  주가 분석 서비스 - 인터페이스 클래스
*
* @author Choi Bo Kyung
* @version 2023-01-23 최초생성
*
* <b>History:</b>
**/

public interface AnalysisService {

    /** 테마 목록 조회 **/
    List<HashMap<String, Object>> getThemeList() throws Exception;
}
