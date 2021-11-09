package logos.ua.projectLogos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import logos.ua.projectLogos.domain.Periodical;
import logos.ua.projectLogos.service.PeriodicalsService;
@Controller
public class PeriodicalController {

	@Autowired
	private PeriodicalsService periodicalsService;

	@RequestMapping(value = "/create-periodical", method = RequestMethod.GET)
	public ModelAndView createPeriodical() {
		return new ModelAndView("createPeriodical", "periodical", new Periodical());
		// page name "createPeriodical", model name "periodical", object Periodical
	}

	@RequestMapping(value = "/addPeriodical", method = RequestMethod.POST)
	public ModelAndView createPeriodical(@Validated @ModelAttribute("periodical") Periodical periodical,
			BindingResult bindingResult) {

		periodicalsService.save(periodical);
//			
//			Map<String, Object> model = bindingResult.getModel();
//			String objectName = bindingResult.getObjectName();
//			System.out.println(objectName);
//			System.out.println(model); 
		return new ModelAndView("redirect:/home");

	}
	

	@RequestMapping(value ="/home", method = RequestMethod.GET)
    public ModelAndView welcome() {
        ModelAndView map = new ModelAndView("home");
        map.addObject("periodicals", periodicalsService.getAllPeriodicals());
    	return map;
    }

}
