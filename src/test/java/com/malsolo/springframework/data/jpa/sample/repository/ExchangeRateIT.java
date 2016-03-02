package com.malsolo.springframework.data.jpa.sample.repository;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class ExchangeRateIT {
    
    @Autowired ExchangeRateRepository exchangeRates;
    @Autowired JdbcTemplate           jdbcTemplate;

    @Test
    public void testSave() {
        Assert.assertNotNull("The repository is null", exchangeRates);
        exchangeRates.save(exchangeRates.create("USD", "EUR", System.currentTimeMillis(), 0.85642, null));
        exchangeRates.flush();
    }
}
