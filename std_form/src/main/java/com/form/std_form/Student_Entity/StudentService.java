package com.form.std_form.Student_Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired private StudentRepository repo;
    public List<Student>listAll(){
        return (List<Student>) repo.findAll();
    }

    public void save(Student student) {
        repo.save(student);
    }
    public Student get(Integer id) throws UserNotFoundException {
        Optional<Student>result=repo.findById(id);
        if(result.isPresent()){
            return result.get();
        }
        throw new UserNotFoundException("could not found any user with id: "+id);
    }
    public void delete(Integer id) throws UserNotFoundException {
        Long count=repo.countById(id);
        if(count==null||count==0){
            throw new UserNotFoundException("could not found any user with Id: "+id);
        }
        repo.deleteById(id);
    }

}
