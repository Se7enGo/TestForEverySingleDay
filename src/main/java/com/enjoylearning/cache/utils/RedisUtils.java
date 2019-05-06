package com.enjoylearning.cache.utils;

import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.BoundListOperations;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Component
public class RedisUtils {

    @Resource
    private RedisTemplate<String,Object> template;


    //
    public List<Object> getCacheList(String cacheKey){
        BoundListOperations boundListOperations = template.boundListOps(cacheKey);
        Long size = boundListOperations.size();
        return  boundListOperations.range(0,size);
    }
    //从redis 更新list 数据
    public void updateCacheList(String cacheKey,List<Object> dataList){
        BoundListOperations bound = template.boundListOps(cacheKey);
        bound.rightPushAll(dataList.toArray());
    }
    //从redis 中获取map数据
    public Map<String,Object> getCacheMap(String cacheKey){
        BoundHashOperations bound = template.boundHashOps(cacheKey);
        return bound.entries();
    }

    // 从redis 中删除缓存数据
    public void clearCache(String cacheKey){
        template.delete(cacheKey);
    }
    // 获取map中 某个键的值
    public Object getDataFromCacheMap(String cacheKey,Object key){
        BoundHashOperations bound = template.boundHashOps(cacheKey);
        return bound.get(key);
    }
    //存入一个map值
    public  void putDataToCacheMap(String cacheKey,Object key,Object value){
        BoundHashOperations bound = template.boundHashOps(cacheKey);
        bound.put(key,value);
    }

    //在redis中获取某个值
    public void putDataToCache(String key,Object value){
        BoundValueOperations<String ,Object> bvo = template.boundValueOps(key);
        bvo.set(value);
    }

    //在redis 中删除某个值
    public Object getDataFromCache(String key){
        BoundValueOperations<String,Object> bvo = template.boundValueOps(key);
        return bvo.get();
    }

}
