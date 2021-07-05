package javakamp.hrms.entities.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EducationWithCvDto {

	private int educationId;
	private int curriculumVitaeId;
	private String schoolName;
	private String schoolDepartment;
	private LocalDate startYear;
	private LocalDate endYear;
}
