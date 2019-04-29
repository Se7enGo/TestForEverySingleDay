package com.enjoylearning.cache.service;

import com.enjoylearning.cache.mapper.PorfitDetailMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ProfitDetailServiceImpl implements ProfitDetailService {
    @Autowired
    PorfitDetailMapper mapper;

    @Override
    public BigDecimal getProfitAmount(String usercode) {
        return mapper.getProfitAmount(usercode);
    }
}
