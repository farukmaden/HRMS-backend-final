package javakamp.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javakamp.hrms.business.abstracts.WorkingTimeService;
import javakamp.hrms.core.utilities.results.DataResult;
import javakamp.hrms.core.utilities.results.Result;
import javakamp.hrms.core.utilities.results.SuccessDataResult;
import javakamp.hrms.core.utilities.results.SuccessResult;
import javakamp.hrms.dataAccess.abstracts.WorkingTimeDao;
import javakamp.hrms.entities.concretes.WorkingTime;
@Service
public class WorkingTimeManeger implements WorkingTimeService{

	private WorkingTimeDao workingTimeDao;
	@Autowired
	public WorkingTimeManeger(WorkingTimeDao workingTimeDao) {
		super();
		this.workingTimeDao = workingTimeDao;
	}

	@Override
	public Result add(WorkingTime workingTime) {
		this.workingTimeDao.save(workingTime);
		return new SuccessResult(true,"eleme başarılı");
	}

	@Override
	public DataResult<List<WorkingTime>> getAll() {
		return new SuccessDataResult<List<WorkingTime>>(this.workingTimeDao.findAll(),"data listelendi");
	}

}
