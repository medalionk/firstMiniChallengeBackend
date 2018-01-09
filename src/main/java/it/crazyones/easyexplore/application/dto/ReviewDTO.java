package it.crazyones.easyexplore.application.dto;

import it.crazyones.easyexplore.application.mapper.ReviewMapper;
import it.crazyones.easyexplore.domain.model.Review;
import lombok.*;

import java.sql.Date;
import java.time.Instant;

/**
 * Created by bilal90 on 9/6/2017.
 */
@Data
@NoArgsConstructor(force = true)
@AllArgsConstructor(staticName = "of")
@EqualsAndHashCode(callSuper=false)
public class ReviewDTO extends ResourceDTO<Review> {
    @NonNull
    private String _id;

    private String subject;

    @NonNull
    private String review;

    private float rating;

    @NonNull
    private Date date;

    protected Instant createdDate;
    protected Instant lastModifiedDate;

    @Override
    public Review asEntity() {
        return ReviewMapper.INSTANCE.toEntity(this);
    }
}
