package entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Person {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	private String email;
	
	public Person() {
	}

	@OneToMany (mappedBy = "person")
	List<CreditCard> list;

	public int getId() {	
		return id;
	}

	public void setId(int id) {
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

	public List<CreditCard> getList() {
		return list;
	}

	public void setList(List<CreditCard> list) {
		this.list = list;
	}

	public Person( String name, String email) {
		this.name = name;
		this.email = email;
		this.list = new ArrayList<CreditCard>();
	}
	
	public Person(int id, String name, String email) {
		this.id = id;
		this.name = name;
		this.email = email;
		
	}

	public void addCreditCard(CreditCard card) {
		list.add(card);
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", email=" + email + "]";
	}
	
	
}
