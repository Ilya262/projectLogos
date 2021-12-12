package logos.ua.projectLogos.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import logos.ua.projectLogos.dao.UserRepository;
import logos.ua.projectLogos.domain.Role;
import logos.ua.projectLogos.domain.User;

@Service
public class UserService {
	private Logger logger = LoggerFactory.getLogger(UserService.class);
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder bCryptPasswordEncoder;

	public void save(User user) {
		logger.info("Register new user {} : " + user);
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		 user.setPasswordConfirm(bCryptPasswordEncoder.encode(user.getPasswordConfirm()));
		user.setRole(Role.ROLE_USER);
		userRepository.save(user);
	}
	
	 public User findByEmail(String email) {
		 logger.info("Get user {} by email: " + email);
	    	return userRepository.findByEmail(email).get();
	    }

//	    public boolean saveUser(User user) {
//	        Optional<User> userFromDB = userRepository.findByEmail(user.getEmail());
//
//	        if (userFromDB != null) {
//	            return false;
//	        }
//			return true;

}
