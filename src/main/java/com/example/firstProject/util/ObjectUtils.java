package com.example.firstProject.util;

import org.apache.commons.lang3.StringUtils;
import org.springframework.jdbc.support.JdbcUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.*;

/**
* ILMS : 객체 유틸
*
* @author Choi Bo Kyung
* @version 2022-02-04 최초생성
*
* <b>History:</b>
**/

public class ObjectUtils {

    /** 객체 null 체크  **/
    public static boolean isNull(Object value){
        if (value instanceof String) {
            String valueStr = value.toString().trim();
            if(StringUtils.isEmpty(valueStr)) {
                return true;
            }
        }else if(value == null){
            return  true;
        }
        return false;
    }

    /** 객체가 양수의 Integer type 인지 확인 **/
    public static boolean isNumber(Object obj, boolean mandatory) {
        if(isNull(obj)) {
            return !mandatory;
        }
        try {
            int num = Integer.parseInt(String.valueOf(obj));
            return num >= 0? true : false;
        } catch(Exception e) {
            return false;
        }
    }

    /** int를 parsing 하거나, 값이 null 이라면 default 값을 반환 **/
    public static int getInt(Object value, int defaultValue) {
        if(value == null) return defaultValue;
        return Integer.parseInt(String.valueOf(value));
    }

    /** String 이 빈값이면 default 값을 반환 **/
    public static String getString(Object value, String defaultValue) {
        if (value == null) return defaultValue;
        String result = String.valueOf(value);
        return "".equals(result) ? defaultValue : result;
    }

    /** String 인코딩 (빈값이면 default 값을 인코딩) **/
    public static String getEncodedString(Object value, String defaultValue, String encoding) throws UnsupportedEncodingException {
        String result = getString(value, defaultValue);
        return URLDecoder.decode(result, encoding);
    }

    /** map 내부에 Null인 값을 제외 후 반환 **/
    public static HashMap<String,Object> trimNullValue(HashMap<String,Object> map) {
        HashMap<String,Object> resultMap = new HashMap<>();
        for(Object keyObj : map.keySet()) {
            String key = keyObj.toString();
            if(!isNull(map.get(key))){
                resultMap.put(key, map.get(key));
            }
        }
        return resultMap;
    }

    /** DB에서 조회한 map 의 Key 를 camelCase로 변환 **/
    public static HashMap<String ,Object> keyToCamelCase(HashMap<String,Object> map) {
        HashMap<String , Object> result = new HashMap<>();
        if(map != null){
            Set originalKeySet = map.keySet();
            for (Object key : originalKeySet) {
                String lowerCasedKey = StringUtils.lowerCase(key.toString());
                String camelCasedKey = JdbcUtils.convertUnderscoreNameToPropertyName(lowerCasedKey);
                result.put(camelCasedKey, map.get(key));
            }
        }
        return result;
    }

    /** map이 리스트일 경우에, keyToCamelCase 오버라이딩 **/
    public static List<HashMap<String, Object>> keyToCamelCase(List<HashMap<String, Object>> mapList) {

        if(mapList == null || mapList.size() == 0) return mapList;

        List<HashMap<String,Object>> result = new ArrayList<>();
        for(HashMap<String,Object> map : mapList){
            result.add(keyToCamelCase(map));
        }
        return result;
    }

    /** 시리얼 넘버 생성 **/
    public static String generateSerialNumber(){
        String uuid = UUID.randomUUID().toString();
        uuid = uuid.replaceAll("-","");
        uuid = uuid.toUpperCase();
        return uuid.substring(0, 25);
    }
}
