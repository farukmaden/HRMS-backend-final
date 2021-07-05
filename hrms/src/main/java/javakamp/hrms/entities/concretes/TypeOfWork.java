package javakamp.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "type_of_work")
public class TypeOfWork {
	@Id
	@Column(name = "id")
	private int id;
	
	@Column(name = "type_name")
	private String typeOfWork;
	
	@JsonIgnore
	@OneToMany(mappedBy = "typeOfWork")
	private List<JobAdvertisement> jobAdvertisement;
}
