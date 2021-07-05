package javakamp.hrms.business.abstracts;

import java.util.List;

import javakamp.hrms.core.utilities.results.DataResult;
import javakamp.hrms.core.utilities.results.Result;
import javakamp.hrms.entities.concretes.JobExperience;
import javakamp.hrms.entities.dtos.JobExperienceWithCvDto;

public interface JobExperienceService {

	Result add (JobExperienceWithCvDto jobExperienceWithCvDto);
	Result update (JobExperienceWithCvDto jobExperienceWithCvDto);
	DataResult<List<JobExperience>> getAll();
	
	
	DataResult<List<JobExperience>> findByAllCurriculumVitaeIdOrderByEndYearDesc(int id);
}
