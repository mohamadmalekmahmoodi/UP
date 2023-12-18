package com.example.common.dtos;

import com.example.common.validations.NotNullGroup;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
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


}
