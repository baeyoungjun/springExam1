package com.example.firstProject.dto.user;

import lombok.Data;

import javax.validation.constraints.Digits;

/**
 * 투자 매핑 data
 *
 * @author Choi Bo Kyung
 * @version 2023-01-19 최초생성
 *
 * <b>History:</b>
 **/

@Data
public class InvestmentData {

    /** 투자 고유 번호 **/
    @Digits(integer = 10, fraction = 0)
    private Integer investmentPk;

    /** 사용자 고유 번호 **/
    @Digits(integer = 10, fraction = 0)
    private Integer userPk;

    /** 주식 고유 번호 **/
    @Digits(integer = 10, fraction = 0)
    private Integer stockPk;

}
