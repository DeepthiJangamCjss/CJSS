package com.example.mappingProject.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.mappingProject.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,Integer>{
}
