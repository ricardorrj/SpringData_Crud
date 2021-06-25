package crud.spring.data.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import crud.spring.data.model.ClientPhones;

@Repository
public interface interfaceClientPhones extends CrudRepository<ClientPhones, Long>{
	
}
