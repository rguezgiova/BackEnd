package com.bosonit.sa2.file.application.register.port;

import com.bosonit.sa2.file.domain.File;
import com.bosonit.sa2.file.infraestructure.dto.FileDto;

import java.nio.file.Path;

public interface RegisterStoragePort {
    File registerFile(FileDto fileDto);
    Path findById(long id);
    Path findByName(String name);
}