package com.tymm.samplerestapi.service;

import com.tymm.samplerestapi.entity.Student;
import com.tymm.samplerestapi.repository.StudentRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author cheong.tymm
 */
@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Transactional
    public Student create(Student student) throws IllegalArgumentException{
        Student existingStudent = getStudentByIc(student.getIc());
        if(existingStudent != null){
            throw new IllegalArgumentException("Student already exist");
        }
        // set enroll date time
        student.setEnrolldate(System.currentTimeMillis() / 1000);
        student.setLastupdateddate(student.getEnrolldate());
        return studentRepository.save(student);
    }

    @Transactional
    public Student update(String ic, Student student) throws IllegalArgumentException{        
        Student existingStudent = getStudentByIc(ic);
        if(existingStudent == null){
            throw new IllegalArgumentException("Student not found with IC " + ic);
        }

        // Update existing student properties
        existingStudent.setName(student.getName());
        existingStudent.setAddress(student.getAddress());
        
        existingStudent.setLastupdateddate(System.currentTimeMillis() / 1000);
        return studentRepository.save(existingStudent);
    }
    
    @Transactional(readOnly = true)
    public Student getStudentByIc(String ic){
        Student query = new Student();
        query.setIc(ic);
        
        return studentRepository.findOne(Example.of(query, ExampleMatcher.matching())).orElse(null);
    }
    
    @Transactional(readOnly = true)
    public List<Student> listAllStudents(int page, int size) {
        int offset = page * size;
        return studentRepository.findAllWithPagination(offset, size);
    }
}
