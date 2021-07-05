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

import javakamp.hrms.business.abstracts.ForeignLanguageService;
import javakamp.hrms.core.utilities.results.DataResult;
import javakamp.hrms.core.utilities.results.Result;
import javakamp.hrms.entities.concretes.ForeignLanguage;
import javakamp.hrms.entities.dtos.ForeignLanguageWithCvDto;

@RestController
@RequestMapping("/api/foreignLanguage")
@CrossOrigin
public class ForeignLanguageController {
	
	private ForeignLanguageService foreignLanguageService;

	@Autowired
	public ForeignLanguageController(ForeignLanguageService foreignLanguageService) {
		super();
		this.foreignLanguageService = foreignLanguageService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<ForeignLanguage>> getAll(){
		return this.foreignLanguageService.getAll();
	}
	
	@PostMapping("/add")
	public Result add (@RequestBody ForeignLanguageWithCvDto foreignLanguageWithCvDto) {
		return this.foreignLanguageService.add(foreignLanguageWithCvDto);
	}
	@PutMapping("/update")
	public Result update(@RequestBody ForeignLanguageWithCvDto foreignLanguageWithCvDto) {
		return this.foreignLanguageService.update(foreignLanguageWithCvDto);
	}
	

}
