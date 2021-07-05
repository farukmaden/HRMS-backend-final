package javakamp.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javakamp.hrms.business.abstracts.ForeignLanguageService;
import javakamp.hrms.core.utilities.results.DataResult;
import javakamp.hrms.core.utilities.results.Result;
import javakamp.hrms.core.utilities.results.SuccessDataResult;
import javakamp.hrms.core.utilities.results.SuccessResult;
import javakamp.hrms.dataAccess.abstracts.CurriculumVitaeDao;
import javakamp.hrms.dataAccess.abstracts.ForeignLanguageDao;
import javakamp.hrms.entities.concretes.ForeignLanguage;
import javakamp.hrms.entities.dtos.ForeignLanguageWithCvDto;
@Service
public class ForeignLanguageManager implements ForeignLanguageService{

	private ForeignLanguageDao foreignLanguageDao;
	private CurriculumVitaeDao curriculumVitaeDao;
	@Autowired
	public ForeignLanguageManager(ForeignLanguageDao foreignLanguageDao, CurriculumVitaeDao curriculumVitaeDao) {
		super();
		this.foreignLanguageDao = foreignLanguageDao;
		this.curriculumVitaeDao = curriculumVitaeDao;
	}

	


	@Override
	public Result add(ForeignLanguageWithCvDto foreignLanguageWithCvDto) {
		ForeignLanguage foreignLanguage = new ForeignLanguage();
		foreignLanguage.setLanguageName(foreignLanguageWithCvDto.getLanguageName());
		foreignLanguage.setLanguageLevel(foreignLanguageWithCvDto.getLanguageLevel());
		foreignLanguage.setCurriculumVitae(this.curriculumVitaeDao.getOne(foreignLanguageWithCvDto.getCurriculumVitaeId()));
		
		this.foreignLanguageDao.save(foreignLanguage);
		return new SuccessResult(true,"ekleem işlemi başarılı");
	}

	@Override
	public DataResult<List<ForeignLanguage>> getAll() {
		return new SuccessDataResult<List<ForeignLanguage>>(this.foreignLanguageDao.findAll(),"data listelendi");
	}




	@Override
	public Result update(ForeignLanguageWithCvDto foreignLanguageWithCvDto) {
		ForeignLanguage foreignLanguage = new ForeignLanguage();
		foreignLanguage.setLanguageLevel(foreignLanguageWithCvDto.getLanguageLevel());
		foreignLanguage.setLanguageName(foreignLanguageWithCvDto.getLanguageName());
		foreignLanguage.setCurriculumVitae(this.curriculumVitaeDao.getOne(foreignLanguageWithCvDto.getCurriculumVitaeId()));
		foreignLanguage.setId(foreignLanguageWithCvDto.getLanguageId());
		this.foreignLanguageDao.save(foreignLanguage);
		return new SuccessResult(true,"güncelleme başrılı");
	}

}
