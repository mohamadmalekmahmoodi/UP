package com.example.common.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AccountDto extends BaseDto {
    private Long id;
    private CardDto card;
    private Long accountNumber;
    private Long balance;
    private UserDto user;
}
