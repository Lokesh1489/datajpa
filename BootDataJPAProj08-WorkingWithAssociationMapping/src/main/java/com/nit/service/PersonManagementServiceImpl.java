package com.nit.service;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nit.Repository.IPersonRepository;
import com.nit.Repository.IPhoneNumberRepository;
import com.nit.entity.Person;
import com.nit.entity.PhoneNumber;

@Service
public class PersonManagementServiceImpl implements IPersonManagementService {

	@Autowired
	private IPersonRepository personRepo;

	@Autowired
	private IPhoneNumberRepository phonenoRepo;

	@Override
	public String saveDataUsingPerson(Person per) {
		return "Person and his PhoneNumbers are saved with " + personRepo.save(per) + "id.value";
	}

	@Override
	public String saveDataUsingPhoneNumber(Set<PhoneNumber> phoneSet) {
		int count = phonenoRepo.saveAll(phoneSet).size();
		return count + "no of phonenumber objects mapped with the person objects are saved";
	}

	@Override
	public Iterable<Person> loadDataUsingParent() {
		Iterable<Person> It = personRepo.findAll();
		return It;
	}

	@Override
	public Iterable<PhoneNumber> loadDataUsingChild() {
		Iterable<PhoneNumber> It1 = phonenoRepo.findAll();
		return It1;
	}

	@Override
	public String deleteAllPhoneNumbersOfaPerson(int pid) {
		Optional<Person> opt = personRepo.findById(pid);
		if (opt.isEmpty()) {
			return "person not found";
		} else {
			// get Parent Object          
			Person per = opt.get();
			// get all PhoneNumbers(child objs) of a person      
			Set<PhoneNumber> phones = per.getPhone();
			int count = phones.size();
			phonenoRepo.deleteAll(phones);
			// re-save the Parent object without linked with children
			per.setPhone(null);
			personRepo.save(per);
			return count + "no of PhoneNumbers are deleted for the Person" + pid;
		}
	}

}
