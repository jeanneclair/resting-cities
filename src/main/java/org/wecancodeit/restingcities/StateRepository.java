package org.wecancodeit.restingcities;

import org.springframework.data.repository.CrudRepository;

public interface StateRepository extends CrudRepository<State, Long> {

	State findByAbbreviation(String abbreviation);


}
