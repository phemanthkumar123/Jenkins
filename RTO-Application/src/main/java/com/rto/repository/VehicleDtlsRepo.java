package com.rto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rto.entity.VehicleEntity;

@Repository
public interface VehicleDtlsRepo extends JpaRepository<VehicleEntity, Integer>{

}
