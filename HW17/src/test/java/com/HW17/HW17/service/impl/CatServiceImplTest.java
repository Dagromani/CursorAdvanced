package com.HW17.HW17.service.impl;

import com.HW17.HW17.service.CatService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class CatServiceImplTest {

    @Autowired
    private CatService catService;

    @Test
    void getCatFact() throws Exception {
        assertThat(catService.getCatFact().length()).isGreaterThan(1);
    }
}