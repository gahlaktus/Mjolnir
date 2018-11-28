package com.test.java.jedis;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import redis.clients.jedis.*;

import java.util.Arrays;
import java.util.List;

/**
 * @author huangzhibo
 * @date 26/09/2017
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class JedisTranscationTest {

    private static Jedis jedis;
    private static ShardedJedis shardedJedis;
    private static ShardedJedisPool pool;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        List<JedisShardInfo> shards = Arrays.asList(
                new JedisShardInfo("localhost",6379),
                new JedisShardInfo("localhost",6379)); //使用相同的ip:port,仅作测试


        jedis = new Jedis("localhost");
        shardedJedis = new ShardedJedis(shards);

        pool = new ShardedJedisPool(new JedisPoolConfig(), shards);
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        jedis.disconnect();
        shardedJedis.disconnect();
        pool.destroy();
    }

    @Test
    public void testNormal() {
        Jedis jedis = new Jedis("localhost");
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            String result = jedis.set("n" + i, "n"+i);
            //System.out.println(result);
        }
        long end = System.currentTimeMillis();
        System.out.println("Simple SET: "+((end-start)/1000.0));

        for (int i = 0; i < 100000; i++) {
            jedis.del("n" + i);
            //System.out.println(result);
        }
        jedis.disconnect();
    }

    @Test
    public void testTrans() {
        Jedis jedis = new Jedis("localhost");
        long start = System.currentTimeMillis();
        Transaction tx = jedis.multi();
        for (int i = 0; i < 100000; i++) {
            tx.set("t"+i, "t"+i);
        }
        List<Object> results = tx.exec();
        long end = System.currentTimeMillis();
        System.out.println("Transaction SET: " + ((end - start)/1000.0) + " seconds");

//        for (int i = 0; i < 100000; i++) {
//            jedis.del("t" + i);
//        }
        jedis.disconnect();

        /*
        * 调用jedis.watch(…)方法来监控key，如果调用后key值发生变化，则整个事务会执行失败。
        * 另外，事务中某个操作失败，并不会回滚其他操作。
        * 可以使用discard()方法来取消事务。
        * */
    }

    @Test
    public void testPipelined(){
        Jedis jedis = new Jedis("localhost");
        Pipeline pipeline = jedis.pipelined();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            pipeline.set("p"+i, "p"+i);
        }
        List<Object> results = pipeline.syncAndReturnAll();
        long end = System.currentTimeMillis();
        System.out.println("Transaction SET: " + ((end - start)/1000.0) + " seconds");

        for (int i = 0; i < 100000; i++) {
            jedis.del("p" + i);
        }

        jedis.disconnect();
    }

    @Test
    public void test7shardSimplePool() {
        ShardedJedis one = pool.getResource();

        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            String result = one.set("spn" + i, "n" + i);
        }
        long end = System.currentTimeMillis();
        pool.returnResource(one);
        for (int i = 0; i < 100000; i++) {
            jedis.del("spn" + i);
        }
        System.out.println("Simple@Pool SET: " + ((end - start)/1000.0) + " seconds");
    }

    @Test
    public void test8shardPipelinedPool() {
        ShardedJedis one = pool.getResource();

        ShardedJedisPipeline pipeline = one.pipelined();

        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            pipeline.set("sppn" + i, "n" + i);
        }
        List<Object> results = pipeline.syncAndReturnAll();
        long end = System.currentTimeMillis();
        pool.returnResource(one);
        for (int i = 0; i < 100000; i++) {
            jedis.del("sppn" + i);
        }
        System.out.println("Pipelined@Pool SET: " + ((end - start)/1000.0) + " seconds");
    }

    @Test
    public void test9shardPipelinedPool() {
        ShardedJedis tJedis = pool.getResource();

        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            tJedis.set("sppn" + i, "n" + i);
        }
        long end = System.currentTimeMillis();
        pool.returnResource(tJedis);
        for (int i = 0; i < 100000; i++) {
            jedis.del("sppn" + i);
        }
        System.out.println("Pipelined@Pool SET: " + ((end - start)/1000.0) + " seconds");
    }
}
