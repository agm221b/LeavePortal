package com.yp.lms;

/**
*
@author Pooja Tiwari
*
*
**/
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import com.yp.lms.model.Employee;

@SpringBootApplication
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationArguments.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class EmpControllerTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	@Autowired
	private TestRestTemplate restTemplate;

	@LocalServerPort
	private int port;
	
	private String getRootUrl() {
		return "http://localhost:" + port;
	}
	@Test
	public void contextLoads() {

	}
	/*@Test
	public void testRegisterEmployee() {
		Employee employee = new Employee(port, null, null, null, null, port, port, port, false, null);
		employee.setEmpId(12344);
		employee.setCurrentLeaves(10);
		employee.setAddress("kjsdihe");
		employee.setEmail("pooja.tiwari@ca.com");
		employee.setManager(true);
		employee.setManagerId(23455);
		employee.setName("pooja Tiwari");
		employee.setPassword("tejsjn");
		employee.setPhoneNo(985737552);

		ResponseEntity<Employee> postResponse = restTemplate.postForEntity(getRootUrl() + "/register", employee, Employee.class);
		assertNotNull(postResponse);
		assertNotNull(postResponse.getBody());
	}*/
	@Test
	public void testGetEmployeeById() {
		Employee employee = restTemplate.getForObject(getRootUrl() + "/profile", Employee.class);
		System.out.println(employee.getName());
		assertNotNull(employee);
	}
	
	@Test
	public void testEditEmployee() {
		int id = 1;
		Employee employee = restTemplate.getForObject(getRootUrl() + "/editProfile/" + id, Employee.class);
		employee.setName("admin1");

		restTemplate.put(getRootUrl() + "/editProfile/" + id, employee);

		Employee updatedEmployee = restTemplate.getForObject(getRootUrl() + "/editProfile/" + id, Employee.class);
		assertNotNull(updatedEmployee);
	}

	

}
