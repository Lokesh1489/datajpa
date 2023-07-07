package com.nit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.nit.entity.Actor;
import com.nit.repository.IActorRepository;

@Service("actorService")
public class ActorMgmtServiceImpl implements IActorMgmtService {
	@Autowired
	private IActorRepository actroRepo;

	@Override
	public Iterable<Actor> showActorByOrder(boolean asc, String... properties) {
		// prepare sort object
		Sort sort = Sort.by(asc ? Direction.ASC : Direction.DESC, properties);
		// get the records by applying sorting
		Iterable<Actor> It = actroRepo.findAll(sort);
		return It;
	}

	@Override
	public Page<Actor> showActorsByPage(int pageNo, int pagesize) {
		Pageable pageable = PageRequest.of(0, pagesize);
		Page<Actor> page = actroRepo.findAll(pageable);
		return page;
	}

	@Override
	public void ShowActorPageBypage(int PageSize) {
		long recordcount = actroRepo.count();
		long pagescount = recordcount / PageSize;
		pagescount = (recordcount % PageSize == 0) ? pagescount : ++pagescount;
		for (int i = 0; i < pagescount; i++) {
			Pageable pageable = PageRequest.of(i, PageSize);
			Page<Actor> page = actroRepo.findAll(pageable);
			System.out.println(i + 1 + "page records");
			page.getContent().forEach(System.out::println);
		}
	}
}
