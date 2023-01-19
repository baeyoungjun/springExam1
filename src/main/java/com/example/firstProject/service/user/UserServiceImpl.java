package com.example.firstProject.service.user;

import com.example.firstProject.dto.user.LoginData;
import com.example.firstProject.dto.user.SessionData;
import com.example.firstProject.dto.user.UserInfoData;
import com.example.firstProject.exception.BadRequestException;
import com.example.firstProject.mapper.user.UserMapper;
import com.example.firstProject.util.ObjectUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

/**
 * ILMS :  사용자 서비스 - 구현 클래스
 *
 * @author Choi Bo Kyung
 * @version 2022-02-07 최초생성
 *
 * <b>History:</b>
 **/

@Service
public class UserServiceImpl implements UserService {

    private UserMapper userMapper;

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    /** @Api 5.1.1	[ILMS_USER_001] 사용자 인증 요청(로그인) **/
    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public HashMap<String,Object> login(LoginData loginData) throws Exception {
        HashMap<String,Object> result = userMapper.login(loginData);
        return ObjectUtils.keyToCamelCase(result);
    }

    /** @Api 5.1.3	[ILMS_USER_003] 사용자 정보 조회 **/
    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public HashMap<String,Object> getUserInfo(SessionData sessionData) throws Exception {
        HashMap<String,Object> result = userMapper.getUserInfo(sessionData);
        return ObjectUtils.keyToCamelCase(result);
    }

    /** @Api 5.1.4	[ILMS_USER_004] 사용자 정보 수정 **/
    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int updateUserInfo(UserInfoData userInfoData) throws Exception {
        return userMapper.updateUserInfo(userInfoData);
    }

    /** @Api 5.1.5	[ILMS_USER_005] 사용자 별 총판/고객사/제품/부서 코드 조회 **/
    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public HashMap<String,Object> getUserOption(String codeType, String prdNo, SessionData sessionData) throws Exception {

        HashMap<String,Object> result = new HashMap<String,Object>();
        List<HashMap<String,Object>> list = null;
        
        switch (codeType) {
            case "Reseller":
                list = userMapper.getUserResellerOption(sessionData); break;

            case "Customer":
                list = userMapper.getUserCustomerOption(sessionData);break;

            case "Product":
                list = userMapper.getUserProductOption(sessionData);break;

            case "Version":
                if(!ObjectUtils.isNumber(prdNo,true)) throw new BadRequestException(); //Version 일 경우 prdNo 필수
                //파라미터 = sessionData + prdNo
                ObjectMapper objectMapper = new ObjectMapper();
                HashMap<String,Object> paramMap = objectMapper.convertValue(sessionData, HashMap.class);
                paramMap.put("prdNo", Integer.parseInt(prdNo));
                list = userMapper.getVersionOption(paramMap);break;

            default: throw new BadRequestException(); //약속되지 않은 코드명은 400 에러
        }

        result.put("list", ObjectUtils.keyToCamelCase(list));
        return result;
    }
}
