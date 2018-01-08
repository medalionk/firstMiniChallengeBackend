package it.crazyones.easyexplore.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

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
    @Column(name = "longitude")
    private float longitude;

    @Column(name = "latitude")
    private float latitude;
}
