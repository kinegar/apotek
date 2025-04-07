package com.egar.apotek.repository;

import com.egar.apotek.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, BigInteger> {

}
