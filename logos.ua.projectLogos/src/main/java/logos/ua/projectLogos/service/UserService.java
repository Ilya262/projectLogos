package logos.ua.projectLogos.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import logos.ua.projectLogos.dao.UserRepository;
import logos.ua.projectLogos.domain.Role;
import logos.ua.projectLogos.domain.User;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder bCryptPasswordEncoder;

	public void save(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		 user.setPasswordConfirm(bCryptPasswordEncoder.encode(user.getPasswordConfirm()));
		user.setRole(Role.ROLE_USER);
		userRepository.save(user);
	}

//	    public boolean saveUser(User user) {
//	        Optional<User> userFromDB = userRepository.findByEmail(user.getEmail());
//
//	        if (userFromDB != null) {
//	            return false;
//	        }
//			return true;

}
