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

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CrimeConstituentInfoTest {
    @Autowired
    private CrimeConstituentInfoRepository crimeConstituentInfoRepository;
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
}
