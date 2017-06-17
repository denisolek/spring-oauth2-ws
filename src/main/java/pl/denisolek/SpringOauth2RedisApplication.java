package pl.denisolek;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.UserDetailsService;
import pl.denisolek.config.CustomUserDetails;
import pl.denisolek.entity.Role;
import pl.denisolek.entity.User;
import pl.denisolek.repository.UserRepository;

import java.util.Arrays;

@SpringBootApplication
public class SpringOauth2RedisApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringOauth2RedisApplication.class, args);
	}

	@Autowired
	public void authenticationManager(AuthenticationManagerBuilder builder, UserRepository repository) throws Exception {
		if (repository.count() == 0) {
			repository.save(new User("user", "password", Arrays.asList(new Role("USER"), new Role("ACTUATOR"))));
		}
		builder.userDetailsService(userDetailsService(repository));
	}

	private UserDetailsService userDetailsService(final UserRepository repository) {
		return username -> new CustomUserDetails(repository.findByUsername(username));
	}

}