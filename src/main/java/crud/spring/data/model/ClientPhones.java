package crud.spring.data.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ClientPhones {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String type;
	
	@Column(nullable = false)
	private String number;
	
	@ManyToOne(optional = false)
	private Client client;

	public ClientPhones() {
	}
	
	public ClientPhones(String type, String number, Client client) {
		super();
		this.type = type;
		this.number = number;
		this.client = client;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Override
	public String toString() {
		return "ClientPhones [id=" + id + ", type=" + type + ", number=" + number + "]";
	}
}
