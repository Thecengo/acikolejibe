package com.acikoleji.adminpanel.repository;

import java.time.LocalTime;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.acikoleji.adminpanel.entity.Session;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class SessionRepositoryTest {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private SessionRepository sessionRepository;
	
	@Test
	void test() {
		List<Session> sessions = sessionRepository.findBySinavTipi("burs");
		sessions.forEach(System.out::println);
		
	}
	
	@Test
	void sessionZamaniVerinceBirTaneSessionBulabilmeli() {
		Session session = sessionRepository.findByStartTime(LocalTime.of(12, 00));
		System.out.println(session.getStartTime());
		
	}

}
