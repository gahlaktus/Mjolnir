package com.dragon.spring.redis;

import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import javax.annotation.Resource;

/**
 * Created by huangzhibo on 31/05/2017.
 */
public class TestRedis {

    @Resource(name = "redisTemplate")
    private RedisTemplate<String, String> template; // inject the template as ListOperations
    //至于这个为什么可以注入。需要参考AbstractBeanFactory doGetBean
    //super.setValue(((RedisOperations) value).opsForValue());就这一行代码  依靠一个editor

    @Resource(name = "redisTemplate")
    private ValueOperations<String, Object> valueOperations;

    public void testSet(){
        template.execute((RedisCallback<Boolean>) redisConnection -> {
            byte[] key = "tempkey".getBytes();
            byte[] value = "tempvalue".getBytes();
            redisConnection.set(key, value);
            return true;
        });
    }

    public void testSet1(){
        valueOperations.set("tempkey", "tempvalue");
    }

    /*@Autowired
    private IncrDao incrDao;

    @Test
    public void addLink(){
        System.out.println(incrDao.incr(13));
        System.out.println(incrDao.get(13));
    }*/
}
