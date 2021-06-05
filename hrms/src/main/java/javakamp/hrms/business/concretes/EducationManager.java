package javakamp.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javakamp.hrms.business.abstracts.EducationService;
import javakamp.hrms.core.utilities.results.DataResult;
import javakamp.hrms.core.utilities.results.Result;
import javakamp.hrms.core.utilities.results.SuccessDataResult;
import javakamp.hrms.core.utilities.results.SuccessResult;
import javakamp.hrms.dataAccess.abstracts.EducationDao;
import javakamp.hrms.entities.concretes.Education;
@Service
public class EducationManager implements EducationService{

	private EducationDao educationDao;
	@Autowired
	public EducationManager(EducationDao educationDao) {
		super();
		this.educationDao = educationDao;
	}

	@Override
	public Result add(Education education) {
		this.educationDao.save(education);
		return new SuccessResult(true,"ekleme işlemi başarılı");
	}

	@Override
	public DataResult<List<Education>> getAll() {
		return new SuccessDataResult<List<Education>>(this.educationDao.findAll(),"data listelendı");
	}

	@Override
	public DataResult<List<Education>> findAllByCurriculumVitaeIdOrderByEndYearDesc(int id) {
		return new SuccessDataResult<List<Education>>(this.educationDao.findAllByCurriculumVitaeIdOrderByEndYearDesc(id));
	}

}
