package com.abhi.freecode.mapper;

import com.abhi.freecode.dto.SchoolRequest;
import com.abhi.freecode.dto.SchoolResponse;
import com.abhi.freecode.entity.School;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class SchoolMapper {

    public static SchoolResponse toSchoolResponse(School school) {
        return new SchoolResponse(school.getId(), school.getName());
    }

    public static School toSchoolEntity(SchoolResponse schoolResponse) {
        return new School(schoolResponse.name());
    }

    public static School toSchoolEntity(SchoolRequest schoolRequest) {
        return new School(schoolRequest.name());
    }
}
