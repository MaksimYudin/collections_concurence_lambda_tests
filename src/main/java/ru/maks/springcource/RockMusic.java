package ru.maks.springcource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

public class RockMusic implements Music {

    private List<String> musicList;

    @Override
    public String getSong() {
        return "Rock music";
    }

    public List<String> getSongList() {
        return musicList;
    }

    public void setRockMusicList(List<String> musicList) {
        this.musicList = musicList;
    }
}
