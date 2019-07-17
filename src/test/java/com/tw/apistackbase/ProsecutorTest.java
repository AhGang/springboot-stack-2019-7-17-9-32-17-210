package com.tw.apistackbase;

import com.tw.apistackbase.entity.Case;
import com.tw.apistackbase.entity.Prosecutor;
import com.tw.apistackbase.repository.CaseRepository;
import com.tw.apistackbase.repository.ProcuratorateRepository;
import com.tw.apistackbase.repository.ProsecutorRepository;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ProsecutorTest {
    @Autowired
    private ProsecutorRepository prosecutorRepository;
    @Autowired
    private CaseRepository caseRepository;
    @Test
    public void test_should_add_prosecutor_to_prosecutorList_when_save_a_prosecutor() {
        //given
        Prosecutor ProsecutorA = new Prosecutor("ProsecutorA");
        prosecutorRepository.saveAndFlush(ProsecutorA);
        //when
        List<Prosecutor> prosecutorList = prosecutorRepository.findAll();

        //then
        Assertions.assertEquals(1, prosecutorList.size());
    }
    @Test
    public void test_get_specific_prosecutor_detail_when_give_a_specific_prosecutor_id() {
        //given
        Prosecutor ProsecutorA = new Prosecutor("ProsecutorA");
        Prosecutor ProsecutorB = new Prosecutor("ProsecutorB");
        Prosecutor ProsecutorC = new Prosecutor("ProsecutorC");
        prosecutorRepository.saveAndFlush(ProsecutorA);
        prosecutorRepository.saveAndFlush(ProsecutorB);
        prosecutorRepository.saveAndFlush(ProsecutorC);
        //when
        Prosecutor resultProsecutor = prosecutorRepository.findById(2L).get();
        //then

        //then
        Assertions.assertEquals("ProsecutorB", resultProsecutor.getName());
    }
}
