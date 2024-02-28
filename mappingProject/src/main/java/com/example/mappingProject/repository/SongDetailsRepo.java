package com.example.mappingProject.repository;

import com.example.mappingProject.entity.SongDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongDetailsRepo extends JpaRepository<SongDetails, Integer> {
}
