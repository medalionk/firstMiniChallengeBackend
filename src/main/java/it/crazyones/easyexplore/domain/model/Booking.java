package it.crazyones.easyexplore.domain.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * Created by bilal90 on 9/6/2017.
 */
@Entity
@Data
@NoArgsConstructor(force = true)
@AllArgsConstructor(staticName = "of")
@EqualsAndHashCode(callSuper = true)
public class Booking extends AuditingEntity {
    @NonNull
    @ManyToOne
    private Client client;

    @NonNull
    @ManyToOne
    private Guide guide;

    @NonNull
    @Embedded
    private Period period;

    @NonNull
    @Embedded
    private Money cost;

    @OneToMany
    private List<Review> reviews;
}
