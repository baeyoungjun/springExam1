package com.example.firstProject.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Digits;
import java.util.Date;

/**
 * 종목 data
 *
 * @author Choi Bo Kyung
 * @version 2023-01-19 최초생성
 *
 * <b>History:</b>
 **/

@Data
public class StockData {

    /** 종목 고유 번호 **/
    @Digits(integer = 10, fraction = 0)
    private Integer stockPk;

    /** 테마 고유 번호 **/
    @Digits(integer = 10, fraction = 0)
    private Integer themePk;

    /** 종목 이름 **/
    @Length(min = 1, max = 100)
    private String stockName;

    /** 종목 코드 **/
    @Length(min = 1, max = 100)
    private String stockCode;

    /** 종목 가격 **/
    @Digits(integer = 10, fraction = 0)
    private Integer stockPrice;

    /** 테마 등락 **/
    @Digits(integer = 10, fraction = 10)
    private Double stockUpAndDown;

    /** 등록 시간 **/
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date stockTime;

}
