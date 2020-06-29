package com.project.service;

import com.project.repo.SportRepo;
import com.project.model.*;

public class SportService {
	public Sport getFirstSport() {
		
		Sport sport = null;
		SportRepo sportRepo = new SportRepo();
		sport = sportRepo.getFirstSport();
		sport.setName("You did it!");
		
		
		return(sport);
		
	}
	
public Sport updateSport() {
		
		Sport sport = null;
		SportRepo sportRepo = new SportRepo();
		sport = sportRepo.getFirstSport();
		sport.setName("You did it!");
		
		
		return(sport);
		
	}

	public boolean saveSport(Sport sport) {
	SportRepo sportRepo = new SportRepo();
	boolean saved = sportRepo.saveSport(sport);
	// the service layer applies the discount (business logic)
//	product.setPrice(product.getPrice() - 50);
//	return product;
	return saved;
}


}
