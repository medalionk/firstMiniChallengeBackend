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
public class Guide extends User {
    @NonNull
    @Column(name="about")
    private String about;

    @Column(name="rating")
    private float rating;

    @NonNull
    @Embedded
    private Money rate;

    @ElementCollection(targetClass=String.class)
    @CollectionTable(name="services", joinColumns=@JoinColumn(name="id"))
    @Column(name="service")
    private List<String> services;

    @ElementCollection(targetClass=Language.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name="languages", joinColumns=@JoinColumn(name="id"))
    @Column(name="language")
    private List<Language> languages;

    @OneToMany
    private List<Attraction> attractions;

    @OneToMany
    private List<Memory> memories;
}
