package com.floow.challenge.web.controller;


import com.floow.challenge.web.domain.Driver;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(tags = "Driver Controller")
public class DriverController {

    @RequestMapping(value = "/driver/", method = RequestMethod.POST)
    public ResponseEntity<Driver> create(Driver driver){
        Driver driver1 = new Driver();
        driver1.setId(1000L);
        driver1.setFirstName("Daolin");
        driver1.setLastName("Sheng");
        driver1.setDateOfBirth("04/05/1989");
        driver1.setCreateDate("25 Jun 2021");

        return new ResponseEntity<Driver>((Driver) null, HttpStatus.CREATED);
    }


    @RequestMapping(value = "/drivers/", method = RequestMethod.GET)
    public ResponseEntity<List<Driver>> findAll(){

        return new ResponseEntity<List<Driver>>((List<Driver>) null, HttpStatus.OK);
    }

    @RequestMapping(value = "/drivers/byDate", method = RequestMethod.GET)
    public ResponseEntity<List<Driver>> findAllByDate(String createDate){

        return new ResponseEntity<List<Driver>>((List<Driver>) null, HttpStatus.OK);
    }





}
