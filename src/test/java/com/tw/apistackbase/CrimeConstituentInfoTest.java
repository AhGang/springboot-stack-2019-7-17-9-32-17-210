package com.tw.apistackbase;

import com.tw.apistackbase.entity.Case;
import com.tw.apistackbase.entity.CrimeConstituentInfo;
import com.tw.apistackbase.repository.CaseRepository;
import com.tw.apistackbase.repository.CrimeConstituentInfoRepository;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CrimeConstituentInfoTest {
    @Autowired
    private CrimeConstituentInfoRepository crimeConstituentInfoRepository;
    @Autowired
    private CaseRepository caseRepository;
    @Test
    public void test_should_add_crime_constituent_info_to_crime_constituent_List_when_save_a_crime_constituent() {
        //given
        CrimeConstituentInfo crimeConstituentInfo = new CrimeConstituentInfo("aaaa","bbbb");
        crimeConstituentInfoRepository.saveAndFlush(crimeConstituentInfo);
        //when
        List<CrimeConstituentInfo> crimeConstituentInfoList = crimeConstituentInfoRepository.findAll();

        //then
        Assertions.assertEquals(1, crimeConstituentInfoList.size());
    }
    @Test
    public void test_get_specific_case_detail_when_give_a_specific_case_id() {
        //given
        CrimeConstituentInfo crimeConstituentInfoA = new CrimeConstituentInfo("aaaa","aaaa");
        CrimeConstituentInfo savedCrimeConstituentInfoA = crimeConstituentInfoRepository.saveAndFlush(crimeConstituentInfoA);
        //when
        CrimeConstituentInfo resultCrimeConstituentInfo = crimeConstituentInfoRepository.findById(savedCrimeConstituentInfoA.getId()).get();
        //then

        //then
        Assertions.assertEquals("aaaa", resultCrimeConstituentInfo.getObjectiveRequirement());
        Assertions.assertEquals("aaaa", resultCrimeConstituentInfo.getSubjectiveRequirement());
    }

    @Test
    public void test_should_get_basic_information_specific_information_of_each_case_one_to_one_when_find_correspond_case_and_crime_constituent_info() {
        //given
        Case caseA = new Case("CaseA", new Date().getTime(),new CrimeConstituentInfo("subjectA","objectA"));
        //when
        Case savedCaseA = caseRepository.save(caseA);
        //then
        Assertions.assertEquals("subjectA", savedCaseA.getCrimeConstituentInfo().getSubjectiveRequirement());
        Assertions.assertEquals("objectA", savedCaseA.getCrimeConstituentInfo().getObjectiveRequirement());

    }
    @Test
    public void test_should_add_specific_information_in_criminal_case_when_case_belongs_to_criminal_case() {
        //given
        Case normalCase = new Case("normal", new Date().getTime());
        Case criminalCase = new Case("criminal", new Date().getTime());
        CrimeConstituentInfo crimeConstituentInfo = new CrimeConstituentInfo("subjectA","objectA");
        List<Case> caseList = new ArrayList<>();
        caseList.add(normalCase);
        caseList.add(criminalCase);
        Case savedNormalCase = caseRepository.save(normalCase);
        Case savedCriminalCase = caseRepository.save(criminalCase);
        //when
        for(int i = 0;i<caseList.size();i++){
            if(caseList.get(i).getCaseName()=="criminal"){
                caseList.get(i).setCrimeConstituentInfo(crimeConstituentInfo);
                caseRepository.save(caseList.get(i));
            }
        }
        //then
        Assertions.assertEquals("subjectA", caseRepository.findById(savedCriminalCase.getId()).get().getCrimeConstituentInfo().getSubjectiveRequirement());

    }
}
