package it.crazyones.easyexplore.application.mapper;

import it.crazyones.easyexplore.application.dto.GuideDTO;
import it.crazyones.easyexplore.domain.model.Guide;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GuideMapper extends BaseMapper<GuideDTO, Guide> {
    GuideMapper INSTANCE = Mappers.getMapper(GuideMapper.class );

    Guide toEntity(GuideDTO dto);
    GuideDTO toDTO(Guide entity);

    List<GuideDTO> toDTOs(List<Guide> entities);
    List<Guide> toEntities(List<GuideDTO> dtos);
}
