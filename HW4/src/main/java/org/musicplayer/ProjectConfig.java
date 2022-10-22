package org.musicplayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfig {

    @Bean
    @Autowired
    MusicPlayerService rockPlayer(){
        MusicPlayerService musicPlayerService = new MusicPlayerService();
        return musicPlayerService;
    }

    @Bean
    MusicPlayerService classicPlayer(){
        MusicPlayerService musicPlayerService = new MusicPlayerService();
        return musicPlayerService;
    }
}
