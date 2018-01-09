package it.crazyones.easyexplore.application.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import it.crazyones.easyexplore.application.mapper.BookingMapper;
import it.crazyones.easyexplore.domain.model.Booking;
import lombok.*;

import java.time.Instant;
import java.util.List;

/**
 * Created by bilal90 on 9/6/2017.
 */
@Data
@NoArgsConstructor(force = true)
@AllArgsConstructor(staticName = "of")
@EqualsAndHashCode(callSuper=false)
public class BookingDTO extends ResourceDTO<Booking> {
    @NonNull
    private String _id;

    @NonNull
    private ClientDTO client;

    @NonNull
    private GuideDTO guide;

    @NonNull
    private PeriodDTO period;

    @NonNull
    private MoneyDTO cost;

    private List<ReviewDTO> reviews;

    //@JsonIgnore
    protected Instant createdDate;
    protected Instant lastModifiedDate;

    @Override
    public Booking asEntity() {
        return BookingMapper.INSTANCE.toEntity(this);
    }
}
