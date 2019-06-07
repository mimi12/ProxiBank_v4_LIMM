package org.project.proxibank.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

/**
 * Classe abstraite {@link Client} qui contient les attributs d'un objet Client, les getters,
 * setters et constructeurs. Elle peut être un {@link Company} ou un
 * {@link Customer}, de même elle peut avoir un compte {@link CurrentAccount},
 * un compte {@link SavingsAccount}, ou une liste de comptes.
 * 
 * @author LIMM
 *
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "TypeOfClient", discriminatorType = DiscriminatorType.STRING)
public abstract class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idClient;
	private String firstName;
	private String lastName;
	private String phone;
	private String email;
	private String addressClient;
	private String zipCodeClient;
	private String cityClient;

	@OneToMany(mappedBy = "client", cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
	private List<Account> accountList = new ArrayList<Account>();

	public Client() {
		super();
	}

	public Client(String firstName, String lastName, String phone, String email, String addressClient,
			String zipCodeClient, String cityClient) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.email = email;
		this.addressClient = addressClient;
		this.zipCodeClient = zipCodeClient;
		this.cityClient = cityClient;
	}

	public Client(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Long getIdClient() {
		return idClient;
	}

	public void setIdClient(Long idClient) {
		this.idClient = idClient;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddressClient() {
		return addressClient;
	}

	public void setAddressClient(String addressClient) {
		this.addressClient = addressClient;
	}

	public String getZipCodeClient() {
		return zipCodeClient;
	}

	public void setZipCodeClient(String zipCodeClient) {
		this.zipCodeClient = zipCodeClient;
	}

	public String getCityClient() {
		return cityClient;
	}

	public void setCityClient(String cityClient) {
		this.cityClient = cityClient;
	}

	public List<Account> getAccountList() {
		return accountList;
	}

	public void setAccountList(List<Account> accountList) {
		this.accountList = accountList;
	}

}
