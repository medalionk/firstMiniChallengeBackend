package it.crazyones.easyexplore.application.mapper;

import it.crazyones.easyexplore.application.dto.MemoryDTO;
import it.crazyones.easyexplore.domain.model.Memory;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MemoryMapper extends BaseMapper<MemoryDTO, Memory> {
    MemoryMapper INSTANCE = Mappers.getMapper(MemoryMapper.class );

    Memory toEntity(MemoryDTO dto);
    MemoryDTO toDTO(Memory entity);

    List<MemoryDTO> toDTOs(List<Memory> entities);
    List<Memory> toEntities(List<MemoryDTO> dtos);
}
