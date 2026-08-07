package com.klef.soa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.klef.soa.entity.Scholarship;
import com.klef.soa.service.ScholarshipService;

@RestController
@RequestMapping("/scholarship")
public class ScholarshipController
{
    @Autowired
    private ScholarshipService service;

    @GetMapping("/")
    public String demo()
    {
        return "Spring Boot Project";
    }

    // Add Scholarship
    @PostMapping("/add")
    public ResponseEntity<Scholarship> addScholarship(@RequestBody Scholarship s)
    {
        Scholarship scholarship = service.addScholarship(s);
        return ResponseEntity.status(201).body(scholarship);
    }

    // Display All Scholarships
    @GetMapping("/displayall")
    public ResponseEntity<List<Scholarship>> displayAllScholarships()
    {
        List<Scholarship> scholarships = service.displayAllScholarships();
        return ResponseEntity.status(200).body(scholarships);
    }

    // Display Scholarship By ID
    @GetMapping("/display")
    public ResponseEntity<?> displayScholarshipById(@RequestParam Long id)
    {
        Scholarship scholarship = service.displayScholarshipById(id);

        if (scholarship != null)
        {
            return ResponseEntity.status(200).body(scholarship);
        }
        else
        {
            return ResponseEntity.status(404).body("Scholarship ID Not Found");
        }
    }

    // Update Scholarship
    @PutMapping("/update")
    public ResponseEntity<?> updateScholarship(@RequestBody Scholarship scholarship)
    {
        Scholarship s = service.updateScholarship(scholarship);

        if (s != null)
        {
            return ResponseEntity.ok(s);
        }
        else
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Scholarship ID Not Found");
        }
    }

    // Delete Scholarship By ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteScholarshipById(@PathVariable Long id)
    {
        String message = service.deleteScholarshipById(id);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    // Display Scholarships By Name
    @GetMapping("/displaybyname/{name}")
    public ResponseEntity<List<Scholarship>> displayScholarshipsByName(@PathVariable String name)
    {
        List<Scholarship> scholarships = service.displayScholarshipsByName(name);
        return ResponseEntity.status(200).body(scholarships);
    }

    // Display Scholarships By Type
    @GetMapping("/displaybytype/{type}")
    public ResponseEntity<List<Scholarship>> displayScholarshipsByType(@PathVariable String type)
    {
        List<Scholarship> scholarships = service.displayScholarshipsByType(type);
        return ResponseEntity.status(200).body(scholarships);
    }
    @GetMapping("/count")
    public ResponseEntity<String> ScholarshipCount() {
     Long c=service.ScholarshipCount() ;
     
     String msg="Total Shholarships="+c;
     
     return ResponseEntity.ok(msg);
    }
    
    
}