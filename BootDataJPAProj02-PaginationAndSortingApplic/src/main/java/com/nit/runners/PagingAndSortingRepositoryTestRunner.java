package com.nit.runners;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.nit.entity.Actor;
import com.nit.service.IActorMgmtService;

@Component
public class PagingAndSortingRepositoryTestRunner implements CommandLineRunner {

	@Autowired
	private IActorMgmtService service;

	@Override
	public void run(String... args) throws Exception {
		try {
			System.out.println("----------findall(sort sort)-call-------");
			service.showActorByOrder(false, "aname").forEach(System.out::println);
			System.out.println("-------Pagination--------");
			Page<Actor> page = service.showActorsByPage(0, 3);
			List<Actor> list = page.getContent();
			System.out.println("Record are:");
			list.forEach(System.out::println);
			System.out.println("other info about page");
			System.out.println("current page no::" + page.getNumber());
			System.out.println("total pages::" + page.getTotalPages());
			System.out.println("total records::" + page.getTotalElements());
			System.out.println("Is it first page" + page.isFirst());
			System.out.println("Is it last page" + page.isLast());
			System.out.println("---------");
			service.ShowActorPageBypage(5);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
