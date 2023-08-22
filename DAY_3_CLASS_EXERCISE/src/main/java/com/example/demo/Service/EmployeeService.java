package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.EmployeeRepo;
import com.example.demo.model.EmployeeModel;

@Service
public class EmployeeService {
      @Autowired
       EmployeeRepo repository;
      
      public EmployeeModel showInfo(EmployeeModel em)
      {
    	  return repository.save(em);
      }
      
      public List<EmployeeModel> getInfo()
      {
    	  return repository.findAll();
      }
}
