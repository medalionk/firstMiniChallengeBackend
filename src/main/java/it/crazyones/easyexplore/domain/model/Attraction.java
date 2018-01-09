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
public class Attraction extends IdentifiableEntity {
    @NonNull
    @Column(name="name")
    private String attractionName;

    @Column(name="about")
    private String about;

    @NonNull
    @Embedded
    private GeographicLocation location;

    @ElementCollection(targetClass=String.class)
    @CollectionTable(name="images", joinColumns=@JoinColumn(name="id"))
    @Column(name="image")
    private List<String> images;
}
