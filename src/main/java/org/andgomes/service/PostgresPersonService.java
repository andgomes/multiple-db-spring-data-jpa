package org.andgomes.service;

import org.andgomes.bean.Person;
import org.andgomes.repository.postgres.PostgresPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("dev")
public class PostgresPersonService implements IPersonService {

	@Autowired
	private PostgresPersonRepository personRepo;
	
	@Override
	public void save(Person person) {
		personRepo.save(person);
	}

}
