package com.festivGo.controller;

import com.festivGo.entity.Vehicle;
import com.festivGo.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicle/v1")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @PostMapping("/create/vehicle")
    public ResponseEntity<Vehicle> createVehicle(@RequestBody Vehicle vehicle) {
        Vehicle saveVehicle = vehicleService.createVehicle(vehicle);
        return new ResponseEntity<>(saveVehicle, HttpStatus.CREATED);
    }

    @GetMapping("/{vehicleNo}")
    public ResponseEntity<Vehicle> getVehicle(@PathVariable String vehicleNo) {
        return  new ResponseEntity<>(vehicleService.getVehicleByNo(vehicleNo), HttpStatus.OK);
    }

    @GetMapping("/available")
    public ResponseEntity<List<Vehicle>> getAvailableVehicles(@RequestParam boolean availability) {
        return  new ResponseEntity<>(vehicleService.getAvailableVehicles(availability), HttpStatus.OK);
    }

    @PutMapping("/{vehicleNo}/available")
    public ResponseEntity<Vehicle> updateAvailability(@PathVariable String vehicleNo, @RequestParam boolean availability) {
        return new ResponseEntity<>(vehicleService.updateAvailability(vehicleNo,availability), HttpStatus.OK);
    }

    @DeleteMapping("/{vehicleNo}")
    public ResponseEntity<Void> deleteVehicle(@PathVariable String vehicleNo) {
        vehicleService.deleteVehicle(vehicleNo);
        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
