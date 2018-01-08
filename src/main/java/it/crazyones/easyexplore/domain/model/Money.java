package it.crazyones.easyexplore.domain.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigDecimal;

/**
 * Created by bilal90 on 9/26/2017.
 */
@Embeddable
@Data
@NoArgsConstructor(force = true)
@AllArgsConstructor(staticName = "of")
@EqualsAndHashCode(callSuper = false)
public class Money extends BaseEntity {
    @NonNull
    @Column(name="amount")
    private BigDecimal amount;

    @Column(name="label")
    private String label;

    @NonNull
    @Enumerated(EnumType.STRING)
    @Column(name="currency")
    private Currency currency;
}
