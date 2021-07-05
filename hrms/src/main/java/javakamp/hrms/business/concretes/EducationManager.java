package javakamp.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javakamp.hrms.business.abstracts.EducationService;
import javakamp.hrms.core.utilities.results.DataResult;
import javakamp.hrms.core.utilities.results.Result;
import javakamp.hrms.core.utilities.results.SuccessDataResult;
import javakamp.hrms.core.utilities.results.SuccessResult;
import javakamp.hrms.dataAccess.abstracts.CurriculumVitaeDao;
import javakamp.hrms.dataAccess.abstracts.EducationDao;
import javakamp.hrms.entities.concretes.Education;
import javakamp.hrms.entities.dtos.EducationWithCvDto;
@Service
public class EducationManager implements EducationService{

	private EducationDao educationDao;
	private CurriculumVitaeDao curriculumVitaeDao;
	
	@Autowired
	public EducationManager(EducationDao educationDao,CurriculumVitaeDao curriculumVitaeDao) {
		super();
		this.educationDao = educationDao;
		this.curriculumVitaeDao = curriculumVitaeDao;
	}

	

	@Override
	public Result add(EducationWithCvDto educationWithCvDto) {
		Education education = new Education();
		education.setSchoolName(educationWithCvDto.getSchoolName());
		education.setSchoolDepartment(educationWithCvDto.getSchoolDepartment());
		education.setStartYear(educationWithCvDto.getStartYear());
		education.setEndYear(educationWithCvDto.getEndYear());
		education.setCurriculumVitae(this.curriculumVitaeDao.getOne(educationWithCvDto.getCurriculumVitaeId()));
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



	@Override
	public Result update(EducationWithCvDto educationWithCvDto) {
		Education education = new Education();
		education.setSchoolName(educationWithCvDto.getSchoolName());
		education.setSchoolDepartment(educationWithCvDto.getSchoolDepartment());
		education.setStartYear(educationWithCvDto.getStartYear());
		education.setEndYear(educationWithCvDto.getEndYear());
		education.setCurriculumVitae(this.curriculumVitaeDao.getOne(educationWithCvDto.getCurriculumVitaeId()));
		education.setId(educationWithCvDto.getEducationId());
		this.educationDao.save(education);
		return new SuccessResult(true,"güncelleme başarılı");
	}

}
