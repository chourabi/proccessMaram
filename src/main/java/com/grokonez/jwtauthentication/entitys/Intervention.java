package com.grokonez.jwtauthentication.entitys;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.grokonez.jwtauthentication.model.User;

@Entity
@Table(name = "interventions")
public class Intervention {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@NotBlank
    @Size(min=3, max = 50)
    private String description;
    

	@Basic
	@Temporal(TemporalType.TIMESTAMP)
    private Date utilTimestamp ;
	

	
	
	@ManyToOne
	@JoinColumn(nullable = true,name="machines_id")
	private Machine machine;
	
	
	@ManyToOne
	@JoinColumn(nullable = true,name="users_id")
	private User user;
	
	
    
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@NotBlank
    @Size(min=0, max = 3000)
    private String parametersString;
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}



	public Machine getMachine() {
		return machine;
	}

	public void setMachine(Machine machine) {
		this.machine = machine;
	}

	public String getParametersString() {
		return parametersString;
	}

	public void setParametersString(String parametersString) {
		this.parametersString = parametersString;
	}

	public Date getUtilTimestamp() {
		return utilTimestamp;
	}

	public void setUtilTimestamp(Date utilTimestamp) {
		this.utilTimestamp = utilTimestamp;
	}

	public Intervention(Long id, @NotBlank @Size(min = 3, max = 50) String description,
			@NotBlank @Size(min = 3, max = 50) Date utilTimestamp, Machine machine,
			@NotBlank @Size(min = 0, max = 3000) String parametersString) {
		super();
		this.id = id;
		this.description = description;
		this.utilTimestamp = utilTimestamp;
		this.machine = machine;
		this.parametersString = parametersString;
	}

	public Intervention() {
		super();
	}
	
	
	

	
	
	

}
