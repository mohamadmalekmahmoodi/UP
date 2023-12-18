package com.example.common.entities;

import jakarta.persistence.MappedSuperclass;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

@MappedSuperclass
@Getter
@Setter
@ToString
@NoArgsConstructor
public class BaseEntity {

    @CreatedDate
    private Date insertDate;

    @LastModifiedDate
    private Date lastModifiedDate;
}
