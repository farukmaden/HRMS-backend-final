package javakamp.hrms.business.abstracts;

import java.util.List;

import javakamp.hrms.core.utilities.results.DataResult;
import javakamp.hrms.core.utilities.results.Result;
import javakamp.hrms.entities.concretes.Talent;

public interface TalentService {

	Result add (Talent talent);
	
	DataResult<List<Talent>> getAll();
}
