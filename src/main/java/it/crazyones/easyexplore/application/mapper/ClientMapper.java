package it.crazyones.easyexplore.application.mapper;

import it.crazyones.easyexplore.application.dto.ClientDTO;
import it.crazyones.easyexplore.domain.model.Client;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientMapper extends BaseMapper<ClientDTO, Client> {
    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class );

    Client toEntity(ClientDTO dto);
    ClientDTO toDTO(Client entity);

    List<ClientDTO> toDTOs(List<Client> entities);
    List<Client> toEntities(List<ClientDTO> dtos);
}
