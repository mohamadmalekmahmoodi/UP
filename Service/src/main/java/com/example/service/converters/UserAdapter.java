package com.example.service.converters;

import com.example.common.dtos.UserDto;
import com.example.common.entities.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserAdapter extends AbstractAdapter<User, UserDto> {
}
