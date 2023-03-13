package com.exam.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="users")
public class User {
   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)

	private long id;
	@NotBlank(message = "Username is required")
	@Size(min = 4,max = 12, message = "Username must be between at 4-12 characters")
	private String username;
	@NotBlank(message = "Password is required")
	@Size(min = 8,max = 12, message = "Password must be between 8-12 characters")
	private String password;
	 @NotBlank(message = "Email address is required")
	    @Email(message = "Invalid email address")
	private String email;
	 @NotBlank(message = "Profile is required")
	private String profile;
	
	//user have many userroles so we have to put many userrole by creating list.
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER, mappedBy="user")
	@JsonIgnore //to not craete circulate dependencie
	private Set<UserRole>  userRole=new  HashSet<>();//one to many raelation
	
	public User() {
		
	}	

	public Set<UserRole> getUserRole() {
		return userRole;
	}


	public void setUserRole(Set<UserRole> userRole) {
		this.userRole = userRole;
	}


	public User(long id, String username, String password, String firstName, String lastName, String email,
			String phone, boolean enabled, String profile) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.profile = profile;
	}

	public String getProfile() {
		return profile;
	}


	public void setProfile(String profile) {
		this.profile = profile;
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", profile=" + profile + ", userRole=" + userRole + "]";
	}
}