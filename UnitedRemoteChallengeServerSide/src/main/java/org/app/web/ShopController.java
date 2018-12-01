package org.app.web;

import java.util.List;

import org.app.entity.Shop;
import org.app.service.AccountService;
import org.app.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShopController {

	@Autowired
	private ShopService shopService;
	
	@Autowired
	private AccountService accountService;
	
	@GetMapping("/shops")
	public List<Shop> getShops(){
		AbstractAuthenticationToken auth = (AbstractAuthenticationToken)
			    SecurityContextHolder.getContext().getAuthentication();
		List<Shop> shops = shopService.getListOfShops(auth.getPrincipal().toString());
		return shops;
	}
	
	@GetMapping("/preferredshops")
	public List<Shop> getPreferredShops(){
		AbstractAuthenticationToken auth = (AbstractAuthenticationToken)
			    SecurityContextHolder.getContext().getAuthentication();
		List<Shop> shops = shopService.getListOfPreferredShops(auth.getPrincipal().toString());
		return shops;
	}
	
	@GetMapping("/dislikeshops/{idShop}")
	public void addPreferredShop(@PathVariable String idShop){
		AbstractAuthenticationToken auth = (AbstractAuthenticationToken)
			    SecurityContextHolder.getContext().getAuthentication();
		accountService.removeLikedShop(auth.getPrincipal().toString(), Long.parseLong(idShop));
	}
	
	@GetMapping("/likeshops/{idShop}")
	public void removePreferredShop(@PathVariable String idShop){
		AbstractAuthenticationToken auth = (AbstractAuthenticationToken)
			    SecurityContextHolder.getContext().getAuthentication();
		accountService.addLikedShops(auth.getPrincipal().toString(), Long.parseLong(idShop));
	}
	
}
