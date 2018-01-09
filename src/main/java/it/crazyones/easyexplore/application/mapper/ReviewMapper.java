package it.crazyones.easyexplore.application.mapper;

import it.crazyones.easyexplore.application.dto.ReviewDTO;
import it.crazyones.easyexplore.domain.model.Review;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReviewMapper extends BaseMapper<ReviewDTO, Review> {
    ReviewMapper INSTANCE = Mappers.getMapper(ReviewMapper.class );

    Review toEntity(ReviewDTO dto);
    ReviewDTO toDTO(Review entity);

    List<ReviewDTO> toDTOs(List<Review> entities);
    List<Review> toEntities(List<ReviewDTO> dtos);
}
