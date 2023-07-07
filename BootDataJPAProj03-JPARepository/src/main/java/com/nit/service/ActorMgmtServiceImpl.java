package com.nit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nit.entity.Actor;
import com.nit.repository.IActorRepository;

@Service("actorService")
public class ActorMgmtServiceImpl implements IActorMgmtService {
	@Autowired
	private IActorRepository actroRepo;

	@Override
	public String removeActorByIdInBatch(List<Integer> ids) {
		List<Actor> list = actroRepo.findAllById(ids);
		int count = list.size();
		actroRepo.deleteAllByIdInBatch(ids);
		return count + "no of records deleted in batch";
	}

	@Override
	public Actor searchActorById(int aid) {
		return actroRepo.getReferenceById(aid);

	}

}
