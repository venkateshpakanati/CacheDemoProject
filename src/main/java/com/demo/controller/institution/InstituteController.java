package com.demo.controller.institution;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.domain.institution.Institution;
import com.demo.service.institution.InstitutionService;

@RestController
@RequestMapping(path = "/institutions")
public class InstituteController {

	@Autowired
    InstitutionService instituteService;
 
    @GetMapping(path = "")
    public List<Institution> getAllInstitutions()  {        
        return instituteService.getAllInstitutions();
    }
    
    @GetMapping(path = "/{id}")
	public Optional<Institution> findInstituteById(@PathVariable int id) {
	    System.out.println("Searching by ID  : " + id);
	    return instituteService.findInstituteById(id); 
	}
    
    @PostMapping(path = "/add")
	public Institution addInstitute(@RequestBody Institution institute) {
    	return instituteService.addInstitute(institute);
	}
    
    @GetMapping(path = "/delete/{id}")
	public void deleteInstituteById(@PathVariable int id) {
    	instituteService.deleteInstituteById(id);
    }
	 
}
