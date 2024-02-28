package com.example.mappingProject.models;

import com.example.mappingProject.entity.Songs;
import com.example.mappingProject.entity.User;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PlayListModel {
    private int playListId;
    private String playListName;
    private String description;
    private List<Songs> songsList=new ArrayList<>();
    private User user;

    @Override
    public String toString() {
        return "PlayListModel{" +
                "playListId=" + playListId +
                ", playListName='" + playListName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
