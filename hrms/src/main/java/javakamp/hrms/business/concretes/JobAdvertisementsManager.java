package javakamp.hrms.business.concretes;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javakamp.hrms.business.abstracts.JobAdvertisementsService;
import javakamp.hrms.core.utilities.results.DataResult;
import javakamp.hrms.core.utilities.results.Result;
import javakamp.hrms.core.utilities.results.SuccessDataResult;
import javakamp.hrms.core.utilities.results.SuccessResult;
import javakamp.hrms.dataAccess.abstracts.CityDao;
import javakamp.hrms.dataAccess.abstracts.EmployersDao;
import javakamp.hrms.dataAccess.abstracts.JobAdvertisementsDao;
import javakamp.hrms.dataAccess.abstracts.JobTitlesDao;
import javakamp.hrms.dataAccess.abstracts.TypeOfWorkDao;
import javakamp.hrms.dataAccess.abstracts.WorkingTimeDao;
import javakamp.hrms.entities.concretes.JobAdvertisement;
import javakamp.hrms.entities.dtos.JobAdvDto;
@Service
public class JobAdvertisementsManager implements JobAdvertisementsService {

	private JobAdvertisementsDao jobAdvertisementsDao;
	private CityDao cityDao;
	private TypeOfWorkDao typeOfWork;
	private WorkingTimeDao workingTimeDao;
	private JobTitlesDao jobTitleDao;
	private EmployersDao employerDao;
	
	@Autowired
	public JobAdvertisementsManager(JobAdvertisementsDao jobAdvertisementsDao, CityDao cityDao,
			TypeOfWorkDao typeOfWork, WorkingTimeDao workingTimeDao, JobTitlesDao jobTitleDao,EmployersDao employerDao) {
		super();
		this.jobAdvertisementsDao = jobAdvertisementsDao;
		this.cityDao = cityDao;
		this.typeOfWork = typeOfWork;
		this.workingTimeDao = workingTimeDao;
		this.jobTitleDao = jobTitleDao;
		this.employerDao=employerDao;
	}

	@Override
	public Result add( JobAdvDto jobAdvDto) {
		JobAdvertisement jobAdvertisement = new JobAdvertisement();
		jobAdvertisement.setApplicationDeadline(jobAdvDto.getApplicationDeadline());
		jobAdvertisement.setCity(this.cityDao.getOne(jobAdvDto.getCityId()));
		jobAdvertisement.setJobTitle(this.jobTitleDao.getOne(jobAdvDto.getJobTitleId()));
		jobAdvertisement.setTypeOfWork(this.typeOfWork.getOne(jobAdvDto.getTypeOfWorkId()));
		jobAdvertisement.setWorkingTime(this.workingTimeDao.getOne(jobAdvDto.getWorkingTimeId()));
		jobAdvertisement.setJobDescription(jobAdvDto.getDescription());
		jobAdvertisement.setSalaryRange(jobAdvDto.getSalaryRange());
		jobAdvertisement.setJobPostingCount(jobAdvDto.getJobCount());
		jobAdvertisement.setEmployer(this.employerDao.getOne(jobAdvDto.getEmployerId()));
		jobAdvertisement.setListingDate(LocalDate.now());
		jobAdvertisement.setActive(false);
		this.jobAdvertisementsDao.save(jobAdvertisement);
		return new SuccessResult(true , "İş ialnı başarıyla eklendi");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAll() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementsDao.findAll(),"İş ilanları listelendi");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByIsActiveTrue() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementsDao.getByIsActiveTrue(),"data listelendi");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByIsActiveTrueAndEmployer_id(int id) {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementsDao.getByIsActiveTrueAndEmployer_id(id),"data listelendi");
	}

	

	@Override
	public DataResult<JobAdvertisement> getUpdate(int id) {
		JobAdvertisement jobAdvertisement =jobAdvertisementsDao.getOne(id);
		jobAdvertisement.setActive(false);
		return new SuccessDataResult<JobAdvertisement>(this.jobAdvertisementsDao.save(jobAdvertisement),"ialn pasif hale getirildi");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByIsActiveTrueOrderByApplicationDeadline() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementsDao.getByIsActiveTrueOrderByApplicationDeadline(),"data listelendi");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAllByCityIdAndTypeOfWorkId(int cityId, int typeOfWorkId, int pageNo,
			int pageSize) {
		Pageable pageable = PageRequest.of(pageNo-1, pageSize);
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementsDao.getAllByCityIdAndTypeOfWorkId(cityId, typeOfWorkId, pageable));
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAllByCityId(int cityId, int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo-1, pageSize);
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementsDao.getAllByCityId(cityId, pageable));
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAllByTypeOfWorkId(int typeOfWorkId, int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo-1, pageSize);
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementsDao.getAllByTypeOfWorkId(typeOfWorkId, pageable));
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByIsActiveTrue(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo-1, pageSize);
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementsDao.getByIsActiveTrue(pageable));
	}

	

	
	

	

	
	

	

}
