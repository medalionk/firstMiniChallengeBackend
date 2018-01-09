package it.crazyones.easyexplore.application.dto;

import it.crazyones.easyexplore.application.mapper.PeriodMapper;
import it.crazyones.easyexplore.domain.model.Period;
import lombok.*;

import java.sql.Date;

/**
 * Created by bilal90 on 9/6/2017.
 */
@Data
@AllArgsConstructor(staticName = "of", access = AccessLevel.PRIVATE)
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor(force = true)
public class PeriodDTO implements DTO<Period> {
    @NonNull
    private Date startDate;
    private Date endDate;

    @Override
    public Period asEntity() {
        return PeriodMapper.INSTANCE.toEntity(this);
    }
}
