package com.tww.service;

import com.tww.model.Student;

import java.util.List;

public interface StudentService {

	public void addStudent(Student p);
	public void updateStudent(Student p);
	public List<Student> listStudents();
	public Student getStudentById(int id);
	public void removeStudent(int id);
	
}
