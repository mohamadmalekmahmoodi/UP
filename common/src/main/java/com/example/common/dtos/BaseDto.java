package com.example.common.dtos;

import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

@Data
@MappedSuperclass
public class BaseDto {

    @CreatedDate
    private Date insertDate;

    @LastModifiedDate
    private Date lastModifiedDate;
}
