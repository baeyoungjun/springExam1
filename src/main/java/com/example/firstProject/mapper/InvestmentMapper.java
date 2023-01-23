package com.example.firstProject.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

/**
* 투자 현황 맵퍼 - 인터페이스 클래스
*
* @author Choi Bo Kyung
* @version 2023-01-23 최초생성
*
* <b>History:</b>
**/

@Mapper
public interface InvestmentMapper {

    /** 사용자별 투자 현황 **/
    List<HashMap<String, Object>> getInvestmentList(int loginUserPk);


}
