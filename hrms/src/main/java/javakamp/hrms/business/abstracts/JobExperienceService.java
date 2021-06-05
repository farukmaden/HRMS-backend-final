package javakamp.hrms.business.abstracts;

import java.util.List;

import javakamp.hrms.core.utilities.results.DataResult;
import javakamp.hrms.core.utilities.results.Result;
import javakamp.hrms.entities.concretes.JobExperience;

public interface JobExperienceService {

	Result add (JobExperience jobExperience);
	
	DataResult<List<JobExperience>> getAll();
	
	
	DataResult<List<JobExperience>> findByAllCurriculumVitaeIdOrderByEndYearDesc(int id);
}
