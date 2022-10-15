package fa.appcode.services.impl;

import fa.appcode.common.logging.LogUtils;
import fa.appcode.exceptions.ImageFileException;
import fa.appcode.services.StorageService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.UUID;
import java.util.stream.Stream;

@Service
public class ImageServiceImpl implements StorageService {

    private boolean isImageFile(MultipartFile file) {
        String fileExtension = FilenameUtils.getExtension(file.getOriginalFilename());
        if (fileExtension == null) {
            return false;
        }
        return Arrays.asList(new String[]{"png", "jpg", "jpeg", "bmp"}).contains(fileExtension.trim().toLowerCase());
    }

    @Override
    public String storeFile(MultipartFile file, String storageFolder) {

            if (file.isEmpty()) {
                throw new ImageFileException("Failed to store empty file.");
            }
            if (!isImageFile(file)) {
                throw new ImageFileException("You can only upload image file (png, jpg, jpeg, bmp)");
            }

//            //file must be <=5MB
//            float fileSizeInMegabytes = file.getSize() / 1_000_000;
//            if (fileSizeInMegabytes > 5.0f) {
//                throw new ImageFileException("Fail must be <= 5MB");
//            }

            // rename file
            String fileExtension = FilenameUtils.getExtension(file.getOriginalFilename());
            String generatedFileName = UUID.randomUUID().toString().replace("-", "");
            generatedFileName = generatedFileName + "." + fileExtension;

            Path uploadPath = Paths.get(storageFolder);
            Path destinationFilePath = uploadPath.resolve(Paths.get(generatedFileName)).normalize().toAbsolutePath();
            try (InputStream inputStream = file.getInputStream()) {
                Files.copy(inputStream, destinationFilePath, StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                LogUtils.getLogger().info("Failed to store file " + e.getMessage());
                throw new ImageFileException("Failed to store file. " + e);
            }

        return generatedFileName;

    }

    @Override
    public Stream<Path> loadAll() {
        return null;
    }

    @Override
    public byte[] readFileContent(String fileName) {
        return new byte[0];
    }

    @Override
    public boolean deleteAllFiles() {
        return false;
    }
}
