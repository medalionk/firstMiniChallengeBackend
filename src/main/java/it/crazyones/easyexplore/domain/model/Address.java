package it.crazyones.easyexplore.domain.model;

import lombok.*;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;

/**
 * Created by bilal90 on 9/6/2017.
 */
@Embeddable
@Data
@NoArgsConstructor(force = true)
@AllArgsConstructor(staticName = "of")
@EqualsAndHashCode(callSuper = true)
public class Address extends BaseEntity {
    @NotEmpty
    @NonNull
    @Column(name = "street", nullable = false)
    private String street;

    @NotEmpty
    @NonNull
    @Column(name = "city", nullable = false)
    private String city;

    @NotEmpty
    @NonNull
    @Column(name = "country", nullable = false)
    private String country;

    @Column(name = "zip_code", nullable = false)
    private String zipcode;
}
