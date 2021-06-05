package javakamp.hrms.business.abstracts;

import java.util.List;

import javakamp.hrms.core.utilities.results.DataResult;
import javakamp.hrms.core.utilities.results.Result;
import javakamp.hrms.entities.concretes.ForeignLanguage;

public interface ForeignLanguageService {

	Result add (ForeignLanguage foreignLanguage);
	
	DataResult<List<ForeignLanguage>> getAll();
}
