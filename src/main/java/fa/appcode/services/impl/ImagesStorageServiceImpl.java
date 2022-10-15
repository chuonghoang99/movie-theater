package fa.appcode.services.impl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;


import fa.appcode.exceptions.ImageFileException;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import fa.appcode.services.ImagesStorageService;

@Service("imageService")
public class ImagesStorageServiceImpl implements ImagesStorageService{
	
	private final Path rootPath = Paths.get("uploads");
	
	@Override
	public void init() {
		try {
			Files.createDirectories(rootPath);
		} catch (IOException e) {
			throw new ImageFileException("Could not initialize folder for upload image!");
		}
	}

	@Override
	public void saveImage(MultipartFile file) {
		try {
			Files.copy(file.getInputStream(), this.rootPath.resolve(Objects.requireNonNull(file.getOriginalFilename())));
		} catch (IOException e) {
			throw new ImageFileException("Could not store the file. Error: " + e.getMessage());
		}
	}

	@Override
	public Resource load(String filename) {
		try {
			Path file = rootPath.resolve(filename);
			Resource resource = new UrlResource(file.toUri());
			
			if(resource.exists() || resource.isReadable()) {
				return resource;
			}
			else {
				throw new ImageFileException("Could not read the file!");
			}
		}
		catch (MalformedURLException e) {
			throw new ImageFileException("Error: " + e.getMessage());
		}
	}

}
