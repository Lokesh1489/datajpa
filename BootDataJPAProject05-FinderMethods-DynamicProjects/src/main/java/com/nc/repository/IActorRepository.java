package com.nc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nc.entity.Actor;
import com.nc.view.View;

public interface IActorRepository extends JpaRepository<Actor, Integer> {
	public <T extends View> Iterable<T> findByCategoryContainingIgnoreCase(String letters, Class<T> cla);
}