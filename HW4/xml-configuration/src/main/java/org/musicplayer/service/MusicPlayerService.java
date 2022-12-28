package org.musicplayer.service;

public class MusicPlayerService {
    ClassicalMusicPlayer classicalMusicPlayer;
    RockMusicPlayer rockMusicPlayer;

    public MusicPlayerService(ClassicalMusicPlayer classicalMusicPlayer, RockMusicPlayer rockMusicPlayer) {
        this.classicalMusicPlayer = classicalMusicPlayer;
        this.rockMusicPlayer = rockMusicPlayer;
    }

    public void playClassic() {
        classicalMusicPlayer.playClassicMusic();
    }

    public void playRock() {
        rockMusicPlayer.playRockMusic();
    }
}
