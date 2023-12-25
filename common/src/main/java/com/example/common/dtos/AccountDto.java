package com.example.common.dtos;

import com.example.common.entities.Card;
import com.example.common.entities.Transaction;
import com.example.common.validations.GeneralValidationGroup;
import com.example.common.validations.NotNullGroup;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class AccountDto extends BaseDto {

    @NotNull(groups = NotNullGroup.class,message = "account.accountNumber.null")
    private Long accountNumber;
    @Max(groups = GeneralValidationGroup.class,value = 100,message = "account.balance.max")
    @Min(groups = GeneralValidationGroup.class,value = 100,message = "account.balance.min")
    private Long balance;
    private CardDto card;
}
