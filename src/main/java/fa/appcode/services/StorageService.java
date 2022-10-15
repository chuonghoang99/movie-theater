package fa.appcode.services;

import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.stream.Stream;

public interface StorageService {


    String storeFile(MultipartFile file, String storageFolder);

    public Stream<Path> loadAll(); // load all file inside forder

    public byte[] readFileContent(String fileName);

    public boolean deleteAllFiles();
}
