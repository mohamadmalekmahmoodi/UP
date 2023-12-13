package com.example.common.entities;

import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

@MappedSuperclass
@Data
@NoArgsConstructor
public class BaseEntity {

    @CreatedDate
    private Date insertDate;

    @LastModifiedDate
    private Date lastModifiedDate;
}
