package com.marcinwinny.booklibrary.repository;

import com.marcinwinny.booklibrary.model.accesinfo.AccessInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccessInfoRepository extends JpaRepository<AccessInfo, Long> {
}
