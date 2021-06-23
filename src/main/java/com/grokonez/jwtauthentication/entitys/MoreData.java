package com.grokonez.jwtauthentication.entitys;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "moredata")
public class MoreData {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	private String trsPoste;
	private String trsInstantane;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTrsPoste() {
		return trsPoste;
	}
	public void setTrsPoste(String trsPoste) {
		this.trsPoste = trsPoste;
	}
	public String getTrsInstantane() {
		return trsInstantane;
	}
	public void setTrsInstantane(String trsInstantane) {
		this.trsInstantane = trsInstantane;
	}
	public MoreData(Long id, String trsPoste, String trsInstantane) {
		super();
		this.id = id;
		this.trsPoste = trsPoste;
		this.trsInstantane = trsInstantane;
	}
	public MoreData() {
		super();
	}
	
	

}
