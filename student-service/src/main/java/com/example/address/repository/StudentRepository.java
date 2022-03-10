package com.example.address.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.address.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

}
