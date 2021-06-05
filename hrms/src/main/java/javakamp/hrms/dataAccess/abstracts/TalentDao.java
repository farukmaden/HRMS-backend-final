package javakamp.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import javakamp.hrms.entities.concretes.Talent;

public interface TalentDao extends JpaRepository<Talent, Integer>{

}
