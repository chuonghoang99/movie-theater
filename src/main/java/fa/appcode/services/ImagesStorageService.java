package fa.appcode.services;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface ImagesStorageService {
	public void init();
	
	public void saveImage(MultipartFile file);
	
	public Resource load(String filename);
}
