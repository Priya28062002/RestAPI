package com.priya.vehicleapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.priya.vehicleapp.model.Charges;

public interface ChargesRepository extends JpaRepository<Charges, Integer> {

}
