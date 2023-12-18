package com.example.service.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.print.DocFlavor;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionDto {
    @JsonFormat(timezone = "Asia/Tehran",shape = JsonFormat.Shape.STRING,pattern = "yyyy/MM/dd'T'HH:mm:ss")
    private Date timeStamp;
    private String message;
    private Integer errorCode;
}
