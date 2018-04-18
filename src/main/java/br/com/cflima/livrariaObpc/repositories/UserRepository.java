package br.com.cflima.livrariaObpc.repositories;

import org.springframework.data.repository.CrudRepository;

import br.com.cflima.livrariaObpc.models.User;

public interface UserRepository extends CrudRepository<User, Integer>{

}
