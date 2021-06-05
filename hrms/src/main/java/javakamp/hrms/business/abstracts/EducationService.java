package javakamp.hrms.business.abstracts;

import java.util.List;

import javakamp.hrms.core.utilities.results.DataResult;
import javakamp.hrms.core.utilities.results.Result;
import javakamp.hrms.entities.concretes.Education;

public interface EducationService {

	Result add (Education education);
	
	DataResult<List<Education>> getAll();
	DataResult<List<Education>> findAllByCurriculumVitaeIdOrderByEndYearDesc(int id);
}
