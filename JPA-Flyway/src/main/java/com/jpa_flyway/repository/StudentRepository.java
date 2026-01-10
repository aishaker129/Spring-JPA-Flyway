package com.jpa_flyway.repository;

import com.jpa_flyway.entity.Student;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    Optional<Student> findByUniversityId(Long universityId);

    Optional<Student> findById(Long id);
}
