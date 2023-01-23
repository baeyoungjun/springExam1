package com.example.firstProject.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Digits;
import java.util.Date;

/**
 * 분석 data
 *
 * @author Choi Bo Kyung
 * @version 2023-01-19 최초생성
 *
 * <b>History:</b>
 **/

@Data
public class AnalysisData {


    /** 분석 고유 번호 **/
    @Digits(integer = 10, fraction = 0)
    private Integer analysisPk;

    /** 종목 고유 번호 **/
    @Digits(integer = 10, fraction = 0)
    private Integer stockPk;

    /** 주가 추정 (10일치) **/
    @Length(min = 1, max = 100)
    private String analysisForecast;

    /** 주가 추정 (감성분석 포함 10일치) **/
    @Length(min = 1, max = 100)
    private String analysisForecastReply;

    /** 평균 주가 추정 **/
    @Length(min = 1, max = 100)
    private String analysisForecastEval;

    /** 평균 등락 추정 **/
    @Length(min = 1, max = 100)
    private String analysisForecastUpAndDown;

    /** 최고점 예상 시간 **/
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date analysisForecastHighTime;

}
