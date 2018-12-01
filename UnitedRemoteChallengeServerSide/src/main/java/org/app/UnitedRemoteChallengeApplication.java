package org.app;

import org.app.dao.ShopRepository;
import org.app.entity.AppRole;
import org.app.entity.AppUser;
import org.app.entity.Location;
import org.app.entity.Shop;
import org.app.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class UnitedRemoteChallengeApplication implements CommandLineRunner {

	@Autowired
	private ShopRepository shopRepository;
	
	@Autowired
	private AccountService accountService;
	
	public static void main(String[] args) {
		SpringApplication.run(UnitedRemoteChallengeApplication.class, args);
	}
	
	@Bean
	public BCryptPasswordEncoder getEncoder() {
	    return new BCryptPasswordEncoder();
	}

	@Override
	public void run(String... args) throws Exception {
		Location location =  new Location(33, -7); //Casablanca
		Shop shop1 = new Shop("Shop 2",location);
		shopRepository.save(shop1);
		shopRepository.save(new Shop("Shop 3", new Location(31, -9))); // Essaouira
		shopRepository.save(new Shop("Shop 1", new Location(30, -9))); // Agadir
		AppUser user = new AppUser(null, "user1", "1234");
		user.setLocation(new Location(28, -10)); // guelmim
		accountService.saveUser(user);
		
		accountService.saveRole(new AppRole("ADMIN"));
		accountService.saveRole(new AppRole("USER"));
		accountService.addRoleToUser("user1", "USER");
				
	}
	
	
	
}
