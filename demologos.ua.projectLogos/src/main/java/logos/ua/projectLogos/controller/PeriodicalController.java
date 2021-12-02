package logos.ua.projectLogos.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.MultipartAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import logos.ua.projectLogos.domain.Periodical;
import logos.ua.projectLogos.service.PeriodicalsDTOHelper;
import logos.ua.projectLogos.service.PeriodicalsService;

@Controller
public class PeriodicalController {

	@Autowired
	private PeriodicalsService periodicalsService;

	@RequestMapping(value = "/create-periodical", method = RequestMethod.GET)
	public String createPeriodical() {
		return "createPeriodical";
		// page name "createPeriodical", model name "periodical", object Periodical
	}

	@RequestMapping(value = "/addPeriodical", method = RequestMethod.POST)
	public ModelAndView addPeriodical(@RequestParam MultipartFile image, @RequestParam String name,
			@RequestParam String description, @RequestParam Double price) throws IOException {

		periodicalsService.save(PeriodicalsDTOHelper.createEntity(image, name, description, price));

		return new ModelAndView("redirect:/home");

	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView welcome() {
		ModelAndView map = new ModelAndView("home");
		map.addObject("periodicals", periodicalsService.getAllPeriodicals());
		return map;
	}

}
