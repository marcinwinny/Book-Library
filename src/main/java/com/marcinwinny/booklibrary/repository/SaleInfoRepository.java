package com.marcinwinny.booklibrary.repository;

import com.marcinwinny.booklibrary.model.saleinfo.SaleInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleInfoRepository extends JpaRepository<SaleInfo, Long> {
}
