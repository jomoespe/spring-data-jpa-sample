package com.malsolo.springframework.data.jpa.sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyRepository extends JpaRepository<Currency, String> {
}
