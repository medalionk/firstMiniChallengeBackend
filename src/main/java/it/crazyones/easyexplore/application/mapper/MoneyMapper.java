package it.crazyones.easyexplore.application.mapper;

import it.crazyones.easyexplore.application.dto.MoneyDTO;
import it.crazyones.easyexplore.domain.model.Money;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MoneyMapper extends BaseMapper<MoneyDTO, Money> {
    MoneyMapper INSTANCE = Mappers.getMapper(MoneyMapper.class );

    Money toEntity(MoneyDTO dto);
    MoneyDTO toDTO(Money entity);

    List<MoneyDTO> toDTOs(List<Money> entities);
    List<Money> toEntities(List<MoneyDTO> dtos);
}
