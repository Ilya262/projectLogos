package logos.ua.projectLogos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import logos.ua.projectLogos.dao.PeriodicalRepository;
import logos.ua.projectLogos.domain.Periodical;

@Service
public class PeriodicalsService {
	
	@Autowired
	private PeriodicalRepository periodicalRepository;
	
//    	public Periodical save(Periodical periodical) {
//		logger.info("Create periodical item {} : " + periodical);
//		return periodicalRepository.save(periodical);
//	}
	public Periodical save(Periodical periodical) {
		return periodicalRepository.save(periodical);
	}
	
	public List<Periodical> getAllPeriodicals(){
		return periodicalRepository.findAll();
	}
	
	
	
	
	
}
