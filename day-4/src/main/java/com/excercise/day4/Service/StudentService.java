package com.excercise.day4.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.excercise.day4.Entity.StudentEntity;
import com.excercise.day4.Repository.StudentRepo;

@Service
public class StudentService {
	@Autowired
	StudentRepo studentRepo;
	public List<StudentEntity> getinfo()
	{
		return studentRepo.findAll();
	}
	public List<StudentEntity> saveinfo(List<StudentEntity> sdutEntity)
	{
		return studentRepo.saveAll(sdutEntity);
	}
	  public StudentEntity putinfo(StudentEntity sdutEntity)
      {
              return studentRepo .saveAndFlush(sdutEntity);
      }
	  public void delete(StudentEntity stuEntity)
      {
		  studentRepo .delete( stuEntity);
       }


}
