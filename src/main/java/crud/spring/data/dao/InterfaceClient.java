package crud.spring.data.dao;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import crud.spring.data.model.Client;

@Repository
public interface InterfaceClient extends CrudRepository<Client, Long>{
	
	@Query(value = "select c from Client c where c.login = :login")
	public Client queryName (@Param("login") String login);
	
	@Modifying
	@Transactional
	@Query("delete from Client where id = ?1")
	public void queryDelete (Long id);
}
