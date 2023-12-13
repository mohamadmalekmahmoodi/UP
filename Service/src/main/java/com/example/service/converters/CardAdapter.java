package com.example.service.converters;

import com.example.common.dtos.CardDto;
import com.example.common.entities.Card;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CardAdapter extends AbstractAdapter<Card, CardDto> {
}
