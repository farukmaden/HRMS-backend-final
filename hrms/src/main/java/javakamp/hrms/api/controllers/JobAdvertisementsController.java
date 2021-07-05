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

import javakamp.hrms.business.abstracts.JobAdvertisementsService;
import javakamp.hrms.core.utilities.results.DataResult;
import javakamp.hrms.core.utilities.results.Result;
import javakamp.hrms.entities.concretes.JobAdvertisement;
import javakamp.hrms.entities.dtos.JobAdvDto;

@RestController
@RequestMapping("/api/jobAdvertisements")
@CrossOrigin
public class JobAdvertisementsController {

	private JobAdvertisementsService jobAdvertisementsService;

	@Autowired
	public JobAdvertisementsController(JobAdvertisementsService jobAdvertisementsService) {
		super();
		this.jobAdvertisementsService = jobAdvertisementsService;
	}

	@GetMapping("/getall")
	public DataResult<List<JobAdvertisement>> getAll() {
		return this.jobAdvertisementsService.getAll();
	}

	@PostMapping("/add")
	public Result add(@RequestBody JobAdvDto jobAdvDto) {
		return this.jobAdvertisementsService.add(jobAdvDto);
	}

	@GetMapping("/getByIsActiveTrue")
	public DataResult<List<JobAdvertisement>> getByIsActiveTrue() {
		return this.jobAdvertisementsService.getByIsActiveTrue();
	}

	@GetMapping("/getByIsActiveTrueAndEmployerId")
	public DataResult<List<JobAdvertisement>> getByIsActiveAndEmployerId(@RequestParam int id) {
		return this.jobAdvertisementsService.getByIsActiveTrueAndEmployer_id(id);
	}

	@PutMapping("/getupdate")
	public DataResult<JobAdvertisement> getUpdate(int id) {
		return this.jobAdvertisementsService.getUpdate(id);
	}

	@GetMapping("/getByIsActiveTrueOrderByApplicationDeadline")
	public DataResult<List<JobAdvertisement>> getByIsActiveTrueOrderByApplicationDeadline() {
		return this.jobAdvertisementsService.getByIsActiveTrueOrderByApplicationDeadline();
	}

	@GetMapping("getAllFilterCityAndTypeOfWorking")
	public DataResult<List<JobAdvertisement>> getAllByCityIdAndTypeOfWorkId(int cityId, int typeOfWorkId, int pageNo,
			int pageSize) {
		return this.jobAdvertisementsService.getAllByCityIdAndTypeOfWorkId(cityId, typeOfWorkId, pageNo, pageSize);
	}
	@GetMapping("/getAllFilterCityId")
	public DataResult<List<JobAdvertisement>> getAllByCityId(int cityId, int pageNo, int pageSize){
		return this.jobAdvertisementsService.getAllByCityId(cityId, pageNo, pageSize);
	}
	@GetMapping("/getAllFilterTypeOfWorkId")
	public DataResult<List<JobAdvertisement>> getAllByTypeOfWorkId(int typeOfWorkId, int pageNo, int pageSize){
		return this.jobAdvertisementsService.getAllByTypeOfWorkId(typeOfWorkId, pageNo, pageSize);
	}
	
	@GetMapping("/getAllIsActiveTruePageable")
	public DataResult<List<JobAdvertisement>> getByIsActiveTrue(int pageNo,int pageSize){
		return this.jobAdvertisementsService.getByIsActiveTrue(pageNo, pageSize);
	}
}
