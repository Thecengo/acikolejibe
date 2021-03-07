package com.acikoleji.adminpanel.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.acikoleji.adminpanel.entity.Sinav;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class SinavRepositoryTest2 {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private SinavRepository sinavRepository;
	
	@Test
	void activeSinavOlmali() {
		
		List<Sinav> findActiveExamns = sinavRepository.findByStatusNot("P");
		findActiveExamns.stream().map(s -> s.getTipi()).forEach(System.out::println);
		
	}
	
	@Test
	void activeSinavUzerindeOgrenciOlmali() {
		Sinav sinav = sinavRepository.findByTipi("Burs");
		sinav.getStudents().stream().map(s -> s.getName()).forEach(System.out::println);
		
	}

}
