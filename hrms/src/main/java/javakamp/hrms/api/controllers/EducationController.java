package javakamp.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javakamp.hrms.business.abstracts.EducationService;
import javakamp.hrms.core.utilities.results.DataResult;
import javakamp.hrms.core.utilities.results.Result;
import javakamp.hrms.entities.concretes.Education;
import javakamp.hrms.entities.dtos.EducationWithCvDto;

@RestController
@RequestMapping("*api/education")
@CrossOrigin
public class EducationController {

	private EducationService educationService;

	@Autowired
	public EducationController(EducationService educationService) {
		super();
		this.educationService = educationService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<Education>> getAll(){
		return this.educationService.getAll();
	}
	
	@PostMapping("/add")
	public Result add (@RequestBody EducationWithCvDto educationWithCvDto) {
		return this.educationService.add(educationWithCvDto);
	}
	
	@GetMapping("/getByEndYear")
	public DataResult<List<Education>> findAllByCurriculumVitaeIdOrderByEndYearDesc(int id){
		return this.educationService.findAllByCurriculumVitaeIdOrderByEndYearDesc(id);
	}
	@PutMapping("/update")
	public Result update(@RequestBody EducationWithCvDto educationWithCvDto) {
		return this.educationService.update(educationWithCvDto);
	}
}
