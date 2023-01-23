package com.example.firstProject.util;

import org.json.simple.JSONObject;

import java.util.HashMap;

public enum ReturnCode {

    //성공
	S_0(200,"성공"),

    //서버 에러
    E_400(400,"요청 정보가 잘못되었습니다."),
    E_401(401,"인증 권한이 만료되었습니다."),
    E_403(403,"해당 기능의 권한이 없습니다."),
    E_500(500,"시스템 에러가 발생했습니다. 잠시 후 다시 시도 해 주세요.");


	private int resCode;
    private String resMsg;

    ReturnCode(int resCode, String resMsg) {
        this.resCode = resCode;
        this.resMsg = resMsg;
    }

    public int getResCode() {
        return resCode;
    }

    public String getResMsg() {
        return resMsg;
    }
    
    public JSONObject getJson() {
    	JSONObject response = new JSONObject();
    	response.put("resCode", resCode);
    	response.put("resMsg", resMsg);
    	return response;
    }

    public HashMap<String,Object> getHashMap() {
        HashMap<String,Object> response = new HashMap<>();
        response.put("resCode", resCode);
        response.put("resMsg", resMsg);
        return response;
    }
}
