package ru.maks.springcource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class Computer {
    private MusicPlayer musicPlayer;

    public Computer(MusicPlayer musicPlayer) {
        this.musicPlayer = musicPlayer;
    }

    public String getSong() {
        return "ff";
       // return musicPlayer.playMusic(MusicType.CLASSIC);
    }


}
