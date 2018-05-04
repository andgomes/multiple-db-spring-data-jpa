package org.andgomes.repository.postgres2;

import org.andgomes.bean.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Postgres2PersonRepository extends CrudRepository<Person, Long> {}
