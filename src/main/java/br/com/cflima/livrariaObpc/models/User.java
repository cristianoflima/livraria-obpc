package br.com.cflima.livrariaObpc.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;

@Entity(name="user")
public @Data class  User implements UserDetails  {

	private static final long serialVersionUID = 6820399347503874779L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	private String email;
	
	@Column
	private String password;
	
	@Column
	private Integer status;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="user_permission", 
		joinColumns= @JoinColumn(name="user_id"), 
		inverseJoinColumns = @JoinColumn(name="permission_id"))
	private List<Permission> permissoes = new ArrayList<>();
	

	@Override
	public Collection<GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> permissoesAdapt = new ArrayList<>();		
		if(permissoes != null)
			permissoes.forEach(p -> permissoesAdapt.add(new SimpleGrantedAuthority(p.getName())));		
		return permissoesAdapt;
	}

	@Override
	public String getUsername() {
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		if(status.equals(Integer.valueOf(1)))
			return true;
		else
			return false;
	}

}
