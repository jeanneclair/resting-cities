package org.wecancodeit.restingcities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
public class Populator implements CommandLineRunner {
	
	@Autowired
	StateRepository stateRepo;
	
	@Autowired
	CityRepository cityRepo;
	

	

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Fish walleye = new Fish("walleye", "sander vitreus", "https://wdfw.wa.gov/fishing/washington/graphics/species/walleye_duane_raver.jpg");
		
		State ohio = stateRepo.save(new State("Ohio", "oh", "birthplace of aviation", walleye));
		
		City columbus = cityRepo.save(new City("Columbus", 860090, ohio));
		City cleveland = cityRepo.save(new City("Cleveland", 385509, ohio));
		City sandusky = cityRepo.save(new City("Sandusky", 25006, ohio));
		
	}

}
