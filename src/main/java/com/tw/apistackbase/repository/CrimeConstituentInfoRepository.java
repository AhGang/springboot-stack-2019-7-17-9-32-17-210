package com.tw.apistackbase.repository;

import com.tw.apistackbase.entity.Case;
import com.tw.apistackbase.entity.CrimeConstituentInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CrimeConstituentInfoRepository extends JpaRepository<CrimeConstituentInfo, Long> {

}
