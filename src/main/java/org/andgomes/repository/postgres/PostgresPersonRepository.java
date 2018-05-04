package org.andgomes.repository.postgres;

import org.andgomes.bean.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostgresPersonRepository extends CrudRepository<Person, Long> {}
