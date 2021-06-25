package com.floow.challenge.web.repository;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.floow.challenge.web.domain.Driver;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

@Component
@Slf4j
public class DriverDao {

    @Resource
    private DatabaseLoader databaseLoader;
    Logger logger = LoggerFactory.getLogger(getClass());

    public Driver create(Driver driver) throws Exception {
        try {
            JSONArray arr = databaseLoader.read();
            JSONArray new_arr = databaseLoader.insert(JSONArray.toJSONString(driver), arr);
            databaseLoader.write(new_arr);
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("IOException: {}", e.getMessage());
        }
        return driver;
    }

    /**
     * Get a list of all existing drivers in JSON format.
     * @return
     */
    public List<Driver> findAll() throws Exception {
        JSONArray jsonArray = databaseLoader.read();
        String jsonStr = JSONObject.toJSONString(jsonArray);
        List<Driver> list = JSONObject.parseArray(jsonStr,  Driver.class);
        return list;
    }
}
