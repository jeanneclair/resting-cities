package org.wecancodeit.restingcities;

import java.util.Collection;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class State {
		
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String abbreviation;
	private String motto;
	private String citiesURL;
	
	@JsonIgnore
	@OneToMany (mappedBy = "state")
	private Collection<City> cities;
	
	@Embedded
	private Fish fish;
	
	public State(String name, String abbreviation, String motto, Fish fish) {
		this.name = name;
		this.abbreviation = abbreviation;
		this.motto = motto;
		this.citiesURL = "/api/state/" + abbreviation + "/cities";
		this.fish = fish;
	}

	public State () {
		
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getAbbreviation() {
		return abbreviation;
	}

	public String getMotto() {
		return motto;
	}

	public String getCitiesURL() {
		return citiesURL;
	}

	public Fish getFish() {
		return fish;
	}

	public Collection<City> getCities() {
		return cities;
	}

	@Override
	public String toString() {
		return name;
	}	
	
}
