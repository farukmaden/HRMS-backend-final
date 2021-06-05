package javakamp.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javakamp.hrms.business.abstracts.TalentService;
import javakamp.hrms.core.utilities.results.DataResult;
import javakamp.hrms.core.utilities.results.Result;
import javakamp.hrms.entities.concretes.Talent;

@RestController
@RequestMapping("/api/talent")
public class TalentController {

	private TalentService talentService;

	@Autowired
	public TalentController(TalentService talentService) {
		super();
		this.talentService = talentService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<Talent>> getAll(){
		return this.talentService.getAll();
	}
	@PostMapping("/add")
	public Result add (@RequestBody Talent talent) {
		return this.talentService.add(talent);
	}
}
