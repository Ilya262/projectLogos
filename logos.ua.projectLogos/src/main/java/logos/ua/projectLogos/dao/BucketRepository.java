package logos.ua.projectLogos.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import logos.ua.projectLogos.domain.Bucket;
@Repository
public interface BucketRepository extends JpaRepository<Bucket, Integer>{

}
