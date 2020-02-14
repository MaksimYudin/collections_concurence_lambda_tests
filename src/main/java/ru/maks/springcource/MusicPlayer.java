package ru.maks.springcource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class MusicPlayer {

    //private List<MusicType> musicTypeList;
    private List<Music> musicTypeList;

//    private ClassicalMusic classicalMusic;
//    private RockMusic rockMusic;

    @Value("${musicPlayer.name}")
    private String name;
    @Value("${musicPlayer.volume}")
    private int volume;

//    public MusicPlayer(List<MusicType> musicTypeList) {
//        this.musicTypeList = musicTypeList;
//    }


    public MusicPlayer(List<Music> musicTypeList) {
        this.musicTypeList = musicTypeList;
    }

//    public String playMusic_old() {
//        Random random = new Random();
//        MusicType musicType = musicTypeList.get(random.nextInt(musicTypeList.size()));
//        String message = "no song";
//
////        int index = random.nextInt(3);
//        if (musicType.equals(MusicType.CLASSIC)) {
//            int index = random.nextInt(classicalMusic.getSongList().size());
//            message = "Playing classical music: " + classicalMusic.getSongList().get(index);
//        }
//        else if (musicType.equals(MusicType.ROCK)) {
//            int index = random.nextInt(rockMusic.getSongList().size());
//            message = "Playing rock music: " + rockMusic.getSongList().get(index);
//        }
//        return message;
//    }

    public String playMusic() {
        Random random = new Random();
        Music musicType = musicTypeList.get(random.nextInt(musicTypeList.size()));
        return "Playing: " + musicType.getSongList().get(random.nextInt(musicType.getSongList().size()));

//        int index = random.nextInt(3);
//        if (musicType.equals(MusicType.CLASSIC)) {
//            int index = random.nextInt(classicalMusic.getSongList().size());
//            message = "Playing classical music: " + classicalMusic.getSongList().get(index);
//        }
//        else if (musicType.equals(MusicType.ROCK)) {
//            int index = random.nextInt(rockMusic.getSongList().size());
//            message = "Playing rock music: " + rockMusic.getSongList().get(index);
//        }

    }

    public String getName() {
        return name;
    }

    public int getVolume() {
        return volume;
    }

    @PostConstruct
    public void doMyInit() {
        System.out.println("pre init");
    }

    @PreDestroy
    public void doMyDestroy() {
        System.out.println("on destroy");
    }

//    public void setClassicalMusic(ClassicalMusic classicalMusic) {
//        this.classicalMusic = classicalMusic;
//    }
//
//    public void setRockMusic(RockMusic rockMusic) {
//        this.rockMusic = rockMusic;
//    }
}
