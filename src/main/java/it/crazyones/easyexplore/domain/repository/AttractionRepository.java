package it.crazyones.easyexplore.domain.repository;

import it.crazyones.easyexplore.domain.model.Attraction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttractionRepository extends JpaRepository<Attraction, String> {

}
