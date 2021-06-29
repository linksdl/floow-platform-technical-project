package com.floow.challenge.web.repository;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.Iterator;


@Component
public class DatabaseLoader {


    Logger logger = LoggerFactory.getLogger(getClass());

    @Value("classpath:static/driver.json")
    private Resource driverDB;


    /**
     * read the Json file
     * @return
     * @throws Exception
     */
    public JSONArray read() throws  Exception{
        ClassPathResource pathResource = new ClassPathResource("static/driver.json");
        if(!pathResource.exists()){
            logger.warn("driver.json file does not exist.");
        }
        BufferedReader reader = null;
        JSONArray arr = new JSONArray();
        try{
          reader = new BufferedReader(new InputStreamReader(pathResource.getInputStream()));
            StringBuilder builder = new StringBuilder();
            String line = "";
            while((line = reader.readLine())!=null) {
                builder.append(line);
            }
            arr =  JSON.parseArray(builder.toString());
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            if(reader!=null){
                reader.close();
            }
        }
        return arr;
    }

    /**
     * insert entity to the json file
     * @param str
     * @param array
     * @return
     */
    public JSONArray insert(String str, JSONArray array) {
        array.add(JSONObject.parseObject(str));
        return array;
    }

    /**
     * delete an entity by the id from the json file
     * @param id
     * @param array
     * @return
     * @throws Exception
     */
    public JSONArray deleteById(String id, JSONArray array) throws Exception{
        Iterator<Object> it = array.iterator();
        while(it.hasNext()){
            JSONObject x = (JSONObject)it.next();
            if(x.getString("id").equals(id)){
                it.remove();
            }
        }
        return array;
    }


    /**
     * write json objects to json file
     * @param array
     * @throws Exception
     */
    public void write(JSONArray array) throws Exception{
        BufferedWriter writer = null;
        ClassPathResource pathResource = new ClassPathResource("static/driver.json");
        if(!pathResource.exists()){
            logger.warn("driver.json file does not exist.");
        }
        try {
            String s= JSON.toJSONString(array, SerializerFeature.PrettyFormat, SerializerFeature.WriteMapNullValue,
                    SerializerFeature.WriteDateUseDateFormat);
            File file = pathResource.getFile();
            FileOutputStream resource = new FileOutputStream(file, false);
            writer = new BufferedWriter(new OutputStreamWriter(resource));
            writer.write(s);
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            if (writer != null) {
                writer.close();
            }
        }
    }

}
