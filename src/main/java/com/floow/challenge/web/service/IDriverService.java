package com.floow.challenge.web.service;


import com.floow.challenge.web.domain.Driver;

import java.util.List;

public interface IDriverService {

    /**
     * add a driver record
     * @param driver
     * @return
     */
    public Driver create(Driver driver);

    /**
     * get all driver records existing in JSON file.
     * @return
     */
    public List<Driver> findAll();

    /**
     * get the drivers' record after a create date
     * @param createDate
     * @return
     */
    List<Driver> findAllByDate(String createDate);
}
