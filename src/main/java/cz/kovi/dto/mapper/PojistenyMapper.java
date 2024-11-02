package cz.kovi.dto.mapper;

import cz.kovi.dto.PojistenyDTO;
import cz.kovi.entity.PojistenyEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PojistenyMapper {

    PojistenyEntity toEntity(PojistenyDTO source);

    PojistenyDTO toDTO(PojistenyEntity source);

}
