package com.netjs.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.netjs.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer>{

	List<Employee> findAllByDeptNo(int deptNo);

}
