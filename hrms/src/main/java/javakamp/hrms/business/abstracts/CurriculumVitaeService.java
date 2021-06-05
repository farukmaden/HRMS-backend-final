package javakamp.hrms.business.abstracts;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import javakamp.hrms.core.utilities.results.DataResult;
import javakamp.hrms.core.utilities.results.Result;
import javakamp.hrms.entities.concretes.CurriculumVitae;

public interface CurriculumVitaeService {

	DataResult<List<CurriculumVitae>> getAll();
	Result add (CurriculumVitae curriculumVitae);
	Result addPhoto(MultipartFile multipartFile,int cvId);
	
	DataResult<List<CurriculumVitae>> findAllCandidateId(int candidateId);
}
