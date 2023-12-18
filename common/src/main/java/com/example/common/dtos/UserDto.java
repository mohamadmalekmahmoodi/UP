package com.example.common.dtos;

import com.example.common.entities.Account;
import com.example.common.validations.GeneralValidationGroup;
import com.example.common.validations.NotNullGroup;
import com.fasterxml.jackson.annotation.JsonProperty;
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
public class UserDto {
        @NotNull(groups = NotNullGroup.class,message = "user.userName.null")
        private String userName;
        @NotNull(groups = NotNullGroup.class,message = "user.name.null")
        private String name;
        @NotNull(groups = NotNullGroup.class,message = "user.family.null")
        private String family;
        @NotNull(groups = NotNullGroup.class,message = "user.nationalCode.null")
        @Size(groups = GeneralValidationGroup.class,max = 10, message = "user.nationalCode.size")
        private String nationalCode;
        private List<AccountDto> account;


}
