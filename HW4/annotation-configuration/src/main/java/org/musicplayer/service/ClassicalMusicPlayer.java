package org.musicplayer.service;

import org.musicplayer.entity.Song;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClassicalMusicPlayer {
    private List<Song> classicMusic = new ArrayList<Song>();

    public ClassicalMusicPlayer() {
        Song mozart40Symphony = new Song("40th symphony" , "Mozart");
        Song vivaldiSummer = new Song("Summer", "Vivaldi");
        classicMusic.add(mozart40Symphony);
        classicMusic.add(vivaldiSummer);
    }

    public void playClassicMusic(){
        for(int i = 0 ; i < classicMusic.size() ; i++) {
            System.out.println("Playing: " + classicMusic.get(i));
        }
    }
}
