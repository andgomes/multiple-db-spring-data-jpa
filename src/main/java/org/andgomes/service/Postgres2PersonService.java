package org.andgomes.service;

import org.andgomes.bean.Person;
import org.andgomes.repository.postgres2.Postgres2PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("other")
public class Postgres2PersonService implements IPersonService {

	@Autowired
	private Postgres2PersonRepository personRepo;
	
	@Override
	public void save(Person person) {
		personRepo.save(person);
	}

}
