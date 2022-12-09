package com.HW17.HW17.service.impl;

import com.HW17.HW17.entity.CatFact;
import com.HW17.HW17.service.CatService;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import com.github.tomakehurst.wiremock.junit5.WireMockTest;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.TestPropertySource;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@WireMockTest(httpPort = 8080)
@TestPropertySource(properties = "catFact.url=http://localhost:8080/fact")
public class WireMockCatServiceImplTest {

    @Autowired
    private CatService catService;

    private static WireMockServer wireMockServer;

    @DynamicPropertySource
    static void overrideWebClientBaseUrl(DynamicPropertyRegistry dynamicPropertyRegistry) {
        dynamicPropertyRegistry.add("catFact.url", wireMockServer::baseUrl);
    }

    @BeforeAll
    static void startWiremock() {
        wireMockServer = new WireMockServer(WireMockConfiguration.wireMockConfig().dynamicPort());
        wireMockServer.start();
    }

    @AfterAll
    static void stopWiremock() {
        wireMockServer.stop();
    }

    @Test
    void testWiremock() {
        System.out.println(wireMockServer.baseUrl());
        assertTrue(wireMockServer.isRunning());
    }

    @Test
    void getCatFactTest() {
        CatFact response = new CatFact();
        response.setFact("A cat's normal pulse is 140-240 beats per minute, with an average of 195.");
        response.setLength(73);
        wireMockServer.stubFor(WireMock.get("/").willReturn(jsonResponse(response, 200)));
        String catFact = catService.getCatFact();
        assertThat(catFact).isEqualTo(response.getFact());
    }
}
