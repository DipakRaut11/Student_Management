package com.test.test.school;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class SchoolService {
    private final SchoolRepository schoolRepository;
    private final SchoolMapper schoolMapper;

    public SchoolDto createSchool(SchoolDto SchoolDto) {

        var school = schoolMapper.toSchoolModel(SchoolDto);

        schoolRepository.save(school);

        return SchoolDto;
    }


    public List<SchoolDto> findAll(){

        return schoolRepository.findAll()
                .stream()
                .map(schoolMapper::toSclDto)
                .collect(Collectors.toList());

    }


}
