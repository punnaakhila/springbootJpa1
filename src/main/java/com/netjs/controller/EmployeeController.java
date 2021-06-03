package com.netjs.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.netjs.entities.Employee;
import com.netjs.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
@Autowired
EmployeeService es;
@GetMapping("/{id}")
public Employee getEmployeeById(@PathVariable("id") int id)
{
	return es.getEmployeeById(id);
}
@GetMapping("/all")
public List<Employee> getAllEmployee(){
	return es.getAllEmployee();
	
}
@GetMapping("/dep/{deptNo}")
public List<Employee> getEmployeeByDeptNo(@PathVariable int deptNo)
{
	return es.getEmployeeByDeptNo(deptNo);
}
@DeleteMapping("/{id}")
//@ResponseStatus(HttpStatus.OK)
public void deleteEmployeeByID(@PathVariable int id) {
	es.deleteEmployeeById(id);
}
@PostMapping
public ResponseEntity<Object> addEmployee(@RequestBody Employee emp){
	Employee e=es.addEmployee(emp);
	System.out.println(e.getEmpNo());
	URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(e.getEmpNo()).toUri();
	return ResponseEntity.created(location).build();
}

@PutMapping("/updateEmp")
public ResponseEntity<String> updateEmployee(@RequestBody Employee emp) {  
       Employee e = es.updateEmployee(emp);
       URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(e.getEmpNo()).toUri();
       return ResponseEntity.created(location).build();
}
}
