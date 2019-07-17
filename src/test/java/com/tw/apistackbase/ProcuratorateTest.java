package com.tw.apistackbase;

import com.tw.apistackbase.entity.CrimeConstituentInfo;
import com.tw.apistackbase.entity.Procuratorate;
import com.tw.apistackbase.repository.CaseRepository;
import com.tw.apistackbase.repository.CrimeConstituentInfoRepository;
import com.tw.apistackbase.repository.ProcuratorateRepository;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ProcuratorateTest {
    @Autowired
    private ProcuratorateRepository procuratorateRepository;

    @Test
    public void test_should_add_procuratorate_when_save_a_procuratorate() {
        //given
        Procuratorate procuratorate = new Procuratorate("aaaa");
        //when
        procuratorateRepository.saveAndFlush(procuratorate);
        List<Procuratorate> procuratorateList = procuratorateRepository.findAll();

        //then
        Assertions.assertEquals(1, procuratorateList.size());
    }
}
