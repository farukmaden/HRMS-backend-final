package javakamp.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javakamp.hrms.business.abstracts.EmployeeService;
import javakamp.hrms.core.abstracts.MailVerificationService;
import javakamp.hrms.core.utilities.results.DataResult;
import javakamp.hrms.core.utilities.results.ErrorResult;
import javakamp.hrms.core.utilities.results.Result;
import javakamp.hrms.core.utilities.results.SuccessDataResult;
import javakamp.hrms.core.utilities.results.SuccessResult;
import javakamp.hrms.dataAccess.abstracts.EmployeeDao;
import javakamp.hrms.dataAccess.abstracts.UsersDao;
import javakamp.hrms.entities.concretes.Employee;
@Service
public class EmployeeManager implements EmployeeService{
	
	private EmployeeDao employeeDao;
	private UsersDao usersDao;
	private MailVerificationService mailVerificationService;

	@Autowired
	public EmployeeManager(EmployeeDao employeeDao, UsersDao usersDao,MailVerificationService mailVerificationService) {
		super();
		this.employeeDao = employeeDao;
		this.usersDao = usersDao;
		this.mailVerificationService = mailVerificationService;
	}

	@Override
	public Result add(Employee employee) {
		if(employee.getPassword().length()<6) {
			return new ErrorResult("Şifre en az 6 karakter olmalı");
		}else if(employee.getPassword()==employee.getPasswordRepeat()) {
			return new ErrorResult("şifreleriniz uyuşmamaktadır");
		}else if(emailTypeControl(employee)) {
			return new ErrorResult("mail adresiniz e mail formatında değil");
		}else if(usersDao.findAllByEmail(employee.getEmail()).stream().count()!=0) {
			return new ErrorResult("Mail adresi kullanımda");
		}
		this.mailVerificationService.mailVerification(employee);
		this.employeeDao.save(employee);
		return new SuccessResult(true , "eklendi");
	}

	@Override
	public Result update(Employee employee) {
		this.employeeDao.save(employee);
		return new SuccessResult(true,"güncelleme başarılı");
	}

	@Override
	public DataResult<List<Employee>> getAll() {
		return new SuccessDataResult<List<Employee>>(this.employeeDao.findAll());
	}
	
	public boolean emailTypeControl(Employee employee) {
		if (employee.getEmail().contains("@")) {
			return false;
		} else {
			return true;
		}
	}

}
