package it.crazyones.easyexplore.application.dto;

import it.crazyones.easyexplore.domain.model.BaseEntity;

public interface DTO<T extends BaseEntity> {
    T asEntity();
}
