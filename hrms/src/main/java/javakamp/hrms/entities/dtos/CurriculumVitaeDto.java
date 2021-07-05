package javakamp.hrms.entities.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurriculumVitaeDto {
	private int ıd;
	private int candıdateId;
	private String description;
	private String gitHub;
	private String linkedin;
	private LocalDate creationDate;
	

}
