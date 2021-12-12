package logos.ua.projectLogos.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import logos.ua.projectLogos.domain.User;
@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
	Optional<User> findByEmail (String email);
	

}
