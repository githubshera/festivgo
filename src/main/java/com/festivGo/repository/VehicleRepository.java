package com.festivGo.repository;

import com.festivGo.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

        List<Vehicle> findByAvailability(boolean availability);

        boolean existsByVehicleNo(String vehicleNo);

        Vehicle findByVehicleNo(String vehicleNo);
}
