package com.shardingsphere.demo.service;

public interface RetryService {
    public String retryTransferAccounts(String retryNum) throws Exception;
}