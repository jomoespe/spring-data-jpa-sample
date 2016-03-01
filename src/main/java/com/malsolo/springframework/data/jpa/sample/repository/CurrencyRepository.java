package com.malsolo.springframework.data.jpa.sample.repository;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyRepository extends JpaRepository<Currency, String> {
    List<Currency> findTop3ByNum(Integer num);
    List<Currency> findFirst2ByNum(Integer num, Sort sort);
}
