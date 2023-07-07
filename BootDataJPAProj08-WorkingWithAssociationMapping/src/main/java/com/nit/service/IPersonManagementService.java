package com.nit.service;

import java.util.Set;

import com.nit.entity.Person;
import com.nit.entity.PhoneNumber;

public interface IPersonManagementService {

	public String saveDataUsingPerson(Person per);

	public String saveDataUsingPhoneNumber(Set<PhoneNumber> phoneSet);

	public Iterable<Person> loadDataUsingParent();

	public Iterable<PhoneNumber> loadDataUsingChild();
	
	public String deleteAllPhoneNumbersOfaPerson(int pid);

}
