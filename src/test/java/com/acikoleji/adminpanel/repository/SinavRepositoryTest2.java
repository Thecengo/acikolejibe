package com.acikoleji.adminpanel.repository;

import java.util.Date;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.acikoleji.adminpanel.entity.Sınav;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class SinavRepositoryTest2 {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private SinavRepository sinavRepository;
	
	//Yok ise dbde tarih alanini güncelle
	@Test
	void activeSinavOlmali() {
		
		List<Sınav> findActiveExamns = sinavRepository.findActiveExamns(new Date());
		findActiveExamns.stream().map(s -> s.getTipi()).forEach(System.out::println);
		
	}
	
	@Test
	void activeSinavUzerindeOgrenciOlmali() {
		
		Sınav sinav = sinavRepository.findByTipi("Burs");
		sinav.getStudents().stream().map(s -> s.getName()).forEach(System.out::println);
		
	}

}
