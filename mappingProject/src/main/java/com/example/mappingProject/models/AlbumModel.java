package com.example.mappingProject.models;

import com.example.mappingProject.entity.Songs;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AlbumModel {
    private int albumID;
    private String albumTitle;
    private String artist;
    private int numberOfTracks;
    private List<Songs> songsList=new ArrayList<>();

    public AlbumModel(String albumTitle, String artist,int numberOfTracks) {
        this.albumTitle = albumTitle;
        this.artist = artist;
        this.numberOfTracks = numberOfTracks;
    }

    @Override
    public String toString() {
        return "AlbumModel{" +
                "albumID=" + albumID +
                ", albumTitle='" + albumTitle + '\'' +
                ", artist='" + artist + '\'' +
                ", numberOfTracks=" + numberOfTracks +
                '}';
    }
}
