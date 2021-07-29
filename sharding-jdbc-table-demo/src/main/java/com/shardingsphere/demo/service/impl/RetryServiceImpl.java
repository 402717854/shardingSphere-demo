package com.shardingsphere.demo.service.impl;

import com.shardingsphere.demo.service.RetryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.CircuitBreaker;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

/**
 * @Retryable：标记当前方法会使用重试机制
 * value：重试的触发机制，当遇到Exception异常的时候，会触发重试
 * maxAttempts：重试次数（包括第一次调用）
 * delay：重试的间隔时间
 * multiplier：delay时间的间隔倍数
 * maxDelay：重试次数之间的最大时间间隔，默认为0，如果小于delay的设置，则默认为30000L
 * @Recover：标记方法为回调方法，传参与@Retryable的value值需一致
 * 原文链接：https://blog.csdn.net/huanongying123/article/details/104417712
 * @EnableRetry - 表示开启重试机制
 * @Retryable - 表示这个方法需要重试，它有很丰富的参数，可以满足你对重试的需求
 * @Backoff - 表示重试中的退避策略
 * @Recover - 兜底方法，即多次重试后还是失败就会执行这个方法
 */
@Service
@Slf4j
public class RetryServiceImpl implements RetryService {
    @Override
    @Retryable(value = RuntimeException.class, maxAttempts = 3, backoff = @Backoff(delay = 3000, multiplier = 1, maxDelay = 10000))
    public String retryTransferAccounts(String retryNum) throws Exception {
        log.info("调用重试方法");
        if("3".equals(retryNum)){
           throw new RuntimeException("抛出异常");
        }
        return "调用RPC成功!!";
    }

    /**
     * 断路器开启后,经过resetTimeout并且在这短时间内没有新的请求，超时关闭断路器
     * openTimeout:请求在此时间段内连续请求达到最大重试次数开启断路器
     * @param retryNum
     * @return
     */
    @Override
    @CircuitBreaker(include = { RuntimeException.class }, openTimeout = 10000, resetTimeout = 15000)
    public String retryCircuitBreaker(String retryNum) {
        log.info("real service called:{}",retryNum);
        if("3".equals(retryNum)){
            throw new RuntimeException("抛出异常");
        }
        return "real service called";
    }

    @Recover
    public String recover1(RuntimeException e) {
        log.info("recover1:{}",e.getMessage());
        return e.getMessage();
    }
    @Recover
    public String recover2(RuntimeException e,String retryNum) {
        log.info(retryNum+"recover2:{}",e.getMessage());
        return e.getMessage();
    }
}
