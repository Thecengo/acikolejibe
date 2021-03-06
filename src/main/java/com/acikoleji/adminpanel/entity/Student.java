package com.acikoleji.adminpanel.entity;

import java.time.LocalTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student extends BaseEntity{
	
	private static final long serialVersionUID = -5532281334978887800L;

	@Column(name= "school_name", nullable = false)
	private String schoolName;
	
	@Column(name= "sinif", nullable = false)
	private String sinif;
	
	@Column(name = "tc_no", nullable = false, length = 20)
	private String tcNo;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Veli veli;
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "students")
	private List<Sinav> sinavs;
	
	@Column(name = "exam_time", columnDefinition = "TIME")
	private LocalTime examTime;
	
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

	public Veli getVeli() {
		return veli;
	}

	public void setVeli(Veli veli) {
		this.veli = veli;
	}

	public List<Sinav> getSinavs() {
		return sinavs;
	}

	public void setSinavs(List<Sinav> sinavs) {
		this.sinavs = sinavs;
	}

	public LocalTime getExamTime() {
		return examTime;
	}

	public void setExamTime(LocalTime examTime) {
		this.examTime = examTime;
	}
	
	
	
}
