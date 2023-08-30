package com.priya.vehicleapp.service;

import java.util.List;

import com.priya.vehicleapp.model.VehicleService;

public interface VehicleServices {

    public VehicleService getServiceHistoryById(int id);

    public boolean addService(VehicleService vehicleService);

    public boolean closeService(int id);

    public String checkServiceStatus(int id);

    public String deleteServiceById(int id);
    
    public String fetchOpenServices(int pageNo, int pageSize);
    
    public boolean isAdmin(String emailId);
    
    public boolean isEmployee(String emailId);
    
    public boolean isUser(String emailId);
    
    public List<VehicleService> servicesSortByName(String sortBy, String sortName);
    
}