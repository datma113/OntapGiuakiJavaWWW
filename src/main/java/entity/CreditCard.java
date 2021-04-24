package entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class CreditCard {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	private String type;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "personID")
	private Person person;

	
	public CreditCard() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public CreditCard(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "CreditCard [id=" + id + ", type=" + type + "]";
	}
	
	
}
