package javakamp.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javakamp.hrms.business.abstracts.CurriculumVitaeService;
import javakamp.hrms.core.utilities.results.DataResult;
import javakamp.hrms.core.utilities.results.Result;
import javakamp.hrms.entities.concretes.CurriculumVitae;
import javakamp.hrms.entities.dtos.CurriculumVitaeDto;

@RestController
@RequestMapping("/api/curriculumVitae")
@CrossOrigin
public class CurriculumVitaeController {

	private CurriculumVitaeService curriculumVitaeService;

	@Autowired
	public CurriculumVitaeController(CurriculumVitaeService curriculumVitaeService) {
		super();
		this.curriculumVitaeService = curriculumVitaeService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<CurriculumVitae>> getAll(){
		return this.curriculumVitaeService.getAll();
	}
	
	@PostMapping("/add")
	public Result add (@RequestBody CurriculumVitaeDto curriculumVitaeDto) {
		return this.curriculumVitaeService.add(curriculumVitaeDto);
	}
	
	@PostMapping("/addPhoto")
	public Result addPhoto (@RequestBody MultipartFile multipartFile , @RequestParam int cvId) {
		return this.curriculumVitaeService.addPhoto(multipartFile, cvId);
	}
	@GetMapping("/findAllCandidateId")
	public DataResult<List<CurriculumVitae>> findAllCandidateId(int candidateId){
		return this.curriculumVitaeService.findAllCandidateId(candidateId);
	}
	@PutMapping("/update")
	public Result update (@RequestBody CurriculumVitaeDto curriculumVitaeDto) {
		return this.curriculumVitaeService.update(curriculumVitaeDto);
	}
	
}
