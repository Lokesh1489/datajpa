package com.nit.runner;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nit.entity.Actor;
import com.nit.entity.ResultView;
import com.nit.repository.IActorRepository;

@Component
public class QueryMethodsTestRunner implements CommandLineRunner {

	@Autowired
	private IActorRepository actorRepo;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("lokesh name info ");
		Iterable<Actor> res = actorRepo.searchActorsByCategory("villan");
		System.out.println(res);

		System.out.println(" phone no");
		actorRepo.findActorByMoblieNumbers(1234567890l, 456789l, 9876887l).forEach(System.out::println);

		actorRepo.findActorsDateByCategories("hero", "villan", "comdian").forEach(row -> {
			for (Object val : row) {
				System.out.println(val + "");
				System.out.println();
			}
		});

		actorRepo.findActorsNameByStartLetters("l").forEach(System.out::println);

		System.out.println("------------------");
		Actor actor = actorRepo.getActorByMobileNo(987654L);
		if (actor != null) {
			System.out.println("Actor found:" + actor);
		} else {
			System.out.println("Actor not found");
		}

		Object data = actorRepo.getActorDataByMobileNo(1234567890L);
		Object result[] = (Object[]) data;
		for (Object val : result) {
			System.out.println(val + "");
		}
		String name = actorRepo.getActorNameByMobileNo(1234567890l);
		System.out.println("actor name" + name);

		Optional<Actor> name1 = actorRepo.findById(50);
		System.out.println(name1);

		Object result1[] = (Object[]) actorRepo.getActorsAggregetData();
		for (Object object : result1) {
			System.out.println(object);
		}
		System.out.println("count of records::" + result1[0]);
		System.out.println("max of aid::" + result1[1]);
		System.out.println("min of aid::" + result1[2]);
		System.out.println("sum of aid::" + result1[3]);
		System.out.println("sum of aid::" + result1[4]);

		Actor ress1 = actorRepo.getActorDataByMaxActorId();
		System.out.println(ress1);

		int c = actorRepo.updateActorMobileNoByAid(93439558l, 3);
		System.out.println("phoneno updated");

		int d = actorRepo.deleteActorsByCategory("villan");
		System.out.println("deleted sucessfully");

	}
}
