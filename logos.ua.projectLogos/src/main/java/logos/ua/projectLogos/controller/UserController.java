package logos.ua.projectLogos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import logos.ua.projectLogos.domain.User;
import logos.ua.projectLogos.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

//	@Autowired
//	private PeriodicalsService periodicalsService;

	 @RequestMapping(value = "/registration", method = RequestMethod.GET)
	    public String registration(Model model) {
	        model.addAttribute("userForm", new User());

	        return "registration";
	    }

	    @RequestMapping(value = "/registration", method = RequestMethod.POST)
	    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {

	        if (bindingResult.hasErrors()) {
	            return "/registration";
	        }
	        userService.save(userForm);


	        return "redirect:/home";
	    }

	@RequestMapping(value = { "/", "/login" }, method = RequestMethod.GET)
	public String login(Model model, String error, String logout) {
		if (error != null)
			model.addAttribute("error", "Your username or password is invalid.");

		if (logout != null)
			model.addAttribute("message", "You have been logged out successfully.");

		return "login";
	}

//	@GetMapping("/registration")
//	public String registration(Model model) {
//
//		model.addAttribute("userForm", new User());
//
//		return "registration";
//
//	}
//
//	@PostMapping("/registraton")
//	public String addUser(@ModelAttribute("userForm") @Validated User userForm, BindingResult bindingResult,
//			Model model) {
//
//		if (bindingResult.hasErrors())
//
//		{
//			return "registration";
//		}
//
//		if (!userForm.getPassword().equals(userForm.getConfirmPassword())) {
//			model.addAttribute("passwordError", "Пароли не совпадают");
//			return "registration";
//		}
//
//		if (!userService.saveUser(userForm)) {
//			model.addAttribute("usernameError", "Пользователь с таким именем уже существует");
//			return "registration";
//		}
//
//		return "redirect:/home";
//
//	}

//	    @RequestMapping(value ="/home", method = RequestMethod.GET)
//	    public ModelAndView welcome() {
//	        ModelAndView map = new ModelAndView("home");
//	        map.addObject("periodicals", periodicalsService.getAllPeriodicals());
//	    	return map;
//	    }
//	    
//	    @RequestMapping(value ="/create-periodical", method = RequestMethod.GET)
//	    public ModelAndView createPeriodical() {
//	        return new ModelAndView("createPeriodical", "periodical", new Periodical()) ; 
//	        //page name "createPeriodical", model name "periodical", object Periodical
//	    }

//	    @RequestMapping(value = "/addPeriodical", method = RequestMethod.POST)
//		public ModelAndView createPeriodical(@Validated @ModelAttribute("periodical") Periodical periodical,
//				BindingResult bindingResult) {
//			
//			periodicalsService.save(periodical);
//			/*
//			Map<String, Object> model = bindingResult.getModel();
//			String objectName = bindingResult.getObjectName();
//			System.out.println(objectName);
//			System.out.println(model); */
//		    return new ModelAndView("redirect:/home");
//		} 
}
