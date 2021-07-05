package javakamp.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TalentWithCvDto {
	private int talentId;
	private int curriculumVİtaeId;
	private String talentName;

}
