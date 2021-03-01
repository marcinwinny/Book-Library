package com.marcinwinny.booklibrary.repository;

import com.marcinwinny.booklibrary.model.searchinfo.SearchInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SearchInfoRepository extends JpaRepository<SearchInfo, Long> {
}
