package com.tw.apistackbase.repository;

import com.tw.apistackbase.entity.Case;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CaseRepository extends JpaRepository<Case, Long> {
    List<Case> findByOrderByTimeAsc();
    List<Case> findCasesByCaseName(String caseName);
    void deleteCaseById(long id);

}
