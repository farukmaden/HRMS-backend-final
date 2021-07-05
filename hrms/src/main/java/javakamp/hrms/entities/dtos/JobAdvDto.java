package javakamp.hrms.entities.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvDto {

	
	private int employerId;
	private int cityId;
	private int jobTitleId;
	private String description;
	private String salaryRange;
	private int jobCount;
	private LocalDate applicationDeadline;
	private int typeOfWorkId;
	private int workingTimeId;
	
}
