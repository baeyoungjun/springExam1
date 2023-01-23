package com.example.firstProject.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Digits;

/**
 * 테마 data
 *
 * @author Choi Bo Kyung
 * @version 2023-01-19 최초생성
 *
 * <b>History:</b>
 **/

@Data
public class ThemeData {

    /** 테마 고유 번호 **/
    @Digits(integer = 10, fraction = 0)
    private Integer themePk;

    /** 테마 이름 **/
    @Length(min = 1, max = 100)
    private String themeName;

    /** 테마 등락 **/
    @Digits(integer = 10, fraction = 10)
    private Double themeUpAndDown;

}
