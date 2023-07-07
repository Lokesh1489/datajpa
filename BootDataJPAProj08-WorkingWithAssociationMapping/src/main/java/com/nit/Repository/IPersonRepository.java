package com.nit.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nit.entity.Person;

public interface IPersonRepository extends JpaRepository<Person, Integer> {

}
