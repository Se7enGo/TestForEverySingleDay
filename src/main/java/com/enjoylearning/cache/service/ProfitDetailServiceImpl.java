package com.enjoylearning.cache.service;

import com.enjoylearning.cache.mapper.ProfitDetailMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Random;

@Service
public class ProfitDetailServiceImpl implements ProfitDetailService {
    @Autowired
    private ProfitDetailMapper mapper;
    @Autowired
    private CacheServiceImpl cacheService;

    private Random random = new Random();

    private Logger logger = LoggerFactory.getLogger(ProfitDetailServiceImpl.class);
    @Override
    public BigDecimal getProfitAmount(String usercode) {
        //去redis 里查一下 有没有这个key
        BigDecimal value = (BigDecimal)cacheService.cacheResult( usercode);
        if(value != null){
            logger.info("====== get from cache ========= >");
            return   value;
        }else{
            logger.info("============= no cache ==============");
        }
        // 去数据库里查一下 有没有值
        BigDecimal value2 = mapper.getProfitAmount(usercode);
        if(value2 != null){
            //如果有 就放在内存里 供后面的线程查询
            cacheService.cachePut(usercode,value2);
            logger.info("======= get from db ========= >");
        }
        return  value2;
    }
}
