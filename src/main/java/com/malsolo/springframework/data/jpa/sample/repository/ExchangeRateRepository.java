package com.malsolo.springframework.data.jpa.sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchangeRateRepository extends JpaRepository<ExchangeRate, ExchangeRate.ExchangeRateRequest> {

    default ExchangeRate create(String source, String target, Long timestamp, Double rate, 
                                String date) {
        ExchangeRate newExchangeRate = new ExchangeRate();
        newExchangeRate.setSource(source);
        newExchangeRate.setTarget(target);
        newExchangeRate.setRequestTimestamp(timestamp);
        newExchangeRate.setRate(rate);
        newExchangeRate.setRateDate(date);
        return newExchangeRate;
    }
}
