package com.priya.vehicleapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.priya.vehicleapp.model.Admin;
import com.priya.vehicleapp.model.Employee;
import com.priya.vehicleapp.model.User;
import com.priya.vehicleapp.model.VehicleService;
import com.priya.vehicleapp.repository.AdminRepository;
import com.priya.vehicleapp.repository.ChargesRepository;
import com.priya.vehicleapp.repository.EmployeeRepository;
import com.priya.vehicleapp.repository.UserRepository;
import com.priya.vehicleapp.repository.VehicleServiceRepository;
import com.priya.vehicleapp.utilities.VehicleServiceConstants;

@Service
public class VehicleServiceImpl implements VehicleServices {

    @Autowired
    private VehicleServiceRepository vehicleServiceRepository;
    
    @Autowired
    private AdminRepository adminRepository;
    
    @Autowired
    private EmployeeRepository employeeRepository;
    
    @Autowired
    private ChargesRepository chargesRepository;
    
    @Autowired
    private UserRepository userRepository;

    @Override
    public VehicleService getServiceHistoryById(int id) {
        Optional<VehicleService> vehicleService = vehicleServiceRepository.findById(id);
        return vehicleService.orElse(null);
    }

    @Override
    public boolean addService(VehicleService vehicleService) {
        vehicleServiceRepository.save(vehicleService);
        chargesRepository.save(vehicleService.getCharges());
        return true;
    }

    @Override
    public boolean closeService(int id) {
        Optional<VehicleService> vehicleService = vehicleServiceRepository.findByVehicleId(id);
        if(!vehicleService.isPresent()) {
            return false;
        }
        vehicleService.get().setStatus("Closed");
        vehicleServiceRepository.save(vehicleService.get());
        return true;
    }

    @Override
    public String checkServiceStatus(int id) {
        Optional<VehicleService> vehicleService = vehicleServiceRepository.findByVehicleId(id);
        if(!vehicleService.isPresent()) {
            return VehicleServiceConstants.SERVICE_NOT_EXISTS;
        }
        return vehicleService.get().getStatus();
    }

    @Override
    public String deleteServiceById(int id) {
        Optional<VehicleService> vehicleService = vehicleServiceRepository.findByVehicleId(id);
        if(!vehicleService.isPresent()) {
            return VehicleServiceConstants.SERVICE_NOT_EXISTS;
        }
        if(!vehicleService.get().getStatus().equals("Closed")) {
            return VehicleServiceConstants.SERVICE_NOT_CLOSED;
        }
        vehicleServiceRepository.delete(vehicleService.get());
        return VehicleServiceConstants.SERVICE_DELETED;
    }

	@Override
	public String fetchOpenServices(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo, pageSize);
		List<VehicleService> openServices = vehicleServiceRepository.findAllOpenServices(pageable).toList();
		return openServices.toString();
	}

	@Override
	public boolean isAdmin(String emailId) {
		Admin admin = adminRepository.findByAdminEmail(emailId);
		if(admin == null)
			return false;
		return true;
	}

	@Override
	public boolean isEmployee(String emailId) {
		Employee employee = employeeRepository.findByEmployeeEmail(emailId);
		if(employee == null)
			return false;
		return true;
	}
	
	public boolean isUser(String emailId) {
		User user = userRepository.findByUserEmail(emailId);
		if(user == null)
			return false;
		return true;
	}

	@Override
	public List<VehicleService> servicesSortByName(String sortBy, String sortName) {
		if(sortBy == null)
			sortBy = "ASC";
		if(sortName == null)
			sortName = "vehicleId";
		if(sortBy.equalsIgnoreCase("ASC"))
			return vehicleServiceRepository.findAll(Sort.by(sortName).ascending());
		return vehicleServiceRepository.findAll(Sort.by(sortName).descending());
	}
    
}