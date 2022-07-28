package com.bosonit.sa2.file.infraestructure.repository;

import com.bosonit.sa2.file.domain.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegisterStorageRepository extends JpaRepository<File, Long> {
    List<File> findByName(String name);
}