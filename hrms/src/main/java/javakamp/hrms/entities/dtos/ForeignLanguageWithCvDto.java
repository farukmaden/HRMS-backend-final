package javakamp.hrms.entities.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ForeignLanguageWithCvDto {

	private int languageId;
	private int curriculumVitaeId;
	private String languageName;
	private String languageLevel;
}
