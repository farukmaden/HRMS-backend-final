package javakamp.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javakamp.hrms.business.abstracts.TalentService;
import javakamp.hrms.core.utilities.results.DataResult;
import javakamp.hrms.core.utilities.results.Result;
import javakamp.hrms.core.utilities.results.SuccessDataResult;
import javakamp.hrms.core.utilities.results.SuccessResult;
import javakamp.hrms.dataAccess.abstracts.TalentDao;
import javakamp.hrms.entities.concretes.Talent;
@Service
public class TalentManager implements TalentService{

	private TalentDao talentDao;
	@Autowired
	public TalentManager(TalentDao talentDao) {
		super();
		this.talentDao = talentDao;
	}

	@Override
	public Result add(Talent talent) {
		this.talentDao.save(talent);
		return new SuccessResult(true,"ekelem işlemi başarılı");
	}

	@Override
	public DataResult<List<Talent>> getAll() {
		return new SuccessDataResult<List<Talent>>(this.talentDao.findAll(),"data listelendi");
	}

}
