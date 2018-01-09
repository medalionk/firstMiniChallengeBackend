package it.crazyones.easyexplore.application.mapper;

import it.crazyones.easyexplore.application.dto.PeriodDTO;
import it.crazyones.easyexplore.domain.model.Period;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PeriodMapper extends BaseMapper<PeriodDTO, Period> {
    PeriodMapper INSTANCE = Mappers.getMapper(PeriodMapper.class );

    Period toEntity(PeriodDTO dto);
    PeriodDTO toDTO(Period entity);

    List<PeriodDTO> toDTOs(List<Period> entities);
    List<Period> toEntities(List<PeriodDTO> dtos);
}
