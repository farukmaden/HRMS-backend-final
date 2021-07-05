package javakamp.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javakamp.hrms.business.abstracts.TypeOfWorkService;
import javakamp.hrms.core.utilities.results.DataResult;
import javakamp.hrms.core.utilities.results.Result;
import javakamp.hrms.entities.concretes.TypeOfWork;

@RestController
@RequestMapping("/api/typeOfWork")
@CrossOrigin
public class TypeOfWorkController {

	private TypeOfWorkService typeOfWorkService;

	@Autowired
	public TypeOfWorkController(TypeOfWorkService typeOfWorkService) {
		super();
		this.typeOfWorkService = typeOfWorkService;
	}
	@PostMapping("/add")
	public Result add (@RequestBody TypeOfWork typeOfWork) {
		return this.typeOfWorkService.add(typeOfWork);
	}
	
	@GetMapping("/getAll")
	public DataResult<List<TypeOfWork>> getAll(){
		return this.typeOfWorkService.getAll();
	}
}
