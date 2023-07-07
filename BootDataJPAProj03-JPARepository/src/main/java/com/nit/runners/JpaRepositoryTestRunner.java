package com.nit.runners;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.nit.entity.Actor;
import com.nit.service.IActorMgmtService;

@Component
public class JpaRepositoryTestRunner implements CommandLineRunner {

	@Autowired
	private IActorMgmtService service;

	@Override
	public void run(String... args) throws Exception {
		try {
			System.out.println(service.removeActorByIdInBatch(List.of(6, 7)));
			
			Actor actor=service.searchActorById(3);
			System.out.println(actor);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
