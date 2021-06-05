package javakamp.hrms.entities.concretes;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "curriculum_vitae")
public class CurriculumVitae {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	//@Column(name="candidate_id")
	//private int candidateId;
	
	@Column(name="candidate_photo")
	private String candidatePhoto;
	
	@Column(name="github")
	private String gitHub;
	
	@Column(name="linkedin")
	private String linkedin;
	
	@Column(name="description")
	private String description;
	
	@Column(name="creation_date")
	private LocalDate creationDate;
	
	@JsonIgnoreProperties("curriculumVitae")
	@OneToMany(mappedBy = "curriculumVitae")
	private List<Education> education;
	
	@JsonIgnoreProperties("curriculumVitae")
	@OneToMany(mappedBy = "curriculumVitae")
	private List<ForeignLanguage> foreignLanguage;
	
	@JsonIgnoreProperties("curriculumVitae")
	@OneToMany(mappedBy = "curriculumVitae")
	private List<JobExperience> jobExperience;
	
	@JsonIgnoreProperties("curriculumVitae")
	@OneToMany(mappedBy = "curriculumVitae")
	private List<Talent> talent;
	
	@ManyToOne(targetEntity = Candidate.class)
	@JoinColumn(name ="candidate_id",referencedColumnName = "id",nullable = false)
	private Candidate candidate;
	
	
}







