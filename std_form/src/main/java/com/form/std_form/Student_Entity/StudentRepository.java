package com.form.std_form.Student_Entity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {
    public Long countById(Integer id);
}
