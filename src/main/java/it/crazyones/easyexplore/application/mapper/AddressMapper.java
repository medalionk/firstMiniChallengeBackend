package it.crazyones.easyexplore.application.mapper;

import it.crazyones.easyexplore.application.dto.AddressDTO;
import it.crazyones.easyexplore.domain.model.Address;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AddressMapper extends BaseMapper<AddressDTO, Address> {
    AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class );

    Address toEntity(AddressDTO dto);
    AddressDTO toDTO(Address entity);

    List<AddressDTO> toDTOs(List<Address> entities);
    List<Address> toEntities(List<AddressDTO> dtos);
}
