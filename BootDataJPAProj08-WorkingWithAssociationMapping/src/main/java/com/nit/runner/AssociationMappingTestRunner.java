package com.nit.runner;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nit.entity.Person;
import com.nit.entity.PhoneNumber;
import com.nit.service.IPersonManagementService;

@Component
public class AssociationMappingTestRunner implements CommandLineRunner {

	@Autowired
	private IPersonManagementService service;

	@Override
	public void run(String... args) throws Exception {
//		// Save Object opertion(parent to child)
//		Person per = new Person();
//		per.setPname("lokesh");
//		per.setPAddrs("Bangalore");
//		
//		PhoneNumber ph1 = new PhoneNumber();
//		ph1.setNumber_type("office");
//		ph1.setProvider("Airtel");
//		ph1.setPhoneNumber(1234567890l);
//		
//		PhoneNumber ph2 = new PhoneNumber();
//		ph2.setNumber_type("home");
//		ph2.setProvider("jio");
//		ph2.setPhoneNumber(156789l);
//		ph2.setPerson(per);
//		
//		Set<PhoneNumber> phoneSet =Set.of(ph1,ph2);
//		per.setPhone(phoneSet);
//		
//		try {
//			System.out.println(service.saveDataUsingPerson(per));
//		} catch (Exception e) {
//			// TODO: handle exception
//		}

//		// Save object operation (child to parent)
//		Person per = new Person();
//		per.setPname("Ashik");
//		per.setPAddrs("Mysore");
//
//		PhoneNumber ph1 = new PhoneNumber();
//		ph1.setNumber_type("office");
//		ph1.setProvider("Airtel");
//		ph1.setPhoneNumber(987654323l);
//
//		PhoneNumber ph2 = new PhoneNumber();
//		ph2.setNumber_type("home");
//		ph2.setProvider("jio");
//		ph2.setPhoneNumber(9234567l);
//
//		ph1.setPerson(per);
//		ph2.setPerson(per);
//
//		Set<PhoneNumber> phoneSet = new HashSet<PhoneNumber>();
//		phoneSet.add(ph1);
//		phoneSet.add(ph2);
//
//		per.setPhone(phoneSet);
//
//		try {
//			service.saveDataUsingPhoneNumber(phoneSet);
//		} catch (Exception e) {
//			// TODO: handle exception
//		}

//		service.loadDataUsingParent().forEach(person -> {
//			System.out.println("parent::" + person);
//			Set<PhoneNumber> childs = person.getPhone();
//			childs.forEach(ph -> {
//				System.out.println("child::" + ph);
//			});
//		});

		service.loadDataUsingChild().forEach(ph -> {
			System.out.println("child::" + ph);
			// get Associated parent
			Person person = ph.getPerson();
		//	System.out.println("person::"+person);
		});

	}

}
