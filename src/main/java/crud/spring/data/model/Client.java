package crud.spring.data.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Client {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String name;
	
	@Column(nullable=true)
	private String email;
	
	@Column(nullable=true)
	private String login;
	
	@OneToMany(mappedBy = "client", orphanRemoval = true, fetch = FetchType.EAGER)
	private List<ClientPhones> clientPhones;
	
	public Client() {
	}
	
	public Client(String name, String email, String login) {
		super();
		this.name = name;
		this.email = email;
		this.login = login;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
	
	public List<ClientPhones> getClientPhones() {
		return clientPhones;
	}

	public void setClientPhones(List<ClientPhones> clientPhones) {
		this.clientPhones = clientPhones;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", name=" + name + ", email=" + email + ", login=" + login + "]";
	}
	
}
