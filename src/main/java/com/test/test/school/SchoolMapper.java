package com.test.test.school;

import org.springframework.stereotype.Service;

@Service
public class SchoolMapper {

    public SchoolModel toSchoolModel(SchoolDto SchoolDto){

        var schoolModel = new SchoolModel();
        schoolModel.setName(SchoolDto.name());

        return schoolModel;


    }

    public SchoolDto toSclDto(SchoolModel scModel){
        return new SchoolDto(scModel.getName());

    }
}
