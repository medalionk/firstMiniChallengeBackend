package it.crazyones.easyexplore.domain.model;

import lombok.*;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.sql.Date;

/**
 * Created by bilal90 on 9/6/2017.
 */
@Embeddable
@Data
@NoArgsConstructor(force=true)
@AllArgsConstructor(staticName="of")
@EqualsAndHashCode(callSuper = false)
public class Period extends BaseEntity {
    @NonNull
    @Basic
    @Column(name = "start_date")
    private Date startDate;

    @Basic
    @Column(name = "end_date")
    private Date endDate;
}
