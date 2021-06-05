package javakamp.hrms.core.abstracts;


import org.springframework.web.multipart.MultipartFile;

import javakamp.hrms.core.utilities.results.DataResult;

public interface CloudinaryService {

	DataResult<?> add (MultipartFile multipartFile);
}
