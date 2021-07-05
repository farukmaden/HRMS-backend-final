package javakamp.hrms.business.abstracts;

import java.util.List;

import javakamp.hrms.core.utilities.results.DataResult;
import javakamp.hrms.core.utilities.results.Result;
import javakamp.hrms.entities.concretes.Education;
import javakamp.hrms.entities.dtos.EducationWithCvDto;

public interface EducationService {

	Result add (EducationWithCvDto educationWithCvDto);
	Result update (EducationWithCvDto educationWithCvDto);
	
	DataResult<List<Education>> getAll();
	DataResult<List<Education>> findAllByCurriculumVitaeIdOrderByEndYearDesc(int id);
}
