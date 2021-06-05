package javakamp.hrms.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cloudinary.*;
import com.cloudinary.utils.ObjectUtils;

import javakamp.hrms.core.abstracts.CloudinaryService;
import javakamp.hrms.core.concrates.CloudinaryManager;
@Configuration
public class CloudinaryConfig {

	@Value("${cld.access-key}")     String apiKey;          
	@Value("${cld.secret-key}")     String apiSecretKey;
	
	@Bean
	public Cloudinary user() {
		return new Cloudinary(ObjectUtils.asMap("cloud_name", "dgyan4ij0", 
                "api_key", apiKey ,
                "api_secret", apiSecretKey));
	}
	@Bean
	public CloudinaryService cloudinaryService() {
		return new CloudinaryManager(user());
	}
}
