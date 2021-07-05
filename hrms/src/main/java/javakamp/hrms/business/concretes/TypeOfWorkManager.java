package javakamp.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javakamp.hrms.business.abstracts.TypeOfWorkService;
import javakamp.hrms.core.utilities.results.DataResult;
import javakamp.hrms.core.utilities.results.Result;
import javakamp.hrms.core.utilities.results.SuccessDataResult;
import javakamp.hrms.core.utilities.results.SuccessResult;
import javakamp.hrms.dataAccess.abstracts.TypeOfWorkDao;
import javakamp.hrms.entities.concretes.TypeOfWork;
@Service
public class TypeOfWorkManager implements TypeOfWorkService{
	
	private TypeOfWorkDao typeOfWorkDao;

	@Autowired
	public TypeOfWorkManager(TypeOfWorkDao typeOfWorkDao) {
		super();
		this.typeOfWorkDao = typeOfWorkDao;
	}

	@Override
	public Result add(TypeOfWork typeOfWork) {
		this.typeOfWorkDao.save(typeOfWork);
		return new SuccessResult(true,"ekeleme başarılı");
	}

	@Override
	public DataResult<List<TypeOfWork>> getAll() {
		return new SuccessDataResult<List<TypeOfWork>>(this.typeOfWorkDao.findAll(),"data listelendi");
	}

}
