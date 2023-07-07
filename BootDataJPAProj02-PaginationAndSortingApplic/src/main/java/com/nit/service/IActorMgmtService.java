package com.nit.service;

import org.springframework.data.domain.Page;

import com.nit.entity.Actor;

public interface IActorMgmtService {

	public Iterable<Actor> showActorByOrder(boolean asc, String... properties);

	public Page<Actor> showActorsByPage(int pageNo, int pagesize);

	public void ShowActorPageBypage(int PageSize);
}
