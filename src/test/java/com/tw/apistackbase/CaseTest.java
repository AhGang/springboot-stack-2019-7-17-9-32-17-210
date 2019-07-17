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
    public void test_should_add_CaseA_to_CaseList_when_save_a_case() {
        //given
        Case caseA = new Case("CaseA", new Date().getTime());
        caseRepository.saveAndFlush(caseA);
        //when
        List<Case> caseList = caseRepository.findAll();
        //then

        //then
        Assertions.assertEquals(1, caseList.size());
    }

}
