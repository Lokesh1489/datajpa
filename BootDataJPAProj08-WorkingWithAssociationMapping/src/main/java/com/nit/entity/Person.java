package com.nit.entity;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "PERSON_OTM")
@Setter
@Getter
public class Person {
	@Id
	@GeneratedValue
	private Integer pid;

	@Column(length = 20)
	private String pname;

	@Column(length = 20)
	private String pAddrs;

	//@OneToMany(targetEntity = PhoneNumber.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "person")
	 @JoinColumn(name="PERSON_ID",referencedColumnName = "PID")
	private Set<PhoneNumber> phone;

	@Override
	public String toString() {
		return "Person [pid=" + pid + ", pname=" + pname + ", pAddrs=" + pAddrs + "]";
	}

	public Person() {
		System.out.println("person 0-parameter const"+this.getClass());

	}

}
