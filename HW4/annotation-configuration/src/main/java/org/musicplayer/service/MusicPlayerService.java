package org.musicplayer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MusicPlayerService {

    @Autowired
    ClassicalMusicPlayer classicalMusicPlayer;
    @Autowired
    RockMusicPlayer rockMusicPlayer;

    public void playClassic() {
        classicalMusicPlayer.playClassicMusic();
    }

    public void playRock() {
        rockMusicPlayer.playRockMusic();
    }
}
