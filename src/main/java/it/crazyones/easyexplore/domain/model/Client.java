package it.crazyones.easyexplore.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

/**
 * Created by bilal90 on 9/6/2017.
 */
@Entity
@Data
@NoArgsConstructor(force = true)
@EqualsAndHashCode(callSuper = true)
public class Client extends User {

}
