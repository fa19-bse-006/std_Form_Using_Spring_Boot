package com.form.std_form;

import com.form.std_form.Student_Entity.Student;
import com.form.std_form.Student_Entity.StudentRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class StudentRepositoryTest {
    @Autowired private StudentRepository studentRepository;
    @Test
    public void testAddNew(){
        Student student1=new Student();
        student1.setAge(26);
        student1.setF_name("khan");
        student1.setGender("female");
        student1.setName("sara");
        Student savedStudent=studentRepository.save(student1);
        Assertions.assertThat(savedStudent).isNotNull();
        Assertions.assertThat(savedStudent.getId()).isGreaterThan(0);
    }
    @Test
    public void testListAll(){
        Iterable<Student>StdList=studentRepository.findAll();
        Assertions.assertThat(StdList).hasSizeGreaterThan(0);
        for (Student student:StdList){
            System.out.println(student);
        }
    }
    @Test
    public void testUpdate(){
       Integer std_Id=1;
        Optional<Student>optionalStudent=studentRepository.findById(std_Id);
        Student student=optionalStudent.get();
        student.setAge(11);
        student.setF_name("Rehman");
        student.setGender("Male");
        student.setName("ALI");
        studentRepository.save(student);
        Student updateStudent=studentRepository.getById(std_Id);
    }
    @Test
    public void testGet(){
        Integer std_id=2;
        Optional<Student>optionalStudent=studentRepository.findById(std_id);
        Assertions.assertThat(optionalStudent).isPresent();
        System.out.println(optionalStudent.get());
    }
    @Test
    public void testDelete(){
        Integer std_id=4;
        studentRepository.deleteById(std_id);
        Optional<Student>optionalStudent=studentRepository.findById(std_id);
        Assertions.assertThat(optionalStudent).isNotPresent();
    }

}
