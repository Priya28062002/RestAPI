package com.priya.vehicleapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.priya.vehicleapp.dto.EmailRequestDTO;
import com.priya.vehicleapp.model.VehicleService;
import com.priya.vehicleapp.service.VehicleServices;
import com.priya.vehicleapp.utilities.VehicleServiceConstants;

@RestController
@RequestMapping("/vehicle")
public class VehicleServiceController {

    @Autowired
    private VehicleServices vehicleServices;

    @GetMapping("/getHistory/{id}")
    public String getHistoryById(@PathVariable("id") int id) {
        VehicleService vehicleService = vehicleServices.getServiceHistoryById(id);
        if(vehicleService == null) {
            return VehicleServiceConstants.SERVICE_NOT_EXISTS;
        }
        return vehicleService.toString();
    }

    @PostMapping("/addService")
    public String addService(@RequestBody VehicleService vehicleService) {
    	boolean isUser = vehicleServices.isUser(vehicleService.getUserEmail());
    	if(!isUser) {
    		return VehicleServiceConstants.USER_NOT_EXISTS;
    	}
        boolean isAdded = vehicleServices.addService(vehicleService);
        if(isAdded) {
            return VehicleServiceConstants.SERVICE_ADDED;
        }
        return VehicleServiceConstants.SERVICE_NOT_ADDED;
    }

    @PutMapping("/closeService/{id}")
    public String closeService(@PathVariable("id") int id, @RequestBody EmailRequestDTO emailRequest) {
    	if(!vehicleServices.isAdmin(emailRequest.getEmailId())) {
    		return VehicleServiceConstants.NOT_AUTHORIZED;
    	}
        boolean isClosed = vehicleServices.closeService(id);
        if(isClosed) {
            return VehicleServiceConstants.SERVICE_CLOSED;
        }
        return VehicleServiceConstants.SERVICE_NOT_CLOSED;
    }

    @GetMapping("/checkStatus/{id}")
    public String checkServiceStatus(@PathVariable("id") int id) {
        String status = vehicleServices.checkServiceStatus(id);
        return status;
    }

    @DeleteMapping("/deleteService/{id}")
    public String deleteServiceById(@PathVariable("id") int id, @RequestBody EmailRequestDTO emailRequest) {
    	if(!vehicleServices.isAdmin(emailRequest.getEmailId())) {
    		return VehicleServiceConstants.NOT_AUTHORIZED;
    	}
        String deleteService = vehicleServices.deleteServiceById(id);
        return deleteService;
    }
    
    @GetMapping("/openServices")
    public String fetchOpenServices(@RequestBody EmailRequestDTO emailRequest, @RequestParam(defaultValue = "0") int pageNo, @RequestParam(defaultValue = "10") int pageSize) {
    	if(vehicleServices.isAdmin(emailRequest.getEmailId()) || vehicleServices.isEmployee(emailRequest.getEmailId())) {
    		String openServices = vehicleServices.fetchOpenServices(pageNo, pageSize);
    		return openServices;
    	}
    	return VehicleServiceConstants.NOT_AUTHORIZED;
    }
    
}