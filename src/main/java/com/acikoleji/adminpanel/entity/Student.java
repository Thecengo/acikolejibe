package com.acikoleji.adminpanel.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "student")
public class Student extends BaseEntity{
	
	private static final long serialVersionUID = -5532281334978887800L;

	@Column(name= "school_name", nullable = false)
	private String schoolName;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date birthDate;
	
	@Column(name = "tc_no", nullable = false, length = 11)
	private String tcNo;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Veli veli;
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "students")
	private List<Sınav> sinavs;

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
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

	public List<Sınav> getSinavs() {
		return sinavs;
	}

	public void setSinavs(List<Sınav> sinavs) {
		this.sinavs = sinavs;
	}
	
}
