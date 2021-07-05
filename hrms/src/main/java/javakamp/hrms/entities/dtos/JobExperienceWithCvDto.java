package javakamp.hrms.entities.dtos;


import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobExperienceWithCvDto {
	private int exparianceId;
	private int curriculumVitaeId;
	private String workplaceName;
	private String jobPosition;
	private LocalDate startYear;
	private LocalDate endYear;

}
