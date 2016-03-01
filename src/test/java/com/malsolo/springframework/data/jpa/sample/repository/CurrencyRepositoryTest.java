package com.malsolo.springframework.data.jpa.sample.repository;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.jdbc.JdbcTestUtils;

import com.malsolo.springframework.data.jpa.sample.ApplicationConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationConfiguration.class)
public class CurrencyRepositoryTest {
	
	@Autowired
	CurrencyRepository currencyRepository;

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Test
	public void testMarkerMethod() {
	}

	@Test
	public void testSave() {
		
		this.currencyRepository.save(new Currency("EUR", 978, 2, "Euro"));
		
		this.currencyRepository.flush();
		
		assertEquals(1, JdbcTestUtils.countRowsInTable(jdbcTemplate, "currency"));
	}
}
