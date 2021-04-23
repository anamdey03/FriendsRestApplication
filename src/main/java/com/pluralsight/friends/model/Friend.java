package com.pluralsight.friends.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Friend {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotBlank(message = "First Name should not be blank")
	@JsonProperty("first-name")
	private String firstName;

	@NotBlank(message = "Last Name should not be blank")
	@JsonProperty("last-name")
	private String lastName;

	@JsonIgnore
	private boolean married;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "friend", cascade = CascadeType.ALL)
	List<Address> addresses;

	public Friend() {
	}

	public Friend(int id, @NotBlank(message = "First Name should not be blank") String firstName,
			@NotBlank(message = "Last Name should not be blank") String lastName, boolean married,
			List<Address> addresses) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.married = married;
		this.addresses = addresses;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public boolean isMarried() {
		return married;
	}

	public void setMarried(boolean married) {
		this.married = married;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}
}
