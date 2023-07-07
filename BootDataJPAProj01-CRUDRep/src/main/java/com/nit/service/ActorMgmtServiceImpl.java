package com.nit.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nit.entity.Actor;
import com.nit.repository.IActorRepository;

@Service("actorService")
public class ActorMgmtServiceImpl implements IActorMgmtService {

	@Autowired
	private IActorRepository actorRepo;

	@Override
	public String registerActor(Actor actor) {
		Actor sactor = actorRepo.save(actor);
		System.out.println("InMemory Proxy class name::" + actorRepo.getClass() + "----list of implemented interfaces"
				+ Arrays.toString(actorRepo.getClass().getInterfaces()));

		return "Actor is Registered with id value:" + sactor.getAid();

	}

	@Override
	public String registerActorGroup(List<Actor> list) {
		if (list != null) {
			Iterable<Actor> sEntities = actorRepo.saveAll(list);
			List<Integer> ids = new ArrayList<>();
			for (Actor actor : sEntities) {
				ids.add(actor.getAid());
			}
			return ids.size() + "object are saved in id values:" + ids;

		}
		return "problem in batch insertion";
	}

	@Override
	public String registerActorGroup(Iterable<Actor> list) {
		if (list != null) {
			List<Actor> sEntities = (List<Actor>) actorRepo.saveAll(list);
			List<Integer> ids = sEntities.stream().map(actor -> actor.getAid()).collect(Collectors.toList());
			return ids.size() + "object are saved in id values:" + ids;

		}
		return "problem in batch insertion";
	}

	@Override
	public long fetchRecordCount() {

		return actorRepo.count();
	}

	@Override
	public Iterable<Actor> fetechAllActors() {

		return actorRepo.findAll();
	}

	@Override
	public Iterable<Actor> fetechActorsByIds(Iterable<Integer> ids) {

		return actorRepo.findAllById(ids);
	}

	@Override
	public Optional<Actor> fetechActorById(int aid) {
		Optional<Actor> opt = actorRepo.findById(aid);
		return opt;
	}

	@Override
	public Actor showActorById(int aid) {

		return actorRepo.findById(aid).orElseThrow(() -> new IllegalArgumentException("Actor not found"));
	}

	@Override
	public String updateActor(Actor actor) {
		actorRepo.save(actor);
		return "Actor is updated with new values";
	}

	@Override
	public String deleteActor(Actor actor) {
		actorRepo.delete(actor);
		return "Actor" + actor.getAname() + "Deleted Successfully!";
	}

	@Override
	public String deleteAllActors() {
		actorRepo.deleteAll();
		return "All Actors Records Deleted";
	}

	@Override
	public String deleteAllActorsGroup(List<Actor> actorList) {
		if (actorList != null) {
			actorRepo.deleteAll(actorList);
			return actorList.size() + "Actor are deleted!!";
		} else {
			return "problem in batch delection!";
		}
	}

	@Override
	public String deleteAllActorsByIds(Iterable<Integer> ids) {
		actorRepo.deleteAllById(ids);
		return ((List<Integer>)ids).size()+"Actors are deleted!!";
	}
}
