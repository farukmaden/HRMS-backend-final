package javakamp.hrms.business.abstracts;

import java.util.List;

import javakamp.hrms.core.utilities.results.DataResult;
import javakamp.hrms.core.utilities.results.Result;
import javakamp.hrms.entities.concretes.Employee;

public interface EmployeeService {
	Result add(Employee employee);
	Result update(Employee employee);
	
	DataResult<List<Employee>> getAll();

}
