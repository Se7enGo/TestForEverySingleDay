package com.enjoylearning.cache.service;

import com.enjoylearning.cache.mapper.ProfitDetailMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ProfitDetailServiceImpl implements ProfitDetailService {
    @Autowired
    private ProfitDetailMapper mapper;
    @Autowired
    private CacheServiceImpl cacheService;

    private Logger logger = LoggerFactory.getLogger(ProfitDetailServiceImpl.class);
    @Override
    public BigDecimal getProfitAmount(String usercode) {
        BigDecimal value = (BigDecimal)cacheService.cacheResult("getProfitAmount" + usercode);
        if(value != null){
            logger.info("====== get from cache ========= >");
            return   value;
        }
        BigDecimal value2 = mapper.getProfitAmount(usercode);
        if(value2 != null){
            logger.info("======= get from db ========= >");
            cacheService.cachePut("getProfitAmount" + usercode,value2);

        }
        return  value2;
    }
}
