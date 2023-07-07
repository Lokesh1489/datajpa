package com.nit.runners;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nit.entity.Actor;
import com.nit.service.IActorMgmtService;

@Component
public class CrudReposityTestRunner implements CommandLineRunner {

	@Autowired
	private IActorMgmtService service;

	@Override
	public void run(String... args) throws Exception {
		try {
			System.out.println("Records count is:" + service.fetchRecordCount());
			Iterable<Actor> it = service.fetechAllActors();
			it.forEach(actor -> System.out.println(actor));
			System.out.println("-----------------------");
			it.forEach(System.out::println);//
			System.out.println("--------------------");
			for (Actor actor : it) {
				System.out.println(actor);
			}
			System.out.println("------------------");
			it.forEach(actor -> System.out.println(actor));
			System.out.println("------------------");
			List<Actor> list = (List<Actor>) it;
			list.stream().forEach(System.out::println);
			System.out.println("------------------");
			System.out.println("count of records::" + list.stream().count());
			System.out.println("------------------");
			System.out.println("Sorted Records");
			list.stream().sorted(Comparator.comparing(actor -> actor.getAid())).forEach(System.out::println);
			System.out.println("------------------");
			List<String> namelist = list.stream().map(actor -> actor.getAname()).collect(Collectors.toList());
			namelist.forEach(System.out::println);
			System.out.println("--------------findById()----------");
			service.fetechActorsByIds(List.of(1, 2, 3)).forEach(System.out::println);
			service.fetechActorsByIds(Arrays.asList(1, 2, 3)).forEach(actor -> System.out.println(actor));
			System.out.println("---------------findById()-------------");
			Optional<Actor> opt = service.fetechActorById(1);
			if (opt.isPresent()) {
				System.out.println("Actor info::" + opt.get());
			} else
				System.out.println("Actor not found");
			System.out.println("------------------");
			Optional<Actor> opt1 = service.fetechActorById(1);
			Actor actor = opt1.orElseThrow(() -> new IllegalArgumentException("Actor not found"));
			System.out.println("Actor info::" + actor);
			System.out.println("------------------");
			Optional<Actor> opt2 = service.fetechActorById(1);
			Actor actor1 = opt2.orElse(new Actor());
			System.out.println("Actor info::" + actor1);
			System.out.println("------------------------------------");
			Optional<Actor> opt3 = service.fetechActorById(1);
			if (opt3.isEmpty())
				System.out.println("Actor not found");
			else
				System.out.println("Actor info::" + opt3.get());
			System.out.println("------------------");
			System.out.println("Actor info::" + service.showActorById(1));

			System.out.println("------------Update---------------");
			Actor updateactor = service.showActorById(1);
			updateactor.setAname("lokesh");
			updateactor.setCategory("villan");
			updateactor.setMobileNo(1234567890l);
			System.out.println(service.updateActor(updateactor));

			System.out.println("------------Delete---------------");
			Actor deleteactor = service.showActorById(102);
			System.out.println(service.deleteActor(deleteactor));

			System.out.println("------------DeleteAllActorsGroup---------------");
			List<Actor> actorList1 = (List<Actor>) service.fetechActorsByIds(Arrays.asList(2, 3));
			System.out.println(service.deleteAllActorsGroup(actorList1));

			System.out.println("------------DeleteAllActorsByIds---------------");
			service.deleteAllActorsByIds(List.of(5));
			System.out.println("---------------------------");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
