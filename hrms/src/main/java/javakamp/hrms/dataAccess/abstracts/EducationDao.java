package javakamp.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import javakamp.hrms.entities.concretes.Education;

public interface EducationDao extends JpaRepository<Education, Integer>{

	List<Education>findAllByCurriculumVitaeIdOrderByEndYearDesc(int id);
}
