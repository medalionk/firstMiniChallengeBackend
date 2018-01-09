package it.crazyones.easyexplore.application.mapper;

import it.crazyones.easyexplore.application.dto.GeographicLocationDTO;
import it.crazyones.easyexplore.domain.model.GeographicLocation;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GeographicLocationMapper extends BaseMapper<GeographicLocationDTO, GeographicLocation> {
    GeographicLocationMapper INSTANCE = Mappers.getMapper(GeographicLocationMapper.class );

    GeographicLocation toEntity(GeographicLocationDTO dto);
    GeographicLocationDTO toDTO(GeographicLocation entity);

    List<GeographicLocationDTO> toDTOs(List<GeographicLocation> entities);
    List<GeographicLocation> toEntities(List<GeographicLocationDTO> dtos);
}
