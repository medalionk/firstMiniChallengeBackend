package it.crazyones.easyexplore.domain.model;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by bilal90 on 9/6/2017.
 */
@Entity
@Data
@NoArgsConstructor(force = true)
@AllArgsConstructor(staticName = "of")
@EqualsAndHashCode(callSuper = true)
public class Review extends AuditingEntity {
    @Column(name = "subject")
    private String subject;

    @NonNull
    @Column(name = "review")
    private String review;

    @Column(name = "rating")
    private float rating;

    @NonNull
    @Basic
    @Column(name = "date")
    private Date date;
}
