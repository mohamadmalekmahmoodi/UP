package com.example.common.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class UserDto {

        private Long id;
        private String name;
        private String family;
        private String nationalCode;
}
