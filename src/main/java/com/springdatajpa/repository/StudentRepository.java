package com.springdatajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springdatajpa.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

}