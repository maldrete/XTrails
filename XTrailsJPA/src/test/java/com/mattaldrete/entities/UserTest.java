package com.mattaldrete.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.mattaldrete.entities.Comment;
import com.mattaldrete.entities.Location;
import com.mattaldrete.entities.Playlist;
import com.mattaldrete.entities.User;

class UserTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private User user;

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
		user = em.find(User.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();

	}

//	@Disabled
	@DisplayName("test entity fields owned by table")
	@Test
	void test() {
		assertEquals(1, user.getId());
		assertEquals("matt", user.getUserName());
		assertEquals(true, user.getActive());
		assertEquals("matt@matt.com", user.getEmail());
		assertEquals("cycling", user.getFavoriteActivities());
		assertEquals(null, user.getStats());
		assertEquals(true, user.getEnabled());
		assertEquals("123", user.getPassword());
		assertEquals(null, user.getRole());

	}

//	@Disabled
	@DisplayName("test playlist one to many relationship")
	@Test
	void test2() {
		Playlist playlist1 = user.getPlayist().get(0);

		assertEquals("5 milers", playlist1.getName());
		assertEquals("5 mile trails i enjoy", playlist1.getDescription());
		assertEquals(null, playlist1.getHashtags());
		assertEquals("matt", playlist1.getUser().getUserName());

	}

//	@Disabled
	@DisplayName("test comment one to many relationship")
	@Test
	void test3() {
		LocalDate ldDate = LocalDate.of(2020, 04, 27);

		Comment comment1 = user.getComment().get(0);
		assertEquals("this trail is awesome", comment1.getActualComment());
		assertEquals(ldDate, comment1.getDatePosted());
	}

	
	@DisplayName("test location one to one relationship")
	@Test
	void test4() {
		Location location = user.getLocation();
		assertEquals("Centennial", location.getCity());

	}

}
