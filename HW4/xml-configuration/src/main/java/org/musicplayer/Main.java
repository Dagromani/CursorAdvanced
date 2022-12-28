package org.musicplayer;

import org.musicplayer.service.MusicPlayerService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("beans.xml");
        MusicPlayerService musicPlayerService = beanFactory.getBean(MusicPlayerService.class);
        musicPlayerService.playClassic();
        musicPlayerService.playRock();
    }
}
