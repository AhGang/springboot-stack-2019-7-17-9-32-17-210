package com.tw.apistackbase;

import com.tw.apistackbase.entity.Case;
import com.tw.apistackbase.repository.CaseRepository;

import org.hibernate.annotations.SQLDeleteAll;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CaseTest {
    @Autowired
    private CaseRepository caseRepository;
    @BeforeEach
    public  void deleteDBBeforeEach(){
        caseRepository.deleteAll();
    }

	@Test
    public void test_should_add_caseA_to_caseList_when_save_a_case() {
        //given
        Case caseA = new Case("CaseA", new Date().getTime());
        caseRepository.saveAndFlush(caseA);
        //when
        List<Case> caseList = caseRepository.findAll();

        //then
        Assertions.assertEquals(1, caseList.size());
    }
    @Test
    public void test_get_specific_case_detail_when_give_a_specific_case_id() {
        //given
        Case caseA = new Case("CaseA", new Date().getTime());
        Case caseASaved = caseRepository.saveAndFlush(caseA);
        //when
        Case  specificCase = caseRepository.findById(caseASaved.getId()).get();
        //then
        Assertions.assertEquals(caseA.getCaseName(), specificCase.getCaseName());
        Assertions.assertEquals(caseA.getTime(), specificCase.getTime());
    }
    @Test
    public void test_should_get_cases_order_by_date_asc_when_find_cases_order_by_date_asc_(){
        //given
        Case caseA = new Case("CaseA", new Date().getTime());
        Case caseB = new Case("CaseB", new Date().getTime());
        Case caseC = new Case("CaseC", new Date().getTime());
        caseRepository.saveAndFlush(caseA);
        caseRepository.saveAndFlush(caseB);
        caseRepository.saveAndFlush(caseC);
        //when
        List<Case> caseList = caseRepository.findByOrderByTimeAsc();
        //then
        Assertions.assertEquals("CaseB",caseList.get(1).getCaseName());
    }
    @Test
    public void test_should_get_specific_case_by_same_case_name_when_find_cases__by_name_(){
        //given
        Case caseA = new Case("CaseA", new Date().getTime());
        Case caseB = new Case("CaseB", new Date().getTime());
        Case caseAA = new Case("CaseA", new Date().getTime());
        caseRepository.saveAndFlush(caseA);
        caseRepository.saveAndFlush(caseB);
        caseRepository.saveAndFlush(caseAA);
        //when
        List<Case> caseList = caseRepository.findCasesByCaseName("CaseA");
        //then
        Assertions.assertEquals("CaseA",caseList.get(0).getCaseName());
        Assertions.assertEquals("CaseA",caseList.get(1).getCaseName());
    }
    @Test
    public void test_should_delete_specific_case_by_give_a_specific_id(){
        //given
        Case caseA = new Case("CaseA", new Date().getTime());
        Case caseB = new Case("CaseB", new Date().getTime());
        caseRepository.saveAndFlush(caseA);
        caseRepository.saveAndFlush(caseB);
        Case caseASaved = caseRepository.saveAndFlush(caseA);
        //when
        Case  specificCase = caseRepository.findById(caseASaved.getId()).get();
        caseRepository.deleteCaseById(specificCase.getId());
        //then
        List<Case> caseList = caseRepository.findAll();
        Assertions.assertEquals("CaseB",caseList.get(0).getCaseName());

    }

}
