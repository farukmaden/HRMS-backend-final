package javakamp.hrms.business.abstracts;

import java.util.List;

import javakamp.hrms.core.utilities.results.DataResult;
import javakamp.hrms.core.utilities.results.Result;
import javakamp.hrms.entities.concretes.JobAdvertisement;
import javakamp.hrms.entities.dtos.JobAdvDto;

public interface JobAdvertisementsService {

	DataResult<List<JobAdvertisement>> getAll();
	
	Result add (JobAdvDto jobAdvDto );
	
	DataResult<List<JobAdvertisement>> getByIsActiveTrue();
	
	DataResult<List<JobAdvertisement>> getByIsActiveTrueAndEmployer_id(int id);
	
	DataResult<JobAdvertisement> getUpdate(int id);
	
	DataResult<List<JobAdvertisement>> getByIsActiveTrueOrderByApplicationDeadline();
	
	DataResult<List<JobAdvertisement>> getAllByCityIdAndTypeOfWorkId(int cityId,int typeOfWorkId,int pageNo,int pageSize);
	
	DataResult<List<JobAdvertisement>> getAllByCityId(int cityId,int pageNo,int pageSize);
	
	DataResult<List<JobAdvertisement>> getAllByTypeOfWorkId(int typeOfWorkId,int pageNo,int pageSize);
	
	DataResult<List<JobAdvertisement>> getByIsActiveTrue(int pageNo,int pageSize);
}
