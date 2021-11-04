package logos.ua.projectLogos.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import logos.ua.projectLogos.domain.Periodical;
@Repository
public interface PeriodicalRepository extends JpaRepository<Periodical, Integer>{

}
