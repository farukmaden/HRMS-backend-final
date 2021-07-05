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

import javakamp.hrms.business.abstracts.JobExperienceService;
import javakamp.hrms.core.utilities.results.DataResult;
import javakamp.hrms.core.utilities.results.Result;
import javakamp.hrms.entities.concretes.JobExperience;
import javakamp.hrms.entities.dtos.JobExperienceWithCvDto;

@RestController
@RequestMapping("/api/jobExperience")
@CrossOrigin
public class JobExperienceController {

	private JobExperienceService jobExperienceService;

	@Autowired
	public JobExperienceController(JobExperienceService jobExperienceService) {
		super();
		this.jobExperienceService = jobExperienceService;
	}
	@GetMapping("/getAll")
	public DataResult<List<JobExperience>> getAll(){
		return this.jobExperienceService.getAll();
	}
	
	@PostMapping("/add")
	public Result add (@RequestBody JobExperienceWithCvDto jobExperience) {
		return this.jobExperienceService.add(jobExperience);
	}

	@GetMapping("/getByEndYear")
	public DataResult<List<JobExperience>> findByAllCurriculumVitaeIdOrderByEndYearDesc(int id){
		return this.jobExperienceService.findByAllCurriculumVitaeIdOrderByEndYearDesc(id);
	}
	@PutMapping("/update")
	public Result update(@RequestBody JobExperienceWithCvDto jobExperienceWithCvDto) {
		return this.jobExperienceService.update(jobExperienceWithCvDto);
	}
}