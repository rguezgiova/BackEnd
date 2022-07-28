package com.bosonit.sa2.file.infraestructure.controller;

import com.bosonit.sa2.file.application.register.port.RegisterStoragePort;
import com.bosonit.sa2.file.application.storage.port.StorageFilePort;
import com.bosonit.sa2.file.exception.RegisterStorageException;
import com.bosonit.sa2.file.exception.StorageException;
import com.bosonit.sa2.file.infraestructure.dto.FileDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.nio.file.Path;

@RequestMapping("/file")
@RestController
public class FileController {
    private final StorageFilePort storageFilePort;
    private final RegisterStoragePort registerStoragePort;

    @Autowired
    public FileController(StorageFilePort storageFilePort, RegisterStoragePort registerStoragePort) {
        this.storageFilePort = storageFilePort;
        this.registerStoragePort = registerStoragePort;
    }

    @PostMapping("/upload/{extension}")
    public FileDto storageFile(@RequestParam("file") MultipartFile file, @PathVariable("extension") String extension, RedirectAttributes redirectAttributes) throws Exception {
        String path = storageFilePort.store(file).toString();
        FileDto fileInput = new FileDto(file.getOriginalFilename(), extension, path);
        if (!checkExtension(file, extension)) {
            throw new RegisterStorageException("La extensión dada no es la misma que la del fichero a subir");
        } else {
            FileDto fileOutput = new FileDto(registerStoragePort.registerFile(fileInput));
            return fileOutput;
        }
    }

    @GetMapping("/download/filename/{name}")
    @ResponseBody
    public Resource downloadFileByName(@PathVariable("name") String name) {
        Path path = registerStoragePort.findByName(name);
        return storageFilePort.download(path);
    }

    @GetMapping("/download/fileid/{id}")
    public Resource downloadFileById(@PathVariable("id") long id) {
        Path path = registerStoragePort.findById(id);
        return storageFilePort.download(path);
    }

    @ExceptionHandler(StorageException.class)
    public ResponseEntity<StorageException> handleStorageException(StorageException exception) {
        ResponseEntity responseEntity = ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(exception.getMessage());
        return responseEntity;
    }

    @ExceptionHandler(RegisterStorageException.class)
    public ResponseEntity<RegisterStorageException> handleRegisterStorageException(RegisterStorageException exception) {
        ResponseEntity responseEntity = ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
        return responseEntity;
    }

    private boolean checkExtension(MultipartFile file, String extension) {
        String fileExtension = "." + file.getOriginalFilename().split("\\.")[1];
        return fileExtension.equals(extension);
    }
}