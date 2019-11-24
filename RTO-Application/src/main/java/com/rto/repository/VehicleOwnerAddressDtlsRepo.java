package com.rto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rto.entity.OwnerAddressEntity;

@Repository
public interface VehicleOwnerAddressDtlsRepo extends JpaRepository<OwnerAddressEntity, Integer>{

}
