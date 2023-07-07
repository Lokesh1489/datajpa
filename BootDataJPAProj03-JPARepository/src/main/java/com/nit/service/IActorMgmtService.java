package com.nit.service;

import java.util.List;

import com.nit.entity.Actor;

public interface IActorMgmtService {

	public String removeActorByIdInBatch(List<Integer> ids);

	public Actor searchActorById(int aid);

}
