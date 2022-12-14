package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DistilleryController {
    @Autowired
    DistilleryRepository distilleryRepository;

    @Autowired
    WhiskyRepository whiskyRepository;

    @GetMapping(value = "/distilleries")
    public ResponseEntity<List<Distillery>> getAllDistilleriesByRegion(@RequestParam(name = "region", required = false) String region){
        if(region !=null){
          List<Distillery> distilleries = distilleryRepository.findByRegionIgnoreCase(region);
          return new ResponseEntity<>(distilleries, HttpStatus.OK);
        }
        return new ResponseEntity<>(distilleryRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/distilleries/{id}/whiskies")
    public ResponseEntity<List<Whisky>> getWhiskiesFromDistilleryWithSpecificAge(
            @PathVariable Long id,
            @RequestParam(name = "age", required = false) Integer age

    ) {
        if(age !=null){
            List<Whisky> whiskies = whiskyRepository.findByDistilleryIdAndAge(id, age);

            return new ResponseEntity<>(whiskies, HttpStatus.OK);
        }
        return new ResponseEntity<>(whiskyRepository.findByDistilleryId(id), HttpStatus.OK);
    }



}
