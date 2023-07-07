package com.nit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nit.entity.Actor;

public interface IActorRepository extends JpaRepository<Actor, Integer> {

}
