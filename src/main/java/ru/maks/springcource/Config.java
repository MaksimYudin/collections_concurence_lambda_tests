package ru.maks.springcource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
@ComponentScan("ru.maks.springcource")
@PropertySource("classpath:musicPlayer.properties")
public class Config {
    @Bean
    public List<String> rockMusicList() {
        return Arrays.asList("rock1", "rock2", "rock3");
    }

    @Bean
    public List<String> classicalMusicList() {
        return Arrays.asList("class1", "class2", "class3");
    }

    @Bean
    public List<String> jazzMusicList() {
        return Arrays.asList("jazz1", "jazz2", "jazz3");
    }

    @Bean
    public JazzMusic jazzMusic() {

        JazzMusic jazzMusic = new JazzMusic();
        jazzMusic.setMusicList(jazzMusicList());

        return jazzMusic;
    }

    @Bean
    public RockMusic rockMusic() {

        RockMusic rockMusic = new RockMusic();
        rockMusic.setRockMusicList(rockMusicList());

        return rockMusic;
    }

    @Bean
    public ClassicalMusic classicalMusic() {
        ClassicalMusic classicalMusic = new ClassicalMusic();
        classicalMusic.setMusicList(classicalMusicList());

        return classicalMusic;
    }

    @Bean
    public MusicPlayer2 musicPlayer2() {

        return new MusicPlayer2(jazzMusic());
    }

//    @Bean
//    public List<MusicType> musicTypeList() {
//        return Arrays.asList(MusicType.CLASSIC, MusicType.ROCK);
//    }

    @Bean
    public List<Music> musicTypeList() {
        return Arrays.asList(classicalMusic(), rockMusic(), jazzMusic());
    }

//    @Bean
//    public MusicPlayer musicPlayer() {
//        MusicPlayer musicPlayer = new MusicPlayer(musicTypeList());
//        musicPlayer.setClassicalMusic(classicalMusic());
//        musicPlayer.setRockMusic(rockMusic());
//
//        return musicPlayer;
//    }

    @Bean
    public MusicPlayer musicPlayer() {
        MusicPlayer musicPlayer = new MusicPlayer(musicTypeList());
        //musicPlayer.setClassicalMusic(classicalMusic());
        //musicPlayer.setRockMusic(rockMusic());

        return musicPlayer;
    }
}
