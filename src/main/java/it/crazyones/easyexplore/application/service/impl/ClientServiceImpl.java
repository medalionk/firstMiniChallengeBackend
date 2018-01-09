package it.crazyones.easyexplore.application.service.impl;

import it.crazyones.easyexplore.application.dto.ClientDTO;
import it.crazyones.easyexplore.application.mapper.ClientMapper;
import it.crazyones.easyexplore.application.service.BaseGenericService;
import it.crazyones.easyexplore.application.service.ClientService;
import it.crazyones.easyexplore.domain.model.Client;
import it.crazyones.easyexplore.domain.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl extends BaseGenericService<Client, ClientDTO> implements ClientService {
    @Autowired
    public ClientServiceImpl(ClientRepository repository, ClientMapper mapper) {
        super(ClientServiceImpl.class, repository, mapper);
    }

    @Override
    public ClientDTO create(ClientDTO entity) throws IllegalArgumentException, DataAccessException {
        if(entity == null) return null;
        return super.create(entity);
    }

    @Override
    public Optional<ClientDTO> update(ClientDTO dto) throws IllegalArgumentException, DataAccessException {
        return Optional.ofNullable(repository.findOne(dto.get_id())).map(x -> super.update(dto))
                .orElseThrow(() -> new IllegalArgumentException("Invalid Feedback Id"));
    }

    @Override
    public List<ClientDTO> saveAll(List<ClientDTO> dtos) throws DataAccessException {
        if(dtos == null) return null;
        return super.saveAll(dtos);
    }
}
