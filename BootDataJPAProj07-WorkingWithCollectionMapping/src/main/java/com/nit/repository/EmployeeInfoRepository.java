package com.nit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nit.entity.EmployeeInfo;


public interface EmployeeInfoRepository extends JpaRepository<EmployeeInfo, Integer> {

}
