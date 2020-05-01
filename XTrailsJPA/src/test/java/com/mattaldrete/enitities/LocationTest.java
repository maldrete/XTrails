package com.mattaldrete.enitities;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LocationTest {
	
	private static EntityManagerFactory emf;
	private static EntityManager em;
	private Location location;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("XTrailsPU");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
		location = em.find(Location.class, 3);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
	}

	@DisplayName("test entity fields owned by table")
	@Test
	void test() {
		assertEquals("Lakewood", location.getCity());
		assertEquals(-105.052580, location.getLongitude());
		assertEquals(39.664210, location.getLatitude());
	}

}
