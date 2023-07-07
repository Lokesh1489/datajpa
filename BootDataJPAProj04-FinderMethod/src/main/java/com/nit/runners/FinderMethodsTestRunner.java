package com.nit.runners;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nit.entity.Actor;
import com.nit.entity.ResultView;
import com.nit.repository.IActorRepository;

@Component
public class FinderMethodsTestRunner implements CommandLineRunner {

	@Autowired
	private IActorRepository actorRepo;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("SALMAN name actors info::");
		actorRepo.findByAnameEquals("salman").forEach(System.out::println);

		System.out.println("------------------------");
		System.out.println("Rajini name actors info::");
		actorRepo.findByAnameIs("rajini").forEach(System.out::println);

		System.out.println("------------------------");
		System.out.println("lokesh name actors info::");
		actorRepo.findByAname("lokesh").forEach(System.out::println);

		System.out.println("------------------------");
		System.out.println("lokesh name actors info by Aid::");
		System.out.println(actorRepo.findByAidBetween(1, 4));

		System.out.println("------------------------");
		System.out.println("lokesh name actors info by like ::");
		System.out.println(actorRepo.findByAnameLike("l%"));

		System.out.println("------------------------");
		System.out.println("name actors info by AnameStartingWith ::");
		System.out.println(actorRepo.findByAnameStartingWith("A"));

		System.out.println("------------------------");
		System.out.println("name actors info by AnameContainingIgnoreCase ::");
		System.out.println(actorRepo.findByAnameContainingIgnoreCase("D"));

		System.out.println("-----------casee-------------");
		System.out.println("name actors info by AnameContainingIgnoreCase ::");
		System.out.println(actorRepo.findByCategoryInIgnoreCaseOrderByAnameAsc(List.of("hero")));

		System.out.println("------------------------");
		System.out.println("name actors info by GreaterThan ::");
		System.out.println(actorRepo.findByAidGreaterThan(2));

		System.out.println("------------------------");
		System.out.println("name actors info by AidGreaterThanEqualAndAidLessThanEqual ::");
		System.out.println(actorRepo.findByAidGreaterThanEqualAndAidLessThanEqual(1, 3));

		System.out.println("------------------------");
		System.out.println("lokesh name actors info by StatusTrueOrCategoryEquals ::");
		System.out.println(actorRepo.findByStatusTrueOrCategoryEquals("Hero"));

		System.out.println("__________________Aid between or Category________________________");
		actorRepo.findByAidGreaterThanAndAidLessThanOrCategoryNotInIgnoreCase(1, 152,
				List.of("hero", "villain", "comedian")).forEach(System.out::println);

		Iterable<ResultView> it = actorRepo.findByCategoryEqualsIgnoreCase("hero");
		it.forEach(view -> {
			System.out.println(view.getAid());
			System.out.println(view.getAname());
		});

		System.out.println("------------------------");
		ResultView view = actorRepo.findByMobileNo(34567890);
		System.out.println(view.getAid() + view.getAname());
		
		System.out.println("------------------------");
		Actor actor = actorRepo.findByMobileNoIs(34567890);
		System.out.println(actor);
		

	}
}
