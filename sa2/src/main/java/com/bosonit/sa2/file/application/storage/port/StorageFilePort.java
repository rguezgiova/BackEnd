package com.bosonit.sa2.file.application.storage.port;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.core.io.Resource;

import java.nio.file.Path;

public interface StorageFilePort {
    Path store(MultipartFile file);
    Resource download(Path path);
}