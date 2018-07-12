package org.wecancodeit.restingcities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StateController {

	
	@Autowired
	StateRepository stateRepo;
	
	@Autowired
	CityRepository cityRepo;
	
	@RequestMapping("/")
	public String home() {
		return "redirect:/states";
	}
	
	@RequestMapping("/states")
	public String getStates(Model model) {
		model.addAttribute("states", stateRepo.findAll());
		return "states";
	}
	
	@RequestMapping(value = "/states", method = RequestMethod.POST)
	public String addStates(String stateName, String stateAbbreviation, String stateMotto, String stateFish, String stateFishBinomialNomenclature, String stateFishImgUrl ) {
		
		stateRepo.save(new State(stateName, stateAbbreviation, stateMotto, new Fish(stateFish, stateFishBinomialNomenclature, stateFishImgUrl)));
		
		return "redirect:/states";
	}
	
	
	@RequestMapping("/states/{abbreviation}")
	public String getState(@PathVariable(name = "abbreviation") String abbreviation, Model model) {
		model.addAttribute("state", stateRepo.findByAbbreviation(abbreviation));
		return "state";
	}
	
	@RequestMapping("/states/{abbreviation}/cities/{id}")
	public String getCity(
			@PathVariable(name = "abbreviation") String abbreviation, 
			@PathVariable(name = "id") Long id,
			Model model
	) {
		model.addAttribute("city", cityRepo.findOne(id));
		return "city";
	}
	
	@RequestMapping("/states/{abbreviation}/cities")
	public String getCity(
			@PathVariable(name = "abbreviation") String abbreviation, 
			Model model
	) {
		model.addAttribute("state", stateRepo.findByAbbreviation(abbreviation));
		return "cities";
	}
	
	@RequestMapping(value = "/states/{abbreviation}/cities", method = RequestMethod.POST)
	public String addCities(@PathVariable(name = "abbreviation") String abbreviation, String cityName, int cityPopulation) {
		
		
		cityRepo.save(new City(cityName, cityPopulation, stateRepo.findByAbbreviation(abbreviation)));
		
		return "redirect:/states/{abbreviation}/cities";
	}
	
	@RequestMapping("/states/{abbreviation}/fish")
	public String getStateFish(@PathVariable(name = "abbreviation") String abbreviation, Model model) {
		model.addAttribute("state", stateRepo.findByAbbreviation(abbreviation));
		return "fish";
	}
}
