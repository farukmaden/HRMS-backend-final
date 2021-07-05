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
@Table(name = "working_time")
public class WorkingTime {
	@Id
	@Column(name = "id")
	private int id;
	@Column(name = "working_time")
	private String workingTime;
	
	@JsonIgnore
	@OneToMany(mappedBy = "workingTime")
	private List<JobAdvertisement> jobAdvertisement;
}
