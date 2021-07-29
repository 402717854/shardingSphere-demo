package com.shardingsphere.demo.controller;

import com.shardingsphere.demo.service.RetryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RetryController {
    @Autowired
    private RetryService retryService;

    @RequestMapping("/retry")
    public String retry(String retryNum){
        try {
            return retryService.retryTransferAccounts(retryNum);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    @RequestMapping("/retry2")
    public String retry2(String retryNum){
        try {
            return retryService.retryCircuitBreaker(retryNum);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
