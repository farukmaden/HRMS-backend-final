package javakamp.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import javakamp.hrms.entities.concretes.TypeOfWork;

public interface TypeOfWorkDao extends JpaRepository<TypeOfWork, Integer>{

}
