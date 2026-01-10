package com.jpa_flyway.repository;

import com.jpa_flyway.entity.University;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UniversityRepository extends JpaRepository<University,Long> {
//    @Query("select u from university u where u.name = :name")
    University findByName(String name);
}
