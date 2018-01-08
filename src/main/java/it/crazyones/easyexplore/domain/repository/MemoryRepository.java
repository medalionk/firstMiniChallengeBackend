package it.crazyones.easyexplore.domain.repository;

import it.crazyones.easyexplore.domain.model.Memory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemoryRepository extends JpaRepository<Memory, String> {

}
