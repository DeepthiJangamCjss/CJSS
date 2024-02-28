package com.example.mappingProject.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Album {
    @Id
    @GeneratedValue
    private int albumID;
    private String albumTitle;
    private String artist;
    private int numberOfTracks;

    @OneToMany(mappedBy = "album",cascade = CascadeType.ALL)
    private List<Songs> songsList=new ArrayList<>();

    public Album(String albumTitle, String artist,int numberOfTracks) {
        this.albumTitle = albumTitle;
        this.artist = artist;
        this.numberOfTracks = numberOfTracks;
    }

    @Override
    public String toString() {
        return "Album{" +
                "albumID=" + albumID +
                ", albumTitle='" + albumTitle + '\'' +
                ", artist='" + artist + '\'' +
                ", numberOfTracks=" + numberOfTracks +
                '}';
    }
}
