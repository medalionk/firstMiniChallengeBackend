package it.crazyones.easyexplore.application.dto;

import it.crazyones.easyexplore.application.mapper.MoneyMapper;
import it.crazyones.easyexplore.domain.model.Money;
import lombok.*;

import java.math.BigDecimal;

/**
 * Created by bilal90 on 9/6/2017.
 */
@Data
@AllArgsConstructor(staticName = "of", access = AccessLevel.PRIVATE)
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor(force = true)
public class MoneyDTO implements DTO<Money> {
    @NonNull
    private BigDecimal amount;
    private String label;

    @NonNull
    private CurrencyDTO currency;

    @Override
    public Money asEntity() {
        return MoneyMapper.INSTANCE.toEntity(this);
    }
}
