package com.nc.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nc.repository.IActorRepository;
import com.nc.view.ResultView1;
import com.nc.view.ResultView2;
import com.nc.view.ResultView3;

@Component
public class FinderMethodsTestRunner implements CommandLineRunner {

	@Autowired
	private IActorRepository actorRepo;

	@Override
	public void run(String... args) throws Exception {

		// using ResultView1 as type interface
		Iterable<ResultView1> it1 = actorRepo.findByCategoryContainingIgnoreCase("h", ResultView1.class);
		it1.forEach(view1 -> {
			System.out.println(view1.getAid() + " " + view1.getAname());
		});
		System.out.println("---------------------------------");

		// using ResultView2 as type interface
		Iterable<ResultView2> it2 = actorRepo.findByCategoryContainingIgnoreCase("h", ResultView2.class);
		it2.forEach(view2 -> {
			System.out.println(view2.getCategory() + " " + view2.getMobileNo());
		});
		System.out.println("---------------------------------");

		// using ResultView3 as type interface
		Iterable<ResultView3> it3 = actorRepo.findByCategoryContainingIgnoreCase("h", ResultView3.class);
		it3.forEach(view3 -> {
			System.out.println(view3.getCategory() + " " + view3.getAid() + " " + view3.getAname());
		});
		System.out.println("---------------------------------");

	}

}
