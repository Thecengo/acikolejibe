package com.acikoleji.adminpanel.model;

import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public class SessionDTO {

	private Long id;
	@JsonFormat(pattern = "HH:mm")
	private LocalTime startTime;
	private SınavDTO sinav;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}

	public SınavDTO getSinav() {
		return sinav;
	}

	public void setSinav(SınavDTO sinav) {
		this.sinav = sinav;
	}
	
	
	
}
