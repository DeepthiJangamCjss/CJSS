package com.example.mappingProject.models;

import com.example.mappingProject.entity.Album;
import com.example.mappingProject.entity.PlayList;
import com.example.mappingProject.entity.SongDetails;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SongsModel {
    private int songId;
    private String title;

    private SongDetails songDetails;
    private Album album;
    private List<PlayList> playLists=new ArrayList<>();

    @Override
    public String toString() {
        return "SongsModel{" +
                "songId=" + songId +
                ", title='" + title + '\'' +
                '}';
    }
}
