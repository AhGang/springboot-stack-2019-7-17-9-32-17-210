package com.tw.apistackbase;

import com.tw.apistackbase.entity.Case;
import com.tw.apistackbase.repository.CaseRepository;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
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

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CaseTest {
    @Autowired
    private CaseRepository caseRepository;
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
        Case caseB = new Case("CaseB", new Date().getTime());
        Case caseC = new Case("CaseC", new Date().getTime());
        caseRepository.saveAndFlush(caseA);
        caseRepository.saveAndFlush(caseB);
        caseRepository.saveAndFlush(caseC);
        //when
        Case resultCase = caseRepository.findById(2L).get();
        //then

        //then
        Assertions.assertEquals("CaseB", resultCase.getCaseName());
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
}
