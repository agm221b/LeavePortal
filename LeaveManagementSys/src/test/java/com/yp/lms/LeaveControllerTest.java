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
import com.yp.lms.model.Leave;

@SpringBootApplication
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationArguments.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class LeaveControllerTest {

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
	@Test
	public void testGetLeaveByempId() {
		Leave leaves = restTemplate.getForObject(getRootUrl() + "/leaveEmpid", Leave.class);
		System.out.println(leaves.getEmployee());
		assertNotNull(leaves);
	}
	@Test
	public void testGetLeaveByManagerId() {
		Leave Leaves = restTemplate.getForObject(getRootUrl() + "/leaveManager", Leave.class);
		System.out.println(Leaves.getManagerId());
		assertNotNull(Leaves);
	}
	
}
