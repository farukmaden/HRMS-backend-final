package javakamp.hrms.business.abstracts;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import javakamp.hrms.core.utilities.results.DataResult;
import javakamp.hrms.core.utilities.results.Result;
import javakamp.hrms.entities.concretes.CurriculumVitae;
import javakamp.hrms.entities.dtos.CurriculumVitaeDto;

public interface CurriculumVitaeService {

	DataResult<List<CurriculumVitae>> getAll();
	Result add (CurriculumVitaeDto curriculumVitaeDto);
	Result addPhoto(MultipartFile multipartFile,int cvId);
	Result update (CurriculumVitaeDto curriculumVitaeDto );
	
	DataResult<List<CurriculumVitae>> findAllCandidateId(int candidateId);
}
