package com.abhi.freecode.controller;

import com.abhi.freecode.dto.SchoolRequest;
import com.abhi.freecode.dto.SchoolResponse;
import com.abhi.freecode.entity.School;
import com.abhi.freecode.service.SchoolService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schools/")
public class SchoolController {
    private final SchoolService schoolService;

    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @GetMapping()
    public List<SchoolResponse> getAll() {
        return this.schoolService.getSchools();
    }

    @GetMapping("{id}")
    public SchoolResponse get(@PathVariable("id") Integer id) {
        return this.schoolService.getSchool(id);
    }

    @PostMapping()
    public SchoolResponse post(@RequestBody SchoolRequest schoolRequest) {
        return this.schoolService.saveSchool(schoolRequest);
    }

    @PutMapping("{id}")
    public SchoolResponse update(@PathVariable("id") Integer id, @RequestBody SchoolRequest schoolRequest) {
        return this.schoolService.updateSchool(id, schoolRequest);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Integer id) {
        this.schoolService.deleteSchool(id);
    }
}
