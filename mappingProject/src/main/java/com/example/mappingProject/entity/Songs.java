package com.example.mappingProject.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Songs {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int songId;
    private String title;

    @OneToOne(cascade = CascadeType.ALL)
    @JsonManagedReference
    private SongDetails songDetails;

    @ManyToOne
    @JoinColumn(name="album_id")
    private Album album;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinTable(name="songs_List",joinColumns = @JoinColumn(name="song_id"),
            inverseJoinColumns = @JoinColumn(name="playList_id"))
    private List<PlayList> playList=new ArrayList<>();

    @Override
    public String toString() {
        return "Songs{" +
                "songId=" + songId +
                ", title='" + title + '\'' +
                ", songDetails=" + songDetails +
                ", album=" + album +
                '}';
    }
}
