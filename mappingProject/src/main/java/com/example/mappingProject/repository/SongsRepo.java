package com.example.mappingProject.repository;

import com.example.mappingProject.entity.Songs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongsRepo extends JpaRepository<Songs,Integer> {
}
