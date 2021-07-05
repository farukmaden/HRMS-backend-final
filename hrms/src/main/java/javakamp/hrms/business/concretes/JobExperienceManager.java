package javakamp.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javakamp.hrms.business.abstracts.JobExperienceService;
import javakamp.hrms.core.utilities.results.DataResult;
import javakamp.hrms.core.utilities.results.Result;
import javakamp.hrms.core.utilities.results.SuccessDataResult;
import javakamp.hrms.core.utilities.results.SuccessResult;
import javakamp.hrms.dataAccess.abstracts.CurriculumVitaeDao;
import javakamp.hrms.dataAccess.abstracts.JobExperienceDao;
import javakamp.hrms.entities.concretes.JobExperience;
import javakamp.hrms.entities.dtos.JobExperienceWithCvDto;
@Service
public class JobExperienceManager implements JobExperienceService{

	private JobExperienceDao jobExperienceDao;
	private CurriculumVitaeDao curriculumVitaeDao;

	@Autowired
	public JobExperienceManager(JobExperienceDao jobExperienceDao, CurriculumVitaeDao curriculumVitaeDao) {
		super();
		this.jobExperienceDao = jobExperienceDao;
		this.curriculumVitaeDao = curriculumVitaeDao;
	}

	@Override
	public Result add(JobExperienceWithCvDto jobExperienceWithCvDto) {
		JobExperience jobExperience = new JobExperience();
		jobExperience.setWorkplaceName(jobExperienceWithCvDto.getWorkplaceName());
		jobExperience.setJobPosition(jobExperienceWithCvDto.getJobPosition());
		jobExperience.setStartYear(jobExperienceWithCvDto.getStartYear());
		jobExperience.setEndYear(jobExperienceWithCvDto.getEndYear());
		jobExperience.setCurriculumVitae(this.curriculumVitaeDao.getOne(jobExperienceWithCvDto.getCurriculumVitaeId()));
		this.jobExperienceDao.save(jobExperience);
		return new SuccessResult(true,"ekleme başarılı");
	}

	@Override
	public DataResult<List<JobExperience>> getAll() {
		return new SuccessDataResult<List<JobExperience>>(this.jobExperienceDao.findAll(),"data listelendi");
	}

	@Override
	public DataResult<List<JobExperience>> findByAllCurriculumVitaeIdOrderByEndYearDesc(int id) {
		return new SuccessDataResult<List<JobExperience>>(this.jobExperienceDao.findAllByCurriculumVitaeIdOrderByEndYearDesc(id),"data listelendi");
	}

	@Override
	public Result update(JobExperienceWithCvDto jobExperienceWithCvDto) {
		JobExperience jobExperience = new JobExperience();
		jobExperience.setWorkplaceName(jobExperienceWithCvDto.getWorkplaceName());
		jobExperience.setJobPosition(jobExperienceWithCvDto.getJobPosition());
		jobExperience.setStartYear(jobExperienceWithCvDto.getStartYear());
		jobExperience.setEndYear(jobExperienceWithCvDto.getEndYear());
		jobExperience.setCurriculumVitae(this.curriculumVitaeDao.getOne(jobExperienceWithCvDto.getCurriculumVitaeId()));
		jobExperience.setId(jobExperienceWithCvDto.getExparianceId());
		this.jobExperienceDao.save(jobExperience);
		return new SuccessResult(true,"güncelleme başarılı");
	}


}
