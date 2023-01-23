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

    /** 테마 별 수익률 상위 4개 **/
    List<HashMap<String, Object>> getThemeTop4List(int themePk) throws Exception;

    /** 테마 별 투자 상세 내역 **/
    List<HashMap<String, Object>> getThemeBuyDetail(int parseInt, int userPk) throws Exception;
}
