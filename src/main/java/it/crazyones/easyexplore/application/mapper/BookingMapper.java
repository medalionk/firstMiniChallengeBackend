package it.crazyones.easyexplore.application.mapper;

import it.crazyones.easyexplore.application.dto.BookingDTO;
import it.crazyones.easyexplore.domain.model.Booking;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookingMapper extends BaseMapper<BookingDTO, Booking> {
    BookingMapper INSTANCE = Mappers.getMapper(BookingMapper.class );

    Booking toEntity(BookingDTO dto);
    BookingDTO toDTO(Booking entity);

    List<BookingDTO> toDTOs(List<Booking> entities);
    List<Booking> toEntities(List<BookingDTO> dtos);
}
