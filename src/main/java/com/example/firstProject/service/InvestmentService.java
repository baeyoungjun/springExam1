package com.example.firstProject.service;

import java.util.HashMap;
import java.util.List;

/**
* 투자현황 서비스 - 인터페이스 클래스
*
* @author Choi Bo Kyung
* @version 2023-01-23 최초생성
*
* <b>History:</b>
**/

public interface InvestmentService {
    
    /** 사용자별 투자 현황 **/
    List<HashMap<String, Object>> getInvestmentList(int loginUserPk) throws Exception;


}
