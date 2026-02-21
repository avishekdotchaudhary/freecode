package com.abhi.freecode.service;

import com.abhi.freecode.dto.SchoolRequest;
import com.abhi.freecode.dto.SchoolResponse;
import com.abhi.freecode.entity.School;
import com.abhi.freecode.mapper.SchoolMapper;
import com.abhi.freecode.repository.SchoolRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolService {
    private final SchoolRepository schoolRepository;

    public SchoolService(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

    public List<SchoolResponse> getSchools() {
        var schools = this.schoolRepository.findAll();
        return schools.stream().map(SchoolMapper::toSchoolResponse).toList();
    }

    public SchoolResponse getSchool(Integer id){
        var school = schoolRepository.findById(id).orElseThrow(() -> new RuntimeException("School not found"));
        return SchoolMapper.toSchoolResponse(school);
    }

    public SchoolResponse saveSchool(SchoolRequest school) {
        var schoolEntity = SchoolMapper.toSchoolEntity(school);
        return SchoolMapper.toSchoolResponse(schoolRepository.save(schoolEntity));
    }

    public SchoolResponse updateSchool(Integer id, SchoolRequest schoolRequest){
        var school = this.getSchool(id);
        var updatedSchool = School.builder()
                .id(school.id())
                .name(!schoolRequest.name().isEmpty() ? schoolRequest.name() : school.name())
                .build();
        return SchoolMapper.toSchoolResponse(this.schoolRepository.save(updatedSchool));
    }

    public void deleteSchool(Integer id){
        this.schoolRepository.deleteById(id);
    }

//    private School mapToEntity(SchoolRequest dto) {
//        return new School(dto.name());
//    }

    //Make all code using dtos.
    //Student mapper 5:27:41
    //School mapper 5:41:32
}
