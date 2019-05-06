package com.enjoylearning.cache.service;

import com.enjoylearning.cache.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CacheServiceImpl implements CacheService {

    @Autowired
    private RedisUtils redisUtil;

    @Override
    public <T> T cacheResult(String key) {
        return (T)redisUtil.getDataFromCache(key);
    }

    @Override
    public <T> void cachePut(String key, T t) {
        redisUtil.putDataToCache(key,t);
    }

    @Override
    public void cacheRemove(String key) {
        redisUtil.clearCache(key);
    }
}
