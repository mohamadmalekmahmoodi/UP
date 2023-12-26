package com.example.service.exception;

import com.example.common.documents.ExceptionDocument;
import com.example.service.service.ExceptionDocumentService;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletRequest;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@ControllerAdvice
public class controllerExceptionHandler {
    private static final String[] LOCALES = {"fa_IR", "en_US"};
    private Map<String, Properties> propertiesMap = new HashMap<>();
    @Autowired
    private ExceptionDocumentService exceptionDocumentService;

    @PostConstruct
    public void init() throws IOException {
        for (String locale : LOCALES) {
            Properties properties = new Properties();
            try(InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("exceptions_" + locale + ".properties");
            InputStreamReader in = new InputStreamReader(inputStream, "utf8");){
            properties.load(in);
            propertiesMap.put(locale, properties);
        }
    }
}

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody ExceptionDto handle(Exception e, HttpServletRequest request) {
        String locale = request.getHeader("locale");
        Properties properties = this.propertiesMap.get(locale);
        if (properties == null) {
            properties = this.propertiesMap.get("fa_IR");
        }
        String errorKey = e.getClass().getName();
        if (e instanceof MethodArgumentNotValidException) {
            for (FieldError fieldError : ((MethodArgumentNotValidException) e).getBindingResult().getFieldErrors()) {
                errorKey = fieldError.getDefaultMessage();
            }
            System.out.println(errorKey);
        }

            Object translate = properties.get(e.getClass().getName());
            if (translate == null) {
                translate = properties.get(Exception.class.getName());
            }
            if (e.getCause() != null && e.getCause() instanceof UnrecognizedPropertyException) {
                String propertyName = ((UnrecognizedPropertyException) e.getCause()).getPropertyName();
                translate = String.format(String.valueOf(translate), propertyName);
            }

            ExceptionDocument exceptionDocument = new ExceptionDocument();
            exceptionDocument.setMessage("server error");
            exceptionDocument.setCode("error.code");
            exceptionDocumentService.save(exceptionDocument);

                return ExceptionDto.builder()
                .timeStamp(new Date())
                .errorCode(444)
                .message(String.valueOf(translate))
                .build();
    }

}
