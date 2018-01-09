package it.crazyones.easyexplore.application.mapper;

import it.crazyones.easyexplore.application.dto.AttractionDTO;
import it.crazyones.easyexplore.domain.model.Attraction;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AttractionMapper extends BaseMapper<AttractionDTO, Attraction> {
    AttractionMapper INSTANCE = Mappers.getMapper(AttractionMapper.class );

    Attraction toEntity(AttractionDTO dto);
    AttractionDTO toDTO(Attraction entity);

    List<AttractionDTO> toDTOs(List<Attraction> entities);
    List<Attraction> toEntities(List<AttractionDTO> dtos);
}
