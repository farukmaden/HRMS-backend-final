package javakamp.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import javakamp.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementsDao extends JpaRepository<JobAdvertisement, Integer> {

	List<JobAdvertisement> getByIsActiveTrue();

	List<JobAdvertisement> getByIsActiveTrueAndEmployer_id(int id);

	List<JobAdvertisement> getByIsActiveTrueOrderByApplicationDeadline();

	List<JobAdvertisement> getAllByCityIdAndTypeOfWorkId(int cityId, int typeOfWorkId, Pageable Pageable);
	
	List<JobAdvertisement> getAllByCityId(int cityId,  Pageable Pageable);
	
	List<JobAdvertisement> getAllByTypeOfWorkId( int typeOfWorkId, Pageable Pageable);
	
	List<JobAdvertisement> getByIsActiveTrue(Pageable Pageable);
}
