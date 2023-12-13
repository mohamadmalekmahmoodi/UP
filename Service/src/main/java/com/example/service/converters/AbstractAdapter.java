package com.example.service.converters;

import org.hibernate.annotations.Comment;
import org.mapstruct.MapperConfig;
import org.mapstruct.MappingInheritanceStrategy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
//@MapperConfig(mappingInheritanceStrategy = MappingInheritanceStrategy.AUTO_INHERIT_ALL_FROM_CONFIG)
public interface AbstractAdapter<E,D> {

    E convertDto(D dto);
    List<E> convertDtos(List<D> dto);

    D convertEntity(E dto);
    List<D> convertEntities(List<E> dto);
}
