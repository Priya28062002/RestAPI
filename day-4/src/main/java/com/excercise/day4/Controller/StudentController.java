package com.excercise.day4.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.excercise.day4.Entity.StudentEntity;
import com.excercise.day4.Service.StudentService;

@RestController
public class StudentController {
	@Autowired
	StudentService studentService;
	@GetMapping("/show")
	public List<StudentEntity> showinfo()
	{
		return studentService.getinfo();
	}
	@PostMapping("/post")
	public List<StudentEntity> putinfo(@RequestBody List<StudentEntity> studentity)
	{
		return studentService.saveinfo(studentity);
	}
	@PutMapping("/update")
	public StudentEntity updateinfo(@RequestBody StudentEntity studentity)
	{
		return studentService.putinfo(studentity);
	}
        @DeleteMapping("/delete")
        public String delete(StudentEntity studentity)
        {
                studentService.delete(studentity);
                return "Deleted Successfully";
        }

}
