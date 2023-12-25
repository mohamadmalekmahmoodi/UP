package com.example.common.dtos;

import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;


@MappedSuperclass
@Getter
@Setter
public class BaseDto {

    @CreatedDate
    private Date insertDate;

    @LastModifiedDate
    private Date lastModifiedDate;
}
