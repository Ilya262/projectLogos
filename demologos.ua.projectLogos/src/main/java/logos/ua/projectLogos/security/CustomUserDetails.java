package logos.ua.projectLogos.security;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;

import logos.ua.projectLogos.domain.User;

public class CustomUserDetails extends User implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<String> listRole;

	public CustomUserDetails(User user, List<String> listRole) {
		super(user);
		this.listRole = listRole;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		String role = StringUtils.collectionToCommaDelimitedString(listRole);
		return AuthorityUtils.commaSeparatedStringToAuthorityList(role);
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
