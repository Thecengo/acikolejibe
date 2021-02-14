package com.acikoleji.adminpanel.request;

import java.time.LocalTime;

import com.acikoleji.adminpanel.model.VeliDTO;
import com.fasterxml.jackson.annotation.JsonFormat;

public class RequstStudentApplication {
		
		private Long id;
		private String name;
		private String telNo;
		private String schoolName;
		private String sinif;
		private String tcNo;
		private String sinavType;
		@JsonFormat(pattern = "HH:mm")
		private LocalTime sessionTime;
		private VeliDTO veli;
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getTelNo() {
			return telNo;
		}
		public void setTelNo(String telNo) {
			this.telNo = telNo;
		}
		public String getSchoolName() {
			return schoolName;
		}
		public void setSchoolName(String schoolName) {
			this.schoolName = schoolName;
		}
		public String getSinif() {
			return sinif;
		}
		public void setSinif(String sinif) {
			this.sinif = sinif;
		}
		public String getTcNo() {
			return tcNo;
		}
		public void setTcNo(String tcNo) {
			this.tcNo = tcNo;
		}
		public String getSinavType() {
			return sinavType;
		}
		public void setSinavType(String sinavType) {
			this.sinavType = sinavType;
		}
		public LocalTime getSessionTime() {
			return sessionTime;
		}
		public void setSessionTime(LocalTime sessionTime) {
			this.sessionTime = sessionTime;
		}
		public VeliDTO getVeli() {
			return veli;
		}
		public void setVeli(VeliDTO veli) {
			this.veli = veli;
		}
		

}
