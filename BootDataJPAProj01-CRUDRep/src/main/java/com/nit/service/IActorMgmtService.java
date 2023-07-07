package com.nit.service;

import java.util.List;
import java.util.Optional;

import com.nit.entity.Actor;

public interface IActorMgmtService {
	public String registerActor(Actor actorsList);

	public String registerActorGroup(List<Actor> list);

	public String registerActorGroup(Iterable<Actor> list);

	public long fetchRecordCount();

	public Iterable<Actor> fetechAllActors();

	public Iterable<Actor> fetechActorsByIds(Iterable<Integer> ids);

	public Optional<Actor> fetechActorById(int aid);

	public Actor showActorById(int aid);

	public String updateActor(Actor actor);

	public String deleteActor(Actor actor);

	public String deleteAllActors();

	public String deleteAllActorsGroup(List<Actor> actorList);

	public String deleteAllActorsByIds(Iterable<Integer> ids);

}
