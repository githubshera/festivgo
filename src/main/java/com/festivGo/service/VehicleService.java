package com.festivGo.service;

import com.festivGo.entity.Vehicle;
import com.festivGo.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    public Vehicle createVehicle(Vehicle vehicle) {
        if(vehicleRepository.existsByVehicleNo(vehicle.getVehicleNo())) {
          throw new IllegalArgumentException(" vehicle already exist: " + vehicle.getVehicleNo());
        }
        return vehicleRepository.save(vehicle);
    }

  public Vehicle getVehicleByNo(String vehicleNo) {
       Vehicle vehicle =  vehicleRepository.findByVehicleNo(vehicleNo);
       if(vehicle == null) {
           throw new IllegalArgumentException("in getVehicleByNo method- no vehicle is found: " + vehicleNo);
       }
       return vehicle;
  }

      public List<Vehicle> getAvailableVehicles(boolean availability) {
          return vehicleRepository.findByAvailability(availability);
      }

    public  Vehicle updateAvailability(String vehicleNo, boolean availability) {
        Vehicle updateVehicle = vehicleRepository.findByVehicleNo(vehicleNo);
        if(updateVehicle == null) {
            throw new IllegalArgumentException("no vehicle is found: " + vehicleNo);
        }
        updateVehicle.setAvailability(availability);
        return vehicleRepository.save(updateVehicle);
    }

    public  void deleteVehicle(String vehicleNo) {
        Vehicle existVehicle = vehicleRepository.findByVehicleNo(vehicleNo);
        if(existVehicle == null) {
            throw new IllegalArgumentException("vehicle is not present with this no: " + vehicleNo);
        }
        vehicleRepository.delete(existVehicle);
    }
}
