package javakamp.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javakamp.hrms.business.abstracts.TalentService;
import javakamp.hrms.core.utilities.results.DataResult;
import javakamp.hrms.core.utilities.results.Result;
import javakamp.hrms.core.utilities.results.SuccessDataResult;
import javakamp.hrms.core.utilities.results.SuccessResult;
import javakamp.hrms.dataAccess.abstracts.CurriculumVitaeDao;
import javakamp.hrms.dataAccess.abstracts.TalentDao;
import javakamp.hrms.entities.concretes.Talent;
import javakamp.hrms.entities.dtos.TalentWithCvDto;
@Service
public class TalentManager implements TalentService{

	private TalentDao talentDao;
	private CurriculumVitaeDao curriculumVitaeDao;
	@Autowired
	public TalentManager(TalentDao talentDao, CurriculumVitaeDao curriculumVitaeDao) {
		super();
		this.talentDao = talentDao;
		this.curriculumVitaeDao = curriculumVitaeDao;
	}

	
	@Override
	public Result add(TalentWithCvDto talentWithCvDto) {
		Talent talent = new Talent();
		talent.setTalentName(talentWithCvDto.getTalentName());
		talent.setCurriculumVitae(this.curriculumVitaeDao.getOne(talentWithCvDto.getCurriculumVİtaeId()));
		this.talentDao.save(talent);
		return new SuccessResult(true,"ekelem işlemi başarılı");
	}

	@Override
	public DataResult<List<Talent>> getAll() {
		return new SuccessDataResult<List<Talent>>(this.talentDao.findAll(),"data listelendi");
	}


	@Override
	public Result update(TalentWithCvDto talentWithCvDto) {
		Talent talent = new Talent();
		talent.setTalentName(talentWithCvDto.getTalentName());
		talent.setCurriculumVitae(this.curriculumVitaeDao.getOne(talentWithCvDto.getTalentId()));
		talent.setId(talentWithCvDto.getTalentId());
		this.talentDao.save(talent);
		return new SuccessResult(true,"güncelleme başrılı");
	}

}
