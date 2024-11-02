package cz.kovi.dto.mapper;

import cz.kovi.dto.PojisteniDTO;
import cz.kovi.entity.PojisteniEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PojisteniMapper {

    PojisteniEntity toEntity(PojisteniDTO source);

    PojisteniDTO toDTO(PojisteniEntity source);

}
