package com.abhi.freecode.controller;

import com.abhi.freecode.dto.SchoolDto;
import com.abhi.freecode.entity.School;
import com.abhi.freecode.service.SchoolService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schools")
public class SchoolController {
    private final SchoolService schoolService;

    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }
    @GetMapping()
    public List<School> getSchool(){
        return this.schoolService.getSchool();
    }

    @PostMapping("/school")
    public SchoolDto postSchool(@RequestBody SchoolDto dto) {

        this.schoolService.saveSchool(dto);
        return dto;
    }
}
