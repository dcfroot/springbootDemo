package com.dc.util;

import org.jboss.logging.Logger;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.concurrent.Future;




/**
 * @Auther: dcf
 * @Date: 2019/2/20
 * @Description:异步调用
 */
@Component
public class AsyncTask {
    Random random = new Random();
    static Logger logger = Logger.getLogger(AsyncTask.class.getName());
    //同步
    public void taskOne() throws Exception {
        System.out.println("开始做任务一");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
       System.out.println("完成任务一，耗时：" + (end - start) + "毫秒");

    }

    public void taskTwo() throws Exception {
        System.out.println("开始做任务二");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        System.out.println("完成任务二，耗时：" + (end - start) + "毫秒");
    }

    public void taskThree() throws Exception {
        System.out.println("开始做任务三");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        System.out.println("完成任务三，耗时：" + (end - start) + "毫秒");
    }

    /**
     *Future接口提供方法来检测任务是否被执行完，等待任务执行完获得结果，也可以设置任务执行的超时时间。这个设置超时的方法就是实现Java程序执行超时的关键。
     *Future接口是一个泛型接口，严格的格式应该是Future<V>，其中V代表了Future执行的任务返回值的类型。
     */
    @Async("taskExecutor1")
    public Future<String> doTaskOne() throws Exception {
        System.out.println("开始做任务一");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        System.out.println("完成任务一，耗时：" + (end - start) + "毫秒");
        logger.info("完成任务一，耗时：" + (end - start) + "毫秒");
        return new AsyncResult<>("任务一已完成，耗时：" + (end - start) + "毫秒");
    }

    @Async("taskExecutor")
    public Future<String> doTaskTwo() throws Exception {
        System.out.println("开始做任务二");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        System.out.println("完成任务二，耗时：" + (end - start) + "毫秒");
        logger.info("完成任务二，耗时：" + (end - start) + "毫秒");
        return new AsyncResult<>("任务一已完成，耗时：" + (end - start) + "毫秒");
    }

    @Async("taskExecutor1")
    public Future<String> doTaskThree() throws Exception {
        System.out.println("开始做任务三");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        logger.info("完成任务三，耗时：" + (end - start) + "毫秒");
        return new AsyncResult<>("任务三已完成，耗时：" + (end - start) + "毫秒");
    }
}
