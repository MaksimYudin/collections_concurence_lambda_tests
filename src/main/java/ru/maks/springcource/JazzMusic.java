package ru.maks.springcource;

import java.util.List;

public class JazzMusic implements Music {
    private List<String> musicList;

    @Override
    public String getSong() {
        return null;
    }

    @Override
    public List<String> getSongList() {
        return musicList;
    }

    public void setMusicList(List<String> musicList) {
        this.musicList = musicList;
    }
}
