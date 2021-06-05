package javakamp.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "job_experience")
public class JobExperience {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
//	@Column(name = "cv_id")
//	private int cvId;
	
	@Column(name = "workplace_name")
	private String workplaceName;
	
	@Column(name = "job_position")
	private String jobPosition;
	
	@Column(name = "start_year")
	private LocalDate startYear;
	
	@Column(name = "end_year")
	private LocalDate endYear;
	
	@ManyToOne
	@JoinColumn(name="cv_id")
	private CurriculumVitae curriculumVitae;
}
