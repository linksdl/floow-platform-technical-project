package com.floow.challenge.web.service.impl;

import com.floow.challenge.web.domain.Driver;
import com.floow.challenge.web.exception.BusinessException;
import com.floow.challenge.web.exception.ExceptionEnum;
import com.floow.challenge.web.repository.DriverDao;
import com.floow.challenge.web.service.IDriverService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class DriverServiceImpl implements IDriverService {

    private final static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private DriverDao driverDao;

    /**
     * add a driver record
     *
     * @param driver
     * @return Driver
     */
    @Override
    public Driver create(Driver driver){
        Driver entity = new Driver();
        entity.setId(UUID.randomUUID().toString());
        entity.setFirstName(driver.getFirstName());
        entity.setLastName(driver.getLastName());
        try{
            String dateOfBirth = driver.getDateOfBirth();
            dateFormat.setLenient(false);
            dateFormat.parse(dateOfBirth);
            entity.setDateOfBirth(dateOfBirth);
        }catch (Exception e){
            logger.error("====== Failed to create the driver:{}", e.getMessage());
            throw new BusinessException(ExceptionEnum.INVALID_DATA_FORMAT_ERROR.getCode(),
                    ExceptionEnum.INVALID_DATA_FORMAT_ERROR.getMessage()+",Date of Birth should be 'yyyy-MM-dd'");
        }
        entity.setCreationDate(dateFormat.format(new Date()));
        try {
           driverDao.create(entity);
        }catch (Exception e){
            e.printStackTrace();
            throw new BusinessException(ExceptionEnum.DTDA_CREATE_ERROR);
        }
        return entity;
    }

    /**
     * get all driver records
     *
     * @return List<Drive>
     */
    @Override
    public List<Driver> findAll() {
         List<Driver> drivers = null;
        try {
           drivers = driverDao.findAll();
        }catch (Exception e){
            e.printStackTrace();
            logger.error("====== Failed to query the drivers:{}", e.getMessage());
            throw new BusinessException(ExceptionEnum.DTDA_QUERY_ERROR);
        }
        return drivers;
    }

    /**
     * get all drivers' record after a create date
     *
     * @param createDate
     * @return List<Driver>
     */
    @Override
    public List<Driver> findAllByDate(String createDate) {
        List<Driver> drivers = new ArrayList<>();
        try {
           List<Driver> driverList = driverDao.findAll();
           Date conditionDate = dateFormat.parse(createDate);
           for(Driver driver: driverList){
               Date temp_date = dateFormat.parse(driver.getCreationDate());
               if(temp_date.after(conditionDate)){
                   drivers.add(driver);
               }
           }
        }catch (Exception e){
            e.printStackTrace();
            logger.error("====== Failed to query the drivers by creation date:{}", e.getMessage());
            throw new BusinessException(ExceptionEnum.DTDA_QUERY_ERROR);
        }
        return drivers;
    }


}
