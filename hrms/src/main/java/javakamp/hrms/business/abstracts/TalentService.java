package javakamp.hrms.business.abstracts;

import java.util.List;

import javakamp.hrms.core.utilities.results.DataResult;
import javakamp.hrms.core.utilities.results.Result;
import javakamp.hrms.entities.concretes.Talent;
import javakamp.hrms.entities.dtos.TalentWithCvDto;

public interface TalentService {

	Result add (TalentWithCvDto talentWithCvDto);
	Result update (TalentWithCvDto talentWithCvDto);
	
	DataResult<List<Talent>> getAll();
}
