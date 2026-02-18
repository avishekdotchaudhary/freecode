package com.abhi.freecode.service;

import com.abhi.freecode.dto.SchoolDto;
import com.abhi.freecode.entity.School;
import com.abhi.freecode.repository.SchoolRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolService {
    private final SchoolRepository schoolRepository;

    public SchoolService(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

    public List<School> getSchool() {
        return schoolRepository.findAll();
    }

    public School saveSchool(SchoolDto school) {
        var schoolEntity = mapToEntity(school);
        return schoolRepository.save(schoolEntity);
    }

    private School mapToEntity(SchoolDto dto) {
        return new School(dto.name());
    }

    //Make all code using dtos.
    //Student mapper 5:27:41
    //School mapper 5:41:32
}
