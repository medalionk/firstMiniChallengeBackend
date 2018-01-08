package it.crazyones.easyexplore.application.service;

import it.crazyones.easyexplore.application.dto.DTO;
import it.crazyones.easyexplore.application.dto.ResourceDTO;
import it.crazyones.easyexplore.application.mapper.BaseMapper;
import it.crazyones.easyexplore.domain.model.BaseEntity;
import it.crazyones.easyexplore.util.ValidationUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by bilal90 on 9/30/2017.
 */
@Service
public abstract class BaseGenericService<U extends BaseEntity, T extends ResourceDTO<U>> implements GenericService<T> {
    protected final Logger LOGGER;
    protected final JpaRepository<U, String> repository;
    protected final BaseMapper<T, U> mapper;

    protected <S extends BaseGenericService> BaseGenericService(
            Class<S> tClass, JpaRepository<U, String> repository, BaseMapper<T, U> mapper) {
        this.LOGGER = LoggerFactory.getLogger(tClass);
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public T create(T entity) throws IllegalArgumentException, DataAccessException {
        LOGGER.info("Create entity: '{}'", entity);
        ValidationUtil.ValidateEntity(entity);
        U savedEntity = repository.saveAndFlush(entity.asEntity());
        return mapper.toDTO(savedEntity);
    }

    @Override
    public Optional<T> update(T entity) throws IllegalArgumentException, DataAccessException {
        LOGGER.info("Update entity: '{}'", entity);
        ValidationUtil.ValidateEntity(entity);
        return Optional.ofNullable(repository.saveAndFlush(entity.asEntity()))
                .map(mapper::toDTO);
    }

    @Override
    public Optional<T> findOne(String id) throws IllegalArgumentException, DataAccessException {
        LOGGER.info("Fetch one entity with id: '{}'", id);
        ValidationUtil.ValidateIdentity(id);
        U entity = repository.findOne(id);
        return Optional.ofNullable(entity).map(mapper::toDTO);
    }

    @Override
    public List<T> findAll() throws DataAccessException{
        LOGGER.info("Fetch all entities found");
        List<U> results = repository.findAll();
        if(results == null || results.isEmpty()) {
            LOGGER.info("No entities found");
            return null;
        }

        return mapper.toDTOs(results);
    }

    @Override
    public void delete(String id) throws IllegalArgumentException, DataAccessException {
        LOGGER.info("Delete entity with id: '{}'", id);
        ValidationUtil.ValidateIdentity(id);
        repository.delete(id);
    }

    @Override
    public long count() throws DataAccessException{
        return repository.count();
    }

    @Override
    public List<T> saveAll(List<T> dtos) throws DataAccessException {
        ValidationUtil.ValidateEntity(dtos);
        List<U> entities = dtos.stream().map(DTO::asEntity).collect(Collectors.toList());
        List<U> savedEntities = repository.save(entities);
        return mapper.toDTOs(savedEntities);
    }
}
