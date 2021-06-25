package com.floow.challenge.web.service;

import com.floow.challenge.web.domain.Driver;
import com.floow.challenge.web.repository.DriverDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class RegisterDriverCase {


    private final DriverDao driverDao;

    public Driver registerUser(Driver driver) throws Exception {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        driver.setCreationDate(dateFormat.format(new Date()));
        return driverDao.create(driver);
    }

}
