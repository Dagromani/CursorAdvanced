package com.HW17.HW17.service.impl;

import com.HW17.HW17.entity.CatFact;
import com.HW17.HW17.service.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CatServiceImpl implements CatService {

    @Value("${catFact.url}")
    private String url;

    @Autowired
    private RestTemplate restTemplate;


    @Override
    public String getCatFact() {
        CatFact response = restTemplate.getForObject(url , CatFact.class);
        if (response == null) {
            return null;
        }
        return response.getFact();
    }
}
