package javakamp.hrms.business.abstracts;

import java.util.List;

import javakamp.hrms.core.utilities.results.DataResult;
import javakamp.hrms.core.utilities.results.Result;
import javakamp.hrms.entities.concretes.TypeOfWork;

public interface TypeOfWorkService {

	Result add (TypeOfWork typeOfWork);
	DataResult<List<TypeOfWork>> getAll();
}
