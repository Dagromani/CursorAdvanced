package org.musicplayer;

import org.musicplayer.service.MusicPlayerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("org.musicplayer");
        MusicPlayerService musicPlayerService = applicationContext.getBean(MusicPlayerService.class);
        musicPlayerService.playClassic();
        musicPlayerService.playRock();
    }
}
