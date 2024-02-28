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
public class PlayList {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int playListId;
    private String playListName;
    private String description;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Songs> songsList=new ArrayList<>();

    @ManyToOne()
    @JoinColumn(name="user_id")
    private User user;

    @Override
    public String toString() {
        return "PlayList{" +
                "playListId=" + playListId +
                ", playListName='" + playListName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
