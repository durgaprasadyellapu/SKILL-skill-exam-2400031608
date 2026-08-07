package com.klef.soa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.soa.entity.Scholarship;
import com.klef.soa.repository.ScholarshipRepository;

@Service
public class ScholarshipServiceImpl implements ScholarshipService
{
    @Autowired
    private ScholarshipRepository repo;

    @Override
    public Scholarship addScholarship(Scholarship s)
    {
        return repo.save(s);
    }

    @Override
    public Scholarship updateScholarship(Scholarship s)
    {
        Optional<Scholarship> optional = repo.findById(s.getScholarshipId());

        if(optional.isPresent())
        {
            Scholarship scholarship = optional.get();

            scholarship.setName(s.getName());
            scholarship.setType(s.getType());
            scholarship.setStatus(s.getStatus());
            scholarship.setLocation(s.getLocation());

            return repo.save(scholarship);
        }
        else
        {
            return null;
        }
    }

    @Override
    public List<Scholarship> displayAllScholarships()
    {
        return repo.findAll();
    }

    @Override
    public Scholarship displayScholarshipById(Long id)
    {
        return repo.findById(id).orElse(null);
    }

    @Override
    public String deleteScholarshipById(Long id)
    {
        boolean flag = repo.existsById(id);

        if(flag)
        {
            repo.deleteById(id);
            return "Scholarship Deleted Successfully";
        }
        else
        {
            return "Scholarship ID Not Found";
        }
    }

    @Override
    public List<Scholarship> displayScholarshipsByName(String name)
    {
        return repo.findByName(name);
    }

    @Override
    public List<Scholarship> displayScholarshipsByType(String type)
    {
        return repo.findByType(type);
    }

	@Override
	public Long ScholarshipCount() {
		
		return repo.count();
	}
}