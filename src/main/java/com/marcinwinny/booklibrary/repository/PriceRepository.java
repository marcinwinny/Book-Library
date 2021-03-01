package com.marcinwinny.booklibrary.repository;

import com.marcinwinny.booklibrary.model.saleinfo.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceRepository extends JpaRepository<Price, Long> {
}
