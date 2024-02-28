package com.example.mappingProject.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class SongDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int songDetailsId;
    private String genre;
    private String duration;
    @OneToOne(mappedBy = "songDetails")
    @JsonBackReference
    private Songs songs;

    @Override
    public String toString() {
        return "SongDetails{" +
                "songDetailsId=" + songDetailsId +
                ", genre='" + genre + '\'' +
                ", duration='" + duration + '\'' +
                '}';
    }
}
