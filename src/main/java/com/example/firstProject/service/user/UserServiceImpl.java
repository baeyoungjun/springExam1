package com.example.firstProject.service.user;

import com.example.firstProject.dto.user.LoginData;
import com.example.firstProject.mapper.user.UserMapper;
import com.example.firstProject.util.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;

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
}
