package com.example.common.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CardDto extends BaseDto {

    private Long id;
    private Long cardNumber;
    private Integer cvv2;
    private String expireDate;
}
