// An reference code for creating ManyToMany mapping between User and Roles (registration page) 
//Users and Roles are JPA Entity
package VDIBackend.example.VDI_Backend.model;

import java.util.Collection;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.persistence.JoinColumn;

@Entity
//If @Table is not specified by default if will be class name(User)
@Table(name = "user",uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "associate_ID")
//	String class include's alphabet,number and special characters
	private String associateID;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
//	If we don't specify the @Column name default it will be the field name(email)
	private String email;
	private String contactNumber;
	private String userName;
	private String password;
	private String confirmPassword;
	
//	ManyToMany mapping between Role and User
	@ManyToMany(fetch= FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(
			name="users_roles",
			joinColumns = @JoinColumn(
					name = "user_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(
					name = "role_id", referencedColumnName = "id"))
	
	private Collection<Role> roles;
//	CONSTRUCTOR for above fields[provides compile-time safety by ensuring that
//	we provide all the required dependencies when creating an instance of a class]
	public User(String associateID, String firstName, String lastName, String email, String contactNumber,
			String userName, String password, String confirmPassword, Collection<Role> roles) {
		super();
		this.associateID = associateID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.contactNumber = contactNumber;
		this.userName = userName;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.roles = roles;
	}
//	Getters and Setters
	/* A setter updates the value of a variable,  getter reads the value.
	 * Getter is called accessors and Setters is mutators.
	 */
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAssociateID() {
		return associateID;
	}
	public void setAssociateID(String associateID) {
		this.associateID = associateID;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public Collection<Role> getRoles() {
		return roles;
	}
	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}
	
	
}
