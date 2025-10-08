package com.example.spring_basic.web;

import com.example.spring_basic.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogDemoService {

//    private final ObjectProvider<MyLogger> myLoggerProvider;
    private final MyLogger myLogger;

    public void logic(String id) {
        // Provider(DL)을 사용하여, 필요할 때 DI가 가능함
//        MyLogger myLogger = myLoggerProvider.getObject();
        myLogger.log("service id = " + id); // myLogger 입장에서는 message
    }
}
