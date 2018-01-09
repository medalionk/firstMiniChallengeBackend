package it.crazyones.easyexplore.domain.model;

import lombok.*;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Created by bilal90 on 9/6/2017.
 */
@Embeddable
@Data
@NoArgsConstructor(force=true)
@AllArgsConstructor(staticName="of")
@EqualsAndHashCode(callSuper = false)
public class GeographicLocation extends BaseEntity {
    @NotEmpty
    @NonNull
    @Column(name = "location_name")
    private String name;

    @NotEmpty
    @NonNull
    @Column(name = "state")
    private String state;

    @NotEmpty
    @NonNull
    @Column(name = "country")
    private String country;

    @NotEmpty
    @NonNull
    @Column(name = "longitude", nullable = false)
    private float longitude;

    @NotEmpty
    @NonNull
    @Column(name = "latitude", nullable = false)
    private float latitude;
}
