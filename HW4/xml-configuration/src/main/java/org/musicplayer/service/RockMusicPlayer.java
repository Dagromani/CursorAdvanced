package org.musicplayer.service;

import org.musicplayer.entity.Song;

import java.util.ArrayList;
import java.util.List;

public class RockMusicPlayer {
    private List<Song> rockMusic = new ArrayList<>();

    public RockMusicPlayer() {
        Song LPPapercut = new Song("Papercut", "Linkin Park");
        Song TDGTimeOfDying = new Song("Time of Dying", "Three Days Grace");
        rockMusic.add(LPPapercut);
        rockMusic.add(TDGTimeOfDying);
    }

    public void playRockMusic() {
        for (int i = 0; i < rockMusic.size(); i++) {
            System.out.println("Playing: " + rockMusic.get(i));
        }
    }
}
