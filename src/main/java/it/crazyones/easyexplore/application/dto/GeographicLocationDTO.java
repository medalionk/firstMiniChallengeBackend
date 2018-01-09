package it.crazyones.easyexplore.application.dto;

import it.crazyones.easyexplore.application.mapper.GeographicLocationMapper;
import it.crazyones.easyexplore.domain.model.GeographicLocation;
import lombok.*;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by bilal90 on 9/6/2017.
 */
@Data
@AllArgsConstructor(staticName = "of", access = AccessLevel.PRIVATE)
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor(force = true)
public class GeographicLocationDTO implements DTO<GeographicLocation> {
    @NotEmpty
    @NonNull
    private float longitude;

    @NotEmpty
    @NonNull
    private float latitude;

    @Override
    public GeographicLocation asEntity() {
        return GeographicLocationMapper.INSTANCE.toEntity(this);
    }
}
