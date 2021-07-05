package javakamp.hrms.business.concretes;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javakamp.hrms.business.abstracts.CurriculumVitaeService;
import javakamp.hrms.core.abstracts.CloudinaryService;
import javakamp.hrms.core.utilities.results.DataResult;
import javakamp.hrms.core.utilities.results.Result;
import javakamp.hrms.core.utilities.results.SuccessDataResult;
import javakamp.hrms.core.utilities.results.SuccessResult;
import javakamp.hrms.dataAccess.abstracts.CandidatesDao;
import javakamp.hrms.dataAccess.abstracts.CurriculumVitaeDao;
import javakamp.hrms.entities.concretes.CurriculumVitae;
import javakamp.hrms.entities.dtos.CurriculumVitaeDto;
@Service
public class CurriculumVitaeManager implements CurriculumVitaeService{

	private CurriculumVitaeDao curriculumVitaeDao;
	private CloudinaryService cloudinaryService;
	private CandidatesDao candidatesDao;
	@Autowired
	public CurriculumVitaeManager(CurriculumVitaeDao curriculumVitaeDao, CloudinaryService cloudinaryService,CandidatesDao candidatesDao) {
		super();
		this.curriculumVitaeDao = curriculumVitaeDao;
		this.cloudinaryService = cloudinaryService;
		this.candidatesDao =candidatesDao;
	}

	@Override
	public DataResult<List<CurriculumVitae>> getAll() {
		return new SuccessDataResult<List<CurriculumVitae>>(this.curriculumVitaeDao.findAll(),"data listelendi");
	}

	@Override
	public Result add(CurriculumVitaeDto curriculumVitaeDto) {
		CurriculumVitae curriculumVitae=new CurriculumVitae();
		curriculumVitae.setDescription(curriculumVitaeDto.getDescription());
		curriculumVitae.setGitHub(curriculumVitaeDto.getGitHub());
		curriculumVitae.setLinkedin(curriculumVitaeDto.getLinkedin());
		curriculumVitae.setCandidate(this.candidatesDao.getOne(curriculumVitaeDto.getCandıdateId()));
		curriculumVitae.setCreationDate(LocalDate.now());
		this.curriculumVitaeDao.save(curriculumVitae);
		return new SuccessResult(true,"CV eklendi");
	}

	@Override
	public Result addPhoto(MultipartFile multipartFile, int cvId) {
		Map<String, String> add=(Map<String, String>) cloudinaryService.add(multipartFile).getData();
		
		String photoAddress = add.get("url");
		
		CurriculumVitae curriculumVitae = curriculumVitaeDao.getOne(cvId);
		curriculumVitae.setCandidatePhoto(photoAddress);
		curriculumVitaeDao.save(curriculumVitae);
		return new SuccessResult(true,"fotoğraf eklendi");
	}




	@Override
	public DataResult<List<CurriculumVitae>> findAllCandidateId(int candidateId) {
		return new SuccessDataResult<List<CurriculumVitae>>(curriculumVitaeDao.findAllByCandidateId(candidateId));
	}

	@Override
	public Result update(CurriculumVitaeDto curriculumVitaeDto) {
		CurriculumVitae curriculumVitae=new CurriculumVitae();
		curriculumVitae.setDescription(curriculumVitaeDto.getDescription());
		curriculumVitae.setGitHub(curriculumVitaeDto.getGitHub());
		curriculumVitae.setLinkedin(curriculumVitaeDto.getLinkedin());
		curriculumVitae.setCreationDate(LocalDate.now());
		curriculumVitae.setCandidate(this.candidatesDao.getOne(curriculumVitaeDto.getCandıdateId()));
		curriculumVitae.setId(curriculumVitaeDto.getId());
		this.curriculumVitaeDao.save(curriculumVitae);
		return new SuccessResult(true,"güncelleme başrılı");
	}

}
