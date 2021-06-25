package com.floow.challenge.web;

import com.floow.challenge.web.domain.Driver;
import com.floow.challenge.web.repository.DriverDao;
import com.floow.challenge.web.service.RegisterDriverCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

class DriverUseCaseTest {

    private RegisterDriverCase registerDriverCase;

    private DriverDao driverDao;


    @BeforeEach
    void initUseCase() {
        registerDriverCase = new RegisterDriverCase(driverDao);
    }

    @Test
    void createDriverHasDateOfBirth() throws Exception {

        Driver driver = new Driver();
        driver.setId(UUID.randomUUID().toString());
        driver.setFirstName("Billy");
        driver.setLastName("Sheng");
        driver.setDateOfBirth("1990-09-09");

        Driver savedDriver = registerDriverCase.registerUser(driver);
        assertThat(savedDriver.getCreationDate(), is(nullValue()));

    }
}
