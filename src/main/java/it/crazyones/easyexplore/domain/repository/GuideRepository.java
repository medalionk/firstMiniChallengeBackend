package it.crazyones.easyexplore.domain.repository;

import it.crazyones.easyexplore.domain.model.Guide;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuideRepository extends JpaRepository<Guide, String> {

}
