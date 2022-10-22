package org.musicplayer;

import org.springframework.beans.factory.annotation.Autowired;

public class MusicPlayerService {
    ClassicalMusicPlayer classicalMusicPlayer = new ClassicalMusicPlayer();
    RockMusicPlayer rockMusicPlayer = new RockMusicPlayer();

    public void playClassic() {
        classicalMusicPlayer.playClassicMusic();
    }

    public void playRock() {
        rockMusicPlayer.playRockMusic();
    }
}
