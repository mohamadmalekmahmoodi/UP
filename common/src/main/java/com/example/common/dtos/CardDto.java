package com.example.common.dtos;

import com.example.common.validations.GeneralValidationGroup;
import com.example.common.validations.NotNullGroup;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class CardDto extends BaseDto {
    @Size(groups = GeneralValidationGroup.class,max = 20,message = "card.cardNumber.size")
    private String cardNumber;
    @NotNull(groups = NotNullGroup.class,message = "card.cvv2.null")
    @Size(groups = GeneralValidationGroup.class,max = 4,message = "card.cvv2.size")
    private Integer cvv2 ;
    @NotNull(groups = NotNullGroup.class,message = "card.expireDate.null")
    private Date expireDate;
}
