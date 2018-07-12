package org.wecancodeit.restingcities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class City {
	
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private int population;
	
	@ManyToOne 
	private State state;
	
	
	public City(String name, int population, State state) {
		this.name = name;
		this.population = population;
		this.state = state;
	}

	public City () {
		
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getPopulation() {
		return population;
	}
	

	public State getState() {
		return state;
	}

	@Override
	public String toString() {
		return name +": " + state;
	}



	
	
	
}
