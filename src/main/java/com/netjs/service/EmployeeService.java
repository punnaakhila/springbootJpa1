package com.netjs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netjs.dao.EmployeeRepository;
import com.netjs.entities.Employee;

@Service
public class EmployeeService {
@Autowired
EmployeeRepository res;
public Employee getEmployeeById(int id) {
	return res.findById(id).get();
}
public Employee addEmployee(Employee emp)
{
	return res.save(emp);
}
public List<Employee> getAllEmployee(){
		return res.findAll();
}
public void deleteEmployeeById(int id) {
	res.deleteById(id);
}
public List<Employee> getEmployeeByDeptNo(int deptNo)
{
	return res.findAllByDeptNo(deptNo);
}
public Employee updateEmployee(Employee emp)
{
	Employee empUpdate = res.findById(emp.getEmpNo()).get();
	empUpdate.setJob(emp.getJob());
	return res.save(emp);
}
}
