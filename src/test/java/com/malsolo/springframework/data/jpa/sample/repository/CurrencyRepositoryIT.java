package com.malsolo.springframework.data.jpa.sample.repository;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.jdbc.JdbcTestUtils;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.malsolo.springframework.data.jpa.sample.ApplicationConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationConfiguration.class)
public class CurrencyRepositoryIT {

    @Autowired private CurrencyRepository currencyRepository;
    @Autowired private JdbcTemplate       jdbcTemplate;

    
    @Test
    public void testSave() {
        currencyRepository.save(new Currency("EUR", 978, 2, "Euro"));
        currencyRepository.flush();

        assertEquals(1, JdbcTestUtils.countRowsInTable(jdbcTemplate, "currency"));

        currencyRepository.save(new Currency("USD", 978, 2, "Euro"));
        currencyRepository.save(new Currency("GBP", 978, 2, "Euro"));
        currencyRepository.save(new Currency("JPY", 978, 2, "Euro"));
        currencyRepository.flush();

        assertEquals(4, JdbcTestUtils.countRowsInTable(jdbcTemplate, "currency"));

        List<Currency> top3 = currencyRepository.findTop3ByNum(978);
        assertEquals(3, top3.size());
        top3.forEach((c) -> System.out.printf("!!! currency code=[%s]    \n", c.getCode()));

        List<Currency> last2 = currencyRepository.findFirst2ByNum(978, new Sort(Sort.Direction.ASC, "num"));
        assertEquals(2, last2.size());
        last2.forEach((c) -> System.out.printf("*** currency code=[%s]    \n", c.getCode()));
    }
}
