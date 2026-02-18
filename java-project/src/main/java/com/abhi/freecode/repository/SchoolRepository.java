package com.abhi.freecode.repository;

import com.abhi.freecode.entity.School;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolRepository extends JpaRepository<School, Integer> {
}
