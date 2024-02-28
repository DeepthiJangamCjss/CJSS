package com.example.mappingProject.repository;

import com.example.mappingProject.entity.PlayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayListRepo extends JpaRepository<PlayList,Integer> {
}
