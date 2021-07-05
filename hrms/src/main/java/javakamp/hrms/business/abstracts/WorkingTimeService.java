package javakamp.hrms.business.abstracts;

import java.util.List;

import javakamp.hrms.core.utilities.results.DataResult;
import javakamp.hrms.core.utilities.results.Result;
import javakamp.hrms.entities.concretes.WorkingTime;

public interface WorkingTimeService {

	Result add (WorkingTime workingTime);
	DataResult<List<WorkingTime>> getAll();
}
