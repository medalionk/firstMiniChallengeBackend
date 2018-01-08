package it.crazyones.easyexplore.domain.model;

import lombok.Data;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@Data
@MappedSuperclass
public abstract class BaseEntity implements Serializable {

}