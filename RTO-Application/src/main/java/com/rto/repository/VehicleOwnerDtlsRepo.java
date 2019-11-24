package com.rto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rto.entity.OwnerEntity;

@Repository
public interface VehicleOwnerDtlsRepo extends JpaRepository<OwnerEntity, Integer>{

}
