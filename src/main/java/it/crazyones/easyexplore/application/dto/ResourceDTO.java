package it.crazyones.easyexplore.application.dto;

import it.crazyones.easyexplore.domain.model.BaseEntity;
import org.springframework.hateoas.ResourceSupport;


public abstract class ResourceDTO<T extends BaseEntity> extends ResourceSupport implements DTO<T> {

}
