package com.example.service.exception;

import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletRequest;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@ControllerAdvice
public class controllerExceptionHandler {
    private static final String[] LOCALES = {"fa_IR","en_US"};
    private Map<String,Properties> propertiesMap = new HashMap<>();
    @PostConstruct
    public void init() throws IOException {
        for (String locale : LOCALES) {
            Properties properties =new Properties();
            InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("exceptions_"+locale+".properties");
            InputStreamReader in = new InputStreamReader(inputStream, "utf8");
            properties.load(in);
            propertiesMap.put(locale,properties);
        }

    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody ExceptionDto handle(Exception e, HttpServletRequest request){
        String locale = request.getHeader("locale");
        Properties properties = this.propertiesMap.get(locale);
        if (properties == null){
            properties = this.propertiesMap.get("fa_IR");
        }
        Object translate = properties.get(e.getClass().getName());
        if (translate == null){
             translate = properties.get(Exception.class.getName());
        }
        return ExceptionDto.builder()
                .timeStamp(new Date())
                .errorCode(444)
                .message(String.valueOf(translate))
                .build();
    }
}
