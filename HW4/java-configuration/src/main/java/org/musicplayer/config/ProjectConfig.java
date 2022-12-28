package org.musicplayer.config;

import org.musicplayer.service.ClassicalMusicPlayer;
import org.musicplayer.service.MusicPlayerService;
import org.musicplayer.service.RockMusicPlayer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfig {

    @Bean
    RockMusicPlayer rockPlayer(){
        RockMusicPlayer rockMusicPlayer = new RockMusicPlayer();
        return rockMusicPlayer;
    }

    @Bean
    ClassicalMusicPlayer classicPlayer(){
        ClassicalMusicPlayer classicalMusicPlayer = new ClassicalMusicPlayer();
        return classicalMusicPlayer;
    }

    @Bean
    MusicPlayerService musicPlayerService() {
        MusicPlayerService musicPlayerService = new MusicPlayerService(classicPlayer(),rockPlayer());
        return musicPlayerService;
    }
}
