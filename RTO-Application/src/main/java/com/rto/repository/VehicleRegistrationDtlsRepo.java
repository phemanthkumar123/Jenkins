package com.rto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rto.entity.VehicleRegistrationDetailsEntity;

@Repository
public interface VehicleRegistrationDtlsRepo extends JpaRepository<VehicleRegistrationDetailsEntity, String> {

}
