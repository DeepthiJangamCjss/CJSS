package com.example.mappingProject.models;

import com.example.mappingProject.entity.Songs;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SongDetailsModel {
    private int songDetailsId;
    private String genre;
    private String duration;
    private Songs song;

    @Override
    public String toString() {
        return "SongDetailsModel{" +
                "songDetailsId=" + songDetailsId +
                ", genre='" + genre + '\'' +
                ", duration='" + duration + '\'' +
                '}';
    }
}
