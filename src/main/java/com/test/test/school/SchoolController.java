package com.test.test.school;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class SchoolController {

    private final SchoolService schoolService;

    @PostMapping("/school")
    public SchoolDto create(@RequestBody SchoolDto SchoolDto){
        return schoolService.createSchool(SchoolDto);
    }






    @GetMapping("/school")
    public List<SchoolDto> findAll(){

        return schoolService.findAll();


    }

}
