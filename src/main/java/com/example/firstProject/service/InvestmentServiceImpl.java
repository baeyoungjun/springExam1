package com.example.firstProject.service;

import com.example.firstProject.mapper.InvestmentMapper;
import com.example.firstProject.util.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

/**
 * 투자 현황 서비스 - 구현 클래스
 *
 * @author Choi Bo Kyung
 * @version 2023-01-23 최초생성
 *
 * <b>History:</b>
 **/

@Service
public class InvestmentServiceImpl implements InvestmentService {

    private InvestmentMapper investmentMapper;

    @Autowired
    public void setInvestmentMapper(InvestmentMapper investmentMapper) {
        this.investmentMapper = investmentMapper;
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public List<HashMap<String, Object>> getInvestmentList(int loginUserPk) throws Exception {
        List<HashMap<String,Object>> result = investmentMapper.getInvestmentList(loginUserPk);
        return ObjectUtils.keyToCamelCase(result);
    }
}
