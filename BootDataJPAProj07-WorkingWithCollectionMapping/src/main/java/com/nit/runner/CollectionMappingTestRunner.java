package com.nit.runner;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nit.entity.EmployeeInfo;
import com.nit.repository.EmployeeInfoRepository;

@Component
public class CollectionMappingTestRunner implements CommandLineRunner {

	@Autowired
	private EmployeeInfoRepository EmployeeRepo;

	@Override
	public void run(String... args) throws Exception {
		EmployeeInfo Info = new EmployeeInfo();
		Info.setEname("lokesh");
		Info.setFriends(List.of("sanjay", "Ashik", "Nandish"));
		Info.setPhone(Set.of(1234567890l, 12345l, 67890l));
		Info.setIdDetails(Map.of("aadhar", 1234567890l, "panNo", 1234567l));

		// Save the Object
		System.out.println("Employee is saved with::" + EmployeeRepo.save(Info).getEno() + "id value");

		EmployeeRepo.findAll().forEach(System.out::println);

	}
}
