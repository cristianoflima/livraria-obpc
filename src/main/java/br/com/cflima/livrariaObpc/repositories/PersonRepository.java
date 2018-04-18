package br.com.cflima.livrariaObpc.repositories;

import org.springframework.data.repository.CrudRepository;

import br.com.cflima.livrariaObpc.models.Person;

public interface PersonRepository extends CrudRepository<Person,Integer>{

}
