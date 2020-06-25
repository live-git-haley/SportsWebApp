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

}
