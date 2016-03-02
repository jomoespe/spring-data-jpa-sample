package com.malsolo.springframework.data.jpa.sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchangeRateRepository extends JpaRepository<ExchangeRate, ExchangeRate.ExchangeRateRequest> {

}
