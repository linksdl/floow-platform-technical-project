package com.floow.challenge.web.controller;


import com.floow.challenge.web.domain.Driver;
import com.floow.challenge.web.service.IDriverService;
import io.swagger.annotations.Api;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@Api(tags = "Driver Controller")
@RestController
@RequestMapping("/api/v1")
public class DriverController {

    @Resource
    private IDriverService driverService;

    /**
     *  An POST endpoint to add new driver record.
     * @param driver
     * @return ResponseEntity<Driver>
     */
    @RequestMapping(value = "/driver", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResponseEntity<Driver> create(@Valid @RequestBody Driver driver){
        Driver entity = driverService.create(driver);
        return new ResponseEntity<Driver>(entity, HttpStatus.CREATED);
    }


    /**
     * A GET endpoint which returns a list of all existing drivers in JSON format.
     * @return ResponseEntity<List<Driver>>
     */
    @RequestMapping(value = "/drivers", method = RequestMethod.GET)
    public ResponseEntity<List<Driver>> findAll(){
        List<Driver> drivers = driverService.findAll();
        return new ResponseEntity<List<Driver>>(drivers, HttpStatus.OK);
    }


    /**
     * a GET endpoint with returns a list of all drivers created after the specified date.
     * @param date
     * @return ResponseEntity<List<Driver>>
     */
    @RequestMapping(value = "/drivers/byDate", method = RequestMethod.GET)
    public ResponseEntity<List<Driver>> findAllByDate(@RequestParam("date") String date){
        List<Driver> drivers = driverService.findAllByDate(date);
        return new ResponseEntity<List<Driver>>(drivers, HttpStatus.OK);
    }



}
