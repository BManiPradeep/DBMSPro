package com.example.demo.Student;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }


    public void addNewStudent(Student student) {
        Optional<Student> StudentOptional=studentRepository.findStudentByEmail(student.getEmail());
        if(StudentOptional.isPresent()){
            throw new IllegalStateException("Email Taken");
        }
        studentRepository.save(student);
    }

    public void DeleteStudent(Long id) {
        boolean exists=studentRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException("Student with Id "+id+" does not Exist");
        }
        studentRepository.deleteById(id);
    }


    @Transactional
    public void UpdateStudent(Long id, String name, String email) {
        Student student=studentRepository.findById(id).
                orElseThrow(()->new IllegalStateException("Student with Id "+id+" does not Exist"));
        if(name!=null&& !name.isEmpty() &&!Objects.equals(student.getName(),name)){
            student.setName(name);
        }
        if(email!=null&& !email.isEmpty() &&!Objects.equals(student.getEmail(),email)){
            Optional<Student> studentOptional=studentRepository.findStudentByEmail(email);
            if(studentOptional.isPresent()){
                throw new IllegalStateException("Email Taken..");
            }
            student.setEmail(email);
        }
    }
}
