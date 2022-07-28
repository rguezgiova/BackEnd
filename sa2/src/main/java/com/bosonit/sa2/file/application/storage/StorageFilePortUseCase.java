package com.bosonit.sa2.file.application.storage;

import com.bosonit.sa2.file.application.storage.port.StorageFilePort;
import com.bosonit.sa2.file.exception.StorageException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.core.io.Resource;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;

@Component
public class StorageFilePortUseCase implements StorageFilePort {
    private final StorageConfigurationProperties properties;

    @Autowired
    public StorageFilePortUseCase(StorageConfigurationProperties properties) {
        this.properties = properties;
    }

    @Override
    public Path store(MultipartFile file) {
        try {
            if (file.isEmpty()) {
                throw new StorageException("El fichero: " + file.getOriginalFilename() + " está vacío");
            }
            Path path = Path.of(properties.getPath()).resolve(file.getOriginalFilename());
            Files.copy(file.getInputStream(), path);
            return path;
        } catch (IOException | RuntimeException exception) {
            throw new StorageException("Error en la subida del fichero: " + file.getOriginalFilename());
        }
    }

    @Override
    public Resource download(Path path) {
        try {
            Resource resource = new UrlResource(path.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new StorageException("No se ha podido leer el fichero");
            }
        } catch (MalformedURLException exception) {
            throw new StorageException("Error en la URL del fichero");
        }
    }
}