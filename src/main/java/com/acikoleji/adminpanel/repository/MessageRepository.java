package com.acikoleji.adminpanel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.acikoleji.adminpanel.entity.Message;

public interface MessageRepository extends JpaRepository<Message, Long>{

}
