package br.com.cflima.livrariaObpc.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity(name="person")
public @Data class Person implements Serializable{

	
	private static final long serialVersionUID = -7039285260247783336L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	
	private String phone;
	
	private String street;
	
	private String neighborhood;
	
	private Integer number;
	
	private String complement;
	
	private String city;
	
	private String uf;
	
	private Integer cep;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="user_id")
	private User user;

}
