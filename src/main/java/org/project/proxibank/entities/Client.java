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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * Classe abstraite {@link Client} qui contient les attributs d'un objet Client,
 * les getters, setters et constructeurs. Elle peut être un {@link Company} ou
 * un {@link Customer}, de même elle peut avoir un compte
 * {@link CurrentAccount}, un compte {@link SavingsAccount}, ou une liste de
 * comptes.
 * 
 * @author LIMM
 *
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TypeOfClient", discriminatorType = DiscriminatorType.STRING)
public abstract class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String phone;
	private String email;
	private String addressClient;
	private String zipCodeClient;
	private String cityClient;

	@XmlTransient
	@JsonManagedReference
	@OneToMany(mappedBy = "client", cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
	private List<Account> accountList = new ArrayList<Account>();

	@JsonBackReference
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
	@JoinColumn(name = "id_Advisor")

	private Advisor advisor;

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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Advisor getAdvisor() {
		return advisor;
	}

	public void setAdvisor(Advisor advisor) {
		this.advisor = advisor;
	}

}
