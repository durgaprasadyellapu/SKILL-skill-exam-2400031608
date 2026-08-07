package com.klef.soa.service;

import java.util.List;
import com.klef.soa.entity.Scholarship;

public interface ScholarshipService
{
    Scholarship addScholarship(Scholarship s);

    Scholarship updateScholarship(Scholarship s);

    List<Scholarship> displayAllScholarships();

    Scholarship displayScholarshipById(Long id);

    String deleteScholarshipById(Long id);

    List<Scholarship> displayScholarshipsByName(String name);

    List<Scholarship> displayScholarshipsByType(String type);
    
    Long ScholarshipCount();
}