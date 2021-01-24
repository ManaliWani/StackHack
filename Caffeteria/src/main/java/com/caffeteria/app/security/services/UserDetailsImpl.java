package com.caffeteria.app.security.services;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.caffeteria.app.models.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserDetailsImpl implements UserDetails{

	    private static final long serialVersionUID = 1L;
	   
	    //Characteristics
		private Long id;
		private String username;
		private String organization;
		private Long empid;
		private String mobileno;
		private String email;
		
		@JsonIgnore
		private String password;
		
		private Collection<? extends GrantedAuthority> authorities;

		//Constructor
		public UserDetailsImpl(Long id, String username, String org,Long empid,String mobno,String email, String password, Collection<? extends GrantedAuthority> authorities) {
			super();
			this.id = id;
			this.username = username;
			this.organization = org;
			this.empid = empid;
			this.mobileno = mobno;
			this.email = email;
			this.password = password;
			this.authorities = authorities;
		}
		
		public static UserDetailsImpl build(User user) {
			List<GrantedAuthority> authorities = user.getRoles().stream()
					.map(role -> new SimpleGrantedAuthority(role.getName().name()))
					.collect(Collectors.toList());

			return new UserDetailsImpl(
					user.getId(), 
					user.getUsername(), 
					user.getOrganization(),
					user.getEmpid(),
					user.getMobileno(),
					user.getEmail(),
					user.getPassword(), 
					authorities);
		}
		
		public String getOrganization() {
			return organization;
		}

		public void setOrganization(String organization) {
			this.organization = organization;
		}

		public Long getEmpid() {
			return empid;
		}

		public void setEmpid(Long empid) {
			this.empid = empid;
		}

		public String getMobileno() {
			return mobileno;
		}

		public void setMobileno(String mobileno) {
			this.mobileno = mobileno;
		}

		@Override
		public Collection<? extends GrantedAuthority> getAuthorities() {
			return authorities;
		}

		public Long getId() {
			return id;
		}

		public String getEmail() {
			return email;
		}

		@Override
		public String getPassword() {
			return password;
		}

		@Override
		public String getUsername() {
			return username;
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
			return true;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o)
				return true;
			if (o == null || getClass() != o.getClass())
				return false;
			UserDetailsImpl user = (UserDetailsImpl) o;
			return Objects.equals(id, user.id);
		}
}
