package com.cafe.pojo;

import java.io.Serializable;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.core.sym.Name;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import lombok.Data;

//@NamedQueries({@NamedQuery(name="User.findByEmailId" ,query = "select u from User u where u.email=:email"
@NamedQueries({
    @NamedQuery(name = "User.findByEmailId", 
    query = "select u from User u where u.email=:email") })
@Data
@Entity
@DynamicUpdate
@DynamicInsert
@Table(name="user")
public class User implements Serializable {
	private static long serialVersionUID= 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private Integer id;
	@Column(name="name")
	private String name;
	@Column(name="contact")
	private String ContactNumber;
	@Column(name="email")
	private String email;
	@Column(name="password")
	private String password;
	@Column(name="status")
	private String status;
	@Column(name="role")
	private String role;
	

}
