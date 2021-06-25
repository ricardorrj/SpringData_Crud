package crud.spring.data;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import crud.spring.data.dao.InterfaceClient;
import crud.spring.data.dao.interfaceClientPhones;
import crud.spring.data.model.Client;
import crud.spring.data.model.ClientPhones;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:META-INF/spring-config.xml"})
public class AppTest 
{
	@Autowired
	private InterfaceClient interfaceClient;
	
	@Autowired
	private interfaceClientPhones interfaceClientPhones;
	
	@Test
	public void insertClient() {
		Client user = new Client("Richard","teste@teste.com","richardrrj");
		
		ClientPhones phones = new ClientPhones();
		phones.setType("Telefone");
		phones.setNumber("(00) 00000-0000");
		phones.setClient(user);
		
		interfaceClient.save(user);
		interfaceClientPhones.save(phones);
	}
	
	@Test
	public void insertClient2() {
		Client user = new Client("Richard2","teste@teste.com","richardrrj2");
		
		interfaceClient.save(user);
	}
	
	
	@Test
	public void insertPhones() {
		Optional<Client> user = interfaceClient.findById(1L);
		
		ClientPhones phone = new ClientPhones("Celular","(00) 00001-5000", user.get());
		
		interfaceClientPhones.save(phone);
	}
	
	
	@Test
	public void updateClient() {
		Optional<Client> user = interfaceClient.findById(1L);
		
		user.get().setName("Richard Jr");
		interfaceClient.save(user.get());
	}
	
	
	@Test
	public void updatePhone() {
		Optional<Client> user = interfaceClient.findById(1L);
		Client dataUser = user.get();
		
		if(dataUser.getClientPhones().size() > 0) {
			
			for(ClientPhones phone : dataUser.getClientPhones()) {
				
				if(phone.getId() == 11L) {		
					phone.setNumber("(99) 10100-5001");
					interfaceClientPhones.save(phone);
				}
			}
		}
		else{
			System.out.println("Não existe telefone para este cadastro!");
		}
	}
	
	
	
	@Test
	public void delete() {
		Optional<Client> user = interfaceClient.findById(1L);
		Client dataUser = user.get();
		
		if(dataUser.getClientPhones().size() > 0) {
			for(ClientPhones phone : dataUser.getClientPhones()) {
				interfaceClientPhones.deleteById(phone.getId());
			}
		}
		
		interfaceClient.deleteById(1L);
	}
	
	
	@Test
	public void loadById() {
		Optional<Client> user = interfaceClient.findById(1L);
		
		Client data = user.get();
		System.out.println("Cliente: " + data);
		System.out.println("----------");
		
		if(data.getClientPhones().size() > 0) {
			for(ClientPhones phones : data.getClientPhones()) {
				System.out.println("Contato: " + phones);
			}
		}
	
	}
	
	
	@Test
	public void listAll() {
		Iterable<Client> listUsers = interfaceClient.findAll();
		
		for(Client user : listUsers) {
			System.out.println(user);
			
			if(user.getClientPhones().size() > 0) {
				for(ClientPhones phones : user.getClientPhones()) {
					System.out.println(phones);
				}
			}
			
			System.out.println("------------------------");
		}
	}
	
	
	@Test
	public void querySelect() {
		Client user = interfaceClient.queryName("richardrrj2");
		
		System.out.println(user);
	}
	
	@Test
	public void queryDelete() {
		interfaceClient.queryDelete(16L);
	}
	
	
}
