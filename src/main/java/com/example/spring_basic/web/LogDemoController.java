package com.example.spring_basic.web;

import com.example.spring_basic.common.MyLogger;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class LogDemoController {

    private final LogDemoService logDemoService;
//    private final ObjectProvider<MyLogger> myLoggerProvider;
    private final MyLogger myLogger;

    @RequestMapping("log-demo")
    @ResponseBody
    public String logDemo(HttpServletRequest request) {
        // URL 받아서
        String requestURL = request.getRequestURL().toString();

        // Provider(DL)을 사용하여, 필요할 때 DI가 가능함
//        MyLogger myLogger = myLoggerProvider.getObject();
        // setter로 넣기
        myLogger.setRequestURL(requestURL);

        // log 찍어보기 Service 실행
        myLogger.log("controller test");
        logDemoService.logic("testId");
        return "OK";
    }
}
