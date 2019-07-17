package com.tw.apistackbase.repository;

import com.tw.apistackbase.entity.Case;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CaseRepository extends JpaRepository<Case, Long> {
}
