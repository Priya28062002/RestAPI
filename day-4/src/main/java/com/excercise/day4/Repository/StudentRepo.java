package com.excercise.day4.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.excercise.day4.Entity.StudentEntity;

public interface StudentRepo extends JpaRepository<StudentEntity, Integer> {

}
