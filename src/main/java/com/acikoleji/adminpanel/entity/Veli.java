package com.acikoleji.adminpanel.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "veli")
public class Veli extends BaseEntity{
	
	private static final long serialVersionUID = -9063473838494363807L;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "veli")
	private List<Student> students;

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
	
	
	
}
