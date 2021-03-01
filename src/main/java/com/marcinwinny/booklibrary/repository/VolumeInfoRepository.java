package com.marcinwinny.booklibrary.repository;

import com.marcinwinny.booklibrary.model.volumeinfo.VolumeInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VolumeInfoRepository extends JpaRepository<VolumeInfo, Long> {
}
