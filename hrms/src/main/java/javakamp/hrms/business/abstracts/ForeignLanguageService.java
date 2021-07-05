package javakamp.hrms.business.abstracts;

import java.util.List;

import javakamp.hrms.core.utilities.results.DataResult;
import javakamp.hrms.core.utilities.results.Result;
import javakamp.hrms.entities.concretes.ForeignLanguage;
import javakamp.hrms.entities.dtos.ForeignLanguageWithCvDto;

public interface ForeignLanguageService {

	Result add (ForeignLanguageWithCvDto foreignLanguageWithCvDto);
	Result update (ForeignLanguageWithCvDto foreignLanguageWithCvDto);
	
	DataResult<List<ForeignLanguage>> getAll();
}
