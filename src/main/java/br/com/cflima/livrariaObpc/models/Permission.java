package br.com.cflima.livrariaObpc.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;

@Entity(name="permission")
public @Data class Permission implements Serializable{

	private static final long serialVersionUID = 6561135990276531390L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String name;
	
	@ManyToMany(mappedBy="permissoes")
	private List<User> users;

}
