package com.tymm.samplerestapi.apicontroller;

import com.tymm.samplerestapi.entity.Student;
import com.tymm.samplerestapi.service.StudentService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author cheong.tymm
 */
@RestController
@Slf4j
@RequestMapping("/student")
public class StudentController {
    
    private final StudentService studentService;
    
    @Autowired
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }
    
    @PostMapping("/enroll")
    public ResponseEntity enroll(@RequestBody Student param) throws Exception {
        // perform necessary sanitization and checking
        // ...
        
        try{
            Student createdStudent = studentService.create(param);
            return ResponseEntity.ok(createdStudent);
        }
        catch(IllegalArgumentException iae){
            return ResponseEntity.badRequest().body(iae.getMessage());
        }
    }
    
    @PostMapping("/update")
    public ResponseEntity update(@RequestBody Student param) throws Exception {
        // perform necessary sanitization and checking
        // ...
        
        try{
            Student updatedStudent = studentService.update(param.getIc(), param);
            return ResponseEntity.ok(updatedStudent);
        }
        catch(IllegalArgumentException iae){
            return ResponseEntity.badRequest().body(iae.getMessage());
        }
    }
    
    @GetMapping("/list")
    public ResponseEntity list(@RequestParam("page") int page, @RequestParam("size") int size) throws Exception {
        List<Student> students = studentService.listAllStudents(page, size);
        return ResponseEntity.ok(students);
    }
}
