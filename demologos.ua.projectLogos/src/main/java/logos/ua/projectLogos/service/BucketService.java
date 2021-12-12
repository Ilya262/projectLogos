package logos.ua.projectLogos.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import logos.ua.projectLogos.dao.BucketRepository;
import logos.ua.projectLogos.domain.Bucket;

@Service
public class BucketService {

	@Autowired
	private BucketRepository bucketRepository;
	private Logger logger = LoggerFactory.getLogger(BucketService.class);

	public List<Bucket> getAll() {
		logger.info("Get all buckets items");
		return bucketRepository.findAll();

	}

	public void delete(Bucket bucket) {
		logger.info("Delete bucket item {} : " + bucket);
		bucketRepository.delete(bucket);

	}

	public Bucket add(Bucket bucket) {
		logger.info("Create new bucket item {}: " + bucket);
		return bucketRepository.save(bucket);

	}

}
