package com.tww.service;

import com.tww.dao.StudentDAO;
import com.tww.model.Student;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
	private StudentDAO studentDAO;

    public StudentDAO getStudentDAO() {
        return studentDAO;
    }

    public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}

	@Override
	@Transactional
	public void addStudent(Student p) {
		this.studentDAO.addStudent(p);
	}

	@Override
	@Transactional
	public void updateStudent(Student p) {
		this.studentDAO.updateStudent(p);
	}

	@Override
	@Transactional
	public List<Student> listStudents() {
		return this.studentDAO.listStudents();
	}

	@Override
	@Transactional
	public Student getStudentById(int id) {
		return this.studentDAO.getStudentById(id);
	}

	@Override
	@Transactional
	public void removeStudent(int id) {
		this.studentDAO.removeStudent(id);
	}
}
