package javakamp.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import javakamp.hrms.entities.concretes.WorkingTime;

public interface WorkingTimeDao extends JpaRepository<WorkingTime, Integer>{

}
